package web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PageBean;
import service.BookService;
import service.impl.BookServiceImpl;

public class PageServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int currentPage = 1;
		int pageSize = 4;
		String currPage = request.getParameter("currentPage");

		if (currPage != null) {
			currentPage = Integer.parseInt(currPage);
		}

		BookService bs = new BookServiceImpl();
		PageBean pb = bs.findBooksPage(currentPage, pageSize);

		request.setAttribute("pb", pb);
		request.getRequestDispatcher("/product_list.jsp").forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
