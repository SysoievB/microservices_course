package com.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaserverApplication {

    /**
     * <h1>Spring Cloud Netflix Eureka Server</h1>
     *
     * <p>
     * The <code>spring-cloud-starter-netflix-eureka-server</code> dependency is used to create a service discovery server
     * in a microservices architecture. Eureka Server acts as a registry where all microservices (clients) can register themselves
     * and discover other services dynamically. This eliminates the need for hardcoding service URLs and enables load balancing,
     * failover, and dynamic scaling in a distributed system.
     * </p>
     *
     * <p>
     * By default, the Eureka Server runs on port <strong>8761</strong>. This port can be customized by setting the
     * <code>server.port</code> property in the <code>application.yml</code> or <code>application.properties</code> file
     * of the Eureka Server.
     * </p>
     *
     * <h2>Key Features:</h2>
     * <ul>
     *   <li>Service registration and discovery for microservices.</li>
     *   <li>Supports high availability with peer-to-peer replication between Eureka Servers.</li>
     *   <li>Health checks and self-preservation mode to handle network partitions.</li>
     *   <li>Integration with Spring Boot applications via <code>spring-cloud-starter-netflix-eureka-client</code>.</li>
     *   <li>Provides a user-friendly dashboard to view registered services and their status.</li>
     * </ul>
     */


    public static void main(String[] args) {
        SpringApplication.run(EurekaserverApplication.class, args);
    }

}
