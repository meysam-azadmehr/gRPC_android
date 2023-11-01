package com.zadmehr.meysam.grpc_android.proto

import io.grpc.ManagedChannel
import io.grpc.examples.helloworld.GreeterGrpc
import io.grpc.examples.helloworld.HelloRequest


fun sendMessage(
    message: String,
    channel: ManagedChannel?
): String? {
    return try {
        val stub = GreeterGrpc.newBlockingStub(channel)
        val request = HelloRequest.newBuilder().setName(message).build()
        val reply = stub.sayHello(request)
        reply.message
    } catch (e: Exception) {
        e.message
    }

}

fun sendMessageWithReplies(
    message: String,
    channel: ManagedChannel?
): Any? {
    return try {
        val stub = GreeterGrpc.newBlockingStub(channel)
        val request = HelloRequest.newBuilder().setName(message).build()
        val reply = stub.sayHello(request)
        reply.message
    } catch (e: Exception) {
        e
    }
}
