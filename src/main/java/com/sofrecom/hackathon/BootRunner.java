package com.sofrecom.hackathon;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableTransactionManagement
public class BootRunner extends SpringBootServletInitializer {

	private static final Logger log = LoggerFactory.getLogger(BootRunner.class);

	public static void main(String[] args) throws UnknownHostException {

		SpringApplication app = new SpringApplication(BootRunner.class);
		Environment env = app.run(args).getEnvironment();

		log.info("\n\n${project.base.dir}***********************************************************\n\t"
				+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\thttp://localhost:{}{}\n\t"
				+ "External: \thttp://{}:{}{}" + "\n***********************************************************\n\n",
				env.getProperty("spring.application.name"), env.getProperty("server.port"),
				env.getProperty("server.context-path"), InetAddress.getLocalHost().getHostAddress(),
				env.getProperty("server.port"), env.getProperty("server.context-path"));
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(BootRunner.class);
	}

	@Bean
	public ConversionService conversionService() {
		return new DefaultConversionService();
	}

	@Bean
	public MethodValidationPostProcessor methodValidationPostProcessor() {
		return new MethodValidationPostProcessor();
	}

	@Bean
	ServletRegistrationBean h2servletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new org.h2.server.web.WebServlet());
		registrationBean.addUrlMappings("/console/*");
		return registrationBean;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider(PasswordEncoder passwordEncoder,
			UserDetailsService userDetailsService) {

		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return daoAuthenticationProvider;

	}

}
