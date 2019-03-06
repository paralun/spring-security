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
        <title>Hello Security</title>

        <link href="<c:url value='/static/css/bootstrap.min.css' />"  rel="stylesheet" />
        <link href="<c:url value='/static/css/justified-nav.css' />"  rel="stylesheet" />

    </head>
    <body>
        <div class="container">

            <!-- The justified navigation menu is meant for single line per list item.
                 Multiple lines will require custom code not provided by Bootstrap. -->
            <div class="masthead">
                <h3 class="text-muted">Project name</h3>
                <nav>
                    <ul class="nav nav-justified">
                        <li class="active"><a href="<c:url value="/home" />">Home</a></li>
                        <li><a href="<c:url value="/admin" />">Admin</a></li>
                        <li><a href="<c:url value="/db" />">DBA</a></li>
                        <li><a href="#">Downloads</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="<c:url value="/login" />">Login</a></li>
                    </ul>
                </nav>
            </div>

            <!-- Jumbotron -->
            <div class="jumbotron">
                <h1>Marketing stuff!</h1>
                <p class="lead">Cras justo odio, dapibus ac facilisis in, egestas eget quam. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet.</p>
                <p><a class="btn btn-lg btn-success" href="#" role="button">Get started today</a></p>
            </div>

            <!-- Example row of columns -->
            <div class="row">
                <div class="col-lg-4">
                    <h2>Safari bug warning!</h2>
                    <p class="text-danger">As of v9.1.2, Safari exhibits a bug in which resizing your browser horizontally causes rendering errors in the justified nav that are cleared upon refreshing.</p>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
                </div>
                <div class="col-lg-4">
                    <h2>Heading</h2>
                    <p>Donec id elit non mi porta gravida at eget metus. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa justo sit amet risus. Etiam porta sem malesuada magna mollis euismod. Donec sed odio dui. </p>
                    <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
                </div>
                <div class="col-lg-4">
                    <h2>Heading</h2>
                    <p>Donec sed odio dui. Cras justo odio, dapibus ac facilisis in, egestas eget quam. Vestibulum id ligula porta felis euismod semper. Fusce dapibus, tellus ac cursus commodo, tortor mauris condimentum nibh, ut fermentum massa.</p>
                    <p><a class="btn btn-primary" href="#" role="button">View details &raquo;</a></p>
                </div>
            </div>

            <!-- Site footer -->
            <footer class="footer">
                <p>&copy; 2016 Company, Inc.</p>
            </footer>

        </div> <!-- /container -->
    </body>
</html>
