package org.ecomm.controllers;

import javax.servlet.http.HttpSession;

import org.ecomm.models.BuyerDet;
import org.ecomm.models.SellerDet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * this controller handles all the process 
 * of seller CRUD operations
 * @author sarthak-pc
 *
 */

@Controller
public class SellerController {
	
	@Autowired
	private SessionFactory sessionFactory;
	private SellerDet sellerdet;
	
	
	/**
	 * this controller handles the login request of seller
	 * @param httpSession
	 * @param emailid
	 * @param password
	 * @return
	 */
	
	
	@RequestMapping(value = "/sellerlogin", method = RequestMethod.POST)
	public ModelAndView login(HttpSession httpSession, @RequestParam("id") String emailid,
			@RequestParam("pass") String password) {
		ModelAndView model;
		Session session = sessionFactory.openSession();
		sellerdet = (SellerDet) session.get(SellerDet.class, emailid);
		if (sellerdet!= null) {
					if (sellerdet.getPassword().equals(password)) {
							httpSession.setAttribute("SESSION_email", sellerdet.getSellerEmailId());
							httpSession.setAttribute("SESSION_name", sellerdet.getSellerName());
						
							if((String) httpSession.getAttribute("SESSION_email")!=null){
								model = new ModelAndView("sellerpannel");
								
				               }
							else{
								model = new ModelAndView("index");
								model.addObject("invalid", "LOG IN FIRST TO CONTINUE");
							}
			} else {
				model = new ModelAndView("index");
				model.addObject("invalid", "invalid details");
			}
		}

		else {
			model = new ModelAndView("index");
			model.addObject("norecord", "no record found");
		}
		session.close();
		return model;
	}
	

}
