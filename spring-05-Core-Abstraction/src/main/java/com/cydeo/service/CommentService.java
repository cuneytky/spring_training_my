package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.proxy.EmailCommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;

public class CommentService {

    // save in the DB icin oncelikle-DB.1:
    //private DBCommentRepository dbCommentRepository;
    //boyle yaparsak tightly olur. onun yerine:
    private CommentRepository commentRepository;
    private CommentNotificationProxy commentNotificationProxy;

    public void publishComment(Comment comment){
        //save in the DB
        //sonraDB.2
        commentRepository.storeComment(comment);

        //send email
        commentNotificationProxy.sendComment(comment);
    }
}
