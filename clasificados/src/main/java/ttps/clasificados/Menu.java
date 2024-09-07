package ttps.clasificados;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class Menu
 */
public class Menu extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<Usuario> usuarios;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Menu() {
       	this.usuarios= new ArrayList<Usuario>();
    	Usuario u1= new Usuario("zoezz", "1234", "Publicador");
    	Usuario u2= new Usuario("facundo22", "4567", "Administrador");
    	usuarios.add(u1);
    	usuarios.add(u2);
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Usuario autenticado= this.usuarios.stream().filter(usuario-> usuario.esCorrecto(request.getParameter("usuario"), request.getParameter("contraseña"))).findFirst().orElse(null);
		if (autenticado!=null) {
			if (autenticado.esPublicador()) {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println( "<html><body> ");
				out.println("<h1>" + "Sos publicador" + "</h1>");
				out.print( " </body></html> ");
				out.close();
			}
			else {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println( "<html><body> ");
				out.println("<h1>" + "Sos publicador" + "</h1>");
				out.print( " </body></html> ");
				out.close();
			}	
		}
		else
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println( "<html><body> ");
			out.println("<h1>" + "Datos inválidos" + "</h1>");
			out.print( " </body></html> ");
			out.close();
		
	}

}
