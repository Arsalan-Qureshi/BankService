package com.learning.LearningKotlin.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import software.amazon.awssdk.services.ec2.Ec2Client
import software.amazon.awssdk.services.ec2.model.*


@Service
class AWSEC2Service() {
    @Autowired
    lateinit var ec2: Ec2Client

    fun createEC2Instance(name: String?, amiId: String?): String? {
        val runRequest = RunInstancesRequest.builder()
            .imageId(amiId)
            .instanceType(InstanceType.T2_MICRO)
            .maxCount(1)
            .minCount(1)
            .build()
        val response = ec2.runInstances(runRequest)
        val instanceId = response.instances()[0].instanceId()
        val tag: Tag = Tag.builder()
            .key("Name")
            .value(name)
            .build()
        val tagRequest: CreateTagsRequest = CreateTagsRequest.builder()
            .resources(instanceId)
            .tags(tag)
            .build()
        try {
            ec2.createTags(tagRequest)
            System.out.printf(
                "Successfully started EC2 Instance %s based on AMI %s",
                instanceId, amiId
            )
            return instanceId
        } catch (e: Ec2Exception) {
            System.err.println(e.awsErrorDetails().errorMessage())
            System.exit(1)
        }
        return ""
    }

    fun startInstance(instanceId: String?) {
        val request = StartInstancesRequest.builder()
            .instanceIds(instanceId)
            .build()
        ec2.startInstances(request)
        System.out.printf("Successfully started instance %s", instanceId)
    }

    fun stopInstance(instanceId: String?) {
        val request = StopInstancesRequest.builder()
            .instanceIds(instanceId)
            .build()
        ec2.stopInstances(request)
        System.out.printf("Successfully stopped instance %s", instanceId)
    }

    fun rebootEC2Instance(instanceId: String?) {
        try {
            val request = RebootInstancesRequest.builder()
                .instanceIds(instanceId)
                .build()
            ec2.rebootInstances(request)
            System.out.printf(
                "Successfully rebooted instance %s", instanceId
            )
        } catch (e: Ec2Exception) {
            System.err.println(e.awsErrorDetails().errorMessage())
            System.exit(1)
        }
    }

    fun describeEC2Instances() {
        val done = false
        var nextToken: String? = null
        try {
            do {
                val request = DescribeInstancesRequest.builder().maxResults(6).nextToken(nextToken).build()
                val response = ec2.describeInstances(request)
                for (reservation in response.reservations()) {
                    for (instance in reservation.instances()) {
                        System.out.println("Instance Id is " + instance.instanceId())
                        System.out.println("Image id is " + instance.imageId())
                        System.out.println("Instance type is " + instance.instanceType())
                        System.out.println("Instance state name is " + instance.state().name())
                        System.out.println("monitoring information is " + instance.monitoring().state())
                    }
                }
                nextToken = response.nextToken()
            } while (nextToken != null)
        } catch (e: Ec2Exception) {
            System.err.println(e.awsErrorDetails().errorMessage())
            System.exit(1)
        }
    }

    fun monitorInstance(instanceId: String?) {
        val request = MonitorInstancesRequest.builder()
            .instanceIds(instanceId).build()
        ec2.monitorInstances(request)
        System.out.printf(
            "Successfully enabled monitoring for instance %s",
            instanceId
        )
    }

    fun unmonitorInstance(instanceId: String?) {
        val request = UnmonitorInstancesRequest.builder()
            .instanceIds(instanceId).build()
        ec2.unmonitorInstances(request)
        System.out.printf(
            "Successfully disabled monitoring for instance %s",
            instanceId
        )
    }
}