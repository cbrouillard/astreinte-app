<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
</head>

<body>

<g:if test='${flash.message}'>
    <div class='alert-info alert'>${flash.message}</div>
</g:if>


<div class="container">

    <div class="col-lg-6 col-lg-offset-3">
        <div class="panel panel-success">

            <div class="panel-heading">
                <h3>Connexion sur Dentifrice</h3>
            </div>

            <div class="panel-body">

                <form class="form-signin" action='${postUrl}' method='POST' id='loginForm' autocomplete='off'>

                    <label for="username" class="sr-only"><g:message code="user"/></label>
                    <input type="text" name='username' id='username' class="form-control"
                           placeholder="Votre id utilisateur"
                           required
                           autofocus>

                    <br/>

                    <label for="password" class="sr-only"><g:message code="password"/></label>
                    <input type="password" name='password' id='password' class="form-control"
                           placeholder="Votre mot de passe"
                           required>

                    <br/>

                    <div class="checkbox">
                        <label>
                            <input type="checkbox" name='${rememberMeParameter}' id='remember_me'
                                   <g:if test='${hasCookie}'>checked='checked'</g:if>/> Se souvenir de moi
                        </label>
                    </div>
                    <button class="btn btn-lg btn-success btn-block" type="submit">Connexion</button>
                </form>
            </div>

        </div>
    </div>

</div>
</body>
</html>