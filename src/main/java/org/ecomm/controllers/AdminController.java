package org.ecomm.controllers;

import javax.servlet.http.HttpSession;

import org.ecomm.models.AdminDet;
import org.ecomm.models.BuyerDet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * this controller handles all the operations for 
 * the admin user
 * includes all the crud operations of items,buyers and sellers
 * 
 * 
 * @author sarthak-pc
 *
 */

@Controller
public class AdminController {

	@Autowired
	private SessionFactory sessionFactory;
	private BuyerDet buyerdet;
	private AdminDet admindet;
	
	
	/**
	 * controller for login of admin
	 * 
	 * 
	 * @param httpSession
	 * @param emailid
	 * @param password
	 * @return
	 */
	
	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public ModelAndView login(HttpSession httpSession, @RequestParam("id") String emailid,
			@RequestParam("pass") String password) {
		ModelAndView model;
		Session session = sessionFactory.openSession();
		admindet= (AdminDet) session.get(AdminDet.class, emailid);
		if (admindet != null) {
					if (admindet.getPassword().equals(password)) {
							httpSession.setAttribute("SESSION_email", admindet.getAdminEmailId());
							httpSession.setAttribute("SESSION_name", admindet.getAdminName());
						
							if((String) httpSession.getAttribute("SESSION_email")!=null){
								model = new ModelAndView("adminpannel");
								
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
