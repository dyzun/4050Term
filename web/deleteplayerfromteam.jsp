<%-- 
    Document   : deleteplayerfromteam
    Created on : Apr 21, 2017, 6:30:00 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Delete Player From Team</title>
        <meta charset="utf-8">
        <link rel="stylesheet" type="text/css" media="screen" href="css/reset.css">
        <link rel="stylesheet" type="text/css" media="screen" href="css/grid_12.css">
        <link rel="stylesheet" type="text/css" media="screen" href="css/style.css">
        <script src="js/jquery-1.7.min.js"></script>
        <script src="js/jquery.easing.1.3.js"></script>
        <script src="js/cufon-yui.js"></script>
        <script src="js/cufon-replace.js"></script>
        <script src="js/Kozuka_L_300.font.js"></script>
        <script src="js/Kozuka_B_700.font.js"></script>
    </head>
    <body>
        <!--==============================header=================================-->
        <header>
            <div class="main">
                <h1><a href="homepage.html"><img src="images/logo.png" alt=""></a></h1>
                <div class="clear"></div>
            </div>
        </header>
        <nav>
            <ul class="menu">
                <li class="current"><a href="homepage.html">Home</a></li>

                <li class="dropdown"><a href="#">Admin</a>
                    <div class="dropdown-content">
                        <a href="createsport.html">Create Sport</a><br>
                        <a href="createdivision.html">Create Divisions</a><br>
                        <a href="createplayoffbracket.html">Create Playoff Tournament</a><br>
                        <a href="deletesport.jsp">Delete Sport</a><br>
                        <a href="deletedivision.jsp">Delete Division</a><br>
                        <a href="deleteplayoffbracket.jsp">Delete Playoff Tournament</a><br>
                    </div>
                </li>
                <li class="dropdown"><a href="#">Coach</a>
                    <div class="dropdown-content">
                        <a href="createteam.html">Create Team</a><br>
                        <a href="addplayerstoteam.jsp">Add Players To Team</a><br>
                        <a href="deleteplayerfromteam.jsp">Delete Players From Team</a><br>
                    </div>
                </li>
                <li class="dropdown"><a href="#">Player</a>
                    <div class="dropdown-content">
                        <a href="updateplayerprofile.jsp">Update Player Profile</a><br>
                    </div>
                </li>
                <li style="align:right;"><a href="login.jsp">Logout</a></li>
            </ul>
            <div class="clear"></div>
        </nav>
        <!--==============================content================================-->
        <section id="content">
            <div class="container_12 top-4">

                <div class="grid_8">
                    <div class="left-1">
                        <h2>Delete Player From Team</h2>
                        <form action="Servlet" method="post">
                            <fieldset>
                                <label><strong>Name of Player:</strong><br>
                                    <input type="text" id="currentname" name="currentname" value="" style="width:200px;">
                                </label><br>
                                <label><strong>ID of Player:</strong><br>
                                    <input type="number" id="currentid" name="currentid" value="" style="width:200px;">
                                </label><br>
                                <div class="btns"><button name="deleteplayerfromteam" class="btn">Delete</button></div>
                            </fieldset>
                        </form>
                    </div>
                </div>
                <div class="clear"></div>
            </div>
        </section>
        <!--==============================footer=================================-->
        <footer>
            <div>
                <p>� Team 2 - CSCI 6050 (Spring 2017)<br></p>
            </div>
        </footer>
        <script>Cufon.now();</script>
    </body>
</html>


