package com.scm.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm.scm.constant.MessageType;
import com.scm.scm.entity.User;
import com.scm.scm.forms.UserForm;
import com.scm.scm.helpers.Message;
import com.scm.scm.service.UserService;

import jakarta.servlet.http.HttpSession;


@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @RequestMapping("/home")
    public String home(Model model){
        model.addAttribute("name", "Smart Contact Manager");
        return "home";
    }

    @RequestMapping("/about")
    public String about(Model model){
        return "about";
    }

    @RequestMapping("/services")
    public String services(){
        return "services";
    }

    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(Model model){
        UserForm userForm = new UserForm();
        model.addAttribute("userform", userForm);
        return "register";
    }

    @RequestMapping(value = "/do-register", method=RequestMethod.POST)
    public String userRegistration(@ModelAttribute UserForm userForm, HttpSession httpSession) {
        System.out.println("User Registration Begin......");
        //System.out.println(userForm);
        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("/media/dell/New Volume/Yedhu/Projects/scm/src/main/resources/static/assets/default-profile.png");

        userService.saveUser(user);

        Message message = Message.builder().content("User Registered Successfully").type(MessageType.green).build();
        httpSession.setAttribute("message", message);

        return "redirect:/register";
    }
    



}




