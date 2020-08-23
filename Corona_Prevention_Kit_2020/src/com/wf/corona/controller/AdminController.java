package com.wf.corona.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wf.corona.dao.ProductMasterDao;
import com.wf.corona.model.ProductMaster;


//@WebServlet({ "/admin", "/login","/insertProduct", "/newproduct", "/addLoan", "/editLoan", "/save" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductMasterDao productMasterDao;
	
	
	public void setProductMasterDao(ProductMasterDao productMasterDao) {
		this.productMasterDao = productMasterDao;
	}

	public void init(ServletConfig config) {
		String jdbcURL = config.getServletContext().getInitParameter("jdbcUrl");
		String jdbcUsername = config.getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = config.getServletContext().getInitParameter("jdbcPassword");

	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action =  request.getParameter("action");
		String viewName = "";
		try {
			switch (action) {
			case "/admin" : 
				viewName = adminLogin(request, response);
				break;
			case "login" : 
				viewName = adminLogin12(request, response);
				break;
			case "addnewproduct":
				viewName = showNewProductForm(request, response);
				break;
			case "insertproduct":
				viewName = insertProduct(request, response);
				break;
			case "deleteproduct":
				viewName = deleteProduct(request, response);
				break;
			case "editproduct":
				viewName = showEditProductForm(request, response);
				break;
			case "updateproduct":
				viewName = updateProduct(request, response);
				break;
			case "list":
				viewName = listAllProducts(request, response);
				break;	
			case "logout":
				viewName = adminLogout(request, response);
				break;	
			default : viewName = "notfound.jsp"; break;		
			}
		} catch (Exception ex) {
			throw new ServletException(ex.getMessage());
		}
		RequestDispatcher dispatch = 
					request.getRequestDispatcher(viewName);
		dispatch.forward(request, response);
		
		
	}

	private String adminLogout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String listAllProducts(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String updateProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String showEditProductForm(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String deleteProduct(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return "";
	}

	private String insertProduct(HttpServletRequest request, HttpServletResponse response) {
		
		ProductMaster pm = new ProductMaster(); 
		pm.setId(Integer.parseInt(request.getParameter("id")));
		pm.setProductDescription(request.getParameter("productDescription"));
		pm.setProductName(request.getParameter("productName"));
		pm.setCost(Double.parseDouble(request.getParameter("cost")));
		
		String view="";
		
		
		return view;
	}

	private String showNewProductForm(HttpServletRequest request, HttpServletResponse response) {
		
		ProductMaster item = new ProductMaster();
		request.setAttribute("productMaster", item);
		
		return "newproduct.jsp";
		
	}

	private String adminLogin(HttpServletRequest request, HttpServletResponse response) {
		
		String view = "AdminUserLogin.jsp";

		return view;
	}
	
private String adminLogin12(HttpServletRequest request, HttpServletResponse response) {
		

	request.setAttribute("loginsuccess", true);

		return "AdminUserLogin.jsp";
	}

	
}