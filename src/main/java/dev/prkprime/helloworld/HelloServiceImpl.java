package dev.prkprime.helloworld;

import dev.prkprime.helloworld.HelloServiceGrpc.HelloServiceImplBase;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceImplBase {
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = "Hello " + request.getFirstName() + " " + request.getLastName();
        HelloResponse helloResponse = HelloResponse
                .newBuilder()
                .setGreeting(greeting)
                .build();
        responseObserver.onNext(helloResponse);
        responseObserver.onCompleted();
    }
}