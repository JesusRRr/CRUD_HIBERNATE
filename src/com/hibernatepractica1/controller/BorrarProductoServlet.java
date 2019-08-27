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
 * Servlet implementation class BorrarProductoServlet
 */
@WebServlet("/BorrarProductoServlet")
public class BorrarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter salida =response.getWriter();
		
	Configuration cfg = new Configuration();
		
		//Se crea el sessionFactory
		SessionFactory factory = cfg.configure().buildSessionFactory();
				
		//Se inicia el objeto session
		Session miSesion = factory.openSession();
				
		//Se inicia la transaccion
		Transaction miTransaccion = miSesion.beginTransaction();
	
		Producto miProducto = new Producto();
		
		miProducto.setIdProducto(Integer.parseInt(request.getParameter("txtIdProducto")));
		// Obtenemos los valores 
		
		miSesion.delete(miProducto);
		
		
		salida.print("Producto borrado:"+miProducto.getIdProducto());
		miTransaccion.commit();
		miSesion.close();
		salida.close();
	}

}
