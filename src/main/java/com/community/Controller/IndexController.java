package com.community.Controller;

import com.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class IndexController {



    @GetMapping("hello")
    public String hello() {
        return "index";
    }

}