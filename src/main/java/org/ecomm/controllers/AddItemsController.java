package org.ecomm.controllers;

import org.ecomm.models.ItemsDet;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * this controller handles the process for
 * adding items it the database by the seller and admin
 * @author sarthak-pc
 *
 */

@Controller
public class AddItemsController {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	/**
	 * controller for adding items in database by sellers
	 * @param itemsdet
	 * @return
	 */
	
	@RequestMapping(value = "/additem", method = RequestMethod.POST)
	public ModelAndView signup(@ModelAttribute("itemsdet") org.ecomm.models.ItemsDet itemsdet) {
		Session session = sessionFactory.openSession();
		ModelAndView model = new ModelAndView("sellerpannel");
		if (session.get(ItemsDet.class, itemsdet.getItemId()) == null) {
			
			session.beginTransaction();
			session.save(itemsdet);
			
			session.getTransaction().commit();
			model.addObject("invalid", "Successfully added item");

		} else
			model.addObject("invalid", "This item is already there.");
		session.close();
		return model;

	}

}
