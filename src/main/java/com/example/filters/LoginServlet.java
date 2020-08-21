package com.example.filters;

import com.example.dto.User;
import com.example.services.implementations.AuthenticationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Autowired
    AuthenticationServiceImpl authenticationService;

    private WebApplicationContext springContext;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(config.getServletContext());
        final AutowireCapableBeanFactory beanFactory = springContext.getAutowireCapableBeanFactory();
        beanFactory.autowireBean(this);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/jsp/loginuser.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String userID = request.getParameter("email");
        String password = request.getParameter("password");
        User user = authenticationService.checkUser(userID, password);

        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setAttribute("userId", user.getId());
            session.setMaxInactiveInterval(30 * 60);
            Cookie cookie = new Cookie("name", userID);
            cookie.setMaxAge(30 * 60);
            response.addCookie(cookie);
            response.sendRedirect("../");
        }else {
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/loginuser");
            PrintWriter out = response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}