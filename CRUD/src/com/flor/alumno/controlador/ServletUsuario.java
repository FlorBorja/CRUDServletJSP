package com.flor.alumno.controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flor.alumno.dao.UsuarioDAO;
import com.flor.alumno.modelo.Usuario;

@WebServlet("/servletUsuario")
public class ServletUsuario extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	UsuarioDAO usuarioDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			usuarioDAO = new UsuarioDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletUsuario() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		String action = req.getParameter("action");
		System.out.println(action);
		try {
			switch (action) {
			case "index":
				index(req, res);
				break;
			case "validarUsuario":
				validarUsuario(req, res);
				break;
			case "nuevoUsuario":
				nuevoUsuario(req, res);
				break;
			case "registrarUsuario":
				//System.out.println("entro");
				registrarUsuario(req, res);
				break;
			case "cerrarSesion":
				//System.out.println("entro");
				cerrarSesion(req, res);
				break;
			}			
		} catch (SQLException e) {
			e.getStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("Hola Servlet..");
		doGet(req, res);
	}
	
	private void index(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher= req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, res);
	}
	
	private void validarUsuario(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		Usuario usuario = new Usuario(req.getParameter("usuario"), req.getParameter("password"));
		
		try {
			if(req.getParameter("ckbox").equals("on")) {
				Cookie cookie = new Cookie("usuario", req.getParameter("usuario")); 
				cookie.setMaxAge(60*60*24);
				 res.addCookie(cookie);
				 System.out.println("cookie creada");
			}
		}catch(NullPointerException e) {
			System.out.print("checkbox vacio");
		}
		
		 if(usuarioDAO.validar(usuario)){ 
			 	RequestDispatcher dispatcher= req.getRequestDispatcher("/Vista/mostrar.jsp");
				dispatcher.forward(req, res);
		    }  
		    else{  
		        System.out.print("Usuario o contraseña inconrrecto");  
		        RequestDispatcher dispatcher= req.getRequestDispatcher("index.jsp");
				dispatcher.forward(req, res);  
		    }  
		    System.out.close();   
	}
	
	private void registrarUsuario(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		Usuario usuario = new Usuario(req.getParameter("usuario"), req.getParameter("password"));
		usuarioDAO.insertarUsuario(usuario);
		index(req, res);
	}
	
	private void nuevoUsuario(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Vista/registrarUsuario.jsp");
		dispatcher.forward(req, res);
	}
	
	private void cerrarSesion(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		HttpSession session = req.getSession();
		session.invalidate();
		RequestDispatcher dispatcher= req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, res);
	}
}
