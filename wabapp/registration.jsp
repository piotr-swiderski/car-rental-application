<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import=" java.util.* " %>
<%@ page isELIgnored="false" %>

<%@page session="false" %>
<html>
<head>
    <title>Login</title>
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

<div class="container">
    <form action="registration" method="post">
        <div class="form-group">
            <label for="userLogin">Nazwa uzytkownika:</label>
            <input type="text" class="form-control" id="userLogin" placeholder="Nazwa użytkownika" name="userLogin"
                   required>
        </div>
        <div class="form-group">
            <label for="userPassword">Hasło:</label>
            <input type="password" class="form-control" id="userPassword" placeholder="Haslo uzytkownika"
                   name="userPassword" required>
        </div>
        <div class="form-group">
            <label for="userConfirmPassword">Hasło:</label>
            <input type="password" class="form-control" id="userConfirmPassword" placeholder="Powtórz haslo uzytkownika"
                   name="userConfirmPassword" required>
        </div>
        <div class="form-group">
            <label for="userName">Imie uzytkownika:</label>
            <input type="text" class="form-control" id="userName" placeholder="Imie" name="userName"
                   required>
        </div>
        <div class="form-group">
            <label for="userSurname">Nazwisko uzytkownika:</label>
            <input type="text" class="form-control" id="userSurname" placeholder="Nazwisko" name="userSurname"
                   required>
        </div>
        <div class="form-group">
            <label for="userAddress">Adres uzytkownika:</label>
            <input type="text" class="form-control" id="userAddress" placeholder="Adres" name="userAddress"
                   required>
        </div>
        <div class="form-group">
            <label for="userPhone">Telefon:</label>
            <input type="number" class="form-control" id="userPhone" placeholder="Numer telefonu" name="userPhone"
                   required>
        </div>
        <button type="submit" class="btn btn-primary center-pill">registration</button>
    </form>
</div>
</body>
</html>
