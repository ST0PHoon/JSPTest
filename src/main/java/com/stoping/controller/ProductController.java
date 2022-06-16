package com.stoping.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.stoping.domain.model.Product;
import com.stoping.domain.repository.ProductRepository;

@WebServlet(name = "ProductController", urlPatterns = { "/products.do", "/addProduct.do" })
public class ProductController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -806780286306903448L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String command = req.getRequestURI().substring(req.getContextPath().length());

		ProductRepository repository = ProductRepository.getInstance();
		
		if (command.equals("/products.do")) {
			List<Product> products = repository.getAllProducts();
			req.getSession().setAttribute("products", products);
			
		} else if (command.equals("/addProduct.do")) {
			// 구현 전
		}

		System.out.println("통과!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		// 주소를 유지하면서 products.jsp로 이동
		req.getRequestDispatcher("products.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
