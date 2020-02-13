package controllers.servlets;

import model.User;
import services.impl.UserManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static controllers.servlets.utils.ServletUtils.*;

@WebServlet(name = "RegistrationServlet", urlPatterns = "/registration")
public class RegistrationServlet extends HttpServlet {

    private UserManagementServiceImpl service;

    @Override
    public void init() throws ServletException {
        service = new UserManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter(USER_LOGIN);
        if (service.isUserLoginExist(login)) {
            req.setAttribute("errors", LOGIN_IS_EXISTS);
            req.getRequestDispatcher("registration.jsp").forward(req, resp);
            return;
        }
        String password = req.getParameter(USER_PASSWORD);
        String userName = req.getParameter(USER_NAME);
        String userSurname = req.getParameter(USER_SURNAME);
        String userAddress = req.getParameter(USER_ADDRESS);
        String userPhone = req.getParameter(USER_PHONE);

        User user = User.UserBuilder.anUser()
                .withLogin(login)
                .withPassword(password)
                .withName(userName)
                .withSurname(userSurname)
                .withAddress(userAddress)
                .withPhone(userPhone)
                .withStatus(USER_STATUS)
                .build();

        service.saveUser(user);
        req.getRequestDispatcher("login.jsp").forward(req, resp);

    }


}
