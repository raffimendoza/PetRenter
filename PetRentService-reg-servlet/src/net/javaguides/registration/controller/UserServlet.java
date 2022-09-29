package net.javaguides.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.javaguides.login.bean.LoginBean;
import net.javaguides.registration.dao.UserDao;
import net.javaguides.registration.model.User;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/register")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	private LoginBean loginBean = new LoginBean();
    /**
     * Default constructor. 
     */
    public UserServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("userregister.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String firstName = request.getParameter("fName");
		String lastName = request.getParameter("lName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address = request.getParameter("address");
		String contact = request.getParameter("contact");
		String submitType = request.getParameter("submit");
		
		User user = new User();
		if (firstName != null && lastName != null && email != null && password != null
				&& address != null && contact != null) {
		user.setfName(firstName);
		user.setlName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		user.setContact(contact);
		user.setAddress(address);
		loginBean.setUsername(user.getEmail());
		loginBean.setPassword(user.getPassword());		
		}
		// Login result case
		if(submitType.equals("Login")) {
			try {
				if (userDao.validate(loginBean)) {
					//HttpSession session = request.getSession();
					// session.setAttribute("username",username);
					RequestDispatcher dispatcher = request.getRequestDispatcher("userdetails.jsp");
					dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("loginfailed.jsp");
					dispatcher.forward(request, response);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			// Register result case
		}else if (submitType.equals("Register")) {
			try {
				userDao.registeruser(user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("userdetails.jsp");
			dispatcher.forward(request, response);
			// Login error
		}else {
			request.setAttribute("message", "User does not exist, click to Register");
			request.getRequestDispatcher("userlogin.jsp").forward(request,response);
		}
	}
/*		try {
			userDao.registeruser(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("userdetails.jsp");
		dispatcher.forward(request, response);
	}*/

}
