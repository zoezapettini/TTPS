package misFiltros;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

/**
 * Servlet Filter implementation class FiltroLogDeAccesos
 */
public class FiltroLogDeAccesos extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public FiltroLogDeAccesos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		HttpServletRequest cliente = (HttpServletRequest) request;
		String iP= cliente.getRemoteAddr();
		LocalDateTime fechaHoraActual= LocalDateTime.now();
		String method= cliente.getMethod();
		String requestedUri= cliente.getRequestURI();
		String protocol= cliente.getProtocol();
		String requestLine= method + " " + requestedUri + " " + protocol;
		String userAgent= cliente.getHeader("User-Agent");
		
		System.out.println("Dirección IP del cliente: "+ iP);
		System.out.println("Fecha y Hora: "+ fechaHoraActual);
		System.out.println("Request Line: "+ requestLine);
		System.out.println("User-Agent: "+ userAgent);
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
