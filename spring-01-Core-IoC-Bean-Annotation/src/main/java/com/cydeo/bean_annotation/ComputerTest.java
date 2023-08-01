package com.cydeo.bean_annotation;

import com.cydeo.bean_annotation.casefactory.Case;
import com.cydeo.bean_annotation.casefactory.DellCase;
import com.cydeo.bean_annotation.config.ComputerConfig;
import com.cydeo.bean_annotation.config.RandomConfig;
import com.cydeo.bean_annotation.monitorfactory.AcerMonitor;
import com.cydeo.bean_annotation.monitorfactory.Monitor;
import com.cydeo.bean_annotation.monitorfactory.SonyMonitor;
import com.cydeo.bean_annotation.motherboardfactory.AsusMotherboard;
import com.cydeo.bean_annotation.motherboardfactory.Motherboard;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {


        System.out.println("Creating Container");

        //Creating container by using Application Context
        ApplicationContext container = new AnnotationConfigApplicationContext(ComputerConfig.class, RandomConfig.class);

        //Creating container by using BeanFactory
       // BeanFactory context = new AnnotationConfigApplicationContext();

        System.out.println("************Retrieving the beans******************");

        SonyMonitor sony = container.getBean(SonyMonitor.class);
        DellCase dell = container.getBean(DellCase.class);
        AsusMotherboard asus = container.getBean(AsusMotherboard.class);

        PC myPc = new PC(dell,sony,asus);

        myPc.powerUp();  // Power button pressed
                         // Drawing pixel with Sony

        dell.pressPowerButton(); // Power button pressed

        System.out.println("************Retrieving the beans******************");

//        Monitor theMonitor = container.getBean(Monitor.class);
//        Case theCase = container.getBean(Case.class);
//        Motherboard theMotherboard = container.getBean(Motherboard.class);
//
//        PC myPc2 = new PC(theCase,theMonitor,theMotherboard);
//
//        myPc2.powerUp(); //Power button pressed
//                         //Drawing pixel with Acer
//
//        theCase.pressPowerButton();  //Power button pressed
//
//        theMonitor.drawPixelAt();    //Drawing pixel with Acer

        System.out.println("************Multiple Objects******************");

        //Monitor theMonitor5= container.getBean(beanName, Monitor.class);
               //burada beanName oluşturduğumuz metodlarda hangisini alacaksak onu kullanmalıyız

        Monitor theMonitor2 = container.getBean("monitorSony", Monitor.class);  //DEFAULT BEAN NAME (dirak method adını kullandık)
        Monitor theMonitor3 = container.getBean("sony", Monitor.class);         //CUSTOM BEAN NAME (adını biz vererek kullandık)
                                                                                    //( bunu yapınca artık adı sony oldu monitorSony bulamaz)
        Monitor theMonitor4 = container.getBean( Monitor.class);  //@Primary  (direk bunu kullanmasını sağladık.adını yazmadık primary alıp kullanacak)
        // primary 1 den fazla aynı type te olursa kullanabiliriz Burada ikisinin adı da Monitor










    }
}
