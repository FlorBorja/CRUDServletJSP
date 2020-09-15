package com.flor.alumno.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flor.alumno.dao.AlumnoDAO;
import com.flor.alumno.modelo.Alumno;

@WebServlet("/servletAlumno")
public class ServletAlumno extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	AlumnoDAO alumnoDAO;

	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {
			alumnoDAO = new AlumnoDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAlumno() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		System.out.println("Hola Servlet Alumno..");
		String action = req.getParameter("action");
		System.out.println("Accion del servlet Alumno: "+action);
		try {
			switch (action) {
			case "index":
				index(req, res);
				break;
			case "nuevo":
				nuevo(req, res);
				break;
			case "registrar":
				//System.out.println("entro");
				registrar(req, res);
				break;
			case "mostrar":
				mostrar(req, res);
				break;
			case "buscarId":
				buscarId(req, res);
				break;
			case "showeditar":
				showEditar(req, res);
				break;	
			case "editar":
				editar(req, res);
				break;
			case "eliminar":
				eliminar(req, res);
				break;
			default:
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
		System.out.println("Hola Servlet Alumno..");
		doGet(req, res);
	}
	
	private void index (HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		//mostrar(request, response);
		RequestDispatcher dispatcher= req.getRequestDispatcher("index.jsp");
		dispatcher.forward(req, res);
	}

	private void registrar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		Alumno alumno = new Alumno(0, Integer.parseInt(req.getParameter("ncontrol")), req.getParameter("nombre"), req.getParameter("paterno"), req.getParameter("materno"), req.getParameter("curso"), Integer.parseInt(req.getParameter("semestre")));
		alumnoDAO.insertar(alumno);
		RequestDispatcher dispatcher= req.getRequestDispatcher("/Vista/mostrar.jsp");
		dispatcher.forward(req, res);
	}
	
	private void nuevo(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Vista/registrar.jsp");
		dispatcher.forward(req, res);
	}
	
	private void mostrar(HttpServletRequest req, HttpServletResponse res) throws SQLException, IOException , ServletException{
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Vista/mostrar.jsp");
		List<Alumno> listaAlumnos= alumnoDAO.listarAlumnos();
		req.setAttribute("lista", listaAlumnos);
		dispatcher.forward(req, res);
	}
	
	private void buscarId(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		Alumno alumno =  alumnoDAO.obtenerID(Integer.parseInt(req.getParameter("id")));
		List<Alumno> lista= new ArrayList<Alumno>();
		lista.add(alumno);
		req.setAttribute("lista", lista);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Vista/mostrar.jsp");
		dispatcher.forward(req, res);
	}
	
	private void showEditar(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		Alumno alumno = alumnoDAO.obtenerID(Integer.parseInt(req.getParameter("id")));
		req.setAttribute("alumno", alumno);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/Vista/editar.jsp");
		dispatcher.forward(req, res);
	}
	
	private void editar(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		Alumno alumno = new Alumno(Integer.parseInt(req.getParameter("id")), Integer.parseInt(req.getParameter("ncontrol")), req.getParameter("nombre"), req.getParameter("paterno"), req.getParameter("materno"), req.getParameter("curso"), Integer.parseInt(req.getParameter("semestre")));
		alumnoDAO.actualizar(alumno);
		RequestDispatcher dispatcher= req.getRequestDispatcher("/Vista/mostrar.jsp");
		dispatcher.forward(req, res);
	}
	
	private void eliminar(HttpServletRequest req, HttpServletResponse res) throws SQLException, ServletException, IOException{
		Alumno alumno = alumnoDAO.obtenerID(Integer.parseInt(req.getParameter("id")));
		alumnoDAO.eliminar(alumno);
		RequestDispatcher dispatcher= req.getRequestDispatcher("/Vista/mostrar.jsp");
		dispatcher.forward(req, res);
	}
}
