package com.guilhermepisco.springgrpc.client;

import com.guilhermepisco.springgrpc.HelloRequest;
import com.guilhermepisco.springgrpc.HelloResponse;
import com.guilhermepisco.springgrpc.HelloServiceGrpc;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientGRPC {

	 public static void main(String[] args) throws InterruptedException {
	        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
	            .usePlaintext()
	            .build();

	        HelloServiceGrpc.HelloServiceBlockingStub stub 
	          = HelloServiceGrpc.newBlockingStub(channel);

	        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
	            .setFirstName("Guilherme")
	            .setLastName("Pisco")
	            .build());

	        System.out.println("Response received from server:\n" + helloResponse);

	        channel.shutdown();
	    }
}
