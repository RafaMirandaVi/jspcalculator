<!DOCTYPE HTML>
<html>
<head>
    <title>Calculadora con Servlets</title>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-widht, minimum-scale=1, maximum-scale=1" />
    <link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <header>
        <h1>
            Calculadora
        </h1>
        <p>
            <a href="https://github.com/rafamirandavi" target="_blank">Rafael Miranda Villegas©</a> <strong>5IM8</strong>
        </p>
    </header>

    <form name="calcular" action="Servlet" method="POST">
        <input type="text" name = "primerTermino" size="15" placeholder="Primer número" /> 
        <select name="Signo">
            <option value="" class="icon-arrow"></option>
            <option value="+">+</option>
            <option value="-">-</option>
            <option value="*">*</option>
            <option value="/">÷</option>
        </select>

        <input type="text" name="segundoTermino" size="15" placeholder="Segundo número" />
        <input type="submit" value="Calcular" onclick="return validar(primerTermino, segundoTermino, Signo);" data-loading-text="Calculando..."/>
    </form>    
    <div id="resultado">
        <% 
        if ((request.getAttribute("operacionr") != null)&& !request.getAttribute("operacionr").toString().isEmpty()) {
        %>
        <p><% out.print(request.getAttribute("operacionr").toString()); %></p>
        <% 
        } 
        else{
            request.setAttribute("operacionr", null);
            } 
        %>
        <% 
        if (request.getAttribute("resultado") != null) {
        %>
        <p><% if (request.getAttribute("resultado") != null) {out.print(request.getAttribute("resultado"));} %></p>
        <p>
            <a href="./">Limpiar</a>
        </p>
        <% } %>
    </div>
</body>
</html>
