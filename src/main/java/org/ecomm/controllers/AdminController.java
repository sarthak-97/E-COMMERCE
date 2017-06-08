package org.ecomm.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.ecomm.models.AdminDet;
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
	private SellerDet sellerdet;
	
	
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
	
	/**
	 * controller to view all the seller 
	 * by admin for crud operations
	 * @param httpSession
	 * @return
	 */
	
	@RequestMapping(value = "/viewallsellers", method = RequestMethod.GET)
	public ModelAndView ViewAllSeller(HttpSession httpSession) {
		Session session = sessionFactory.openSession();
		ModelAndView model=new ModelAndView("adminpannel");
		
		
		
		
		List<SellerDet> seller = session.createCriteria(SellerDet.class).list();
		
		model.addObject("seller",seller);
		model.addObject("adminname",(String)httpSession.getAttribute("SESSION_name"));
		
		return model;
	}
	
	@RequestMapping(value = "/delseller", method = RequestMethod.GET)
	public ModelAndView DelSeller(HttpSession httpSession, @RequestParam("id") String selleremailid) {
		Session session = sessionFactory.openSession();
		ModelAndView model;
		
		
		sellerdet = (SellerDet) session.get(SellerDet.class, selleremailid);
		
		if(httpSession.getAttribute("SESSION_email")!=null){
				if(sellerdet.getSellerEmailId().equals(selleremailid)){
			
							session.delete(sellerdet);
							model=new ModelAndView("adminpanel");
							model.addObject("invalid","seller delete successfully");
							model.addObject("adminname",(String)httpSession.getAttribute("SESSION_name"));
			
							}
		
				else{
							model=new ModelAndView("adminpannel");
							model.addObject("invalid","no record found");
							model.addObject("adminname",(String)httpSession.getAttribute("SESSION_name"));
		                     }
		}
		else{
			model=new ModelAndView("adminlogin");
			model.addObject("invalid","KINDLY LOGIN FIRST TO CONTINUE");
		}
	
		return model;
	}
	
}
