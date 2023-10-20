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
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>

        <<form action="CcntroladorArtista" method="POST" enctype="multipart/form-data">
            
            <div class="form-group">
                <label for="txtID">NIS Artista:</label>
                <input type="number" class="form-control" id="codigoartista" name="codigoartista" required>
            </div>
            <div class="form-group">
                <label for="txtcodigoartista">Codigo Artista:</label>
                <input type="number" class="form-control" id="codigoartista" name="codigoartista" required>
            </div>
            <div class="form-group">
                <label for="txtapellido">Apellido:</label>
                <input type="text" class="form-control" id="apellido" name="apellido" required>
            </div>
            <div class="form-group">                   
                <label for="txtnombre">Nombre:</label>
                <input type="text" class="form-control" id="nombre" name="nombre" required>
            </div>
            
            <div class="form-group">
                <label for="txtlugarnacim">Lugar:</label>
                <input type="text" class="form-control" id="lugar" name="lugar" required>
            </div>                
            <div class="form-group">
                <label for="txtfechanacimiento">Fecha de nacimiento</label>
                <input type="date" class="form-control" id="fechanacimiento" name="fechanacimiento" required>
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
