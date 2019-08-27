package com.hibernatepractica1.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
import com.hibernatepractica1.model.Producto;




/**
 * Servlet implementation class LecturaGeneralServlet
 */
@WebServlet("/LecturaGeneralServlet")
public class LecturaGeneralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturaGeneralServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		PrintWriter salida = response.getWriter();
		
	
		Configuration cfg = new Configuration();
		
		SessionFactory fct = cfg.configure().buildSessionFactory();
		
		Session sssn = fct.openSession();
		
		Transaction trnsc = sssn.beginTransaction();
		
	
		
		CriteriaQuery<Producto> cq = sssn.getCriteriaBuilder().createQuery(Producto.class);
		cq.from(Producto.class);
		
		List<Producto> resultados = sssn.createQuery(cq).getResultList();
		Gson gson = new Gson();
		
		salida.append(gson.toJson(resultados));
		trnsc.commit();
		
		sssn.close();
		
		salida.close();
	}

}
