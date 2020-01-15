package com.sytoss.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

import java.security.Principal;
import java.util.Locale;

@Controller
public class MainController {


    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String welcomePage(WebRequest webRequest, Model model) {

     /*   if (webRequest.getParameter("lang") != null) {
            Locale.setDefault(Locale.forLanguageTag(webRequest.getParameter("lang")));
        } else {
            Locale.setDefault(Locale.forLanguageTag("ru"));
        }*/
      //  model.addAttribute("title", messageSource.getMessage("pageTitle.welcome", null, Locale.getDefault()));
        return "Main";
    }



    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {
     /*   if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();
            String userInfo = WebUtils.toString(loginedUser);
            model.addAttribute("userInfo", userInfo);
            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);
            model.addAttribute("title", messageSource.getMessage("pageTitle.403", null, Locale.getDefault()));
        }*/
        return "403Page";
    }




}
