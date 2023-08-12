package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CydeoApplication {

    public static void main(String[] args) {

        SpringApplication.run(CydeoApplication.class, args);
    }

}
/*
TASK:
1-create a mentor class with the firstname, lastname, age, gender fields
2- Gender should be an enum
3- Create mentorController
4- Create sample mentor class objects
5- add those objects to the model
6- create HTML page
7- Pass the mentor object added to model earlier, to view and show them in the
   table on browser, as shown in the picture
 */