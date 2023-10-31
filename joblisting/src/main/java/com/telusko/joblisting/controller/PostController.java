package com.telusko.joblisting.controller;

import com.telusko.joblisting.repository.PostRepository;
import com.telusko.joblisting.model.Post;
import com.telusko.joblisting.repository.SearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")//verify and change it next time
public class PostController
{

    @Autowired
    PostRepository repo;

    @Autowired
    SearchRepository srepo;
    @ApiIgnore
    @RequestMapping(value="/")
   public void redirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-ui.html");

   }
   @GetMapping("/allPosts")
   @CrossOrigin
   public List<Post> getAllPosts()

   {
       return repo.findAll();
   }
   @GetMapping("/posts/{text}")
   @CrossOrigin
   public List<Post> Search(@PathVariable String text){
        return srepo.findByText(text);
   }
   @PostMapping("/post")
   @CrossOrigin
   public Post addPost(@RequestBody Post post)
   {
       return repo.save(post);

   }
}
