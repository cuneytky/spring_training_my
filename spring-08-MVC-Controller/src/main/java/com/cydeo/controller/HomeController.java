package com.cydeo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller                        // component in child 'ı controller
public class HomeController {

    @RequestMapping("/home")    // end point
    public String home(){          // method adı onemli değil
        return "home.html";        // dönüş yapacak unutma
    }

    @RequestMapping("/ozzy")
    public String getHomePage2(){
        return "home.html";
    }

    @RequestMapping // nothing and /
    public String getHomePage3(){
        return "home.html";
    }

    @RequestMapping ({"/apple","/orange"})
    public String getHomePage4(){
        return "home.html";
    }

}
