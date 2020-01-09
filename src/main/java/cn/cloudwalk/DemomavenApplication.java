package cn.cloudwalk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemomavenApplication {
    @Value("${sdk.engineServer.url}")
    private String serverUrl;
    public static void main(String[] args) {
        SpringApplication.run(DemomavenApplication.class, args);
    }


}
