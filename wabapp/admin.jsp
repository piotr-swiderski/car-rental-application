<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" java.util.* " %>
<%@ page isELIgnored="false" %>

<%@page session="false" %>
<html>
<head>
    <title>AdminPage</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="car.css">
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
            integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
            crossorigin="anonymous"></script>
    <script defer src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
            integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
            crossorigin="anonymous"></script>
    <link href="css/freelancer.min.css" rel="stylesheet">
    <script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
</head>
<body>

<%@include file="header.jsp" %>

<div class="container p-3 mb-2">
    <h2>Dodaj nowe auto</h2>
    <c:if test="${errors.size() > 0}">
        <c:forEach items="${errors}" var="error">
            <div class="alert alert-warning">
                <strong>${error}</strong>
            </div>
        </c:forEach>
    </c:if>
    <form action="admin" method="post">
        <div class="form-group">
            <label for="markName">Marka:</label>
            <input type="text" class="form-control" id="markName" placeholder="Mark name" name="markName" required>
        </div>
        <div class="form-group">
            <label>Nazwa modelu:</label>
            <input type="text" class="form-control" id="modelName" placeholder="Model name" name="modelName" required>
        </div>
        <div class="form-group">
            <label>Rejestracja:</label>
            <input type="text" class="form-control" id="registrationNumber" placeholder="Registracja"
                   name="registrationNumber" required>
        </div>
        <div class="form-group">
            <label for="productionYear">Rok produkcji:</label>
            <input type="number" class="form-control" id="productionYear" placeholder="Production year"
                   name="productionYear" required>
        </div>
        <div class="form-group">
            <label for="generation">Generacja:</label>
            <input type="text" class="form-control" id="generation" placeholder="Generation" name="generation" required>
        </div>
        <div class="form-group">
            <label for="photoDirectory">Zdjecie:</label>
            <input type="text" class="form-control" id="photoDirectory" placeholder="Adres zdjecia"
                   name="photoDirectory">
        </div>
        <div class="form-group">
            <label for="equipmentDescription">Opis:</label>
            <input type="text" class="form-control" id="equipmentDescription" placeholder="Opis samochodu"
                   name="equipmentDescription" required>
        </div>
        <button type="submit" class="btn btn-primary center-pill">Submit</button>
    </form>
</div>

<div class="container p-3 mb-2">
    <br>
    <c:if test="${cars.size() > 0}">
        <h2 class="text-center">Samochody:</h2>
        <br>
        <div class="row">
            <c:forEach items="${cars}" var="car">
                <div class="card-body d-flex flex-column align-items-start">
                    <strong class="d-inline-block mb-2 text-primary">${car.model.name}</strong>
                    <h3 class="mb-0">
                        <a class="text-dark">${car.mark}</a>
                    </h3>
                    <div class="mb-1 text-muted">_</div>
                    <p class="card-text mb-auto">${car.model.equipmentVersion.equipmentDescription}</p>
                </div>
                <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb"
                     alt="Thumbnail [200x250]" style="width: 400px; height: 250px;"
                     src=${car.model.photoDirectory} data-holder-rendered="true">
            </c:forEach>
        </div>
    </c:if>
    <c:if test="${cars.size() <= 0}">
        <h2 class="text-center">Brak samochodow</h2>
    </c:if>
</div>


</body>

</html>
