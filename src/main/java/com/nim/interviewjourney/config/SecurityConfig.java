package com.nim.interviewjourney.config; 
import com.nim.interviewjourney.security.CustomOAuth2UserService; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 
import org.springframework.security.config.Customizer; 
import org.springframework.security.config.annotation.web.builders.HttpSecurity; 
import org.springframework.security.web.SecurityFilterChain;
 @Configuration
  public class SecurityConfig { 
        private final CustomOAuth2UserService customOAuth2UserService;
         public SecurityConfig(CustomOAuth2UserService customOAuth2UserService) { 
                this.customOAuth2UserService = customOAuth2UserService;
         }
          @Bean 
          public SecurityFilterChain securityFilterChain(HttpSecurity http) 
          throws Exception { 
                http 
                .csrf(csrf -> csrf.disable()) 
                .authorizeHttpRequests(auth -> auth 
                        .requestMatchers( 
                                "/", 
                                "/login", 
                                "/oauth2/**", 
                                "/swagger-ui/**",
                                 "/v3/api-docs/**" 
                                ).permitAll()
                                 .anyRequest().authenticated() 
                                )
                                 .oauth2Login(oauth -> 
                                        oauth 
                                        .loginPage("/oauth2/authorization/google") 
                                        .userInfoEndpoint(userInfo -> userInfo.userService(customOAuth2UserService)
                                 )
                                 )
                                  .logout(logout -> logout 
                                        .logoutSuccessUrl("/oauth2/authorization/google") 
                                )
                                 .httpBasic(Customizer.withDefaults());

                                return http.build(); 
                        }
                 }