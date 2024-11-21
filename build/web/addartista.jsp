<%-- 
    Document   : addartista
    Created on : 19 oct 2023, 18:29:45
    Author     : M4nu3h
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        
        <title>JSP Page</title>
    </head>
    <body>

        <form action="CcntroladorArtista" method="POST" enctype="multipart/form-data">
            
            <div class="form-group">
                <label for="txtID">NIS Artista:</label>
                <input type="number" class="form-control" id="codigoartista" name="txtID" required>
            </div>
            
            <div class="form-group">
                <label for="txtcodigoartista">Codigo Artista:</label>
                <input type="number" class="form-control" id="codigoartista" name="txtcodigoartista" required>
            </div>
            <div class="form-group">
                <label for="txtapellido">Apellido:</label>
                <input type="text" class="form-control" id="apellido" name="txtapellido" required>
            </div>
            <div class="form-group">                   
                <label for="txtnombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="txtnombre" required>
            </div>
            
            <div class="form-group">
                <label for="txtlugarnacim">Lugar:</label>
                <input type="text" class="form-control" id="lugar" name="txtlugarnacim" required>
            </div>                
            <div class="form-group">
                <label for="txtfechanacimiento">Fecha de nacimiento</label>
                <input type="date" class="form-control" id="fechanacimiento" name="txtfechanacimiento" required>
            </div>
            <div class="form-group">
                <label for="imagen">Foto</label>
                <input type="file" name="file" accept="image/jpeg">
            </div>
            <br>
            <button type="submit" class="btn btn-primary">Enviar</button>

        </form>
    </body>
</html>
