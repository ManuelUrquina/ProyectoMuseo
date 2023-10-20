<%-- 
    Document   : listarartista
    Created on : 19 oct 2023, 18:30:04
    Author     : M4nu3h
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.adso.clasesPojo.ArtistaPOJO"%>
<%@page import="java.util.List"%>
<%@page import="com.adso.ModeloDAO.ArtistaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Sala</title>
        <script>
        function buscar() {
            var input, filter, table, tr, td, i, txtValue;
            input = document.getElementById("searchInput");
            filter = input.value.toUpperCase();
            table = document.getElementById("salaTable");
            tr = table.getElementsByTagName("tr");

            for (i = 0; i < tr.length; i++) {
                td = tr[i].getElementsByTagName("td");
                var found = false;
                for (var j = 0; j < td.length; j++) {
                    if (td[j]) {
                        txtValue = td[j].textContent || td[j].innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            found = true;
                            break;
                        }
                    }
                }
                if (found) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    </script>
    </head>
    <body>
        <a class="btn btn-success" href="addartista.jsp">Agregar Nueva Sala</a>
        <br>
        <br>
        <div class="input-wrapper ml-4 mt-2">
            <input class="form-control" type="search" placeholder="Buscar" aria-label="Search" id="searchInput" onkeyup="buscar()">
        </div>
        <br>

        <table class="table table-bordered" id="salaTable">
            <thead>
                <tr>
                    <th class="text-center">Nis</th>
                    <th class="text-center">Codigo</th>
                    <th class="text-center">Apellido</th>
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Lugar de Nacimiento</th>
                    <th class="text-center">Fecha de nacimiento</th>
                    <th class="text-center">Foto</th>
                    <th class="text-center">Decisiones</th>
                </tr>
            </thead>

            <%
                ArtistaDAO dao = new ArtistaDAO();
                List<ArtistaPOJO> list = dao.listarartista();
                Iterator<ArtistaPOJO> iter = list.iterator();
                ArtistaPOJO art = null;
                while (iter.hasNext()) {
                    art = iter.next();

            %>

            <tbody>
                <tr>
                    <td class="text-center"><%= art.getArtId()%></td>
                    <td class="text-center"><%= art.getArtCodigoArtista()%></td>
                    <td class="text-center"><%= art.getArtapellidos()%></td>
                    <td class="text-center"><%= art.getArtnombre()%></td>
                    <td class="text-center"><%= art.getArtlugarNacimiento()%></td>
                    <td class="text-center"><%= art.getArtfechaNacimiento()%></td>
                    <td class="text-center"><%= art.getArtPathImagen()%></td>
                    
                    
                    <td class="text-center"><a class="btn btn-warning"  href="controladorSala?accion=editar&id=<%= art.getArtId()%>" >Editar</a> 
                        <a class="btn btn-danger" href="controladorSala?accion=eliminar&id=<%= art.getArtId()%>" 
                           onclick="return confirm('¿Realmente desea eliminar?')">Eliminar</a> </td>

                </tr>
                <%
                    }
                %> 

        </table>

    </body>
</html>
