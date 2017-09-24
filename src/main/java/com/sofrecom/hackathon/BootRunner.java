package com.sofrecom.hackathon;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@SpringBootApplication
@EnableJpaRepositories(basePackages = { "com.sofrecom.hackathon.repository" })
@EntityScan(basePackages = { "com.sofrecom.hackathon.model" })
@EnableTransactionManagement
@EnableWebSocket
@EnableScheduling
public class BootRunner extends SpringBootServletInitializer implements WebSocketConfigurer{

	private static final Logger log = LoggerFactory.getLogger(BootRunner.class);

	public static void main(String[] args) throws UnknownHostException {

		SpringApplication app = new SpringApplication(BootRunner.class);
		Environment env = app.run(args).getEnvironment();

		log.info("\n${project.base.dir}\n***********************************************************\n\t"
				+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:{}{}\n\t"
				+ "External: \thttp://{}:{}{}" + "\n***********************************************************\n\n",
				env.getProperty("spring.application.name"), env.getProperty("server.port"),
				env.getProperty("server.contextPath"), InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"), env.getProperty("server.contextPath"));
	}
	
	
	@Autowired
    ArticleNotificationHandler articleNotificationHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(articleNotificationHandler, "/counter").setAllowedOrigins("*");
    }
    
    
}

/*
 * SpringBoot Notes
 * 
 * @Bean :tells Spring 'here is an instance of this class, please keep hold of
 * it and give it back to me when I ask'.
 * 
 * @Autowired :says 'please give me an instance of this class, for example, one
 * that I created with an @Bean annotation earlier'.
 * 
 */
