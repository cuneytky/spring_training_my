package com.cydeo.controller;

import com.cydeo.enums.Gender;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

// 0- enum olştur
//01- mentor sf ile variable oluştur
//02- bu sf oluştur ve aşagıdaki sırayı takip et

@Controller                      // 2-controller ekle
public class MentorController {  // 1 mentor class olustur.
    @RequestMapping("/list")
    public String showTable(Model model){   // 3-method oluştur   // 6- Model ekle

        //4. liste oluştur ve ekle:
        List<Mentor> mentorList = new ArrayList<>();
        mentorList.add(new Mentor("Mike","Smith",45, Gender.MALE));
        mentorList.add(new Mentor("Tom","Hanks",65, Gender.MALE));
        mentorList.add(new Mentor("Ammy","Bryan",25, Gender.FEMALE));

        model.addAttribute("mentors",mentorList); //7- modala attribute ekle

        // 5- son noktayı ekle
        return "mentor/mentor-list";

        // 8- html sayfası oluşturup tyhm ile ekleme yap ki dinamik olsun.
        //    mentors ile eklenecek dikkat (th:text="${mentors.get(0).firstName}")
        //    burada headera th ekle
    }
}
