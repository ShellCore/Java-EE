<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Agregar Persona</title>
    </head>
    <body>
        <h1>Agregar persona</h1>
        <form action="ServletControlador" method="post">
            <input type="hidden" name="accion" value="agregar" />
            
            <label for="nombre">Nombre:</label>
            <input type="text" name="nombre" style="display: block;">
            <label for="paterno">Apellido Paterno:</label>
            <input type="text" name="paterno" style="display: block;">
            <label for="materno">Apellido Materno:</label>
            <input type="text" name="materno" style="display: block;">
            <label for="email">Correo Electrónico:</label>
            <input type="text" name="email" style="display: block;">
            <label for="telefono">Teléfono</label>
            <input type="text" name="telefono" style="display: block;">
            
            <input type="submit" value="Guardar">
            
        </form>
        <a href="index.jsp">Regresar al inicio</a>
    </body>
</html>
