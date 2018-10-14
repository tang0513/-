package com.txy.meet.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.txy.meet.entity.User;
import com.txy.meet.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public String login(String username,String password,HttpSession session,Model model) {
		List<User> list=userService.findUserAll();
		for (User user : list) {
			if(username.equals(user.getUsername())&&password.equals(user.getPassword())) {
				session.setAttribute("user", user);
				return "redirect:http://localhost/index.html";
			}
		}
		model.addAttribute("mess", "用户名或密码有误，请重新输入");
		return "redirect:http://localhost/login.html";
	}
	
}
