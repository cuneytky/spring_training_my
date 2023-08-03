package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {

        Comment comment  = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");


        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);


        CommentService cs1 = context.getBean(CommentService.class);
        CommentService cs2 = context.getBean(CommentService.class);

        System.out.println(cs1);
        System.out.println(cs2);
        System.out.println(cs1==cs2);

        //scope yapmadan bu 2 si aynı cıktı verecek true verecek:
        /*
com.cydeo.service.CommentService@5bf0d49
com.cydeo.service.CommentService@5bf0d49
true
         */
        //scope yapınca farklı ve false verdi;
        /*
        com.cydeo.service.CommentService@43bc63a3
        com.cydeo.service.CommentService@702657cc
        false
         */

    }
}
