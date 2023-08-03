package com.cydeo.service;

import com.cydeo.config.AppConfigData;
import com.cydeo.config.DBConfigData;
import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {

    // save in the DB icin oncelikle-DB.1:
    //private DBCommentRepository dbCommentRepository;
    //boyle yaparsak tightly olur. onun yerine:
    private final CommentRepository commentRepository; // final yapmak genel usuldur.
     // Cok fazla oldugunda ekleme yapınca constructora eklemeyı unutma ıhtımalı var fınal yapına hata verıp bıze haber vermıs olur.
    private final CommentNotificationProxy commentNotificationProxy;

    private final AppConfigData appConfigData;
    private final DBConfigData dbConfigData;

    // private lere(yukarideki) @autowiring getirmemiz gerekirdi
    // ama bunun yerine constructor getırdık(asagıda)
    //bunları gormesı ıcınde @component getırmeyı unutma
    public CommentService(CommentRepository commentRepository, @Qualifier("EMAİL") CommentNotificationProxy commentNotificationProxy, AppConfigData appConfigData, DBConfigData dbConfigData) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.appConfigData = appConfigData;
        this.dbConfigData = dbConfigData;
    }

    public void publishComment(Comment comment){
        //save in the DB
        //sonraDB.2
        commentRepository.storeComment(comment);
        //send email
        commentNotificationProxy.sendComment(comment);
    }
    public void printConfigData() {
        //print ozzy ==> bunu getirmek için farklı dosyada çğıracağımız için get kullandık
            // ve appConfigData yı da yukarıda tanımlayıp constructor a ekledik.
        System.out.println(appConfigData.getUserName());
        //print abc123
        System.out.println(appConfigData.getPassword());
        //print url
        System.out.println(appConfigData.getUrl());

    }

    public void printDbConfigData(){
        System.out.println(dbConfigData.getUsername());
        System.out.println(dbConfigData.getPassword());
        System.out.println(dbConfigData.getType());
    }



}
