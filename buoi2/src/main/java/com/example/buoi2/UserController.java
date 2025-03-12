package com.example.buoi2;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping
    public String index(Model model) {
        return "fileHTML";
    }

    @GetMapping("/addAtt")
    public String addAtt(Model model) {
        model.addAttribute("name", "abc");
        User user = new User("NV001", "nguyễn văn a", 18);
        model.addAttribute("user", user);

        return "fileHTML2";
    }

    @GetMapping("/addAtt2")
    public String addAtt2(Model model) {
        List<User> list = new ArrayList<User>();
        list.add(new User("NV001", "nguyễn văn a", 18));
        list.add(new User("NV002", "nguyễn văn b", 19));
        list.add(new User("NV003", "nguyễn văn c", 20));
        list.add(new User("NV004", "nguyễn văn d", 21));
        model.addAttribute("users", list);

        return "fileHTML3";
    }


}
