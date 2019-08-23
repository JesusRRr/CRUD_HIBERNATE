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

import com.google.gson.Gson;
import com.hibernatepractica1.model.Producto;

/**
 * Servlet implementation class LeerProductoServlet
 */
@WebServlet("/LeerProductoServlet")
public class LeerProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeerProductoServlet() {
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
		response.setContentType("application/Json");
		
		PrintWriter salida = response.getWriter();
		
		Configuration cfg = new Configuration();
		
		//Se crea el sessionFactory
		SessionFactory factory = cfg.configure().buildSessionFactory();
				
		//Se inicia el objeto session
		Session session = factory.openSession();
				
		//Se inicia la transaccion
		Transaction transac = session.beginTransaction();
		
		int idProducto = Integer.parseInt(request.getParameter("txtIdProducto"));
		Producto miProducto = new Producto();
		miProducto=session.get(Producto.class, idProducto);
		
		Gson miGson = new Gson();
		salida.append(miGson.toJson(miProducto));
		
		transac.commit();
		salida.close();
	}

}
