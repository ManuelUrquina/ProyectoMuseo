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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>
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
        <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.2/dist/js/bootstrap.min.js"></script>

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


                    <td class="text-center"><a class="btn btn-warning"  href="CcntroladorArtista?accion=editar&id=<%= art.getArtId()%>" >Editar</a> 
                        <a class="btn btn-danger" href="CcntroladorArtista?accion=eliminar&id=<%= art.getArtId()%>" 
                           onclick="return confirm('¿Realmente desea eliminar?')">Eliminar</a> 
                        <a class="btn btn-success view-img-btn" data-toggle="modal" data-target="#VerFotoModal" data-img-src="<%= art.getArtPathImagen()%>">Ver Foto</a>
                    </td>

                </tr>
                <%
                    }
                %> 

        </table>

        <div class="modal " id="VerFotoModal" tabindex="-1" role="dialog" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title">Foto del Artista</h5>
                        <a class="close btn btn-danger" data-dismiss="modal"><i class="fa-regular fa-circle-xmark"></i></a>
                    </div>
                    <div class="modal-body">
                        <img id="view-img" src="" style="max-width: 100%; max-height: 100%;" />
                    </div>
                </div>
            </div>
        </div>


        <script>
            $(document).ready(function () {
                $('.view-img-btn').click(function () {
                    var imgSrc = $(this).data('img-src');
                    $('#view-img').attr('src', imgSrc);
                });
            });
        </script>
    </body>
</html>
