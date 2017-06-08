package org.ecomm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemRatings {
	
	@Id@GeneratedValue
private int ratingId;	

private String BuyerEmailId;
private String ItemId;
private  int Rating;
public int getRatingId() {
	return ratingId;
}
public void setRatingId(int ratingId) {
	this.ratingId = ratingId;
}
public String getBuyerEmailId() {
	return BuyerEmailId;
}
public void setBuyerEmailId(String buyerEmailId) {
	BuyerEmailId = buyerEmailId;
}
public String getItemId() {
	return ItemId;
}
public void setItemId(String itemId) {
	ItemId = itemId;
}
public int getRating() {
	return Rating;
}
public void setRating(int rating) {
	Rating = rating;
}
	

}
