package com.scm.helper;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;

import lombok.var;

public class Helper {

    public static String getEmailOfLoggedinUser(Authentication authentication){
        // AuthenticatedPrincipal principal = (AuthenticatedPrincipal)authentication.getPrincipal();

        // if logged in with user name and password
        if(authentication instanceof OAuth2AuthenticationToken){
            var aOAuth2AuthenticationToken = (OAuth2AuthenticationToken) authentication;
            var clientId = aOAuth2AuthenticationToken.getAuthorizedClientRegistrationId();

            var oauth2User = (OAuth2User) authentication.getPrincipal();
            String username = "";


            if(clientId.equalsIgnoreCase("google")){
                // with google
                System.out.println("Getting Email from google");
                username = oauth2User.getAttribute("email").toString();

            } else if (clientId.equalsIgnoreCase("github")) {
                // with github
                System.out.println("Getting Email from github");
                username = oauth2User.getAttribute("email") != null ? oauth2User.getAttribute("email").toString()
                        : oauth2User.getAttribute("login").toString() + "@gmail.com";
            }
            return username;
        } else{
            // from local databse
            System.out.println("Getting Email from local database");
            return authentication.getName();
        }

    }
}
