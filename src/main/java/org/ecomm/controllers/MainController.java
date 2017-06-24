package org.ecomm.controllers;

import org.ecomm.models.ItemsDet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpSession;
@RestController
public class MainController {
	
	@Autowired
	private SessionFactory sessionFactory;
	private ItemsDet itemsdet;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView landingPage(HttpSession httpSession){
		
		ModelAndView model=new ModelAndView("index");

		Session session = sessionFactory.openSession();
		List<ItemsDet> items=session.createCriteria(ItemsDet.class).list();
		 
		Collections.shuffle(items);
		model.addObject("items",items);
		
		
		
		return model;
		
	}

}
