<html>
<head>
<title>Bienvenido al Portal Web</title>
<link href="css/estilos.css" rel="stylesheet" type="text/css">
</head>

<body background="images/apoyos/fondointranetsinfondo.jpg" leftmargin="0"
	topmargin="0" rightmargin="0" bottommargin="0" marginheight="0"
	marginwidth="0">

<table cellspacing="0" cellpadding="0" width="100%" border="0">
	<tr>
		<td colspan="2"><jsp:include page="portalCabecera.jsp" /></td>
	</tr>
	<tr>
		<td valign="top" width="190"><jsp:include page="portalMenu.jsp" /></td>

		<td align="center" valign="top">
		<table border="0">
			<tr>
				<td>&nbsp;</td>
			</tr>
			<tr>
				<td class=ContentHead width="650" align="center" valign="middle">
					Sesión 	Expirada
				</td>
			</tr>
			<tr>
				<td align="center">Ha expirado su tiempo de conexión con el 
					sistema, por favor salga de la intranet y 
					vuelva a ingresar
			</td>
				
			</tr>
		</table>
		
	<table cellspacing="0" cellpadding="4">
			<tr>
				<td colspan="2">
					<%
						String mensaje = (String) request.getAttribute("MENSAJE");
						if(mensaje!= null){
					%>	
					<font color="red" size="3"><%= mensaje %></font>
					<%} %>
				</td>
			</tr>
	</table>	
</table>
</body>
</HTML>
