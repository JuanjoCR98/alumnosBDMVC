<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Alumnos"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous"/>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String grupoActivo = (String) request.getAttribute("grupo");
            ArrayList<String> gruposDAW = (ArrayList<String>) request.getAttribute("grupos"); 
            List<Alumnos> alumnosGrupo = (List<Alumnos>) request.getAttribute("grupoSeleccionado");
        %>
        <div class="container" style="padding-top: 15px">
            <form action="servletAlumnos" method="get">
                <select name="grupo">
                    <%
                        for (int i = 0; i < gruposDAW.size(); i++) {
                            String grupoSeleccionado = "";
                            if (gruposDAW.get(i).equals(grupoActivo)) {
                                grupoSeleccionado = "selected";
                            }
                    %>
                    <option <%=grupoSeleccionado%> value="<%=gruposDAW.get(i)%>"><%=gruposDAW.get(i)%></option>
                    <% }%>
                </select> 
                <input type="submit" class="btn btn-primary" value="Mostrar grupo" style="margin-left:5px">
            </form> 
        </div>
        <br>
        <div class="container">
            <form action="servletAlumnos" method="post">
                <table class="table table-striped">
                <thead>
                    <tr>
                        <th colspan="4" style="text-align:center">ALUMNOS <%=grupoActivo%></th>
                    </tr>
                    <tr>
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Correo</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody>
                    <% for ( Alumnos al: alumnosGrupo) { %>
                        <tr>
                            <td>
                                <%=al.getNombre()  %>
                            </td>
                            <td>
                               <%=al.getApellidos()  %>
                            </td>
                            <td>
                               <%=al.getCorreo()  %>
                            </td>
                            <td>
                                <input type="checkbox" id="<%=al%>" name="alumno" value="<%=al.getId()%>,<%=al.getGrupo()%>,<%=al.getNombre()%>,<%=al.getApellidos()%>,<%=al.getCorreo()%>">
                            </td>
                        </tr>          
                         <% } %>
                </tbody>          
             </table>
            <input type="submit" class="btn btn-primary btn-block" value="ENVIAR">
            </form>
        </div>
    </body>
</html>
