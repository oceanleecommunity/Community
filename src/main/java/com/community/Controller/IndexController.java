package com.community.Controller;

import com.community.dto.QuestionDTO;
import com.community.mapper.UserMapper;
import com.community.model.User;
import com.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
@Controller
public class IndexController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private QuestionService questionService;
    /**
     * 登录页面的时候 循环cookie 如果有就使用，没有就从数据库查
     * @param request
     * @return
     */
    @GetMapping("/")
    public String index(HttpServletRequest request, Model model) {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null && cookies.length!=0)
        for (Cookie cookie:cookies){
            //如果Name equals token
            if(cookie.getName().equals("token")){
                String token = cookie.getValue();
                User user = userMapper.findByToken(token);
                //如果user不=null  就写入到session
                if(user!=null){
                    request.getSession().setAttribute("user",user);
                }
                break;
            }
        }
        List<QuestionDTO> questionList = questionService.list();
        model.addAttribute("questions",questionList);
        return "index";
    }








}
