package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Premio
 */
@WebServlet("/Premio")
public class Premio extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int visitas;
	private String mensaje="¡Felicitaciones @! eres el visitante número # de nuestro sitio y has sido\n"
			+ "seleccionado para el gran premio TTPS - Cursada APROBADA";

    /**
     * Default constructor. 
     */
    public Premio() {
    	this.visitas=0;
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.visitas++;
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getParameter("nombre");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(this.visitas);
		this.visitas++;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println( "<html><body> ");
		out.println("<h1>" + mensaje.replace("@", request.getParameter("nombre")).replace("#", " "+ this.visitas)+ "</h1>");
		out.print( " </body></html> ");
		out.close();
		
	}

}
