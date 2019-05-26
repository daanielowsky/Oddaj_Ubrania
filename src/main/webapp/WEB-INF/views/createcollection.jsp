<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: DANIEL
  Date: 13.05.2019
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Oddaj Ubrania - Profil</title>
    <link rel="stylesheet" href="/media/css/style.css"/>
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
            <li><a href="/user/create_collection" class="btn btn--without-border">Zorganizuj zbiórkę!</a></li>

        </ul>
    </nav>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <div style="font-size: large; padding-left: 30%">
        <form:form method="post" modelAttribute="collection">
        <!-- STEP 1: class .active is switching steps -->
        <div>
            <h3>Zaznacz co chcesz oddać:</h3>

            <form:checkbox path="thingsToGiveaway"
                           value="clothes-to-use"
            />ubrania, które nadają się do ponownego użycia<br><br>
            <form:checkbox path="thingsToGiveaway"
                           value="useless-clothes"
            />ubrania, do wyrzucenia<br><br>
            <form:checkbox path="thingsToGiveaway"
                           value="toys"
            />zabawki<br><br>
            <form:checkbox path="thingsToGiveaway"
                           value="books"
            />książki<br><br>
            <form:checkbox path="thingsToGiveaway"
                           value="other"
            />inne<br>

            <!-- STEP 2 -->
            <div>
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:input path="numberOfPlasticBags"/>
                    </label>
                </div>
            </div>

            <!-- STEP 3 -->
            <div>
                <h3>Lokalizacja:</h3>

                <div class="form-group form-group--dropdown">
                    <form:select path="localization">
                        <form:option value="0">- wybierz -</form:option>
                        <form:option value="warsaw">Warszawa</form:option>
                        <form:option value="wroclaw">Wrocław</form:option>
                        <form:option value="poznan">Poznań</form:option>
                        <form:option value="gdansk">Gdańsk</form:option>
                    </form:select>
                </div>

                <div class="form-section">
                    <h4>Komu chcesz pomóc?</h4>
                    <div>
                        <form:checkbox path="whoWouldLikeToHelp"
                                       value="kids"
                        />dzieciom<br><br>
                        <form:checkbox path="whoWouldLikeToHelp"
                                       value="lonely-mothers"
                        />samotnym matkom<br><br>
                        <form:checkbox path="whoWouldLikeToHelp"
                                       value="homeless"
                        />bezdomnym<br><br>
                        <form:checkbox path="whoWouldLikeToHelp"
                                       value="disabled"
                        />bezdomnym<br><br>
                        <form:checkbox path="whoWouldLikeToHelp"
                                       value="older"
                        />osobom starszym<br>
                    </div>
                </div>
            </div>

            <!-- STEP 4 -->
            <div>
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                <div>
                    <c:forEach items="${organizations}" var="organization">
                        <form:radiobutton path="organizations" value="${organization}"/>
                        <c:out value="${organization.name}"/>
                        <br>
                        <small><c:out value="${organization.mission}"/></small>
                        <br>
                        <br>
                    </c:forEach>
                </div>
            </div>

            <!-- STEP 5 -->
            <div>
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Ulica <form:input path="street"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Miasto <form:input path="city"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Kod pocztowy <form:input path="postCode"/>
                            </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Numer telefonu <form:input path="phoneNumber"/>
                            </label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <label> Data <form:input path="dateOfPickup" /> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label> Godzina <form:input path="hourOfPickup"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <label>
                                Uwagi dla kuriera
                                <form:textarea path="comments"/>
                            </label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <br>
                    <form:button>Wyślij</form:button>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                    <br>
                </div>
            </div>
            </form:form>
        </div>
</header>

</body>
</html>
