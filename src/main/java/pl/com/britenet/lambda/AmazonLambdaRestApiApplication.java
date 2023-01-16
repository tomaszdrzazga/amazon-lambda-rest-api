package pl.com.britenet.lambda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import pl.com.britenet.lambda.controller.StatusController;
import pl.com.britenet.lambda.controller.UserController;

@SpringBootApplication
@Import({StatusController.class, UserController.class})
public class AmazonLambdaRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AmazonLambdaRestApiApplication.class, args);
    }
}