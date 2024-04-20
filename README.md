# gRPC Java Demo

Sample Hello World gRPC Project

### How To Run (for cli)

run gRPC Server in first terminal

``sh
mvn compile exec:java -Dexec.mainClass="dev.prkprime.GrpcServer"
``

run gRPC Client in second terminal

``sh
mvn compile exec:java -Dexec.mainClass="dev.prkprime.GrpcClient"
``