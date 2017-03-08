import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Servlet extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	
	String nombre = req.getParameter("nombre");
	String curso = req.getParameter("curso");
	String fecha = req.getParameter("fecha");
	
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
	LocalDate localDate = LocalDate.parse(fecha, formatter);
	LocalDate today = LocalDate.now();
	Period p = Period.between(localDate, today);
	
	
	req.setAttribute("fec", p.getYears());
	req.setAttribute("nom", nombre);
	req.setAttribute("cur", curso);
	req.getRequestDispatcher("fin.jsp").forward(req,resp);
	CrearTabla.consultas(null);
	//super.doPost(req, resp);
	redirect(resp);
	
}

private void redirect(HttpServletResponse resp) throws IOException {
	resp.sendRedirect("fin.jsp");
	
}




}

