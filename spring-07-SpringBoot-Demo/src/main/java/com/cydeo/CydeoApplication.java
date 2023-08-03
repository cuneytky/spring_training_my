package com.cydeo;

import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CydeoApplication {

	public static void main(String[] args) {

		Comment comment  = new Comment();
		comment.setAuthor("Johnson");
		comment.setText("Spring Framework");


		ApplicationContext container = SpringApplication.run(CydeoApplication.class, args);

		CommentService commentService = container.getBean(CommentService.class);
		commentService.publishComment(comment);
		/*
		spring simge ve aşğıdakiler çıktı:
		Storing comment:Spring Framework
        Sending notification for comment:Spring Framework
		 */

		commentService.printConfigData(); // Comment service yeni method yazıp çağırdık.

		commentService.printDbConfigData();// Comment service yeni method yazıp çağırdık.

	}

}
