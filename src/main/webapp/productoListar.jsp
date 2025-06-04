<%--
  Created by IntelliJ IDEA.
  User: Maiccol Zurtia
  Date: 3/6/2025
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="java.util.*, org.elvis.webbappcookiematu.models.*" %>
<%@ page import="org.elvis.webbappcookiematu.models.Productos" %>
<%
  List<Productos> productos = (List<Productos>) request.getAttribute("productos");
  Optional<String> username = (Optional<String>) request.getAttribute("username");
%>
<html>
<head>
  <title>Listado Productos</title>
</head>
<body>

<h1>Listado Producto</h1>
<%
  if (username.isPresent()) { %>
<div class="welcome">Hola, <%= username.get() %> bienvenido</div>
<div><a href="<%= request.getContextPath() %>/productos/form">Añadir Producto</a></div>
<a class="back-link" href="index.html">Volver al Inicio</a>
<% } %>

<table>
  <thead>
  <tr>
    <th>ID Producto</th>
    <th>ID Categoria</th>
    <th>Código</th>
    <th>Nombre</th>
    <th>Stock</th>
    <th>Descripción</th>
    <th>Imagen</th>
    <th>Condición</th>
    <% if (username.isPresent()) { %>
    <th>Acción</th>
    <% } %>
  </tr>
  </thead>
  <tbody>
  <%
    for (Productos prod : productos) { %>
  <tr>
    <td><%= prod.getIdProducto() %></td>
    <td><%= prod.getIdCategoria() %></td>
    <td><%= prod.getCodigo() %></td>
    <td><%= prod.getNombre() %></td>
    <td><%= prod.getStock() %></td>
    <td><%= prod.getDescripcion() %></td>
    <td>
      <% if(prod.getImagen() != null && !prod.getImagen().isEmpty()) { %>
      <img src="<%= prod.getImagen() %>" alt="Imagen"/>
      <% } else { %>
      Sin imagen
      <% } %>
    </td>
    <td><%= prod.isCondicion() ? "Activo" : "Inactivo" %></td>
    <% if (username.isPresent()) { %>
    <td class="actions">
      <a href="<%= request.getContextPath() %>/productos/form?id=<%= prod.getIdProducto() %>">Editar</a>
      <a href="#">Eliminar</a>
    </td>
    <% } %>
  </tr>
  <%
    }
  %>
  </tbody>
</table>

</body>
</html>
