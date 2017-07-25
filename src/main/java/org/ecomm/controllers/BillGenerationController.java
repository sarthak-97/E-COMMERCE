package org.ecomm.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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

import com.google.api.client.repackaged.org.apache.commons.codec.binary.Base64;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
@Controller
public class BillGenerationController {
	
	@Autowired
	private SessionFactory sessionFactory;
	private BuyerDet buyerdet;
	private AdminDet admindet;
	private ItemsDet itemsdet;
	
	@RequestMapping(value = "/bill", method = RequestMethod.POST)
public ModelAndView Bill(HttpSession httpsession){
		
		ModelAndView model;
		Session session = sessionFactory.openSession();
		int qty;
		int quantity;
		String itemId;
		 
		         qty=Integer.parseInt((String)httpsession.getAttribute("SESSION_qty"));	
			     itemId=(String)httpsession.getAttribute("SESSION_itemId");
				String emailid=(String)httpsession.getAttribute("SESSION_email");
				String buyername=(String)httpsession.getAttribute("SESSION_name");
					model=new ModelAndView("buy");        // temporary name for this view   and can be change afterwards
					                                     
					//buyerdet = (BuyerDet) session.get(BuyerDet.class, emailid);
					itemsdet = (ItemsDet) session.get(ItemsDet.class, itemId);
					quantity=itemsdet.getQuantity();
					itemsdet.setQuantity(quantity-qty);
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
				return model;
}

	public static MimeMessage createEmail(String to,
            String from,
            String subject,
            String bodyText)
throws MessagingException {
Properties props = new Properties();
javax.mail.Session session = Session.getDefaultInstance(props, null);

MimeMessage email = new MimeMessage(session);

email.setFrom(new InternetAddress(from));
email.addRecipient(javax.mail.Message.RecipientType.TO,
new InternetAddress(to));
email.setSubject(subject);
email.setText(bodyText);
return email;
}
	
	public static Message createMessageWithEmail(MimeMessage emailContent)
            throws MessagingException, IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        emailContent.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(bytes);
        Message message = new Message();
        message.setRaw(encodedEmail);
        return message;
    }

	
public static Message sendMessage(Gmail service,
            String userId,
            MimeMessage emailContent)
throws MessagingException, IOException {
Message message = createMessageWithEmail(emailContent);
message = service.users().messages().send(userId, message).execute();

System.out.println("Message id: " + message.getId());
System.out.println(message.toPrettyString());
return message;
}
}
