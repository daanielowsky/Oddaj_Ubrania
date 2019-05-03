<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>Oddaj Ubrania</title>
    <link rel="stylesheet" href="/media/css/style.css" />
</head>
<body>
<sec:authorize access="isAuthenticated()">
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
                <li><a href="/" class="btn btn--without-border active">Start</a></li>
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

        <div class="slogan container container--90">
            <div class="slogan--item">
                <h1>
                    Oddaj rzeczy, których już nie chcesz<br />
                    <span class="uppercase">potrzebującym</span>
                </h1>

                <div class="slogan--steps">
                    <div class="slogan--steps-title">Wystarczą 4 proste kroki:</div>
                    <ul class="slogan--steps-boxes">
                        <li>
                            <div><em>1</em><span>Wybierz rzeczy</span></div>
                        </li>
                        <li>
                            <div><em>2</em><span>Spakuj je w worki</span></div>
                        </li>
                        <li>
                            <div><em>3</em><span>Wybierz fundację</span></div>
                        </li>
                        <li>
                            <div><em>4</em><span>Zamów kuriera</span></div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </header>

    <section class="form--steps">
        <div class="form--steps-instructions">
            <div class="form--steps-container">
                <h3>Ważne!</h3>
                <p data-step="1" class="active">
                    Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                    wiedzieć komu najlepiej je przekazać.
                </p>
                <p data-step="2">
                    Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                    wiedzieć komu najlepiej je przekazać.
                </p>
                <p data-step="3">
                    Jeśli wiesz komu chcesz pomóc, możesz wpisać nazwę tej organizacji w
                    wyszukiwarce. Możesz też filtrować organizacje po ich lokalizacji
                    bądź celu ich pomocy.
                </p>
                <p data-step="4">
                    Na podstawie Twoich kryteriów oraz rzeczy, które masz do oddania
                    wybraliśmy organizacje, którym możesz pomóc. Wybierz jedną, do
                    której trafi Twoja przesyłka.
                </p>
                <p data-step="5">Podaj adres oraz termin odbioru rzeczy.</p>
            </div>
        </div>

        <div class="form--steps-container">
            <div class="form--steps-counter">Krok <span>1</span>/5</div>

            <form>
                <!-- STEP 1: class .active is switching steps -->
                <div data-step="1" class="active">
                    <h3>Zaznacz co chcesz oddać:</h3>

                    <div class="form-group form-group--checkbox">
                        <label>
                            <input
                                    type="checkbox"
                                    name="products[]"
                                    value="clothes-to-use"
                            />
                            <span class="checkbox"></span>
                            <span class="description"
                            >ubrania, które nadają się do ponownego użycia</span
                            >
                        </label>
                    </div>

                    <div class="form-group form-group--checkbox">
                        <label>
                            <input
                                    type="checkbox"
                                    name="products[]"
                                    value="clothes-useless"
                            />
                            <span class="checkbox"></span>
                            <span class="description">ubrania, do wyrzucenia</span>
                        </label>
                    </div>

                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="checkbox" name="products[]" value="toys" />
                            <span class="checkbox"></span>
                            <span class="description">zabawki</span>
                        </label>
                    </div>

                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="checkbox" name="products[]" value="books" />
                            <span class="checkbox"></span>
                            <span class="description">książki</span>
                        </label>
                    </div>

                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="checkbox" name="products[]" value="other" />
                            <span class="checkbox"></span>
                            <span class="description">inne</span>
                        </label>
                    </div>

                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn next-step">Dalej</button>
                    </div>
                </div>

                <!-- STEP 2 -->
                <div data-step="2">
                    <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                    <div class="form-group form-group--inline">
                        <label>
                            Liczba 60l worków:
                            <input type="number" name="bags" step="1" min="1" />
                        </label>
                    </div>

                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="button" class="btn next-step">Dalej</button>
                    </div>
                </div>

                <!-- STEP 3 -->
                <div data-step="3">
                    <h3>Lokalizacja:</h3>

                    <div class="form-group form-group--dropdown">
                        <select name="localization">
                            <option value="0">- wybierz -</option>
                            <option value="warsaw">Warszawa</option>
                            <option value="wroclaw">Wrocław</option>
                            <option value="poznan">Poznań</option>
                            <option value="gdansk">Gdańsk</option>
                        </select>
                    </div>

                    <div class="form-section">
                        <h4>Komu chcesz pomóc?</h4>
                        <div class="form-section--checkboxes">
                            <div class="form-group form-group--checkbox">
                                <label>
                                    <input type="checkbox" name="help[]" value="children" />
                                    <span class="checkbox">dzieciom</span>
                                </label>
                            </div>

                            <div class="form-group form-group--checkbox">
                                <label>
                                    <input type="checkbox" name="help[]" value="mothers" />
                                    <span class="checkbox">samotnym matkom</span>
                                </label>
                            </div>

                            <div class="form-group form-group--checkbox">
                                <label>
                                    <input type="checkbox" name="help[]" value="homeless" />
                                    <span class="checkbox">bezdomnym</span>
                                </label>
                            </div>

                            <div class="form-group form-group--checkbox">
                                <label>
                                    <input type="checkbox" name="help[]" value="disabled" />
                                    <span class="checkbox">niepełnosprawnym</span>
                                </label>
                            </div>

                            <div class="form-group form-group--checkbox">
                                <label>
                                    <input type="checkbox" name="help[]" value="old" />
                                    <span class="checkbox">osobom starszym</span>
                                </label>
                            </div>
                        </div>
                    </div>

                    <div class="form-section">
                        <h4>Wpisz nazwę konkretnej organizacji (opcjonalnie)</h4>
                        <div class="form-group">
                            <textarea rows="4" name="organization_search"></textarea>
                        </div>
                    </div>

                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="button" class="btn next-step">Szukaj</button>
                    </div>
                </div>

                <!-- STEP 4 -->
                <div data-step="4">
                    <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="radio" name="organization" value="old" />
                            <span class="checkbox radio"></span>
                            <span class="description">
                  <div class="title">Fundacja “Bez domu”</div>
                  <div class="subtitle">
                    Cel i misja: Pomoc dla osób nie posiadających miejsca
                    zamieszkania
                  </div>
                </span>
                        </label>
                    </div>

                    <div class="form-group form-group--checkbox">
                        <label>
                            <input type="radio" name="organization" value="old" />
                            <span class="checkbox radio"></span>
                            <span class="description">
                  <div class="title">Fundacja “Dla dzieci"</div>
                  <div class="subtitle">
                    Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji
                    życiowej.
                  </div>
                </span>
                        </label>
                    </div>

                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="button" class="btn next-step">Dalej</button>
                    </div>
                </div>

                <!-- STEP 5 -->
                <div data-step="5">
                    <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru</h4>
                            <div class="form-group form-group--inline">
                                <label> Ulica <input type="text" name="address" /> </label>
                            </div>

                            <div class="form-group form-group--inline">
                                <label> Miasto <input type="text" name="city" /> </label>
                            </div>

                            <div class="form-group form-group--inline">
                                <label>
                                    Kod pocztowy <input type="text" name="postcode" />
                                </label>
                            </div>

                            <div class="form-group form-group--inline">
                                <label>
                                    Numer telefonu <input type="phone" name="phone" />
                                </label>
                            </div>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru</h4>
                            <div class="form-group form-group--inline">
                                <label> Data <input type="date" name="data" /> </label>
                            </div>

                            <div class="form-group form-group--inline">
                                <label> Godzina <input type="time" name="time" /> </label>
                            </div>

                            <div class="form-group form-group--inline">
                                <label>
                                    Uwagi dla kuriera
                                    <textarea name="more_info" rows="5"></textarea>
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="button" class="btn next-step">Dalej</button>
                    </div>
                </div>

                <!-- STEP 6 -->
                <div data-step="6">
                    <h3>Podsumowanie Twojej darowizny</h3>

                    <div class="summary">
                        <div class="form-section">
                            <h4>Oddajesz:</h4>
                            <ul>
                                <li>
                                    <span class="icon icon-bag"></span>
                                    <span class="summary--text"
                                    >4 worki ubrań w dobrym stanie dla dzieci</span
                                    >
                                </li>

                                <li>
                                    <span class="icon icon-hand"></span>
                                    <span class="summary--text"
                                    >Dla fundacji "Mam marzenie" w Warszawie</span
                                    >
                                </li>
                            </ul>
                        </div>

                        <div class="form-section form-section--columns">
                            <div class="form-section--column">
                                <h4>Adres odbioru:</h4>
                                <ul>
                                    <li>Prosta 51</li>
                                    <li>Warszawa</li>
                                    <li>99-098</li>
                                    <li>123 456 789</li>
                                </ul>
                            </div>

                            <div class="form-section--column">
                                <h4>Termin odbioru:</h4>
                                <ul>
                                    <li>13/12/2018</li>
                                    <li>15:40</li>
                                    <li>Brak uwag</li>
                                </ul>
                            </div>
                        </div>
                    </div>

                    <div class="form-group form-group--buttons">
                        <button type="button" class="btn prev-step">Wstecz</button>
                        <button type="submit" class="btn">Potwierdzam</button>
                    </div>
                </div>

                <!-- STEP 7 -->
                <div data-step="7">
                    <h2>
                        Dziękujemy za przesłanie formularza Na maila prześlemy wszelkie
                        informacje o odbiorze.
                    </h2>
                </div>
            </form>
        </div>
    </section>

    <footer>
        <div class="contact">
            <h2>Skontaktuj się z nami</h2>
            <h3>Formularz kontaktowy</h3>
            <form class="form--contact">
                <div class="form-group form-group--50">
                    <input type="text" name="name" placeholder="Imię" />
                </div>
                <div class="form-group form-group--50">
                    <input type="text" name="surname" placeholder="Nazwisko" />
                </div>

                <div class="form-group">
            <textarea
                    name="message"
                    placeholder="Wiadomość"
                    rows="1"
            ></textarea>
                </div>

                <button class="btn" type="submit">Wyślij</button>
            </form>
        </div>
        <div class="bottom-line">
            <span class="bottom-line--copy">Copyright &copy; 2018</span>
            <div class="bottom-line--icons">
                <a href="#" class="btn btn--small"
                ><img src="/media/images/icon-facebook.svg"
                /></a>
                <a href="#" class="btn btn--small"
                ><img src="/media/images/icon-instagram.svg"
                /></a>
            </div>
        </div>
    </footer>

    <script src="/media/js/app.js"></script>
</sec:authorize>
<sec:authorize access="!isAuthenticated()">
<header class="header--main-page">
    <nav class="container container--70">
        <ul class="nav--actions">
            <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
            <li><a href="/register" class="btn btn--small btn--highlighted">Załóż konto</a></li>
        </ul>
        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#about_us" class="btn btn--without-border">O nas</a></li>
            <li><a href="#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br />
                Oddaj niechciane rzeczy w zaufane ręce
            </h1>

            <ul class="slogan--buttons">
                <li><a href="#" class="btn btn--large">Oddaj rzeczy</a></li>
                <li><a href="#" class="btn btn--large">Zorganizuj zbiórkę</a></li>
            </ul>
        </div>
    </div>
</header>

<section class="stats">
    <div class="container container--85">
        <div class="stats--item">
            <em>10</em>
            <h3>Oddanych worków</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Eius est beatae, quod accusamus illum tempora!</p>
        </div>

        <div class="stats--item">
            <em>5</em>
            <h3>Wspartych organizacji</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Laboriosam magnam, sint nihil cupiditate quas quam.</p>
        </div>

        <div class="stats--item">
            <em>7</em>
            <h3>Zorganizowanych zbiórek</h3>
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Quos dolores commodi error. Natus, officiis vitae?</p>
        </div>
    </div>
</section>

<section class="steps">
    <h2>Wystarczą 4 proste kroki</h2>

    <div class="steps--container">
        <div class="steps--item">
            <span class="icon icon--hands"></span>
            <h3>Wybierz rzeczy</h3>
            <p>ubrania, zabawki, sprzęt i inne</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--arrow"></span>
            <h3>Spakuj je</h3>
            <p>skorzystaj z worków na śmieci</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--glasses"></span>
            <h3>Zdecyduj komu chcesz pomóc</h3>
            <p>wybierz zaufane miejsce</p>
        </div>
        <div class="steps--item">
            <span class="icon icon--courier"></span>
            <h3>Zamów kuriera</h3>
            <p>kurier przyjedzie w dogodnym terminie</p>
        </div>
    </div>

    <a href="#" class="btn btn--large">Załóż konto</a>
</section>

<section class="about-us" id="about_us">
    <div class="about-us--text">
        <h2>O nas</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Voluptas vitae animi rem pariatur incidunt libero optio esse quisquam illo omnis.</p>
        <img src="/media/images/signature.svg" class="about-us--text-signature" alt="Signature" />
    </div>
    <div class="about-us--image"><img src="/media/images/about-us.jpg" alt="People in circle" /></div>
</section>

<section class="help" id="help">
    <h2>Komu pomagamy?</h2>

    <ul class="help--buttons">
        <li data-id="1"><a href="#" class="btn btn--without-border active">Fundacjom</a></li>
        <li data-id="2"><a href="#" class="btn btn--without-border">Organizacjom pozarządowym</a></li>
        <li data-id="3"><a href="#" class="btn btn--without-border">Lokalnym zbiórkom</a></li>
    </ul>

    <!-- SLIDE 1 -->
    <div class="help--slides active" data-id="1">
        <p>W naszej bazie znajdziesz listę zweryfikowanych Fundacji, z którymi współpracujemy. Możesz sprawdzić czym się zajmują, komu pomagają i czego potrzebują.</p>

        <ul class="help--slides-items">
            <li>
                <div class="col">
                    <div class="title">Fundacja "Dbam o Zdrowie"</div>
                    <div class="subtitle">Cel i misja: Pomoc dzieciom z ubogich rodzin.</div>
                </div>

                <div class="col"><div class="text">ubrania, jedzenie, sprzęt AGD, meble, zabawki</div></div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Fundacja “Dla dzieci"</div>
                    <div class="subtitle">Cel i misja: Pomoc osobom znajdującym się w trudnej sytuacji życiowej.</div>
                </div>

                <div class="col"><div class="text">ubrania, meble, zabawki</div></div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Fundacja “Bez domu”</div>
                    <div class="subtitle">Cel i misja: Pomoc dla osób nie posiadających miejsca zamieszkania</div>
                </div>

                <div class="col"><div class="text">ubrania, jedzenie, ciepłe koce</div></div>
            </li>
        </ul>

        <ul class="help--slides-pagination">
            <li><a href="#" class="btn btn--small btn--without-border active" data-page="1">1</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="2">2</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="3">3</a></li>
        </ul>
    </div>

    <!-- SLIDE 2 -->
    <div class="help--slides" data-id="2">
        <p>
            Lorem ipsum dolor, sit amet consectetur adipisicing elit. Hic officiis mollitia dolor, neque aspernatur accusamus debitis. Ducimus, officia. Quia, sunt illum! Non iste placeat ab ipsum alias
            quos suscipit corporis!
        </p>
        <ul class="help--slides-items">
            <li>
                <div class="col">
                    <div class="title">Organizacja 1</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col"><div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div></div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Organizacja 2</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col"><div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div></div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Organizacja 3</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col"><div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div></div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Organizacja 4</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col"><div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div></div>
            </li>
        </ul>

        <ul class="help--slides-pagination">
            <li><a href="#" class="btn btn--small btn--without-border active" data-page="1">1</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="2">2</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="3">3</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="4">4</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="5">5</a></li>
        </ul>
    </div>

    <!-- SLIDE 3 -->
    <div class="help--slides" data-id="3">
        <p>Lorem ipsum dolor sit amet, his ocurreret persequeris ea, ad utinam laudem duo. Verterem adipisci partiendo eos ne, ea his reque quaeque recteque, ne quo lobortis intellegam.</p>
        <ul class="help--slides-items">
            <li>
                <div class="col">
                    <div class="title">Lokalna zbiórka 1</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col"><div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div></div>
            </li>

            <li>
                <div class="col">
                    <div class="title">Lokalna zbiórka 2</div>
                    <div class="subtitle">Lorem ipsum dolor sit amet consectetur.</div>
                </div>

                <div class="col"><div class="text">Lorem ipsum dolor sit amet consectetur adipisicing elit.</div></div>
            </li>
        </ul>

        <ul class="help--slides-pagination">
            <li><a href="#" class="btn btn--small btn--without-border active" data-page="1">1</a></li>
            <li><a href="#" class="btn btn--small btn--without-border" data-page="2">2</a></li>
        </ul>
    </div>
</section>

<footer>
    <div class="contact">
        <h2>Skontaktuj się z nami</h2>
        <h3>Formularz kontaktowy</h3>
        <form class="form--contact">
            <div class="form-group form-group--50"><input type="text" name="name" placeholder="Imię" /></div>
            <div class="form-group form-group--50"><input type="text" name="surname" placeholder="Nazwisko" /></div>

            <div class="form-group"><textarea name="message" placeholder="Wiadomość" rows="1"></textarea></div>

            <button class="btn" type="submit">Wyślij</button>
        </form>
    </div>
    <div class="bottom-line">
        <span class="bottom-line--copy">Copyright &copy; 2018</span>
        <div class="bottom-line--icons">
            <a href="#" class="btn btn--small"><img src="/media/images/icon-facebook.svg"/></a> <a href="#" class="btn btn--small"><img src="/media/images/icon-instagram.svg"/></a>
        </div>
    </div>
</footer>

<script src="/media/js/app.js"></script>
</sec:authorize>
</body>
</html>
