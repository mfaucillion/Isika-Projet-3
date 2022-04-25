package fr.isika.cda14.efund.managedbeans;

import java.io.Serializable;

import javax.faces.bean.ManagedProperty;

public class SuperShopBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManagedProperty("#shopBean")
	private ShopBean myshopBean;
	public ShopBean getMyshopBean() {
		return myshopBean;
	}
	public void setMyshopBean(ShopBean myshopBean) {
		this.myshopBean = myshopBean;
	}
	

}
