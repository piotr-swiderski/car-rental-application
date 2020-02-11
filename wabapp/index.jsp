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

<%@include file="header.jsp" %>


<div class="container p-3 mb-2">


    <%--    <h1 class="masthead-heading text-uppercase mb-0">Start Bootstrap</h1>--%>
    <%--    <header class="text-white text-center">--%>
    <%--        <!-- Masthead Avatar Image -->--%>
    <%--        <img class="masthead-avatar mb-5" src="https://auto.wprost.pl/_thumb/e8/a0/a5e3a97ab3e35c41232aaf9ed68a.jpeg"--%>
    <%--             alt="">--%>
    <%--        <!-- Masthead Heading -->--%>
    <%--    </header>--%>


    <c:if test="${cars.size() > 0}">
    <h2 class="text-center">Nasze dostępene sacmochody</h2>
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
                <form action="index" method="post">
                    <div class="form-group">
                        <label>Od kiedy chesz wypożyczyć auto</label>
                        <input type="date" name="fromDate" max="3000-12-31"
                               min="1000-01-01" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label>Do kiedy chcesz wypozyczyć auto</label>
                        <input type="date" name="toDate" min="2020-01-01"
                               max="3000-12-31" class="form-control" required>
                    </div>
                    <button value="${car.id}" class="btn btn-primary my-2 my-sm-0" name="carsToRent"
                            type="submit">Wypożycz auto
                    </button>
                </form>
            </div>
            <img class="card-img-right flex-auto d-none d-lg-block" data-src="holder.js/200x250?theme=thumb"
                 alt="Thumbnail [200x250]" style="width: 400px; height: 250px;"
                 src=${car.model.photoDirectory}
                         data-holder-rendered="true">
        </c:forEach>
    </div>
</div>
</c:if>
<c:if test="${carsToRent.size() <= 0}">
    <h2 class="text-center">Brak dostepnych samochodow</h2>
</c:if>


</body>
</html>
