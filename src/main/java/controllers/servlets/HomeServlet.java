package controllers.servlets;

import model.Car;
import model.EquipmentVersion;
import model.Model;
import services.UserCarManagementService;
import services.UserManagementService;
import services.impl.AdminCarManagementServiceImpl;
import services.impl.UserCarManagementServiceImpl;
import services.impl.UserManagementServiceImpl;
import services.utils.ServiceUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@WebServlet(name = "HomeServlet", value = {"", "/index"})
public class HomeServlet extends HttpServlet {

    private UserCarManagementService service;

    @Override
    public void init() throws ServletException {
        service = new UserCarManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Car> notRentalCar = service.getNotRentalCar();
        req.setAttribute("carsToRent", notRentalCar);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
