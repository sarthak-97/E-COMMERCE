package org.ecomm.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

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
 * this controller handles all the reviews and rating request of 
 * products
 * @author sarthak-pc
 *
 */

@Controller
public class ReviewAndRatingController {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@RequestMapping(value = "/add_rating", method = RequestMethod.POST)
	public ModelAndView searchitem(HttpSession httpSession, @RequestParam("rating") int rating) {

		Session session = sessionFactory.openSession();
		ModelAndView model;
		if((String)httpSession.getAttribute("SESSION_email")!=null)
	
		{	        model=new ModelAndView("viewitem");
						ItemsDet item= new ItemsDet();
						int PrevRating,newrating;
		
						PrevRating =item.getItemRating();
		  
								if(PrevRating==0){
		 		
										item.setItemRating(rating);
										model.addObject("invalid","RATING ADDED SUCCESSFULLY");
									}
		 	
								else{
		 		
									int c=(PrevRating+rating)/2;
									newrating=Math.abs(c);
									System.out.println(newrating);
									item.setItemRating(newrating);
									model.addObject("invalid","RATING ADDED SUCCESSFULLY");
								}
		
		}
		else
		{
			model=new ModelAndView("index");
			model.addObject("invalid","LOGIN FIRST TO CONTINUE");
		}
		
		
		return model;
	}

}
