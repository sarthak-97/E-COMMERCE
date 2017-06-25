package org.ecomm.controllers;

import javax.servlet.http.HttpSession;

import org.ecomm.models.BuyerDet;
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
 * 
 * @author sarthak-pc
 * controller for signin and
 * signup processess.
 */

@Controller
public class LoginController {
	
	@Autowired
	private SessionFactory sessionFactory;
	private BuyerDet buyerdet;
	

	/**
	 * controller for signup of Buyer
	 * @param userdet
	 * @return
	 */
	
	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public ModelAndView signup(@ModelAttribute("buyerdet") org.ecomm.models.BuyerDet buyerdet) {
		Session session = sessionFactory.openSession();
		ModelAndView model = new ModelAndView("index");
		if (session.get(BuyerDet.class, buyerdet.getEmailId()) == null) {
			
			session.beginTransaction();
			session.save(buyerdet);
			
			session.getTransaction().commit();
			model.addObject("invalid", "Successfully registered, login to proceed!");

		} else
			model.addObject("invalid", "This email is already registered.");
		session.close();
		return model;

	}
	
	/**\
	 * controller for login process of Buyer
	 * @param httpSession
	 * @param emailid
	 * @param password
	 * @return
	 */
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(HttpSession httpSession, @RequestParam("id") String emailid,
			@RequestParam("pass") String password) {
		ModelAndView model;
		Session session = sessionFactory.openSession();
		buyerdet = (BuyerDet) session.get(BuyerDet.class, emailid);
		if (buyerdet != null) {
					if (buyerdet.getPassword().equals(password)) {
							httpSession.setAttribute("SESSION_email", buyerdet.getEmailId());
							httpSession.setAttribute("SESSION_name", buyerdet.getName());
						
							if((String) httpSession.getAttribute("SESSION_email")!=null){
								model = new ModelAndView("dashboard");
								
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
	
	/**
	 * 
	 * controller for session logout
	 * 
	 * @author sarthak
	 * @param httpSession
	 * @return
	 */

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView LogoutController(HttpSession httpSession) {
		httpSession.invalidate();
		ModelAndView model = new ModelAndView("index");
		model.addObject("invalid", "successfully logged out");
		return model;
	}
	
}
