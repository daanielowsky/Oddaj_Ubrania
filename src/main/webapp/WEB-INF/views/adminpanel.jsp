<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div style="font-size: large; padding-left: 30%">
        Ilość organizacji: ${number}<br
        <button onclick="javascript:document.location.href='/admin/add_organization'">Dodaj organizację</button><br><br>
        Ilość użytkowników: ${usersamount} <br>
        <button onclick="javascript:document.location.href='/admin/show_users'">Zobacz użytkowników</button><br><br>
        Ilość adminów: ${adminsamount} <br>
        <button onclick="javascript:document.location.href='/admin/show_admins'">Zobacz adminów</button>
    </div>
</header>
</body>
</html>
