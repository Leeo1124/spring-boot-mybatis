package com.leeo.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController
{
  private final Logger logger = LoggerFactory.getLogger(LoginController.class);

  @GetMapping({"/", "/login"})
  public String loginForm()
  {
    this.logger.info("---- 用户登录 ----");

    return "login";
  }

  @GetMapping({"/modeler"})
  public String modeler(Model model) {
    model.addAttribute("modelId", Integer.valueOf(30010));

    return "modeler";
  }
}