package com.gzzz.controller;

import com.gzzz.pojo.User;
import jakarta.ws.rs.core.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * className: UserController
 * Package : com.gzzz.controller
 * Description:
 *
 * @Author gzzz
 * @Create 2024/2/20 3:38
 * @Version 1.0
 */
@RestController
@RequestMapping("user")
public class UserController {
    @GetMapping
    public List<User> page(@RequestParam(required = false, defaultValue = "1") int page, @RequestParam(required = false, defaultValue = "10") int size) {
        System.out.println("page =" + page + ", size = " + size);
        return null;
    }

    @PostMapping()
    public User save(@RequestBody User user) {
        return user;
    }

    @GetMapping("{id}")
    public User detail(@PathVariable("id") String id) {
        return null;
    }

    @PutMapping()
    public User update(@RequestBody User user) {
        return user;
    }

    @DeleteMapping("{id}")
    public User delete(@PathVariable Integer id) {
        return null;
    }

    @GetMapping("search")
    public List<User> search(String keyword,@RequestParam(required = false,defaultValue = "1") int page,@RequestParam(required = false,defaultValue = "10") int size) {
        return null;
    }
}
