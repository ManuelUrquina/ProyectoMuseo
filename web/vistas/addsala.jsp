<%-- 
    Document   : addsala
    Created on : 18 oct 2023, 11:38:51
    Author     : ADSO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Agregar Sala</title>
    </head>
    <body>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Sala</h1>
                <form action="controladorSala">
                    Nis:<br>
                    <input class="form-control" type="text" name="txtID"><br>
                    Nombre de la Sala:<br>
                    <input class="form-control" type="text" name="txtNom"><br>
                    Edificio donde esté la sala: <br>
                    <input class="form-control" type="text" name="txtEdif"><br>
                    Planta:  <br>
                    <input class="form-control" type="text" name="txtPlan"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    
                    
                   </form> 
                    
    </body>
</html>
