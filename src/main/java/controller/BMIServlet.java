package controller;
import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BMIService;

/*
 * 路徑測試:
 * http://localhost:8080/JavaWeb/servlet/bmi
 * http://localhost:8080/JavaWeb/servlet/bmi?height=170&weight=60
 * */

@WebServlet("/servlet/bmi")
public class BMIServlet extends HttpServlet {
	
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//data
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");
		//check
		BMIService bmiservice = new BMIService();
		String output = bmiservice.getBMI(height, weight);
		//return
		RequestDispatcher rd = req.getRequestDispatcher("/html/bmi_result.jsp");
		req.setAttribute("output", output);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}
	
}