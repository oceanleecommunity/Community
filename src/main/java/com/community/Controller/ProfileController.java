package com.community.Controller;

import com.community.dto.PaginationDTO;
import com.community.model.User;
import com.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Com.OceanLee
 * @date 2019/8/26 1:24
 */
@Controller
public class ProfileController {

    @Autowired
    private QuestionService questionService;

    // 我的问题
    @GetMapping("/profile/{action}")
    public String profile(HttpServletRequest request,
                         @PathVariable(name = "action") String action,
                         @RequestParam(name = "page", defaultValue = "1") Integer page,
                         @RequestParam(name = "size", defaultValue = "10") Integer size,
                          Model model){
        //获取用户信息
        User user =(User) request.getSession().getAttribute("user");

        //如果用户  == null 没有登录得时候就跳转到首页
        if(user == null){
            return "redirect:/";
        }
        if("questions".equals(action)){
            model.addAttribute("section","questions");
            model.addAttribute("sectionName","我的提问");
        }else if("replies".equals(action)){
            model.addAttribute("section","replies");
            model.addAttribute("sectionName","最新回复");
        }
        PaginationDTO paginationDTO = questionService.list(user.getId(), page, size);
        model.addAttribute("pagination",paginationDTO);
        return "profile";
    }
}
