package com.wf.corona.model;

import java.util.List;

public class OrderSummary {
	private CoronaKit coronaKit;
	private List<KitDetail> kitDetails;
	
	public OrderSummary() {
		
	}
	
	public OrderSummary(CoronaKit coronaKit, List<KitDetail> kitDetails) {
		
		this.coronaKit = coronaKit;
		this.kitDetails = kitDetails;
	}
	public CoronaKit getCoronaKit() {
		return coronaKit;
	}
	public void setCoronaKit(CoronaKit coronaKit) {
		this.coronaKit = coronaKit;
	}
	public List<KitDetail> getKitDetails() {
		return kitDetails;
	}
	public void setKitDetails(List<KitDetail> kitDetails) {
		this.kitDetails = kitDetails;
	}
	
	
}
