<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Login Page</title>

        <link href="<c:url value='/static/css/bootstrap.min.css' />"  rel="stylesheet" />
        <link href="<c:url value='/static/css/signin.css' />"  rel="stylesheet" />
    </head>
    <body>

        <div class="container">
            <c:url var="loginUrl" value="/login" />
            <form class="form-signin" action="${loginUrl}" method="post">
                <h2 class="form-signin-heading">Please sign in</h2>
                <c:if test="${param.error != null}">
                    <div class="alert alert-danger">
                        <p>Invalid username and password.</p>
                    </div>
                </c:if>
                <c:if test="${param.logout != null}">
                    <div class="alert alert-success">
                        <p>You have been logged out successfully.</p>
                    </div>
                </c:if>
                <label for="username" class="sr-only">Username</label>
                <input type="text" id="username" name="ssoId" class="form-control" placeholder="Enter Username" required autofocus>
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Enter Password" required>
                <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                </div>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
            </form>

        </div> <!-- /container -->

    </body>
</html>
