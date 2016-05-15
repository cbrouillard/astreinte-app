<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        Dentifrice - Gestion d'astreintes
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>

    <g:layoutHead/>
</head>

<body>

<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Dentifrice</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class="nav navbar-nav navbar-right">
                <sec:ifLoggedIn>

                    <li><g:link controller="logoff" class="logout"><span
                            class="glyphicon glyphicon-log-out"></span> Déconnexion</g:link>
                    </li>
                </sec:ifLoggedIn>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<div class="container-fluid">
    <g:layoutBody/>
</div>

<footer>
    <nav class="navbar navbar-default navbar-fixed-bottom">
        <div class="container-fluid">

            <ul class="nav navbar-nav">
                <li class="navbar-text">Dentifrice - Gestion d'astreintes au boulot</li>
            </ul>
        </div>
    </nav>
</footer>


<asset:javascript src="application.js"/>

</body>
</html>
