<nav role="navigation" class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container container-fluid">
        <a href="/" class="navbar-brand">Todo!</a>

        <div class="navbar-collapse container-fluid">
            <ul class="navbar-nav me-auto mb-lg-0">
                <li class="nav-item"><a class="nav-link" href="/">Home</a></li>
                <li class="active nav-item"><a class="nav-link" href="/list-todos">Todos</a></li>
            </ul>
            <div class="d-flex">
            <ul class="navbar-nav me-auto mb-lg-0">
                <li class="nav-item dropdown mx-2 small">
               <a class="nav-link dropdown-toggle" href="#" id="navbarScrollingDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        Lang
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                        <li><a class="dropdown-item" href="?language=en">English</a></li>
                        <li><a class="dropdown-item" href="?language=zh">Chinese</a></li>
                    </ul>
                </li>


            </ul>

             <a href="/logout" class="btn btn-outline-danger d-flex">Logout</a>
            </div>


            </div>

    </div>


</nav>
