package com.gou.springcloud.seluth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class SeluthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeluthApplication.class, args);
    }

}
