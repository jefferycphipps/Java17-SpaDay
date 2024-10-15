package org.launchcode.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.launchcode.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.launchcode.models.User;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping()
    public String displayUserIdex(){
        return "/user/index";

    }

    @GetMapping("add")
    public String displayAddUserForm(){
        return "/user/add";
    }


    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify,  String username, String email) {
        // add form submission handling code here
        System.out.println(verify);

        user.setEmail(email);
        user.setUsername(username);
        String test = user.getPassword();
        System.out.println(test);
        if(!test.equals(verify)){
            model.addAttribute("error", "Password does not match");
        }else {
            model.addAttribute("user", user);
        }
        return "/user/index";
    }

}
