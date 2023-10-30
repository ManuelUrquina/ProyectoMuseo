<%-- 
    Document   : addObra
    Created on : 26 oct 2023, 07:05:46
    Author     : ADSO
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
        <form action="controladorObra" method="POST" enctype="multipart/form-data">

            NIS Obra:<br>
            <input type="number" class="form-control" id="codigoartista" name="txtID" required>
            <br><br>
            Numero del Catalogo:<br>
            <input type="number" class="form-control" id="numc" name="numc" required>
            <br><br>

            Titulo de la Obra: <br>
            <input type="text" class="form-control" id="titulo" name="titulo" required>
            <br><br>
            Fecha Realizada:<br>
            <input type="date" class="form-check" id="FechaR" name="FechaR" required>
            <br>
            <br>
            Artista:
            <input type="radio" id="id" name="Artist" value="1">Vulkan
            <br>
            <br>
            
            Categoria: <br>
            <input type="text" class="form-control" id="Categ" name="Categ" required>
            <br><br>
            
            
            Foto 1: <br>
            <input type="file" name="file" accept="image/png">
            <br><br>
            Foto 2: <br>
            <input type="file" name="file1" accept="image/png">
            <br><br>
            PDF: <br>
            <input type="file" name="file2" accept=".pdf">
            <br>
            <button type="submit" class="btn btn-primary" name="accion" value="agregarobraarte">Enviar</button>

        </form>

    </body>
</html>
