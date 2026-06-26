package com.nim.interviewjourney.security; 
import com.nim.interviewjourney.service.UserService;
 import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService; 
 import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest; 
 import org.springframework.security.oauth2.core.user.OAuth2User; 
 import org.springframework.stereotype.Service; 
 @Service
  public class CustomOAuth2UserService extends
   DefaultOAuth2UserService { 
        private final UserService userService; 
        public CustomOAuth2UserService(UserService userService) { 
                this.userService = userService;
         }
          @Override
           public OAuth2User loadUser(OAuth2UserRequest userRequest) { 
                OAuth2User oauthUser = super.loadUser(userRequest); 
                String name = oauthUser.getAttribute("name"); 
                String email = oauthUser.getAttribute("email"); 
                String providerId = oauthUser.getAttribute("sub");
                
                System.out.println("================================");
System.out.println("GOOGLE USER: " + email);
System.out.println("CUSTOM OAUTH SERVICE EXECUTED");
                userService.saveUser( 
                        name,
                         email,
                          "GOOGLE",
                           providerId 
                        );
 return oauthUser; 
}
 }