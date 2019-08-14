package com.javacode.controller.web;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.javacode.controller.BaseController;
import com.javacode.entities.Profile;
import com.javacode.entities.User;
import com.javacode.service.impl.UserAuth;

@Controller
public class UserProfileController extends BaseController {

	@GetMapping({ "/profile" })
	public String index(Model model, Authentication authentication) {
		loadAttributes(model);
		UserAuth user = (UserAuth) authentication.getPrincipal();
		model.addAttribute("userForm", user.getUser());
		return "views/web/user/index";
	}

	@RequestMapping(value = "/user/profile", method = RequestMethod.POST)
	public String submitAddOrUpdateUser(@Valid @ModelAttribute("userForm") User user, BindingResult bindingResult,
			Model model, final RedirectAttributes redirectAttributes, Authentication authentication) {
		userService.saveProfile(user);
		UserAuth userAuth = (UserAuth) authentication.getPrincipal();
		userAuth.setUser(user);
		return "redirect:/profile";
	}
}
