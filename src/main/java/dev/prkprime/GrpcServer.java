package dev.prkprime;

import dev.prkprime.helloworld.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.flogger.Flogger;

import java.io.IOException;
import java.util.logging.Logger;

@Flogger
public class GrpcServer {


    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder
                .forPort(6000)
                .addService(new HelloServiceImpl())
                .build();
        log.atInfo().log("Starting Server ...");
        server.start();
        server.awaitTermination();
    }
}