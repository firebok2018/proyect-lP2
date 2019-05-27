<%
	if(session.getAttribute("USUARIO")== null){
		request.setAttribute("MENSAJE", "Para ingresar debe logearse");
		pageContext.forward("/portalSesionExpirada.jsp");
	}
%>