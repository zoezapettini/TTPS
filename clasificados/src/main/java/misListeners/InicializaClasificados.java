package misListeners;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class InicializaClasificados implements ServletContextListener {
 public void contextDestroyed(ServletContextEvent sce) { }

 public void contextInitialized(ServletContextEvent sce) {
// Se leen parametros de inicializacion de la aplicación
	 String nombreSitio = sce.getServletContext().getInitParameter("nombreSitio");
	 String email = sce.getServletContext().getInitParameter("email");
	 String telefonoContacto = sce.getServletContext().getInitParameter("telefonoContacto");
// Se guardan en el contexto, las peliculas en Cartelera
	 ServletContext contexto = sce.getServletContext();	
	 contexto.setAttribute("nombreSitio", nombreSitio);
	 contexto.setAttribute("email", email);
	 contexto.setAttribute("telefonoContacto", telefonoContacto);
	 System.out.println("nombre sitio" + contexto.getAttribute("nombreSitio"));
	 System.out.println("email: " + contexto.getAttribute("email"));
	 System.out.println("telefono: " + contexto.getAttribute("telefonoContacto"));
 }
}