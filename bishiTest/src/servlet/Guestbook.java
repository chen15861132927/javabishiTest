package servlet;

import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.oreilly.servlet.CacheHttpServlet;
@WebServlet("/Guestbook")
public class Guestbook extends CacheHttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String CONTENT_TYPE = "text/javascript; charset=utf-8";
	  @SuppressWarnings("rawtypes")
	private Vector entries = new Vector();  // User entry list
	  private long lastModified = 0;          // Time last entry was added

	  // Display the current entries, then ask for a new entry
	  public void doGet(HttpServletRequest req, HttpServletResponse res)
	                               throws ServletException, IOException {
        doPost(req, res);
	  }

	  // Add a new entry, then dispatch back to doGet()
	  public void doPost(HttpServletRequest req, HttpServletResponse res)
	                                throws ServletException, IOException {

	    res.setContentType(CONTENT_TYPE);
	    PrintWriter out = res.getWriter();
	    printHeader(out);
	    printForm(out);
	    printMessages(out);
	    printFooter(out);
	  }

	  private void printHeader(PrintWriter out) throws ServletException {
	    out.println("<HTML><HEAD><TITLE>Guestbook</TITLE></HEAD>");
	    out.println("<BODY>");
	  }

	  private void printForm(PrintWriter out) throws ServletException {
	    out.println("<FORM METHOD=POST>");  // posts to itself
	    out.println("<B>Please submit your feedback:</B><BR>");
	    out.println("Your name: <INPUT TYPE=TEXT NAME=name><BR>");
	    out.println("Your email: <INPUT TYPE=TEXT NAME=email><BR>");
	    out.println("Comment: <INPUT TYPE=TEXT SIZE=50 NAME=comment><BR>");
	    out.println("<INPUT TYPE=SUBMIT VALUE=\"Send Feedback\"><BR>");
	    out.println("</FORM>");
	    out.println("<A HREF=\"http://www.servlets.com/soapbox/freecache.html\">");
	    out.println("Back to the article</A>");

	    out.println("<HR>");
	  }

	  @SuppressWarnings("unused")
	private void printMessages(PrintWriter out) throws ServletException {
	    String name, email, comment;
	    int numEntries = 0;

	    @SuppressWarnings("rawtypes")
		Enumeration e = entries.elements();
	    while (e.hasMoreElements()) {
	      numEntries++;
	      GuestbookEntry entry = (GuestbookEntry) e.nextElement();
	      name = entry.name;
	      if (name == null) name = "Unknown user";
	      email = entry.email;
	      if (name == null) email = "Unknown email";
	      comment = entry.comment;
	      if (comment == null) comment = "No comment";
	      out.println("<DL>");
	      out.println("<DT><B>" + name + "</B> (" + email + ") says");
	      out.println("<DD><PRE>" + comment + "</PRE>");
	      out.println("</DL>");

	      // Sleep for 0.2 seconds to simulate a slow data source, max at 5.0 sec
	      if (numEntries * 0.2 <= 5.0) {
	        try { Thread.sleep(200); } catch (InterruptedException ignored) { }
	      }
	    }
	  }

	  private void printFooter(PrintWriter out) throws ServletException {
	    out.println("</BODY>");
	  }

	  @SuppressWarnings({ "unused", "unchecked" })
	private void handleForm(HttpServletRequest req,
	                          HttpServletResponse res) {
	    GuestbookEntry entry = new GuestbookEntry();

	    entry.name = req.getParameter("name");
	    entry.email = req.getParameter("email");
	    entry.comment = req.getParameter("comment");

	    entries.addElement(entry);

	    // Make note we have a new last modified time
	    lastModified = System.currentTimeMillis();
	  }

	  public long getLastModified(HttpServletRequest req) {
	    return lastModified;
	  }
	}

	class GuestbookEntry {
	  public String name;
	  public String email;
	  public String comment;
	}
