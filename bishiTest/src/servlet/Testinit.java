package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.spi.DirStateFactory.Result;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Testinit
 */
@WebServlet("/Testinit")
public class Testinit extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/html; charset=utf-8"; 
	 byte[] header;
     byte[] navbar;
     byte[] footer;
     byte[] otherStaticData;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Testinit() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init(ServletConfig config) throws ServletException{
    	//create all the static data here
    	StringBuffer sb = new StringBuffer(); // better to initialize the StringBuffer with some size to improve performance
    	sb.append("<html>");
    	sb.append("<head><title>Hello world</title></head>");
    	sb.append("<body>");
    	header = sb.toString().getBytes();
    	// do same for navbar if its data is static
    	sb.delete(0,sb.length());
    	sb.append("hi 孙忠莹");
    	navbar= sb.toString().getBytes();
    	// do same for footer if its data is static
    	sb.delete(0,sb.length()); // better to initialize the StringBuffer with some size to improve performance
    	sb.append("</body>");
		sb.append("</html>");
		footer= sb.toString().getBytes();
    	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType(CONTENT_TYPE); 
		/*PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>HELLO WORLD</title></head>");
		out.print("<body>");
		out.print("hi ,孙忠莹");
		// send the dynamic data here
		out.print("</body>");
		out.print("</html>");
		*/
		response.setContentType("text/html");
		ServletOutputStream out = response.getOutputStream();
		out.write(header);
		out.write(navbar);                               
		// write dynamic data here
		out.write(footer);
	}

}
