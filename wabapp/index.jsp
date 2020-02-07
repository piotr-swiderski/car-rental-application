<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" java.util.* " %>
<%@ page isELIgnored="false" %>

<%@page session="false" %>
<html>
<head>
    <title>Home</title>
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
</head>
<body>

<div class="container p-3 mb-2">

    <header>
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">CarRental</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Cars<span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="admin.jsp">Moje konto</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>


                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Disabled</a>
                    </li>
                </ul>
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="search" placeholder="Search cars by mark"
                           aria-label="Search">
                    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                </form>
            </div>
        </nav>
        <br>
    </header>

    <%--    <h1 class="masthead-heading text-uppercase mb-0">Start Bootstrap</h1>--%>
    <%--    <header class="text-white text-center">--%>
    <%--        <!-- Masthead Avatar Image -->--%>
    <%--        <img class="masthead-avatar mb-5" src="https://auto.wprost.pl/_thumb/e8/a0/a5e3a97ab3e35c41232aaf9ed68a.jpeg"--%>
    <%--             alt="">--%>
    <%--        <!-- Masthead Heading -->--%>
    <%--    </header>--%>


    <c:if test="${carsToRent.size() > 0}">
    <h2 class="text-center">Nasze dostępene sacmochody</h2>
    <br>
    <div class="row">
        <c:forEach items="${carsToRent}" var="car">

            <div class="col-md-6">
                <div class="card flex-md-row mb-4 shadow-sm h-md-250">
                    <div class="card-body d-flex flex-column align-items-start">
                        <strong class="d-inline-block mb-2 text-primary">${car.mark}</strong>
                        <h3 class="mb-0">
                            <a class="text-dark" href="#">${car.model.name}</a>
                        </h3>
                        <div class="mb-1 text-muted">Nov 12</div>
                        <p class="card-text mb-auto">${car.model.equipmentVersion.equipmentDescription}</p>
                        <a href="#">Dowiedz sie wiecej</a>
                    </div>
                    <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb"
                         alt="Thumbnail [200x250]" style="width: 200px; height: 250px;"
                         src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Toyota_Corolla_Limousine_Hybrid_Genf_2019_1Y7A5576.jpg/800px-Toyota_Corolla_Limousine_Hybrid_Genf_2019_1Y7A5576.jpg"
                         data-holder-rendered="true">
                </div>
            </div>

        </c:forEach>
    </div>
</div>
</c:if>
<c:if test="${carsToRent.size() <= 0}">
    <h2 class="text-center">Brak dostepnych samochodow</h2>
</c:if>


</body>
</html>
