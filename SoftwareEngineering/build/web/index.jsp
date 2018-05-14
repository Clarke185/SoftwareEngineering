<%-- 
    Document   : index
    Created on : 02-May-2018, 13:26:28
    Author     : izzyp
--%>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Exercise</title>
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
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
        
    <main role="main" class="container">
        <br><br><br>
        <h1>New Exercise</h1>
        <form name="singleExerciseForm" action="display.jsp" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Exercise identifier : </td>
                        <td><input type="text" name="exerciseID" value="e.g. Friday Night Run" size="50" /></td>
                    </tr>
                    <tr>
                        <td> Exercise type : </td>
                        <td><select name="exerciseType">
                                <option>Cycling</option>
                                <option>Walking</option>
                                <option>Dancing</option>
                                <option>Running</option>
                                <option>Yoga</option>
                                <option>Housework</option>
                                <option>Swimming</option>
                                <option>Weight-lifting</option>
                                <option>Team sport (e.g. football)</option>
                                <option>Unspecified (high heart rate)</option>
                                <option>Unspecified (low heart rate)</option>
                            </select></td>
                    </tr>
                    <tr>
                        <td>Exercise time : </td>
                        <td><input type="text" name="exerciseTime" value="in minutes" size="30" /></td>
                    </tr>
                
                </tbody>
            </table>
            <input type="reset" value="CLEAR" name="clear" />
            <input type="submit" value="SUBMIT" name="submit" />
        </form>
        
    </main><!-- /.container -->
    </body>
    
        
</html>
