package com.wf.corona.model;

public class ProductMaster {
	

	private Integer id;
	private String productName;
	private Double cost;
	private String productDescription;
	private Integer availableQuantity;
	private int reqQuantity;
	private Double totalCost;
	private Double totalAmt;
	
	public ProductMaster() {
		// TODO Auto-generated constructor stub
	}
	
	public ProductMaster(Integer id, String productName, Double cost, String productDescription,int reqQuantity,String availableQuantity,Double totalCost,Double totalAmt) {
		super();
		this.id = id;
		this.productName = productName;
		this.cost = cost;
		this.productDescription = productDescription;
		this.reqQuantity=reqQuantity;
		this.totalCost=totalCost;
		this.totalAmt = totalAmt;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Integer getQuantity() {
		return availableQuantity;
	}

	public void setQuantity(Integer quantity) {
		this.availableQuantity = quantity;
	}

	public Integer getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(Integer availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public Integer getReqQuantity() {
		return reqQuantity;
	}

	public void setReqQuantity(int reqQuantity) {
		this.reqQuantity = reqQuantity;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(Double totalAmt) {
		this.totalAmt = totalAmt;
	}

	@Override
	public String toString() {
		return "ProductMaster [id=" + id + ", productName=" + productName + ", cost=" + cost + ", productDescription="
				+ productDescription + ", availableQuantity=" + availableQuantity + ", reqQuantity=" + reqQuantity
				+ ", totalCost=" + totalCost + ", totalAmt=" + totalAmt + "]";
	}

		}

	


