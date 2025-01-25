package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayApplication {

	/**
	 * <h1>Spring Cloud Gateway</h1>
	 *
	 * <p>
	 * The <code>spring-cloud-starter-gateway</code> dependency is used to create a gateway service
	 * in a microservices architecture. The gateway acts as a single entry point for all incoming
	 * requests, handling routing, load balancing, security, and cross-cutting concerns like logging
	 * and rate limiting. It decouples clients from individual microservices, providing a unified
	 * interface for accessing the system.
	 * </p>
	 *
	 * <p>
	 * By default, the Spring Cloud Gateway runs on port <strong>8080</strong>. This port can be
	 * customized by setting the <code>server.port</code> property in the <code>application.yml</code>
	 * or <code>application.properties</code> file of the Gateway application.
	 * </p>
	 *
	 * <h2>Key Features:</h2>
	 * <ul>
	 *   <li><strong>Routing</strong>: Routes requests to the appropriate microservice based on path, host, or other criteria.</li>
	 *   <li><strong>Load Balancing</strong>: Distributes traffic across multiple instances of a service.</li>
	 *   <li><strong>Security</strong>: Handles authentication and authorization before forwarding requests.</li>
	 *   <li><strong>Filters</strong>: Applies pre- and post-processing logic to requests and responses (e.g., logging, rate limiting).</li>
	 *   <li><strong>Integration</strong>: Works seamlessly with Eureka for service discovery and Spring Cloud Config for centralized configuration.</li>
	 * </ul>
	 *
	 * <h1>Comparison of Key Microservices Tools</h1>
	 *
	 * <table border="1">
	 *   <tr>
	 *     <th><strong>Feature</strong></th>
	 *     <th><strong>Spring Cloud Config</strong></th>
	 *     <th><strong>Eureka</strong></th>
	 *     <th><strong>Spring Cloud Gateway</strong></th>
	 *   </tr>
	 *   <tr>
	 *     <td><strong>Purpose</strong></td>
	 *     <td>Centralized configuration management.</td>
	 *     <td>Service registration and discovery.</td>
	 *     <td>API gateway for routing and filtering.</td>
	 *   </tr>
	 *   <tr>
	 *     <td><strong>What It Does</strong></td>
	 *     <td>Stores and serves configuration files for microservices.</td>
	 *     <td>Tracks the location of microservices.</td>
	 *     <td>Routes requests to the appropriate microservice.</td>
	 *   </tr>
	 *   <tr>
	 *     <td><strong>Key Use Case</strong></td>
	 *     <td>Managing database URLs, API keys, feature flags, etc.</td>
	 *     <td>Allowing microservices to find each other dynamically.</td>
	 *     <td>Acting as a single entry point for all incoming requests.</td>
	 *   </tr>
	 *   <tr>
	 *     <td><strong>Default Port</strong></td>
	 *     <td>8888</td>
	 *     <td>8761</td>
	 *     <td>8080</td>
	 *   </tr>
	 *   <tr>
	 *     <td><strong>Integration</strong></td>
	 *     <td>Works with microservices to provide configurations.</td>
	 *     <td>Works with microservices for registration and discovery.</td>
	 *     <td>Works with Eureka for service discovery and Config Server for configurations.</td>
	 *   </tr>
	 *   <tr>
	 *     <td><strong>Key Features</strong></td>
	 *     <td>
	 *       <ul>
	 *         <li>Centralized configuration management.</li>
	 *         <li>Environment-specific configs.</li>
	 *         <li>Dynamic updates.</li>
	 *       </ul>
	 *     </td>
	 *     <td>
	 *       <ul>
	 *         <li>Service registration and discovery.</li>
	 *         <li>Load balancing.</li>
	 *         <li>Health checks and self-preservation.</li>
	 *       </ul>
	 *     </td>
	 *     <td>
	 *       <ul>
	 *         <li>Routing.</li>
	 *         <li>Load balancing.</li>
	 *         <li>Security (authentication, rate limiting).</li>
	 *         <li>Filters (logging, modification of requests/responses).</li>
	 *       </ul>
	 *     </td>
	 *   </tr>
	 *   <tr>
	 *     <td><strong>Example Scenario</strong></td>
	 *     <td>A microservice fetches its database URL from the Config Server at startup.</td>
	 *     <td>The Order Service asks Eureka, "Where is the User Service?"</td>
	 *     <td>A client sends a request to <code>/user/123</code>, and the gateway routes it to the User Service.</td>
	 *   </tr>
	 *   <tr>
	 *     <td><strong>Dependency</strong></td>
	 *     <td><code>spring-cloud-config-server</code></td>
	 *     <td><code>spring-cloud-starter-netflix-eureka-server</code></td>
	 *     <td><code>spring-cloud-starter-gateway</code></td>
	 *   </tr>
	 *   <tr>
	 *     <td><strong>Annotation</strong></td>
	 *     <td><code>@EnableConfigServer</code></td>
	 *     <td><code>@EnableEurekaServer</code></td>
	 *     <td>None (configured via YAML or properties).</td>
	 *   </tr>
	 *   <tr>
	 *     <td><strong>Analogy</strong></td>
	 *     <td>The <strong>manager’s office</strong> that stores all the rules and settings.</td>
	 *     <td>The <strong>reception desk</strong> that tracks where everyone is.</td>
	 *     <td>The <strong>front door</strong> that directs visitors to the right place.</td>
	 *   </tr>
	 * </table>
	 *
	 * <p>
	 * <h4>Summary</h4>
	 * <ul>
	 * <li>Spring Cloud Config: Manages configurations for all microservices.</li>
	 *
	 * <li>Eureka: Handles service registration and discovery.</li>
	 *
	 * <li>Spring Cloud Gateway: Acts as the single entry point for all requests, handling routing, security, and filtering.</li>
	 * </ul>
	 * </p>
	 */


	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

}
