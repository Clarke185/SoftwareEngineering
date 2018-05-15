<%-- 
    Document   : goals
    Created on : 07-May-2018, 18:30:06
    Author     : George
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0" charset="UTF-8">
<title>New Goal</title>
    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>

</head>

<body>
    
            <div class="container">
            <!--modal form start-->
            <form class="form-horizontal" ame="SetGoal" action="goals.jsp" method="POST">
                <!--modal-header-->
                <div class="container">
                    <h4>New Goal</h4>
                </div>
                <!--modal body-->
                <div class="modal-body">
                    <div class="form-group">
                        <label for="goal-name" class="col-lg-2 control-label">Goal Title</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="goal-name" placeholder="Goal" name="goalName">
                        </div>
                    </div>
                    
                     <div class="form-group">
                        <label for="goal-description" class="col-lg-2 control-label">Description</label>
                        <div class="col-lg-10">
                            <textarea class="form-control" rows="8" name="goalDesc"></textarea>
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="goal-date" class="col-lg-2 control-label">Date</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="goal-date" placeholder="Target Date" name="goalDate">
                        </div>
                    </div>
                    
                    <div class="form-group">
                        <label for="goal-weight" class="col-lg-2 control-label">Target weight</label>
                        <div class="col-lg-10">
                            <input type="text" class="form-control" id="goal-weight" placeholder="Target weight kg" name="goalWeight">
                        </div>
                    </div>
                    
                </div>
                <!--modal footer-->
                <div class="container">
                    <button class="btn btn-success" type="submit" type="submit" value="Submit" name="submit"</button>
                </div>
                </form>
            </div>
    
    
  

           
       
    
        <%!
            public class insertGoal {

                String URL = "";
                String USERNAME = "";
                String PASSWORD = "";

                Connection connection = null;
                PreparedStatement insertMeals = null;
                ResultSet resultset = null;

                public insertGoal() {

                    try {

                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

                        insertMeals = connection.prepareStatement("INSERT INTO goals(goalName, goalDesc, goalDate, goalWeight) VALUES(?, ?, ?, ?)");

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                public int setGoal(String goalname, String goaldesc, String goaldate, int goalweight) {
                    int result = 0;
                    try {
                        insertGoal.setString(1, goalname);
                        insertGoal.setString(2, goaldesc);
                        insertGoal.setString(2, goaldate);
                        insertGoal.setInt(4, goalweight);

                        result = insertGoal.executeUpdate();

                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    return result;

                }
            }
        %>

        <%
            int result = 0;

            if (request.getParameter("submit") != null) {

                String goalName = new String();
                String goalDesc = new String();
                String goalDate = new String();
                int goalweight = 0;

                if (request.getParameter("goalName") != null) {
                    goalName = request.getParameter("goalName");
                }

                if (request.getParameter("goalDesc") != null) {
                    goalDesc = request.getParameter("goalDesc");
                }
                
                 if (request.getParameter("goalDate") != null) {
                    goalDate = request.getParameter("goalDate");
                }

                if (request.getParameter("goalWeight") != null) {
                    goalweight = Integer.parseInt(request.getParameter("calorieAmount"));
                } else {
                    goalweight = 0;
                }

                insertGoal goal = new insertGoal();
                result = goaal.setGoal(goalName, goalDesc, goalDate, goalweight);
            }
        %>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <script language="JavaScript">
        function displayResults()
        {
            if (document.SetGoal.hidden.value == 1) {
                alert("Goal Set!");
            }
        }
    </script>
</body>
</html>

