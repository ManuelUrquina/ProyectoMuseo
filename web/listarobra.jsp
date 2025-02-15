<%-- 
    Document   : listarobra
    Created on : 26 oct 2023, 06:38:26
    Author     : ADSO
--%>

<%@page import="java.util.Iterator"%>
<%@page import="com.adso.clasesPojo.ObraArtePojo"%>
<%@page import="java.util.List"%>
<%@page import="com.adso.ModeloDAO.ObraArteDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>Obras de Arte</title>
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
        <a class="btn btn-success" href="addObra.jsp">Agregar Nueva Obra</a>
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
                    <th class="text-center">Numero de Catalogo</th>
                    <th class="text-center">Titulo</th>
                    <th class="text-center">Fecha Realizacion</th>
                    <th class="text-center">Imagen 1</th>
                    <th class="text-center">Imagen 2</th>
                    <th class="text-center">PDF</th>
                    <th class="text-center">Artista</th>
                    <th class="text-center">Categoria</th>
                    <th class="text-center">Acciones</th>


                </tr>
            </thead>

            <%
                ObraArteDAO dao = new ObraArteDAO();
                List<ObraArtePojo> list = dao.listarobra();
                Iterator<ObraArtePojo> iter = list.iterator();
                ObraArtePojo obr = null;
                while (iter.hasNext()) {
                    obr = iter.next();

            %>

            <tbody>
                <tr>
                    <td class="text-center"><%= obr.getObrId()%></td>
                    <td class="text-center"><%= obr.getObrNumCatalogo()%></td>
                    <td class="text-center"><%= obr.getObrTitulo()%></td>
                    <td class="text-center"><%= obr.getObrFechaRealizacion()%></td>
                    <td class="text-center"><img src="<%= obr.getObrPathImg1()%>" width="200" height="200"/></td>
                    <td class="text-center"><img src="<%= obr.getObrPathImg2()%>" width="200" height="200"/></td>
                    <td class="text-center"><button onclick="abrirPDF()">Ver PDF</button></td>
                    <td class="text-center"><%= obr.getTblartistas_artId()%></td>
                    <td class="text-center"><%= obr.getTblcategoria_catId()%></td>
                    <td class="text-center">
                        <a class="btn btn-warning"  href="controladorSala?accion=editar&id=<%= obr.getObrId()%>" >Editar</a> 
                        <a class="btn btn-danger" href="controladorObra?accion=eliminar&id=<%= obr.getObrId()%>" 
                           onclick="return confirm('¿Realmente desea eliminar?')" method="post">Eliminar</a> </td>

                </tr>
                <%
                    }
                %> 

        </table>
                       <div class="modal" id="VerFotoModal" tabindex="-1" role="dialog" aria-hidden="true">
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
  function abrirPDF() {
    window.open("<%= obr.getObrPathPDF()%>");
  }
</script>
    </head>
    <body>

    </body>
</html>
