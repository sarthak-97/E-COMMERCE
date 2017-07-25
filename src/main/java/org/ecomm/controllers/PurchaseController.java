package org.ecomm.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.ecomm.models.AdminDet;
import org.ecomm.models.BuyerDet;
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
 * this controller is for handling 
 * all purchase related process
 * 
 * 
 * @author sarthak-pc
 *
 */

@Controller
public class PurchaseController {
	
	@Autowired
	private SessionFactory sessionFactory;
	private BuyerDet buyerdet;
	private AdminDet admindet;
	private ItemsDet itemsdet;
	
	
	/**
	 * this controler handles buy now request
	 * 
	 * its a preorder confirmation page that whether buyer wants to confirm the order or not
	 * @param httpsession
	 * @param itemid
	 * @param qty
	 * @return
	 */
	
	@RequestMapping(value = "/buynow", method = RequestMethod.GET)
	public ModelAndView BuyNow(HttpSession httpsession,@RequestParam("itemid") String itemid,@RequestParam("qty") int qty){
		
		ModelAndView model;
		Session session = sessionFactory.openSession();
		
		
			if(httpsession.getAttribute("SESSION_email")!=null){
			        
				String emailid=(String)httpsession.getAttribute("SESSION_email");
				String buyername=(String)httpsession.getAttribute("SESSION_name");
					model=new ModelAndView("buy");        // temporary name for this view   and can be change afterwards
					                                     
					//buyerdet = (BuyerDet) session.get(BuyerDet.class, emailid);
					itemsdet = (ItemsDet) session.get(ItemsDet.class, itemid);
					httpsession.setAttribute("SESSION_item",itemid);
					httpsession.setAttribute("SESSION_qty", qty);
					String itemName=itemsdet.getItemName();
					String brandName=itemsdet.getItemBrandName();
					int    price=itemsdet.getItemPrice()*qty;
					//String img=itemsdet.getItemImageUrl();
		            
 				    model.addObject("itemname",itemName);
 				    model.addObject("brandname",brandName);
 				    model.addObject("price","price");
 				    model.addObject("qty",qty);
 				   // model.addObject("imgurl",img);           //to be changed to image url model class
 				    model.addObject("buyername",buyername);	
				}
	
			else
				{
			        model=new ModelAndView("index");
			        model.addObject("invalid","login first to continue");
			
					}
		
		return model;
		
	}
	

}
