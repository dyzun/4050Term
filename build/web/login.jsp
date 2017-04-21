<%-- 
    Document   : login
    Created on : Apr 19, 2017, 8:42:22 PM
    Author     : josep
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Register Guest</title>
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
                <h1><a><img src="images/logo.png" alt=""></a></h1>
                <div class="clear"></div>
            </div>
        </header>
        <!--==============================content================================-->
        <section id="content">
            <div align="center">
                <div id="header">
                    <h2>Login Page</h2>
                </div>
                <!-- Put link here -->
                <form action="Servlet" method="post">
                    <div id="login">
                        <div>
                            <label for="username">Username:</label>
                            <input type="text" id="username" name="username" class="textcl" />
                        </div>

                        <div>
                            <label for="password">Password:&nbsp;</label>
                            <input type="password" id="password" name="password" class="textcl" />
                        </div>
                        <p>${message}</p> <!--Error message is printed here from servlet.java-->
                        <br>
                        <button name="signin" class="btn">Sign in</button>
                    </div>
                </form>
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
