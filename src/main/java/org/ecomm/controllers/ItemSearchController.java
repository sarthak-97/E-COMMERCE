package org.ecomm.controllers;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * this controller handles all the search 
 * related process of items search
 * @author sarthak-pc
 *
 */

@Controller
public class ItemSearchController {

	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping(value = "/searchitem", method = RequestMethod.POST)
	public ModelAndView signup(HttpSession httpSession, @RequestParam("id") int itemid) {
		
		
		
		return null;
	}
	

}
