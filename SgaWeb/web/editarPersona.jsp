<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Modificar Persona</title>
    </head>
    <body>
        <h1>Modificar Persona</h1>
        <form action="ServletControlador" method="post">
            <input type="hidden" name="accion" value="modificar" />
            <input type="hidden" name="id" value="${persona.id}" />
            
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" style="display: block;" value="${persona.nombre}">
            <label for="paterno">Apellido Paterno:</label>
            <input type="text" name="paterno" style="display: block;" value="${persona.paterno}">
            <label for="materno">Apellido Materno:</label>
            <input type="text" name="materno" style="display: block;" value="${persona.materno}">
            <label for="email">Correo Electrónico:</label>
            <input type="text" name="email" style="display: block;" value="${persona.email}">
            <label for="telefono">Teléfono</label>
            <input type="text" name="telefono" style="display: block;" value="${persona.telefono}">
            
            <input type="submit" name="guardar" value="Guardar">
            <input type="submit" name="eliminar" value="Eliminar">
        </form>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
