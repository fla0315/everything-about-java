package com.muji.login.NaverLogin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/naver")
public class NaverLoginController {

  @GetMapping("/login")
  public String naverLogin() {
    return null;
  }

}
