package org.ecomm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class ItemReviews {

	@Id @GeneratedValue
private int reviewId;	
	
private String BuyerEmailId;
private int ItemId;
@Lob
private String ItemReview;
public int getReviewId() {
	return reviewId;
}
public void setReviewId(int reviewId) {
	this.reviewId = reviewId;
}
public String getBuyerEmailId() {
	return BuyerEmailId;
}
public void setBuyerEmailId(String buyerEmailId) {
	BuyerEmailId = buyerEmailId;
}
public int getItemId() {
	return ItemId;
}
public void setItemId(int itemId) {
	ItemId = itemId;
}
public String getItemReview() {
	return ItemReview;
}
public void setItemReview(String itemReview) {
	ItemReview = itemReview;
}
}
