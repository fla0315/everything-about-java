package com.muji.NaverLogin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/naver")
public class NaverLoginController {

  @GetMapping("/login")
  public String naverLogin() {
    System.out.println("true = " + true);
    System.out.println("로그인!");
    return null;
  }

}
