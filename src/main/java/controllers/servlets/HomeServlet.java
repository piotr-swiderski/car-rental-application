package controllers.servlets;

import model.Car;
import services.UserCarManagementService;
import services.impl.UserCarManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static controllers.servlets.utils.ServletUtils.*;

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
        req.setAttribute(USER_CARS_TO_RENT, notRentalCar);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        long carId = Long.parseLong(req.getParameter(CAR_TO_RENT_ID));
        long userId = 1L; //todo userID
        LocalDate toDate = LocalDate.parse(req.getParameter(CAR_TO_RENT_TO_DATE));
        LocalDate fromDate = LocalDate.parse(req.getParameter(CAR_TO_RENT_FROM_DATE));


        Optional<Car> carById = service.getCarById(carId);
        if (!carById.isPresent()) {
            req.getRequestDispatcher("/index.jsp").forward(req, resp); // error
            return;
        }
        service.rentCar(carId, userId, toDate, fromDate);

        Set<Car> notRentalCar = service.getNotRentalCar();
        req.setAttribute(USER_CARS_TO_RENT, notRentalCar);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
