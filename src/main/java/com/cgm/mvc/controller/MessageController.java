package com.cgm.mvc.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cgm.mvc.users.ListUsers;
import com.cgm.mvc.users.Message;
import com.cgm.mvc.users.User;

@Controller
public class MessageController {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/newmessage", method = RequestMethod.GET)
	protected ModelAndView getMessage(Map model) throws Exception {
		Message message = (Message) model.get("newmessage");
		
		if(message == null || message.getTxt() == null) {
			model.put("newmessage", new Message());
		}
		
		return new ModelAndView("newmessage", model);
	}
	
	@RequestMapping(value = "/newmessage", method = RequestMethod.POST)
	protected ModelAndView setMesssage(@ModelAttribute("message") Message message, HttpServletRequest request) {
		User user = (User)request.getSession().getAttribute("LOGGEDIN_USER");
		
		for(User u : ListUsers.users) {
			if((u.getUsername()).equals(user.getUsername())) {
				u.addMessage(message.getTxt());
			}
		}
		
		return new ModelAndView("redirect:/main");
	}
}
