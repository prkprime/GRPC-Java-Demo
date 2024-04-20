package dev.prkprime;

import dev.prkprime.helloworld.HelloRequest;
import dev.prkprime.helloworld.HelloResponse;
import dev.prkprime.helloworld.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.flogger.Flogger;

import java.util.logging.Logger;

@Flogger
public class GrpcClient {


    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 6000)
                .usePlaintext()
                .build();
        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);
        HelloRequest helloRequest = HelloRequest.newBuilder()
                .setFirstName("Pratik")
                .setLastName("Gorade")
                .build();
        log.atInfo().log("Sending Request with payload -> %s", helloRequest);
        HelloResponse helloResponse = stub.hello(helloRequest);
        log.atInfo().log("Got Response -> %s", helloResponse);
        channel.shutdown();
    }
}
