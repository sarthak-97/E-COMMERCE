package org.ecomm.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ecomm.models.ItemsDet;
import org.ecomm.models.SellerDet;
import org.hibernate.Session;
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
	
	
	/**
	 * this controller handles the product search request
	 * @param httpSession
	 * @param keyword
	 * @return
	 */
	
	@RequestMapping(value = "/searchitem", method = RequestMethod.POST)
	public ModelAndView signup(HttpSession httpSession, @RequestParam("keyword") String keyword) {

		Session session = sessionFactory.openSession();
		
		List<ItemsDet> items=session.createCriteria(ItemsDet.class).list();
		
		ModelAndView model = new ModelAndView("searchresults");
		model.addObject("items",items);
		model.addObject("keyword",keyword);
		
		return model;
	}
	

}
