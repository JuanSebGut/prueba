package co.edu.usco.pw;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfileServlet
 */
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		request.getRequestDispatcher("link.html").include(request, response);

		Cookie ck[] = request.getCookies();
		if (ck != null) {
			String nombre = ck[0].getValue();
			if (!nombre.equals("") || nombre != null) {
				out.print("<b>PERFILES</b>");
				out.print("<br>Hola, " + nombre);
			}
		} else {
			out.print("Debe iniciar sesión primero!");
			request.getRequestDispatcher("login.html").include(request, response);
		}
		out.close();
	}

}
