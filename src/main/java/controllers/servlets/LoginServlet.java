package controllers.servlets;

import controllers.servlets.utils.ServletUtils;
import services.UserManagementService;
import services.impl.UserManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controllers.servlets.utils.ServletUtils.*;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private UserManagementService service;

    @Override
    public void init() throws ServletException {
        service = new UserManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter(USER_LOGIN);
        String password = req.getParameter(USER_PASSWORD);

        if(!service.isUserLoginExist(login) || !service.isUserValid(login, password)){
            req.setAttribute("errors",LOGIN_PASSWORD_IS_WRONG);
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }


}
