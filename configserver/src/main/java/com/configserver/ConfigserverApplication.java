package com.configserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigserverApplication {

    /**
     * <h1>Spring Cloud Config Server</h1>
     *
     * <p>
     * The <code>spring-cloud-config-server</code> dependency is used to create a centralized configuration server
     * for managing external properties across all microservices in a distributed system. This server provides
     * a RESTful API that serves configuration files (e.g., <code>application.yml</code> or <code>application.properties</code>)
     * to client applications. It supports version control and environment-specific configurations, making it easier
     * to manage and deploy configurations across different environments (e.g., development, testing, production).
     * </p>
     *
     * <p>
     * By default, the Spring Cloud Config Server runs on port <strong>8888</strong>. This port can be customized
     * by setting the <code>server.port</code> property in the <code>application.yml</code> or <code>application.properties</code>
     * file of the Config Server.
     * </p>
     *
     * <h2>Key Features:</h2>
     * <ul>
     *   <li>Centralized configuration management for microservices.</li>
     *   <li>Supports Git, SVN, and local file system as configuration sources.</li>
     *   <li>Environment-specific configuration (e.g., dev, test, prod).</li>
     *   <li>Encryption and decryption of sensitive properties.</li>
     *   <li>Integration with Spring Boot applications via <code>spring-cloud-starter-config</code>.</li>
     * </ul>
     */


    public static void main(String[] args) {
        SpringApplication.run(ConfigserverApplication.class, args);
    }

}
