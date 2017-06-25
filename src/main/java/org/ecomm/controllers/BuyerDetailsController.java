package org.ecomm.controllers;




import javax.persistence.Id;
import javax.persistence.Lob;
import javax.servlet.http.HttpSession;

import org.ecomm.models.BuyerDet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * this controllers handles all the crud request of user for his profile details
 * @author sarthak-pc
 *
 */

@Controller
public class BuyerDetailsController {

	@Autowired
	private SessionFactory sessionFactory;	
	private BuyerDet buyerdet;
	
	@RequestMapping(value="/editprofile",method=RequestMethod.GET) 	
	public ModelAndView editprofile(HttpSession httpSession){
		Session session = sessionFactory.openSession();
		
		
		String emailid=(String)httpSession.getAttribute("SESSION_email");
		ModelAndView model;
		if(emailid!=null){
			
			buyerdet=(BuyerDet) session.get(BuyerDet.class,emailid);
			
			
			String EmailId,Name,Address,City,State,Country,password,img;
			 int Pincode,ContactNo,Age;
			model=new ModelAndView("editprofile");
			
			model.addObject("Email",buyerdet.getEmailId()); //******************* have to be made only readonly******************
			model.addObject("name",buyerdet.getName());
			model.addObject("address",buyerdet.getAddress());
			model.addObject("city",buyerdet.getCity());
			model.addObject("State",buyerdet.getState());
			model.addObject("country",buyerdet.getCountry());
			model.addObject("pincode",buyerdet.getPincode());
			model.addObject("contact",buyerdet.getContactNo());
			model.addObject("age",buyerdet.getAge());  //*****************have to be made readonly***********************
			model.addObject("password",buyerdet.getPassword());//**************have to use password text field *************
			model.addObject("img",buyerdet.getImgUrl());
			
			
			
			
			
			
			 
		}
		else{
			model=new ModelAndView("index");
			model.addObject("invalid","Log in first to continue");
		}
		return model;
	}
	
	
	@RequestMapping(value="/updateprofile",method=RequestMethod.POST) 	
	public ModelAndView updateprofile(HttpSession httpSession,@ModelAttribute("buyerdet") org.ecomm.models.BuyerDet buyerdet){
		Session session = sessionFactory.openSession();
		
		
		String emailid=(String)httpSession.getAttribute("SESSION_email");
		ModelAndView model;
		if(emailid!=null){
			
	         session.beginTransaction();
	         session.update(buyerdet);
	         session.getTransaction().commit();		
			
			  model=new ModelAndView("index");
			  model.addObject("invalid","profile updated successfully");
			
			
			
			
			
			
			 
		}
		else{
			model=new ModelAndView("index");
			model.addObject("invalid","Log in first to continue");
		}
		return model;
	}
	
}
