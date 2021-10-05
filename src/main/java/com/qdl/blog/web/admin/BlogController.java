package com.qdl.blog.web.admin;


import com.qdl.blog.po.Blog;
import com.qdl.blog.po.Type;
import com.qdl.blog.service.BlogService;
import com.qdl.blog.service.TypeService;
import com.qdl.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/admin")
public class BlogController {

    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(@PageableDefault(size = 10,sort ={"updateTime"},direction = Sort.Direction.DESC)Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("types",typeService.listType());
        model.addAttribute("page",blogService.ListBlog(pageable,blog));
        return "admin/blogs";
    }
    @PostMapping("/blogs/search")
    public String search(@PageableDefault(size = 10,sort ={"updateTime"},direction = Sort.Direction.DESC)Pageable pageable, BlogQuery blog, Model model){
        model.addAttribute("page",blogService.ListBlog(pageable,blog));
        return "admin/blogs::blogList";
    }

}
