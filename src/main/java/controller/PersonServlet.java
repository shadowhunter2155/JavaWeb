package controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/person")
public class PersonServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//data
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String sex = req.getParameter("sex");
		String birth = req.getParameter("birth");
		String edu = req.getParameter("edu");
		String[] hobbies = req.getParameterValues("hobby");
		String memo = req.getParameter("memo");
		//check
		Map<String, String> errMsg = new LinkedHashMap<>();
		if (name == null || name.trim().length() == 0) {
			errMsg.put("name", "姓名沒有填入");
		}
		if (age == null || age.trim().length() == 0) {
			errMsg.put("age", "年齡沒有填入");
		}
		if (birth == null || birth.trim().length() == 0) {
			errMsg.put("birth", "生日沒有填入");
		}
		//return
		RequestDispatcher rd = req.getRequestDispatcher("/html/person_result.jsp");
		req.setAttribute("name", name);
		req.setAttribute("age", age);
		req.setAttribute("sex", sex);
		req.setAttribute("birth", birth);
		req.setAttribute("edu", edu);
		req.setAttribute("hobbies", hobbies);
		req.setAttribute("memo", memo);
		req.setAttribute("errMsg", errMsg);
		rd.forward(req, resp);
		
	}

}