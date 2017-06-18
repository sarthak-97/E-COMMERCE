package org.ecomm.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ecomm.models.ItemReviews;
import org.ecomm.models.ItemsDet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
	public ModelAndView searchitem(HttpSession httpSession, @RequestParam("keyword") String keyword) {

		Session session = sessionFactory.openSession();
		
		/*
		 * 
		 * space left for using JAX-RS API for optimised search result
		 * 
		 * 
		 */
		
		List<ItemsDet> items=session.createCriteria(ItemsDet.class).list();
		
		ModelAndView model = new ModelAndView("searchresults");
		model.addObject("items",items);
		model.addObject("keyword",keyword);
		
		return model;
	}
	
	/**
	 * this controller handles the request for 
	 * viewing full details of product
	 * @param httpSession
	 * @param itemid
	 * @return
	 */
	
	@RequestMapping(value = "/viewitem", method = RequestMethod.GET)
	public ModelAndView viewitem(HttpSession httpSession, @RequestParam("itemid") int itemid) {

		Session session = sessionFactory.openSession();
		ItemsDet item=new ItemsDet();
		String itemName=item.getItemName();
		
		List<ItemsDet> items=session.createCriteria(ItemsDet.class).list();
		List<ItemReviews> rev=session.createCriteria(ItemReviews.class).list();
		ModelAndView model = new ModelAndView("viewitem");
		model.addObject("items",items);
		model.addObject("id",itemid);
		model.addObject("reviews",rev);
		model.addObject("itemName",itemName);
		
		return model;
	}
	

}
