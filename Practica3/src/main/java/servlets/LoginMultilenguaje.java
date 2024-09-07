package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Servlet implementation class LoginMultilenguaje
 */
public class LoginMultilenguaje extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginMultilenguaje() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String lenguaje = (String) request.getAttribute("idioma");
		System.out.println(lenguaje);
		if (lenguaje == null) {
			lenguaje = "es";
		}
		
		String archivoPropiedades = "textos_" + lenguaje + ".properties";
		System.out.println("primero");
		//Cargar el archivo
		Properties textos = new Properties();
		InputStream input = getClass().getClassLoader().getResourceAsStream(archivoPropiedades);
		System.out.println("Segundo");
		
		try (InputStream finalInput = input){
			textos.load(finalInput);
		}
		
		System.out.println("Tercero");
		//Configurar respuesta del hml
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head><title>" + textos.getProperty("titulo") + "</title></head>");
		out.println("<body>");
		out.println("<h1>" + textos.getProperty("titulo") + "</h1>");
		out.println("<p>" + textos.getProperty("labelusuario") + "</p>");
		out.println("</body>");
		out.println("</html>");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
