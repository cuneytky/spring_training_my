package com.cydeo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages = "com.cydeo")
//@ComponentScan(basePackages = {"com.cydeo.proxy","com.cydeo.service","com.cydeo.repository"})
  //tum paketleri yapabiliriz boyle onun yerine ustteki gıbı yaparız

public class CommentConfig {
}
