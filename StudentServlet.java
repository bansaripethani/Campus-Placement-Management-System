/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.CoordinatorBeanLocal;
import ejb.StudentBeanLocal;
import entity.Answertb;
import entity.Appliedcompanytb;
import entity.Certificatetb;
import entity.Companytb;
import entity.Notificationtb;
import entity.Querytb;
import entity.Studenttb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author De
 */
@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

      @EJB StudentBeanLocal pbl;
      
      @PersistenceContext(unitName="FinalAppPU")
    EntityManager em;
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
            out.println("<title>Servlet StudentServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
                        java.util.Date date = new java.util.Date();
                        
                  //   int maxResults = pbl.studnetbyid("Bansari");
                    // System.out.println(maxResults);
                     
                     //pbl.insertStudent("test", "test", "test", 123, "test", date, "test", "1", "1", "1", "image", 1, 2);
                     //   pbl.studnetbyid("Bansari");
            //int maxResults = pbl.countstudent();
            //int maxResults = pbl.studnetbyid("Sweta");
                    
           // System.out.println(maxResults);
                        
                     //pbl.countstudent();
              //  pbl.updateStudent(15, "tulsee", "patel", "tulsee12@gmail.com", 1234567, "tulsee", date, "surat", "78.90", "80.90", "5.6", 1, 2);
            //System.out.println(date);   java.util.Date
           // pbl.addAppliedCompany(5,7, date);
           // pbl.adduser("meera","meera");
//pbl.addStudent("reema", "Narayan", "Rema12@gmail.com", 123456789, "Reema@123", date, "Surat","70.8", "78.9","7.8", 2, 2);
//pbl.addStudent("jinali", "Malaviya", "jinali09gmail.com", 122338, "Jinali@123", date, "surat", "70.8", "78.9","7.8", 2, 2);
//pbl.updateStudent(12, "jinali", "Malaviya", "jinali09gmail.com", 122338, "Jinali@123", date, "surat", "70.8", "78.9","7.8", 4, 2);
    
            out.println("<table border=1>");
            out.println("<tr><td colspan=8 align=center>Student By Name</td>");
            out.println("<tr><td>Student Name</td>"+"<td>Email</td>"+"<td>Adress</td>"+"<td>DOB</td>"+
                    "<td>10th Percentage</td>"+"<td>12th Percenatage</td>"+"<td>Sem Aggregate</td>"+"<td>Department Name</td></tr>");
            Collection<Studenttb> students = pbl.getStudentByName("Bansari");
            for(Studenttb s : students)
            {
                
                out.println("<tr><td>"+ s.getFirstname()+" "+s.getLastname()+"</td><td>"+s.getEmail()+"</td><td>"+s.getAddress()+
                        "</td><td>"+s.getDob()+"</td><td>"+s.getPercentage10th()+"</td><td>"+s.getPercentage12th()+"</td><td>"+s.getSemAggregate()+
                        "</td><td>"+s.getDeptid().getDeptName()+"</td></tr>");
            }
          out.println("</table>");
          out.println("<br>");
            //pbl.addCertificate("abc", "fdfsd",3);
            //pbl.updateCertificate(1,"update", "update", 3);
             //pbl.removeStudent(3, 2, 2);
             
           out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Certificate Details</td>");
            out.println("<tr><td>Title</td><td>Image</td><td>Student Name</td></tr>");

          Collection<Certificatetb> certificates = pbl.getCertificateByStudentName(5);
                   
             for(Certificatetb cr : certificates)
             {
                  out.println("<tr><td>"+cr.getTitle()+"</td><td>"+cr.getImage() + "</td><td>"+ cr.getStid().getFirstname()+"</td></tr>");
             }
             out.println("</table>");
             out.println("<br>");
          
           //==========Notification==============
           out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Notification Details</td>");
            out.println("<tr><td>Company Name</td><td>Title</td><td>Description</td></tr>");
          Collection<Notificationtb> notification = pbl.getNotificationById(5);
          for(Notificationtb n : notification)
          {
              out.println("<tr><td>"+n.getCid().getCName() + "</td><td>"+n.getTitle() + "</td><td>"+n.getDescription()+"</td></tr>");
          }
          out.println("</table>");
          out.println("<br>");
          
            
          //=======Company===========
           out.println("<table border=1>");
            out.println("<tr><td colspan=11 align=center>Comapny Details</td></tr>");
            out.println("<tr><td>Company Name</td>"+"<td>Location</td><td>Location</td><td>NoOfVacancy</td><td>10th Percentage</td>"
                    + "<td>12th Percentage</td><td>Sem Aggregate</td><td>Passing Date</td><td>Job Role</td>"
                    + "<td>Department Name</td><td>Placement Type</td></tr>");
          Collection<Companytb> company = pbl.getAllByStatus(1);
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
//    out.println("<tr>");out.println("<td>"+c.getCName()+"</td><td>"+c.getLocation()+"</td><td>"+c.getPackage1()+"</td><td>"+c.getNoOfVacancy()+
//                      "</td><td>"+c.getPercentage10th()+"</td><td>"+c.getPercentage12th()+"</td><td>"+c.getSemAggregate()+
//                      "</td><td>"+c.getPassingDate()+"</td><td>"+c.getJid().getTitle()+"</td><td>"+c.getDeptid().getDeptName()+
//                      "</td><td>"+c.getPtid().getType());
//              out.println("</tr>");
//          }   
//          out.println("</table>");
//          out.println("<br>");

//          Collection<Companytb> companybylocation = pbl.getCompanyByLocation("dsfds");    
//          for(Companytb c : companybylocation)
//          {
//    out.println("<tr>");out.println("<td>"+c.getCName()+"</td><td>"+c.getLocation()+"</td><td>"+c.getPackage1()+"</td><td>"+c.getNoOfVacancy()+
//                      "</td><td>"+c.getPercentage10th()+"</td><td>"+c.getPercentage12th()+"</td><td>"+c.getSemAggregate()+
//                      "</td><td>"+c.getPassingDate()+"</td><td>"+c.getJid().getTitle()+"</td><td>"+c.getDeptid().getDeptName()+
//                      "</td><td>"+c.getPtid().getType());
//              out.println("</tr>");
//          }   
//          out.println("</table>");
//          out.println("<br>");          

//        Collection<Companytb> companybypackage = pbl.getCompanyByPackage(98);
//          for(Companytb c : companybypackage)
//          {
//    out.println("<tr>");out.println("<td>"+c.getCName()+"</td><td>"+c.getLocation()+"</td><td>"+c.getPackage1()+"</td><td>"+c.getNoOfVacancy()+
//                      "</td><td>"+c.getPercentage10th()+"</td><td>"+c.getPercentage12th()+"</td><td>"+c.getSemAggregate()+
//                      "</td><td>"+c.getPassingDate()+"</td><td>"+c.getJid().getTitle()+"</td><td>"+c.getDeptid().getDeptName()+
//                      "</td><td>"+c.getPtid().getType());
//              out.println("</tr>");
//          }   
//          out.println("</table>");
//          out.println("<br>");

//            pbl.addQuery("Is there any bond sign?", 4);
//            pbl.updateQuery(1,"Is there any bond sign?updated",4);
             //pbl.removeQuery(2, 4);
             
            out.println("<table border=1>");
            out.println("<tr><td colspan=2 align=center>Query Details</td>");
            out.println("<tr><td>Question</td><td>Student Name</td></tr>");             
            Collection<Querytb> query = pbl.getQueriesOfStudent(5);
            for(Querytb q : query)
            {
                out.println("<tr><td>"+q.getQuestion()+"</td><td>"+q.getStid().getFirstname()+"</td></tr>");
            }
            out.println("</table>");
          out.println("<br>");
          
            out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Answer Details</td>");
            out.println("<tr><td>Query</td><td>Answer</td><td>Student Name</td></tr>");
            Collection<Answertb> answer = pbl.getAnswerOfQuery(2);
            for(Answertb a : answer)
            {
                out.println("<tr><td>"+a.getQid().getQuestion()+"</td><td>"+a.getAnsDesc()+"</td><td>"+a.getQid().getStid().getFirstname());
            }
            out.println("</table>");
          out.println("<br>");
             
           // pbl.addAppliedCompany(4, 1, date);
            //pbl.updateAppliedCompany(2,4,1, date);
            //pbl.removeAppliedCompany(2,4,1);
            
            out.println("<table border=1>");
            out.println("<tr><td colspan=2 align=center>Applied Company Details</td>");
            out.println("<tr><td>Company Name</td><td>Application Date</td></tr>");

            Collection<Appliedcompanytb> appliedcompanybystudent = pbl.getStudentsAppliedCompanies(5);
            for(Appliedcompanytb a : appliedcompanybystudent)
            {
                out.println("<tr><td>"+a.getCid().getCName()+"</td><td>"+a.getApplicationDate()+"</td></tr>");
            }
            out.println("</table>");
          out.println("<br>");

            
            out.println("<h1>Servlet StudentServlet at " + request.getContextPath() + "</h1>");
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
