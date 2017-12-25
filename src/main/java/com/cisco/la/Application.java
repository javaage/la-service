package com.cisco.la;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableAutoConfiguration
@ComponentScan(basePackages = "com.cisco.la")
@EnableTransactionManagement
@SpringBootApplication
public class Application  {
	
	public final static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public enum Env {
		local, gehc, beta, alpha, bj, diliu, test, security
	};

	public static Env envCurrent = Env.alpha;
	public static String urlUAA = "";
	public static String authorization = "";
	
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(Application.class);
		ApplicationContext ctx = springApplication.run(args);
		envCurrent = Enum.valueOf(Env.class, ctx.getEnvironment().getProperty("spring.profiles.active"));
		urlUAA = ctx.getEnvironment().getProperty("uaa.url");
		authorization = ctx.getEnvironment().getProperty("uaa.authorization");
	}
}
