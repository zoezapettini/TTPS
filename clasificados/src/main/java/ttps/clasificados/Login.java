package ttps.clasificados;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private List<Usuario> usuarios;
    /**
     * Default constructor. 
     */
    public Login() {
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
		/*Usuario autenticado= this.usuarios.stream().filter(usuario-> usuario.esCorrecto(request.getParameter("usuario"), request.getParameter("contraseña"))).findFirst().orElse(null);
		if (autenticado!=null) {
			if (autenticado.esPublicador())
				response.sendRedirect("/clasificados/menuPublicador.html");
			else
				response.sendRedirect("/clasificados/menuAdministrador.html");
		}
		else
			response.sendRedirect("/clasificados/error.html");
			/*
			 * 
			 */
		RequestDispatcher dispatcher= getServletContext().getRequestDispatcher("/Menu");
		dispatcher.forward(request, response);
		
		
	}

}
