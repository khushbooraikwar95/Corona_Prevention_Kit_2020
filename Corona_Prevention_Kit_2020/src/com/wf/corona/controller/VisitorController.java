package com.wf.corona.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wf.corona.exception.CoronaPreventionException;
import com.wf.corona.model.ProductMaster;
import com.wf.corona.model.VisitorProfile;
import com.wf.corona.service.AdminService;
import com.wf.corona.service.AdminServiceImpl;

@WebServlet({ "/visitorprofile","/visitorlogin","/additem","/showcart","/placeorder","/confirmorder","/homepage"})
public class VisitorController extends HttpServlet{
	private static final long serialVersionUID = 1L;

	private AdminService adminService;

	@Override
	public void init() throws ServletException {
		adminService = new AdminServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = request.getServletPath();

		String viewName = "";

		switch (url) {
		case "/visitorprofile" : 
			viewName = doVisitorProfile(request, response);
			break;
			
		case "/visitorlogin" : 
			viewName = doVisitorLogin(request, response);
			break;
			
		case "/additem" : 
			viewName = doAddItem(request, response);
			break;
			
		case "/showcart" : 
			viewName = doShowCart(request, response);
			break;
		case "/placeorder" : 
			viewName = doPlaceOrder(request, response);
			break;
		case "/confirmorder" : 
			viewName = doConfirmOrder(request, response);
			break;
		case "/homepage" : 
			viewName = "index.jsp";
			break;
			
			
		}

		request.getRequestDispatcher(viewName).forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	private String doVisitorProfile(HttpServletRequest request, HttpServletResponse resp)
	{
		request.getSession().setAttribute("visitorprof", null);
		return "newuser.jsp";
		
	}
	private String doVisitorLogin(HttpServletRequest request, HttpServletResponse resp)
	{
		String view;
		try {
			VisitorProfile visitorprof = new VisitorProfile();
			visitorprof.setUserName(request.getParameter("username"));
			visitorprof.setEmailid(request.getParameter("email"));
			visitorprof.setContact(request.getParameter("contact"));
			request.getSession().setAttribute("visitorprof", visitorprof);
			
			List<ProductMaster> products = adminService.getAllProductMasters();
			request.getSession().setAttribute("productMaster", products);
			request.getSession().setAttribute("selectedProductsList", null);
			view="productsDisplayList.jsp";
		} 
		catch (CoronaPreventionException e) {
			request.setAttribute("errMsg", e.getMessage());
			view = "errorPage.jsp";
		}
		return view;
		
	}
	
	private String doAddItem(HttpServletRequest request, HttpServletResponse resp)
	{
		 HttpSession session = request.getSession();
		 List<ProductMaster> selectedProductsList = (List<ProductMaster>) session.getAttribute("selectedProductsList");
		List<ProductMaster> productsList = (List<ProductMaster>) session.getAttribute("productMaster");
		  System.out.println("id " + request.getParameter("id"));
		  System.out.println("req quan " + request.getParameter("reqQuantity"));
		 
		if(null == productsList)
		{
			productsList = new ArrayList<ProductMaster>();
		}
		if(null == selectedProductsList)
		{
			selectedProductsList = new ArrayList<ProductMaster>();
		}
		String productName = null;
		for(ProductMaster prodmast : productsList)
		{
			if(prodmast.getId()==Integer.parseInt(request.getParameter("id")) && Integer.parseInt(request.getParameter("reqQuantity"))>0)
			{
				prodmast.setReqQuantity(Integer.parseInt(request.getParameter("reqQuantity")));
				productName = prodmast.getProductName();
				selectedProductsList.add(prodmast);
				break;
			}
			
			else if (Integer.parseInt(request.getParameter("reqQuantity")) == 0)
			{
				prodmast.setReqQuantity(Integer.parseInt(request.getParameter("reqQuantity")));
				productName = prodmast.getProductName();
				request.setAttribute("msg", "Product " + productName + " is removed from cart");
				for(ProductMaster selprodmast : selectedProductsList)
				{
					if(selprodmast.getId()==Integer.parseInt(request.getParameter("id")))
					{
						selectedProductsList.remove(selprodmast);
						selprodmast=null;
						session.setAttribute("selectedProductsList", selectedProductsList);
						break;
					}
				}
				return "productsDisplayList.jsp";
			}
			 
		}
		
		
			System.out.println("list" + productsList.size());
			request.setAttribute("msg", "Product " + productName + " is added to cart");
			session.setAttribute("productMaster", productsList);
			session.setAttribute("selectedProductsList", selectedProductsList);
			List<ProductMaster> productsList1 = (List<ProductMaster>) request.getSession().getAttribute("productMaster");
			for(ProductMaster prodmast : productsList)
			{
				System.out.println("after id " +prodmast.getId());
				System.out.println("after req " + prodmast.getReqQuantity());
			}
		
			
		return "productsDisplayList.jsp";
		
	}
	
	private String doShowCart(HttpServletRequest request, HttpServletResponse resp)
	{
		
		  HttpSession session = request.getSession();
		  List<ProductMaster> selectedProductsList = (List<ProductMaster>)session.getAttribute("selectedProductsList");
		  Double totalAmount = 0d;
		  for(ProductMaster prodmast : selectedProductsList)
		  {
			  totalAmount = prodmast.getCost() * prodmast.getReqQuantity() + totalAmount;
			  prodmast.setTotalCost(prodmast.getCost() * prodmast.getReqQuantity());
		  }
		 
		  session.setAttribute("totalAmt", totalAmount);
		return "showkit.jsp";
		
	}
	
	private String doPlaceOrder(HttpServletRequest request, HttpServletResponse resp)
	{
		
		return "placeorder.jsp";
		
	}
	
	private String doConfirmOrder(HttpServletRequest request, HttpServletResponse resp)
	{
		VisitorProfile vistorProf = (VisitorProfile) request.getSession().getAttribute("visitorprof");
		System.out.println("flat no " + request.getParameter("flatno"));
		vistorProf.setFlatno(request.getParameter("flatno"));
		vistorProf.setArea(request.getParameter("area"));
		vistorProf.setStreet(request.getParameter("street"));
		vistorProf.setCity(request.getParameter("city"));
		vistorProf.setState(request.getParameter("state"));
		request.setAttribute("visitorprof", vistorProf);
		return "ordersummary.jsp";
		
	}

}
