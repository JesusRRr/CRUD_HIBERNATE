package com.hibernatepractica1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernatepractica1.model.Producto;

/**
 * Servlet implementation class CrearProductoServlet
 */
@WebServlet("/CrearProductoServlet")
public class CrearProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearProductoServlet() {
        super();
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
		response.setContentType("text/html");
		Producto miProducto= new Producto();
		PrintWriter salida = response.getWriter();
		
		miProducto.setIdProducto(Integer.parseInt(request.getParameter("txtIdProducto")));
		miProducto.setNombreProducto(request.getParameter("txtNombreProducto"));
		miProducto.setPrecioProducto(Double.parseDouble(request.getParameter("txtPrecioProducto")));
		miProducto.setExistenciaProducto(Integer.parseInt(request.getParameter("txtExistenciaProducto")));
	
		
		salida.print("<html> "
				+ "<head>"
				+" <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css\">\r\n" 
				+"  <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js\"></script>\r\n"  
				+"  <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js\"></script>\r\n"
				+ "<link rel='stylesheet' href='css/style.css'>"
				+ ""
				+ "</head>"
				+ "<body>"
				+"<div class=\"container\">"
				+ "<h2>Producto</h1>"
				+ "<p><span class=\"label label-success\">Nombre: </span>"+"<span class=\"label label-primary\">"+miProducto.getNombreProducto()+"</span>"+"</p>"
				+ "<p><span class=\"label label-success\">Precio: </span>"+"<span class=\"label label-primary\">"+miProducto.getPrecioProducto()+"</span>"+"</p>"
				+ "<p><span class=\"label label-success\">Existencias: </span>"+"<span class=\"label label-primary\">"+miProducto.getExistenciaProducto()+"</span>"+"</p>"
				+ "</div>"
				+ ""
				+ "</body>"
				+ "  </html>");
		//Creamos la configuración
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		
		//Se crea el sessionFactory
		SessionFactory factory = cfg.buildSessionFactory();
		
		//Se inicia el objeto session
		Session session = factory.openSession();
		
		//Se inicia la transaccion
		Transaction transac = session.beginTransaction();
		
		//Se crea el objeto no persistido
		//Ya creamos el objeto en lineas mas arriba
		
		//Persistimos el objeto
		session.persist(miProducto);
		
		//Hacemos el commit
		transac.commit();
		
		
		session.close();
		salida.close();
	}

}
