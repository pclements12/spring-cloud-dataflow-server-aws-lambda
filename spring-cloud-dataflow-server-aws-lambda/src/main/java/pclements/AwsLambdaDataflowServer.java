package pclements;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.dataflow.server.EnableDataFlowServer;

@SpringBootApplication
@EnableDataFlowServer
public class AwsLambdaDataflowServer {

    public static void main(String[] args) {
        SpringApplication.run(AwsLambdaDataflowServer.class, args);
    }

}