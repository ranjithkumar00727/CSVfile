/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Owner
 */
@WebServlet(urlPatterns = {"/NewServlet2"})
public class NewServlet2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet NewServlet2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align=\"center\"><font color=\"blue\">Application Form</font></h1>\n" +
"<hr>\n" +
" Last Date Of Application 10 FEB 2017\n" +
"<hr>\n" +
"\n" +
"<div bgcolor=\"#f0b48c\">\n" +
"\n" +
"\n" +
"<table cellpadding=\"5\" width=\"50%\" bgcolor=\"#d5d5d4\" align=\"center\" cellspacing=\"4\">\n" +
"<tr>\n" +
"<td colspan=\"2\">\n" +
"<center><font size=\"4\" color=\"white\"><b>Student Application Form</b></font></center>\n" +
"</td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td align=\"right\"><font color=\"white\">Name</font></td>\n" +
"<td><input type=\"text\" name=\"textnames\" size=\"30\"></td>\n" +
"</tr> \n" +
"<tr> <td align=\"right\"><font color=\"white\">Father Name</font></td>\n" +
"<td><input type=\"text\" name=\"fathername\" size=\"30\"></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td align=\"right\"><font color=\"white\">DOB</font></td>\n" +
"<td><input type=\"text\" name=\"dob\" size=\"30\"></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td align=\"right\"><font color=\"white\">Sex</font></td>\n" +
"<td><input type=\"radio\" name=\"sex\" value=\"male\" size=\"10\"><font color=\"white\">Male\n" +
"<input type=\"radio\" name=\"sex\" value=\"Female\" size=\"10\"><font color=\"white\">Female</font></font></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td align=\"right\"><font color=\"white\">EmailId</font></td>\n" +
"<td><input type=\"text\" name=\"emailid\" size=\"30\"></td>\n" +
"</tr> <tr> <td align=\"right\"><font color=\"white\">Course</font></td>\n" +
"<td><select name=\"Course\">\n" +
"<option value=\"-1\" selected>select..</option>\n" +
"<option value=\"B.Tech\">B.TECH</option>\n" +
"<option value=\"B.Tech\">BSC</option>\n" +
"<option value=\"B.Tech\">BCOM</option>\n" +
"<option value=\"B.Tech\">BA</option>\n" +
"<option value=\"MCA\">MCA</option>\n" +
"<option value=\"MBA\">MBA</option>\n" +
"<option value=\"BCA\">BCA</option>\n" +
"</select></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td align=\"right\"><font color=\"white\">Permanent Address</font></td>\n" +
"<td><input type=\"text\" name=\"paddress\" size=\"30\"></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td align=\"right\"><font color=\"white\">City</font></td>\n" +
"<td><select name=\"City\">\n" +
"<option value=\"-1\" selected>select..</option>\n" +
"<option value=\"New Delhi\">NEW DELHI</option>\n" +
"<option value=\"Mumbai\">MUMBAI</option>\n" +
"<option value=\"Goa\">GOA</option>\n" +
"<option value=\"Patna\">PATNA</option>\n" +
"<option value=\"Jaipur\">Jaipur</option>\n" +
"</select></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td align=\"right\"><font color=\"white\">District</font></td>\n" +
"<td><select name=\"District\">\n" +
"<option value=\"-1\" selected>select..</option>\n" +
"<option value=\"Nalanda\">NALANDA</option>\n" +
"<option value=\"UP\">UP</option>\n" +
"<option value=\"Goa\">GOA</option>\n" +
"<option value=\"Patna\">PATNA</option>\n" +
"</select></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td align=\"right\"><font color=\"white\">State</font></td>\n" +
"<td><select name=\"State\">\n" +
"<option value=\"-1\" selected>select..</option>\n" +
"<option value=\"New Delhi\">NEW DELHI</option>\n" +
"<option value=\"Mumbai\">MUMBAI</option>\n" +
"<option value=\"Goa\">GOA</option>\n" +
"<option value=\"Bihar\">BIHAR</option>\n" +
"<option value=\"Rajasthan\">Rajasthan</option>\n" +
"</select></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td align=\"right\"><font color=\"white\">PinCode</font></td>\n" +
"<td><input type=\"text\" name=\"pincode\" size=\"30\"></td>\n" +
"</tr>\n" +
"<tr>\n" +
"<td align=\"right\"><font color=\"white\">MobileNo</font></td>\n" +
"<td><input type=\"text\" name=\"mobileno\" size=\"30\"></td>\n" +
"</tr>\n" +
"<tr>\n" +
"\n" +
"<td align=\"center\" colspan=\"2\"><input type=\"submit\" value=\"Submit\"></td>\n" +
"</tr>\n" +
"</table>\n" +
"<hr><center>\n" +
"© Ranjith Kumar</center>\n" +
"<hr>\n" +
"\n" +
"</div>>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
