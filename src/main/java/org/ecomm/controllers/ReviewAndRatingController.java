package org.ecomm.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ecomm.models.AdminDet;
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
 * this controller handles all the reviews and rating request of 
 * products
 * @author sarthak-pc
 *
 */

@Controller
public class ReviewAndRatingController {
	
	@Autowired
	private SessionFactory sessionFactory;
	private ItemsDet item;
	private ItemReviews itemreviews;
	
	
	/**
	 * add ratings to the products
	 * @param httpSession
	 * @param rating
	 * @param itemid
	 * @return
	 */
	
	@RequestMapping(value = "/add_rating", method = RequestMethod.POST)
	public ModelAndView addrating(HttpSession httpSession, @RequestParam("rating") int rating,@RequestParam("id") int itemid) {

		Session session = sessionFactory.openSession();
		  session.beginTransaction();
		ModelAndView model;
		if((String)httpSession.getAttribute("SESSION_email")!=null)
	
		{	        model=new ModelAndView("viewitem");
						item= (ItemsDet) session.get(ItemsDet.class, itemid);
						int PrevRating,newrating;
		
						PrevRating =item.getItemRating();
		  
								if(PrevRating==0){
		 		
										item.setItemRating(rating);
										session.save(item);
										session.getTransaction().commit();
										List<ItemsDet> items=session.createCriteria(ItemsDet.class).list();
										
										
										model.addObject("items",items);
										model.addObject("id",itemid);
										
										model.addObject("invalid","RATING ADDED SUCCESSFULLY");
									}
		 	
								else{
		 		
									int c=(PrevRating+rating)/2;
									newrating=Math.abs(c);
									System.out.println(newrating);
									item.setItemRating(newrating);
									session.save(item);
									session.getTransaction().commit();
									List<ItemsDet> items=session.createCriteria(ItemsDet.class).list();
									
									
									model.addObject("items",items);
									model.addObject("id",itemid);
									
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
	
	
	@RequestMapping(value = "/add_reviews", method = RequestMethod.POST)
	public ModelAndView addreviews(HttpSession httpSession, @RequestParam("review") String review,@RequestParam("id") int itemid) {

		Session session = sessionFactory.openSession();
		  session.beginTransaction();
		ModelAndView model;
		 if((String)httpSession.getAttribute("SESSION_email")!=null)
		 {
			  
			  String PostedBy=(String)httpSession.getAttribute("SESSION_email");
			  
			  itemreviews= new ItemReviews();
			  itemreviews.setBuyerEmailId(PostedBy);
			  itemreviews.setItemId(itemid);
			  itemreviews.setItemReview(review);
			  session.save(itemreviews);
			  session.getTransaction().commit();
			  model=new ModelAndView("viewitem");
			  List<ItemsDet> items=session.createCriteria(ItemsDet.class).list();
			  List<ItemReviews> rev=session.createCriteria(ItemReviews.class).list();
				
				model.addObject("items",items);
				model.addObject("reviews",rev);
				model.addObject("id",itemid);
			  model.addObject("invalid","review added successfully");
			
		 }
		
		 else{
			 model=new ModelAndView("index");
			 model.addObject("invalid","LOG IN FIRST TO CONTINUE");
		 }
		  
		  
		  return model;
	}
	

}
