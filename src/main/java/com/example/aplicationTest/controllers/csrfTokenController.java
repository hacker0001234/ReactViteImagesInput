package com.example.aplicationTest.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class csrfTokenController {
    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(CsrfToken token) {
        return token;
    }
    @GetMapping("api/auth/check")
    public boolean checkAuthentication(@AuthenticationPrincipal OAuth2User principal) {
        return principal != null;
    }
}
