package com.in28minutes.controllers;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {
 //    Login function is handled by Spring Security now, so this userValidationService method is useless now
//    @Autowired      //dependency injection
//    UserValidationService userValidationService;

//    //Tell DispatcherServlet to redirect  http://localhost:8080/ to login page
//    @RequestMapping(value="")
//    public String indexPage(){
//        return "login";
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        model.put("name", getLoggedInUserName());
        return "welcome";       //direct to login.jsp, but first need to set up ViewResolver so that "login" is resolved to "/WEB-INF/views/login.jsp", or we can hard code the path "/WEB-INF/views/welcome.jsp""
    }

    private String getLoggedInUserName(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();

    }

//    Login function is handled by Spring Security now, so this post method is useless now
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public String handleLoginRequest(@RequestParam String name, @RequestParam String password, ModelMap model){ //ModelMap is used to pass data (model) between view and controller
//        if (userValidationService.isUserValid(name, password)){
//            model.put("name", name);  //what is put in the model will be available in the view
//            return "welcome";
//        } else {
//            model.put("errorMessage", "Invalid login details");
//            return "login";
//        }
//
//
//    }



}
