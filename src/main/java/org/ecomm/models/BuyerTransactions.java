package org.ecomm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BuyerTransactions {

	@Id@GeneratedValue
	private int TransactionId;
	private String BuyerEmailId;
	private int ItemId;
	private int MoneyRecieved;
	public int getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
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
	public int getMoneyRecieved() {
		return MoneyRecieved;
	}
	public void setMoneyRecieved(int moneyRecieved) {
		MoneyRecieved = moneyRecieved;
	}
	
	
}
