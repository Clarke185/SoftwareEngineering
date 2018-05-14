<%-- 
    Document   : display
    Created on : 10-May-2018, 16:45:41
    Author     : izzyp
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Display page</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark fixed-top">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="#">Link</a>
          </li>
            </div>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>

    <main role="main" class="container">
        <br><br><br>
        <h1>Exercise Display:</h1>
            <%
                String exerciseID = request.getParameter("exerciseID");
                String exerciseType = request.getParameter("exerciseType");
                String exerciseTime = request.getParameter("exerciseTime");
                int exTimeInt = Integer.parseInt(exerciseTime);
                int calsPerHour = 0;
                int calsBurnt = 0;

                switch (exerciseType) {
                    case "Cycling" :  calsPerHour = 270;
                             break;
                    case "Walking" :  calsPerHour = 180;
                             break;
                    case "Dancing" :  calsPerHour = 360;
                             break;
                    case "Running" :  calsPerHour = 720;
                             break;
                    case "Yoga" :  calsPerHour = 250;
                             break;
                    case "Housework" :  calsPerHour = 130;
                             break;
                    case "Swimming ":  calsPerHour = 500;
                             break;
                    case "Weight-lifting" :  calsPerHour = 180;
                             break;
                    case "Team sport (e.g. football)":  calsPerHour = 590;
                             break;
                    case "Unspecified (high heart rate)" : calsPerHour = 800;
                             break;
                    case "Unspecified (low heart rate)" : calsPerHour = 200;
                             break;
                }
                calsBurnt = exTimeInt * (calsPerHour/60);
                %>
                <table border="0">
                    <tbody>
                        <tr>
                            <td><p>With <%= exerciseID %> you burnt:</p></td>
                            <td><p><%= calsBurnt %> calories!</p></td>
                        </tr>
                    </tbody>
                </table>

        </main><!-- /.container -->
        

    </body>
</html>
