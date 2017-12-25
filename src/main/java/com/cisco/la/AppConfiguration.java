package com.cisco.la;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class AppConfiguration {
//	@Value("${security.oauth2.client.accessTokenUri}")
//    private String accessTokenUri;
//
//    @Value("${security.oauth2.client.userAuthorizationUri}")
//    private String userAuthorizationUri;
//
//    @Value("${security.oauth2.client.clientId}")
//    private String clientID;
//
//    @Value("${security.oauth2.client.clientSecret}")
//    private String clientSecret;
//    
//    @Value("${security.oauth2.client.pre-established-redirect-uri}")
//    private String preEstablishedRedirectUri;
//    
//    @Value("${security.oauth2.client.registered-redirect-uri}")
//    private String registeredRedirectUri;
//    
//    @Value("${security.oauth2.client.use-current-uri}")
//    private Boolean useCurrentUri;

//    @Bean
//    public OAuth2RestOperations restTemplate(OAuth2ClientContext oauth2ClientContext) {
//    	System.out.println("restTemplate");
//    	System.out.println(oauth2ClientContext.getAccessTokenRequest().getCurrentUri());
//    	
//        return new OAuth2RestTemplate(resource(), oauth2ClientContext);
//    }
//
//    private OAuth2ProtectedResourceDetails resource() {
//    	Oauth2ResourceDetail resource = new Oauth2ResourceDetail();
//        resource.setClientId(clientID);
//        resource.setClientSecret(clientSecret);
//        resource.setAccessTokenUri(accessTokenUri);
//        resource.setUserAuthorizationUri(userAuthorizationUri);
//        resource.setScope(Arrays.asList("read"));
//        
//        resource.setUseCurrentUri(useCurrentUri);
//        resource.setPreEstablishedRedirectUri(preEstablishedRedirectUri);
//
//        return resource;
//    }
//	
//    @Bean
//    public AuthenticationSuccessHandler successHandler() {
//		return new OAuth2SuccessHandler();
//	}
    
//    @Bean
//	public OAuth2ClientContextFilter oauth2ClientContextFilter() {
//		OAuth2ClientContextFilter filter = new OAuth2RedirectFilter();
//		return filter;
//	}
    
	@Bean
    public PlatformTransactionManager txManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

	private CorsConfiguration buildConfig() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*"); // 1
		corsConfiguration.addAllowedHeader("*"); // 2
		corsConfiguration.addAllowedMethod("*"); // 3
		return corsConfiguration;
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", buildConfig()); // 4
		return new CorsFilter(source);
	}
}
