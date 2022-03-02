package com.spring.codeblog.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.spring.codeblog.entities.Post;
import com.spring.codeblog.services.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PostController {

    @Autowired
    private PostService service;

    @RequestMapping("/")
    public String index() {
        return "redirect:/posts";
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public ModelAndView getPosts() {
        ModelAndView mv = new ModelAndView("posts");
        List<Post> posts = service.findAll();
        mv.addObject("posts", posts);
        return mv;
    }

    @GetMapping(value = "/posts/{id}")
    public ModelAndView getPostDetails(@PathVariable("id") Long id) {
        ModelAndView mv = new ModelAndView("postDetails");
        Post post = service.findPostById(id);
        mv.addObject("post", post);
        return mv;
    }

    @GetMapping(value = "/compose")
    public String getPostForm() {
        return "postForm";
    }

    @PostMapping(value = "/compose")
    public String savePost(@Valid Post obj, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            attributes.addFlashAttribute("error", "Required fields are not all filled in!");
            return "redirect:/compose";
        }
        obj.setDate(LocalDate.now());
        service.savePost(obj);
        return "redirect:/posts";
    }

}
