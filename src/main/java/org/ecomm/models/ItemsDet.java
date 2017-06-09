package org.ecomm.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class ItemsDet {

@Id	
private int ItemId;	
private String ItemName;
private String ItemCategory;
private String ItemBrandName;
@Lob
private String ItemDescription;
private int ItemPrice;
private int ItemRating;
private String ItemSellerId;
private String ItemImageUrl;

public int getItemId() {
	return ItemId;
}
public void setItemId(int itemId) {
	ItemId = itemId;
}
public String getItemName() {
	return ItemName;
}
public void setItemName(String itemName) {
	ItemName = itemName;
}
public String getItemCategory() {
	return ItemCategory;
}
public void setItemCategory(String itemCategory) {
	ItemCategory = itemCategory;
}
public String getItemBrandName() {
	return ItemBrandName;
}
public void setItemBrandName(String itemBrandName) {
	ItemBrandName = itemBrandName;
}
public String getItemDescription() {
	return ItemDescription;
}
public void setItemDescription(String itemDescription) {
	ItemDescription = itemDescription;
}
public int getItemPrice() {
	return ItemPrice;
}
public void setItemPrice(int itemPrice) {
	ItemPrice = itemPrice;
}
public int getItemRating() {
	return ItemRating;
}
public void setItemRating(int itemRating) {
	ItemRating = itemRating;
}
public String getItemSellerId() {
	return ItemSellerId;
}
public void setItemSellerId(String itemSellerId) {
	ItemSellerId = itemSellerId;
}
public String getItemImageUrl() {
	return ItemImageUrl;
}
public void setItemImageUrl(String itemImageUrl) {
	ItemImageUrl = itemImageUrl;
}

	
}
