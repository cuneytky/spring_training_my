package com.cydeo.service;


import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentService {

    // save in the DB icin oncelikle-DB.1:
    //private DBCommentRepository dbCommentRepository;
    //boyle yaparsak tightly olur. onun yerine:
    private final CommentRepository commentRepository; // final yapmak genel usuldur.
     // Cok fazla oldugunda ekleme yapınca constructora eklemeyı unutma ıhtımalı var fınal yapına hata verıp bıze haber vermıs olur.
    private final CommentNotificationProxy commentNotificationProxy;


    // private lere(yukarideki) @autowiring getirmemiz gerekirdi
    // ama bunun yerine constructor getırdık(asagıda)
    //bunları gormesı ıcınde @component getırmeyı unutma
    public CommentService(CommentRepository commentRepository,@Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment){
        //save in the DB
        //sonraDB.2
        commentRepository.storeComment(comment);

        //send email
        commentNotificationProxy.sendComment(comment);
    }
}
