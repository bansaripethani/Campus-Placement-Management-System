/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.AdminBeanLocal;
import entity.Admintb;
import entity.Companytb;
import entity.Placementtb;
import entity.Studenttb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author De
 */
@WebServlet(name = "AdminServlet", urlPatterns = {"/AdminServlet"})
public class AdminServlet extends HttpServlet {

    @EJB AdminBeanLocal pbl;
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
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AdminServlet</title>");            
            out.println("</head>");
            out.println("<body>");
           
            pbl.updateStudentStatus(24,1);
           // pbl.updateAdmin(1, "Admin", "admin23@gmail.com","Admin@123", 123456789);
                //pbl.addAdmin("admin13", "asdaf322", "efafa", 1);
            //  pbl.updateAdmin(2, "adminupdate", "sfds", "sf",3124);
            //pbl.removeAdmin(2);
            Collection<Admintb> admins = pbl.getAdminByName("Admin");
            out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Admin Details</td></tr>");
            out.println("<tr><td>Admin Name</td>"+"<td>Admin Email</td><td>PhoneNo</td></tr>");
            for(Admintb a : admins)
            {
                out.println("<tr>");
                out.println("<td> Name : " + a.getAdminName()+"</td>");
                out.println("<td> Email : " + a.getEmail()+"</td>");
                out.println("<td> PhoneNo : " + a.getPhoneNo()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br>");
//            
            out.println("<table border=1>");
            out.println("<tr><td colspan=2 align=center>Student By Department</td></tr>");
            out.println("<tr><td>Student Name</td>"+"<td>Department Name</td></tr>");
            Collection<Studenttb> student = pbl.getStudentOfDepartment(1);
            for(Studenttb s : student)
            {
                out.println("<tr>");
                out.println("<td>"+s.getFirstname()+" "+s.getLastname()+"</td><td>"+s.getDeptid().getDeptName());
                out.println("<tr>");
            }
            out.println("</table>");
            out.println("<br>");
            
            out.println("<table border=1>");
            out.println("<tr><td colspan=2 align=center>Student By Department</td></tr>");
            out.println("<tr><td>Student Name</td>"+"<td>Department Name</td></tr>");
            pbl.updateStudentStatus(7, 1);
            Collection<Studenttb> studentbyaddress = pbl.getStudentByAddress("Sarthana jakatanaka");
            for(Studenttb s : studentbyaddress)
            {
                out.println("<tr>");
                out.println("<td>"+s.getFirstname()+" "+s.getLastname()+"</td><td>"+s.getDeptid().getDeptName());
                out.println("<tr>");
            }
            out.println("</table>");
            out.println("<br>");
            
            out.println("<table border=1>");
            out.println("<tr><td colspan=2 align=center>Student By FirstName</td></tr>");
            out.println("<tr><td>Student Name</td>"+"<td>Department Name</td></tr>");
            Collection<Studenttb> studentbyfirstname = pbl.getStudentByFirstNamae("Riddhi");
            for(Studenttb s : studentbyfirstname)
            {
                out.println("<tr>");
                out.println("<td>"+s.getFirstname()+" "+s.getLastname()+"</td><td>"+s.getDeptid().getDeptName());
                out.println("<tr>");
            }
            out.println("</table>");
            out.println("<br>");
            //out.println("<br>");
            
            out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Student By Email</td></tr>");
            out.println("<tr><td>Student Name</td>"+"<td>Email</td>"+"<td>Department Name</td></tr>");
            Collection<Studenttb> studentbyemail = pbl.getStudentByEmail("jinali09@gmail.com");
            for(Studenttb s : studentbyemail)
            {
                out.println("<tr>");
                out.println("<td>Name: "+s.getFirstname()+" "+s.getLastname()+"</td><td>"+s.getEmail()+"</td><td>"+s.getDeptid().getDeptName());
                out.println("<tr>");
            }
            out.println("</table>");
            out.println("<br>");
             

//            out.println("<table border=1>");
//            out.println("<tr><td colspan=2 align=center>Student By Date Of Birth</td></tr>");
//            out.println("<tr><td>Student Name</td>"+"<td>DOB</td>"+"<td>Department Name</td></tr>");
//            Collection<Studenttb> studentbydob = pbl.getStudentByDOB(20/03/2022);
//            for(Studenttb s : studentbydob)
//            {
//                out.println("<tr>");
//                out.println("<td>Name: "+s.getFirstname()+" "+s.getLastname()+"<td></td>"+s.getDob()+"</td><td>"+s.getEmail()+"</td><td>"+s.getDeptid().getDeptName());
//                out.println("<tr>");
//            }
//               out.println("</table>");
//              out.println("<br>");

         //=======Company==========
            out.println("<table border=1>");
            out.println("<tr><td colspan=11 align=center>Comapny Details</td></tr>");
            out.println("<tr><td>Company Name</td>"+"<td>Location</td><td>Location</td><td>NoOfVacancy</td><td>10th Percentage</td>"
                    + "<td>12th Percentage</td><td>Sem Aggregate</td><td>Passing Date</td><td>Job Role</td>"
                    + "<td>Department Name</td><td>Placement Type</td></tr>");
          Collection<Companytb> company = pbl.getAllCompanies();
          for(Companytb c : company)
          {
              out.println("<tr>");out.println("<td>"+c.getCName()+"</td><td>"+c.getLocation()+"</td><td>"+c.getPackage1()+"</td><td>"+c.getNoOfVacancy()+
                      "</td><td>"+c.getPercentage10th()+"</td><td>"+c.getPercentage12th()+"</td><td>"+c.getSemAggregate()+
                      "</td><td>"+c.getPassingDate()+"</td><td>"+c.getJid().getTitle()+"</td><td>"+c.getDeptid().getDeptName()+
                      "</td><td>"+c.getPtid().getType());
              out.println("</tr>");
          }   
          out.println("</table>");
          out.println("<br>");
//          
//          Collection<Companytb> companybyname = pbl.getCompanyByName("zxy");
//          for(Companytb c : companybyname)
//          {
//              out.println("<tr>");
//out.println("<td>"+c.getCName()+"</td><td>"+c.getLocation()+"</td><td>"+c.getPackage1()+"</td><td>"+c.getNoOfVacancy()+
//                      "</td><td>"+c.getPercentage10th()+"</td><td>"+c.getPercentage12th()+"</td><td>"+c.getSemAggregate()+
//                      "</td><td>"+c.getPassingDate()+"</td><td>"+c.getJid().getTitle()+"</td><td>"+c.getDeptid().getDeptName()+
//                      "</td><td>"+c.getPtid().getType());//              out.println("</tr>");
//          }
        //out.println("</table>");
        
        
//          Collection<Companytb> companybylocation = pbl.getCompanyByLocation("dsfds");    
//          for(Companytb c : companybylocation)
//          {
 //       out.println("<tr>");
 //             out.println("<td>"+c.getCName()+"</td><td>"+c.getLocation()+"</td><td>"+c.getPackage1()+"</td><td>"+c.getNoOfVacancy()+
//                      "</td><td>"+c.getPercentage10th()+"</td><td>"+c.getPercentage12th()+"</td><td>"+c.getSemAggregate()+
//                      "</td><td>"+c.getPassingDate()+"</td><td>"+c.getJid().getTitle()+"</td><td>"+c.getDeptid().getDeptName()+
//                      "</td><td>"+c.getPtid().getType());
//              out.println("</tr>");
//          }
        //out.println("</table>");
        //out.println("<br>");
                  
//        Collection<Companytb> companybypackage = pbl.getCompanyByPackage(98);
//          for(Companytb c : companybypackage)
//          {
//        out.println("<tr>");
//          out.println("<td>"+c.getCName()+"</td><td>"+c.getLocation()+"</td><td>"+c.getPackage1()+"</td><td>"+c.getNoOfVacancy()+
//                      "</td><td>"+c.getPercentage10th()+"</td><td>"+c.getPercentage12th()+"</td><td>"+c.getSemAggregate()+
//                      "</td><td>"+c.getPassingDate()+"</td><td>"+c.getJid().getTitle()+"</td><td>"+c.getDeptid().getDeptName()+
//                      "</td><td>"+c.getPtid().getType());
//              out.println("</tr>");
//          }
        //out.println("</table>");
        //out.println("<br>");
        
            Collection<Placementtb> placement = pbl.getAllPlacements();
            out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Placement Details</td></tr>");
            out.println("<tr><td>Student Name</td>"+"<td>Company Name</td><td>Placement Date</td></tr>");
            for(Placementtb p : placement)
            {
                out.println("<tr>");
                out.println("<td>"+p.getStid().getFirstname()+" "+p.getStid().getLastname()+"</td><td>"+p.getCid().getCName()+
                        "</td><td>"+p.getPlacementDate()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        out.println("<br>");
            
            out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Placement Details By CompanyName</td></tr>");
            out.println("<tr><td>Student Name</td>"+"<td>Company Name</td><td>Placement Date</td></tr>");
            Collection<Placementtb> placementbycompany = pbl.getCompanyOfPlacement(7);
            for(Placementtb p: placementbycompany)
            {
                out.println("<tr>");
                out.println("<td>"+p.getStid().getFirstname()+" "+p.getStid().getLastname()+"</td><td>"+p.getCid().getCName()+
                        "</td><td>"+p.getPlacementDate()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br>");
            
            out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Placement Details By StudentId</td></tr>");
            out.println("<tr><td>Student Name</td>"+"<td>Company Name</td><td>Placement Date</td></tr>");
            Collection<Placementtb> placementbystudent = pbl.getStudentsOfPlacement(6);
            for(Placementtb p: placementbystudent)
            {
                out.println("<tr>");
                out.println("<td>"+p.getStid().getFirstname()+" "+p.getStid().getLastname()+"</td><td>"+p.getCid().getCName()+
                        "</td><td>"+p.getPlacementDate()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br>");
       
            
            out.println("<h1>Servlet AdminServlet at " + request.getContextPath() + "</h1>");
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
