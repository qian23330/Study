package com.bigc.controller;

import com.bigc.pojo.DiscussPost;
import com.bigc.pojo.Page;
import com.bigc.pojo.User;
import com.bigc.service.DiscussPostService;
import com.bigc.service.LikeService;
import com.bigc.service.UserService;
import com.bigc.utils.CommunityConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@Controller
@RequestMapping
public class HomeController implements CommunityConstant {

    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @Autowired
    private LikeService likeService;

//    @RequestMapping(path = "/index", method = RequestMethod.GET)
    @GetMapping("/index")
    public String getIndexPage(Model model, Page page) {
        // 方法调用前，springMVC会自动实例化Model和Page，并将Page注入Model，
        // 因此，在thymeleaf中可以直接访问Page对象中的数据
        page.setRows(discussPostService.findDiscussPostRows(0));
        page.setPath("/index");

        List<DiscussPost> list = discussPostService.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String, Object>> disscussPosts = new ArrayList<>();
        if (list != null) {
            for (DiscussPost post: list) {
                Map<String, Object> map = new HashMap<>();
                map.put("post", post);
                User user = userService.findUserById(post.getUserId());
                map.put("user", user);

                long likeCount = likeService.findEntityLikeCount(ENTITY_TYPE_POST, post.getId());
                map.put("likeCount", likeCount);

                disscussPosts.add(map);
            }
        }
        model.addAttribute("discussPosts", disscussPosts);
        return "/index";
    }

    @GetMapping("/error")
    public String getErrorPage() {
        return "/error/500";
    }
}
