package edu.hanoi.controller;

import edu.hanoi.jazz.ContextStartEventHandler;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.security.Principal;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    HttpServletRequest request;
    @Autowired
    HttpServletResponse  response;

    private final static Logger logger = Logger.getLogger(HomeController.class);
    @RequestMapping("index")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("message","Home");
        logger.info("Da truy cap vao day");
        return mv;
    }

    @RequestMapping("form-login")
    public ModelAndView formLogin(){
        return new ModelAndView("login");
    }
    @RequestMapping(value = "login")
    public ModelAndView login(@RequestParam(value = "error",required = false)String error) {
        ModelAndView mv = new ModelAndView();
        if (error != null) {
            mv.setViewName("login");
            mv.addObject("error", "Sai tên hoặc mật khẩu!");
        }
        return mv;
    }
    @RequestMapping("user")
    public ModelAndView forUser(){
        ModelAndView mv = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        mv.setViewName("index");
        mv.addObject("message","HelloUser " + auth.getName());
        return mv;
    }
    @RequestMapping("logout")
    public String logout() throws Exception{
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth != null) {
            new SecurityContextLogoutHandler().logout(request,response,auth);
        }
        return "redirect:/";
    }
}
