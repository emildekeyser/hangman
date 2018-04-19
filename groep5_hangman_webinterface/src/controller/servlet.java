package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.WoordSchrijver;
import db.WoordenLezer;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/servlet")
public class servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private WoordenLezer lezer;
	private ArrayList<String> woordenLijst;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	@SuppressWarnings("unchecked")
	public servlet() {
		super();
		this.lezer = new WoordenLezer("../groep5_hangman_app/hangman.txt");
		this.woordenLijst = (ArrayList<String>) this.lezer.lees().woordenLijst.clone();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");
		String destination = "index.jsp";

		switch (command) {
		case "woordenlijst":
			destination = serveWoordenlijst(request, response);
			break;
		case "download":
			String filename = "woorden.txt";
			response.setContentType("APPLICATION/OCTET-STREAM");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
			PrintWriter out = response.getWriter();
			for (int i = 0; i < this.woordenLijst.size(); i++) {
				out.println(this.woordenLijst.get(i));
			}
			out.close();
			break;
		case "stats":
			destination = serveStats(request, response);
			break;
		default:
			break;
		}

		request.getRequestDispatcher(destination).forward(request, response);

	}

	private String serveStats(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("aantalwoorden", this.woordenLijst.size());
		return "index.jsp";

	}

	private String serveWoordenlijst(HttpServletRequest request, HttpServletResponse response) {

		request.setAttribute("woordenlijst", this.woordenLijst);
		return "woorden.jsp";
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nieWoord = request.getParameter("niewwoord");
		
		new WoordSchrijver().schrijf(nieWoord);
	}

}
