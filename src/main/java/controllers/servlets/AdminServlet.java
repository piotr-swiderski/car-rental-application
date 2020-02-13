package controllers.servlets;

import controllers.servlets.utils.ServletUtils;
import model.Car;
import model.EquipmentVersion;
import model.Model;
import services.AdminCarManagementService;
import services.impl.AdminCarManagementServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebServlet(name = "AdminServlet", value = "/admin")
public class AdminServlet extends HttpServlet {

    private AdminCarManagementService adminService;
    private String page = "admin.jsp";


    @Override
    public void init() throws ServletException {
        adminService = new AdminCarManagementServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Set<Car> allCars = adminService.getAllCars();
        req.setAttribute("cars", allCars);
        req.getRequestDispatcher(page).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String registrationNumber = req.getParameter("registrationNumber");
        List<String> errors = new ArrayList<>();

        if (adminService.isCarRegistrationNumberExist(registrationNumber)) {
            Set<Car> allCars = adminService.getAllCars();
            req.setAttribute("cars", allCars);

            errors.add(ServletUtils.ERROR_REGISTRATION_NUMBER);
            req.setAttribute("errors", errors);

            req.getRequestDispatcher(page).forward(req, resp);
            return;
        }


        String markName = req.getParameter(ServletUtils.MARK_NAME);
        String modelName = req.getParameter(ServletUtils.MODEL_NAME);
        int productionYear = Integer.parseInt(req.getParameter("productionYear"));
        String generation = req.getParameter("generation");
        String photoDirectory = req.getParameter("photoDirectory");
        String equipmentDescription = req.getParameter("equipmentDescription");

        Car car = buildCar(registrationNumber, markName, modelName, productionYear, generation, photoDirectory, equipmentDescription);
        adminService.addCar(car);

        Set<Car> allCars = adminService.getAllCars();
        req.setAttribute("cars", allCars);

        req.getRequestDispatcher(page).forward(req, resp);
    }

    private Car buildCar(String registrationNumber, String markName, String modelName, int productionYear, String generation, String photoDirectory, String equipmentDescription) {
        EquipmentVersion equipmentVersion = new EquipmentVersion();
        equipmentVersion.setEquipmentDescription(equipmentDescription);
        Model model = Model.ModelBuilder.aModel()
                .withName(markName)
                .withGeneration(generation)
                .withPhotoDirectory(photoDirectory)
                .withEquipmentVersion(equipmentVersion)
                .build();
        return Car.CarBuilder.aCar()
                .withMode(model)
                .withMark(modelName)
                .withStatus("FREE")
                .withProductionYear(productionYear)
                .withRegistrationNumber(registrationNumber)
                .build();
    }
}

