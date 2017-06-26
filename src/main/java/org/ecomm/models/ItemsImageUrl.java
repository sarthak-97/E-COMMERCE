package org.ecomm.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ItemsImageUrl {
	
	
	@Id@GeneratedValue
		private int urlId;	
		private int itemId;
		private String url;
		
		
		public int getUrlId() {
			return urlId;
		}
		public void setUrlId(int urlId) {
			this.urlId = urlId;
		}
		public int getItemId() {
			return itemId;
		}
		public void setItemId(int itemId) {
			this.itemId = itemId;
		}
		public String getUrl() {
			return url;
		}
		public void setUrl(String url) {
			this.url = url;
		}
	
		
		
	
}
