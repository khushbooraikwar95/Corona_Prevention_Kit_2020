package com.wf.corona.model;

public class VisitorProfile {
	
	
	private String userName;
	private String emailid;
	private String contact;
	
	
	
	public VisitorProfile(String userName, String emailid, String contact, String flatno, String street, String area,
			String city, String state) {
		super();
		this.userName = userName;
		this.emailid = emailid;
		this.contact = contact;
		this.flatno = flatno;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
	}

	public VisitorProfile() {
	}

	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
		private String flatno;
		private String street;
		private String area;
		private String city;
		private String state;
		
		
		public String getFlatno() {
			return flatno;
		}
		public void setFlatno(String flatno) {
			this.flatno = flatno;
		}
		public String getStreet() {
			return street;
		}
		public void setStreet(String street) {
			this.street = street;
		}
		public String getArea() {
			return area;
		}
		public void setArea(String area) {
			this.area = area;
		}
		public String getCity() {
			return city;
		}
		public void setCity(String city) {
			this.city = city;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
	

}
