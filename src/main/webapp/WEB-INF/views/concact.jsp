<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Oddaj Ubrania - Panel Admina</title>
    <link rel="stylesheet" href="/media/css/style.css" />
</head>
<body>
<header class="header--form-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li class="logged-user">
                Witaj ${username}
                <ul class="dropdown">
                    <li><a href="/profile">Profil</a></li>
                    <li><a href="/profile/settings">Ustawienia</a></li>
                    <li><a href="/mycollections">Moje zbiórki</a></li>
                    <li><a href="/logout">Wyloguj</a></li>
                </ul>
            </li>
        </ul>

        <ul>
            <li><a href="/landingpage" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#" class="btn btn--without-border">O nas</a></li>
            <li>
                <a href="#" class="btn btn--without-border"
                >Fundacje i organizacje</a
                >
            </li>
            <li><a href="/concact" class="btn btn--without-border">Kontakt</a></li>
            <li><a href="/user/create_collection" class="btn btn--without-border">Zorganizuj zbiórkę!</a></li>

        </ul>
    </nav>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div style="font-size: large; padding-left: 30%;padding-right: 10%;">
        <div class="contact">
            <h2>Skontaktuj się z nami</h2>
            <h3>Formularz kontaktowy</h3>
            <form:form method="post" action="/concact" class="form--contact" modelAttribute="concact">
                <div class="form-group form-group--50">
                    <form:input path="name" placeholder="Imię"/>
                </div>
                <div class="form-group form-group--50">
                    <form:input path="surname" placeholder="Nazwisko"/>
                </div>

                <div class="form-group">
            <form:textarea path="email" placeholder="Email"/>
                </div>
                <div class="form-group">
            <form:textarea path="message" placeholder="Wiadomość"/>
                </div>

                <button class="btn" type="submit">Wyślij</button>
            </form:form>
        </div>
    </div>
</header>
</body>
</html>
