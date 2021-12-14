<#import "basic.ftlh" as basicPage>

<@basicPage.mybasicmacro>
    <div>
        <div class="navigation">
            <input type="checkbox" class="navigation__checkbox" id="navi-toggle">

            <label for="navi-toggle" class="navigation__button">
                <span class="navigation__icon">&nbsp;</span>
            </label>

            <div class="navigation__background">&nbsp;</div>

            <nav class="navigation__nav">
                <ul class="navigation__list">
                    <li class="navigation__item"><a href="#" class="navigation__link"><span>01</span>About the Carpathians</a></li>
                    <li class="navigation__item"><a href="#" class="navigation__link"><span>02</span>Popular tours</a></li>
                    <li class="navigation__item"><a href="#" class="navigation__link"><span>03</span>Our discounts</a></li>
                    <li class="navigation__item"><a href="#" class="navigation__link"><span>04</span>Stories</a></li>
                    <li class="navigation__item"><a href="#" class="navigation__link"><span>05</span>Buy now</a></li>
                </ul>
            </nav>
        </div>

        <header class="header">
            <div class="header__logo-box">
                <img src="img/logo-white.svg" alt="Logo" class="header__logo">
            </div>


            <div class="header__text-box">
                <h1 class="heading-primary">
                    <span class="heading-primary--main">In the mountains</span>
                    <span class="heading-primary--sub">is where the real life goes</span>
                </h1>
                <a href="#section-tours" class="btn btn--white btn--animated">Discover our tours</a>
            </div>

        </header>

        <main>
            <section class="section-about">
                <div class="u-center-text u-margin-bottom-big">
                    <h2 class="heading-secondary">
                        Exciting tours to Carpathian Mountains
                    </h2>
                </div>

                <div class="row">
                    <div class="col-1-of-2">
                        <h3 class="heading-tertiary u-margin-bottom-small">You're going to fall in love with Carpathians</h3>
                        <p class="paragraph">
                            The Carpathian Mountains or Carpathians are a mountain range system forming an arc roughly 1,500 km.
                        </p>

                        <h3 class="heading-tertiary u-margin-bottom-small">See hutsuls like you've never seen them before</h3>
                        <p class="paragraph">
                            They provide the habitat for the largest European populations of brown bears, wolves, chamois, and lynxes.
                        </p>

                        <a href="#" class="btn-text">Learn more &rarr;</a>
                    </div>
                    <div class="col-1-of-2">
                        <div class="composition">

                            <img srcset="img/nast-1.jpg 300w,
                       img/nast-1-large.jpg 960w"
                                 sizes="(max-width: 56.25em) 20vw,
                      (max-width: 37.5em) 30vw, 300px"
                                 alt="Photo 1"
                                 class="composition__photo composition__photo--p1 nast-1-large"
                                 src="img/nast-1-large.jpg">

                            <img srcset="img/nast-2.jpg 300w,
                       img/nast-2-large.jpg 960w"
                                 sizes="(max-width: 56.25em) 20vw,
                      (max-width: 37.5em) 30vw, 300px"
                                 alt="Photo 2"
                                 class="composition__photo composition__photo--p2"
                                 src="img/nast-2-large.jpg">

                            <img srcset="img/nast-3.jpg 300w,
                       img/nast-3-large.jpg 720w"
                                 sizes="(max-width: 56.25em) 20vw,
                      (max-width: 37.5em) 30vw, 300px"
                                 alt="Photo 3"
                                 class="composition__photo composition__photo--p3"
                                 src="img/nast-3-large.jpg">
                            <!--
                              <img src="img/nast-1.jpg" alt="Photo 1" class="composition__photo composition__photo--p1">
                              <img src="img/nast-2.jpg" alt="Photo 2" class="composition__photo composition__photo--p2">
                              <img src="img/nast-3.jpg" alt="Photo 3" class="composition__photo composition__photo--p3"> -->
                        </div>
                    </div>
                </div>
            </section>

            <section class="section-features">

                <div class="row">
                    <div class="col-1-of-4">
                        <div class="feature-box">
                            <i class="feature-box__icon icon-basic-world"></i>
                            <h3 class="heading-tertiary u-margin-bottom-small">Explore the Carpathians</h3>
                            <p class="feature-box__text">
                                The name "Carpates" is highly associated with the old Dacian tribes called "Carpes" or "Carpi" who lived in a large area from the east, north-east of the Black Sea to Transylvanian plains.
                            </p>
                        </div>
                    </div>

                    <div class="col-1-of-4">
                        <div class="feature-box">
                            <i class="feature-box__icon icon-basic-compass"></i>
                            <h3 class="heading-tertiary u-margin-bottom-small">Find the vuykos</h3>
                            <p class="feature-box__text">
                                The northwestern Carpathians begin in Slovakia and southern Poland. They surround Transcarpathia and Transylvania in a large semicircle, and end on the Danube in Romania.
                            </p>
                        </div>
                    </div>

                    <div class="col-1-of-4">
                        <div class="feature-box">
                            <i class="feature-box__icon icon-basic-watch"></i>
                            <h3 class="heading-tertiary u-margin-bottom-small">Meet the hutsuls</h3>
                            <p class="feature-box__text">
                                Although commonly referred to as a mountain chain, the Carpathians do not actually form an uninterrupted chain of mountains. Rather, they consist of several distinctive groups.
                            </p>
                        </div>
                    </div>

                    <div class="col-1-of-4">
                        <div class="feature-box">
                            <i class="feature-box__icon icon-basic-heart"></i>
                            <h3 class="heading-tertiary u-margin-bottom-small">Live a healthier life</h3>
                            <p class="feature-box__text">
                                The Carpathians at their highest altitude are only as high as the middle region of the Alps, with which they share a common appearance, climate, and flora. The Carpathians are separated from the Alps by the Danube.
                            </p>
                        </div>
                    </div>
                </div>

            </section>

            <section class="section-tours" id="section-tours">
                <div class="u-center-text u-margin-bottom-big">
                    <h2 class="heading-secondary">
                        The most interesting tours
                    </h2>
                </div>

                <div class="row">

                    <div class="col-1-of-3">
                        <div class="card">

                            <div class="card__side card__side--front">
                                <div class="card__picture card__picture--1">
                                    &nbsp;
                                </div>
                                <h4 class="card__heading">
              <span class="card__heading-span card__heading-span--1">
                  The Sea Explorer
              </span>
                                </h4>
                                <div class="card__details">
                                    <ul>
                                        <li>3 days tours</li>
                                        <li>Up to 30 people</li>
                                        <li>2 tour guides</li>
                                        <li>Sleep in cozy hotels</li>
                                        <li>Difficulty: easy</li>
                                    </ul>
                                </div>
                            </div>

                            <div class="card__side card__side--back card__side--back-1">
                                <div class="card__cta">
                                    <div class="card__price-box">
                                        <p class="card__price-only">Only</p>
                                        <p class="card__price-value">$297</p>
                                    </div>
                                    <a href="#popup" class="btn btn--white">Book now!</a>
                                </div>
                            </div>
                        </div>
                    </div>


                    <div class="col-1-of-3">
                        <div class="card">
                            <div class="card__side card__side--front">
                                <div class="card__picture card__picture--2">
                                    &nbsp;
                                </div>
                                <h4 class="card__heading">
      <span class="card__heading-span card__heading-span--2">
          The Forest Hiker
      </span>
                                </h4>
                                <div class="card__details">
                                    <ul>
                                        <li>7 days tours</li>
                                        <li>Up to 40 people</li>
                                        <li>6 tour guides</li>
                                        <li>Sleep in provided tents</li>
                                        <li>Difficulty: medium</li>
                                    </ul>
                                </div>

                            </div>

                            <div class="card__side card__side--back card__side--back-2">
                                <div class="card__cta">
                                    <div class="card__price-box">
                                        <p class="card__price-only">Only</p>
                                        <p class="card__price-value">$497</p>
                                    </div>
                                    <a href="#popup" class="btn btn--white">Book now!</a>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-1-of-3">
                        <div class="card">
                            <div class="card__side card__side--front">
                                <div class="card__picture card__picture--3">
                                    &nbsp;
                                </div>
                                <h4 class="card__heading">
      <span class="card__heading-span card__heading-span--3">
          The Snow Adventurer
      </span>
                                </h4>
                                <div class="card__details">
                                    <ul>
                                        <li>5 days tours</li>
                                        <li>Up to 15 people</li>
                                        <li>3 tour guides</li>
                                        <li>Sleep in provided tents</li>
                                        <li>Difficulty: hard</li>
                                    </ul>
                                </div>

                            </div>

                            <div class="card__side card__side--back card__side--back-3">
                                <div class="card__cta">
                                    <div class="card__price-box">
                                        <p class="card__price-only">Only</p>
                                        <p class="card__price-value">$897</p>
                                    </div>
                                    <a href="#popup" class="btn btn--white">Book now!</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div> <!-- after the row -->

                <div class="u-center-text u-margin-top-huge">
                    <a href="#section-tours" class="btn btn--green">Discover all tours</a>
                </div>

            </section>

            <section class="section-stories">

                <div class="bg-video">
                    <video class="bg-video__content" autoplay muted loop>
                        <source src="img/Dirt-bike.mp4" type="video/mp4">
                        <source src="img/Dirt-bike.webm" type="video/webm">
                        Your browser is not supported
                    </video>
                </div>

                <div class="u-center-text u-margin-bottom-big">
                    <h2 class="heading-secondary">
                        The Carpathian Mountains make people really happy
                    </h2>
                </div>

                <div class="row">
                    <div class="story">
                        <figure class="story__shape">
                            <img srcset="img/nast-8.jpg 300w,
                       img/nast-8-large.jpg 960w"
                                 sizes="(max-width: 56.25em) 20vw,
                      (max-width: 37.5em) 30vw, 300px"
                                 alt="Person on tour"
                                 class="story__img"
                                 src="img/nast-8-large.jpg">
                            <!-- <img src="img/nast-8.jpg" alt="Person on tour"
                            class="story__img"> -->
                            <figcaption class="story__caption">
                                Ana Billex
                            </figcaption>
                        </figure>
                        <div class="story__text">
                            <h3 class="heading-tertiary u-margin-bottom-small">
                                I had the best week ever with my friends
                            </h3>
                            <p>It was very inspiring time. I saw the wild nature like I have never seen it before - full of smells, colors and sounds. Green trees, grass, stones, wind, blue waves - we all belong here.
                            </p>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="story">
                        <figure class="story__shape">
                            <img srcset="img/nast-9.jpg 300w,
                       img/nast-9-large.jpg 960w"
                                 sizes="(max-width: 56.25em) 20vw,
                      (max-width: 37.5em) 30vw, 300px"
                                 alt="Person on tour"
                                 class="story__img"
                                 src="img/nast-9-large.jpg">
                            <!-- <img src="img/nast-9.jpg" alt="Person on tour"
                            class="story__img"> -->
                            <figcaption class="story__caption">
                                Stacy Bileach
                            </figcaption>
                        </figure>
                        <div class="story__text">
                            <h3 class="heading-tertiary u-margin-bottom-small">
                                My life has changed for the better
                            </h3>
                            <p>Dances around the camp-fire, songs and tales in the night, air of the woods - I'll never forget these moments. The heaven was covered with millions of stars that were glowing like grains and the Moon was like a yellow chicken. My soul is warmed up by these memories.
                            </p>
                        </div>
                    </div>
                </div>

                <div class="u-center-text u-center-top-huge">
                    <a href="#" class="btn-text">Read all stories &rarr;</a>
                </div>

            </section>

            <section class="section-book">
                <div class="row">
                    <div class="book">
                        <div class="book__form">
                            <form action="#" class="form">
                                <div class="u-margin-bottom-medium">
                                    <h2 class="heading-secondary">
                                        Start journey now
                                    </h2>
                                </div>

                                <div class="form__group">
                                    <input type="text" class="form__input" placeholder="Full name" id="name" required>
                                    <label for="name" class="form__label">Full name</label>
                                </div>

                                <div class="form__group">
                                    <input type="email" class="form__input" placeholder="Email address" id="email" required>
                                    <label for="email" class="form__label">Email address</label>
                                </div>

                                <div class="form__group u-margin-bottom-medium">
                                    <div class="form__radio-group">
                                        <input type="radio" class="form__radio-input" id="small" name="size">
                                        <label for="small" class="form__radio-label">
                                            <span class="form__radio-button"></span>
                                            Small group tour</label>
                                    </div>

                                    <div class="form__radio-group">
                                        <input type="radio" class="form__radio-input" id="large" name="size">
                                        <label for="large" class="form__radio-label">
                                            <span class="form__radio-button"></span>
                                            Large group tour</label>
                                    </div>

                                </div>

                                <div class="form__group">
                                    <button class="btn btn--green">Next step &rarr;</button>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>

            </section>

        </main>
        <footer class="footer">
            <div class="footer__logo-box">
                <!-- // For future generations:
                <picture class="footer__logo">
                  <source srcset="img/logo-green-small-1x.png 1x,
                                  img/logo-green-small-2x.png 2x"
                          media="(max-width: 37.5em)">
                  <img srcset="img/logo-green-1x.png 1x,
                               img/logo-green-2x.png 2x"
                       alt="Full logo"
                       class="footer__logo"
                       src="img/logo-green-2x.png">
                </picture>
                -->
                <img src="img/logo-white.svg" alt="Full logo" class="footer__logo">
                <!-- <img srcset="img/logo-green-1x.png 1x, img/logo-green-2x.png 2x" alt="Full logo" class="footer__logo"> -->
            </div>

            <div class="row">
                <div class="col-1-of-2">
                    <div class="footer__navigation">
                        <ul class="footer__list">
                            <li class="footer__item"><a href="#" class="footer__link">Company</a></li>
                            <li class="footer__item"><a href="#" class="footer__link">Privacy policy</a></li>
                            <li class="footer__item"><a href="#" class="footer__link">Terms</a></li>
                            <li class="footer__item"><a href="#" class="footer__link">Careers</a></li>
                            <li class="footer__item"><a href="#" class="footer__link">Contact us</a></li>
                        </ul>
                    </div>
                </div>
                <div class="col-1-of-2">
                    <p class="footer__copyright">
                        Made by <a href="#" class="footer__link">Ditrich Luddendorf</a> and <a href="#" class="footer__link">Jonas Schmedtman</a> for <a href="#" class="footer__link">Anna Billex</a>. Copyright &copy; by Ditrich Luddendorf. You are 100% allowed to use this webpage for both personal and commercial use.
                    </p>
                </div>
            </div>

        </footer>

        <div class="popup" id="popup">
            <div class="popup__content">
                <div class="popup__left">
                    <img srcset="img/nast-7.jpg 300w,
                       img/nast-7-large.jpg 960w"
                         sizes="(max-width: 56.25em) 20vw,
                      (max-width: 37.5em) 30vw, 300px"
                         alt="Tour photo"
                         class="popup__img"
                         src="img/nast-7-large.jpg">

                    <!-- <img src="img/nast-7.jpg" alt="Tour photo" class="popup__img"> -->

                    <img srcset="img/nast-9.jpg 300w,
                       img/nast-9-large.jpg 960w"
                         sizes="(max-width: 56.25em) 20vw,
                      (max-width: 37.5em) 30vw, 300px"
                         alt="Tour photo"
                         class="popup__img"
                         src="img/nast-9-large.jpg">
                    <!--   <img src="img/nast-9.jpg" alt="Tour photo" class="popup__img"> -->
                </div>
                <div class="popup__right">
                    <a href="#section-tours" class="popup__close">&times;</a>
                    <h2 class="heading-secondary u-margin-bottom-small">Start travel now</h2>
                    <h3 class="heading-tertiary u-margin-bottom-small">Important &ndash; Please read these terms and conditions before booking.</h3>
                    <p class="popup__text">Closer to the road, the mountains are not sharp peaks, but round, as if oval. They are densely wooded. From a distance it may seem that these are the thick backs of huge shaggy bears, and their skins are green. But the wool on the backs of the bears is century-old firs and pines tens of meters high. When you go on the road, the bear's backs almost close in front of the car. And further away, the chain raises real high-rise peaks.</p>
                    <a href="" class="btn btn--green">Order here</a>
                </div>
            </div>
        </div>
    </div>
</@basicPage.mybasicmacro>
