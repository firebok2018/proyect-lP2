<%@page import="entidad.Menu"%>
<%@page import="java.util.List"%>
<%@page import="entidad.Usuario"%>

<TABLE >

		  <TR><td>&nbsp;</td></TR>
		  <TR>
		  	   <TD>
				   <A class=SiteLinkBold href="intranetPrincipal.jsp">
		                Principal
		           </A>
	           <TD>
		  </TR>		
		   <TR><td>&nbsp;</td></TR>
			
<%
	List<Menu> menus = (List<Menu>)session.getAttribute("MENU");
	if(menus!= null){			
		for(Menu x : menus){	
%>
			<TR>
			    <TD>
					<A class="SiteLinkBold" 
						href="<%= x.getUrl() %>">
	                	<%= x.getDescripcion() %>
	                </A>
				</TD>
		  	</TR>		
<%}} %>			
		  

		  <TR><td>&nbsp;</td></TR>
		  <TR>
			    <TD>
					<A class="SiteLinkBold" HREF="logout">
				    	   Salir
				   	 </A>
				</TD>
		  </TR>	
		  <TR><td>&nbsp;</td></TR>
		  <TR><td>&nbsp;</td></TR>
		  
		  <TR>
			  <td>
			  	<%
			  		Usuario usu = (Usuario)session.getAttribute("USUARIO");      
			  			
			  	%>	
			  		<font color="white"><b> 
			  			Bienvenido sr(a) : 
			  			<%
			  				if(usu!= null){
			  					out.print( usu.getNombre() + " " + usu.getApellido());  
			  				}
			  			%>
			  		</b></font>
			  </td>
		  </TR>	
		  
		 <TR><td>
		 		<A class="SiteLinkBold" href="logout">
	                	Salir
	            </A>
		</td></TR>
</TABLE>

