<%-- 
    Document   : listarsala
    Created on : 18 oct 2023, 09:09:41
    Author     : ADSO
--%>
<%@page import="com.adso.clasesPojo.SalaPOJO"%>
<%@page import="com.adso.ModeloDAO.SalaDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
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
        <a class="btn btn-success" href="controladorSala?accion=add">Agregar Nueva Sala</a>
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
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Edificio</th>
                    <th class="text-center">Planta</th>
                    <th class="text-center">Acciones</th>


                </tr>
            </thead>

            <%
                SalaDAO dao = new SalaDAO();
                List<SalaPOJO> list = dao.listarsala();
                Iterator<SalaPOJO> iter = list.iterator();
                SalaPOJO spo = null;
                while (iter.hasNext()) {
                    spo = iter.next();

            %>

            <tbody>
                <tr>
                    <td class="text-center"><%= spo.getSalId()%></td>
                    <td class="text-center"><%= spo.getSalNombre()%></td>
                    <td class="text-center"><%= spo.getSalEdificio()%></td>
                    <td class="text-center"><%= spo.getSalPlanta()%></td>
                    <td class="text-center"><a class="btn btn-warning"  href="controladorSala?accion=editar&id=<%= spo.getSalId()%>" >Editar</a> 
                        <a class="btn btn-danger" href="controladorSala?accion=eliminar&id=<%= spo.getSalId()%>" 
                           onclick="return confirm('¿Realmente desea eliminar?')" method="post">Eliminar</a> </td>

                </tr>
                <%
                    }
                %> 

        </table>

    </body>
</html>
