package org.studyeasy.SpringBlog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.studyeasy.SpringBlog.models.Account;
import org.studyeasy.SpringBlog.models.Post;
import org.studyeasy.SpringBlog.services.AccountService;
import org.studyeasy.SpringBlog.services.PostService;

@Controller
public class AdminController {

    @Autowired
    private PostService postService;

    @SuppressWarnings("unused")
    @Autowired
    private AccountService accountService;

    @GetMapping("/admin")
    public String getAllPosts(Model model) {
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);

        // Fetch account details for each post
        Map<Long, String> postCountsAndRoles = new HashMap<>();
        for (Post post : posts) {
            Account account = post.getAccount();
            long postCount = postService.countPostsByAccount(account);
            String role = account.getRole();  // Assuming you have a method getRole() in Account
            postCountsAndRoles.put(account.getId(), "Posts: " + postCount + ", Role: " + role);
        }
        model.addAttribute("postCountsAndRoles", postCountsAndRoles);

        return "admin_views/admin";
    }
}
