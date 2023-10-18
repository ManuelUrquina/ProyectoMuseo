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
        
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <table class="table table-bordered" border="1">
            <thead>
                <tr>
                    <th class="text-center">Nis</th>
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Edificio</th>
                    <th class="text-center">Tipo de documento</th>



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
                    </td>
                </tr>
                <%
                    }
                %> 
                
                </table>
                
                </body>
                </html>
