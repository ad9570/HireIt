package com.hire.it.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

   @Bean
   public CorsFilter corsFilter() {
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      CorsConfiguration config = new CorsConfiguration();
      config.setAllowCredentials(true);
      config.addAllowedOriginPattern("*");
      config.addAllowedHeader("*");
      config.addAllowedMethod("*");

      source.registerCorsConfiguration("/resume/**", config);
      source.registerCorsConfiguration("/jobposting/**", config);
      source.registerCorsConfiguration("/corpManagement/**", config);
      source.registerCorsConfiguration("/**", config);
      source.registerCorsConfiguration("/board/**", config);
      source.registerCorsConfiguration("/save/**", config);
      source.registerCorsConfiguration("/image/**", config);
      source.registerCorsConfiguration("/static/image/**", config);
      
      return new CorsFilter(source);
   }

}
