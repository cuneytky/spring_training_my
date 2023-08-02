package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp { // burasının cm.cydeo altında olması onemli sprıng ıcın
    public static void main(String[] args) {

        Comment comment  = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");


        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);

        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

        /* cıktı
        Storing comment:Spring Framework
        Sending notification for comment:Spring Framework
         */

    }
}
