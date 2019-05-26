<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Oddaj Ubrania - LoginPage</title>
    <link rel="stylesheet" href="/media/css/style.css" />
</head>
<body>
<header>
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="/login">Zaloguj</a></li>
            <li class="highlighted"><a href="/register">Załóż konto</a></li>
        </ul>

        <ul>
            <li><a href="/">Start</a></li>
            <li><a href="/">O co chodzi?</a></li>
            <li><a href="/">O nas</a></li>
            <li><a href="/">Fundacje i organizacje</a></li>
            <li><a href="#concact">Kontakt</a></li>
        </ul>
    </nav>
</header>

<section class="login-page">
    <h2>Zaloguj się</h2>
    <form:form modelAttribute="loginform" method="post">
        <div class="form-group">
            <form:input path="email" placeholder="Email"/> <form:errors path="email"/>
        </div>
        <div class="form-group">
            <form:password path="password" placeholder="Hasło"/> <form:errors path="password"/>
            <p style="font-size: medium">Remember me <input type="checkbox" name="remember-me"></p>
            <a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a>
        </div>

        <div class="form-group form-group--buttons">
            <a href="/register" class="btn btn--without-border">Załóż konto</a>
            <button class="btn">Zaloguj się</button>
        </div>
    </form:form>
</section>

<footer>
    <div class="contact" id="concact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>
        <form:form modelAttribute="contact" method="post" action="/user/message">
            <div class="form-group form-group--50">
                <form:input path="name" placeholder="Imię" />
            </div>
            <div class="form-group form-group--50">
                <form:input path="surname" placeholder="Nazwisko" />
            </div>

            <div class="form-group">
                <form:input path="email" rows="1"/>
            </div>

            <div class="form-group">
                <form:textarea path="message" rows="1"/>
            </div>

            <button class="btn" type="submit">Wyślij</button>
        </form:form>
    </div>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2018</span>
        <div class="bottom-line--icons">
            <a href="#" class="btn btn--small"><img src="/media/images/icon-facebook.svg"/></a>
            <a href="#" class="btn btn--small"><img src="/media/images/icon-instagram.svg"/></a>
        </div>
    </div>
</footer>
</body>
</html>
