/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.CoordinatorBeanLocal;
import entity.Answertb;
import entity.Appliedcompanytb;
import entity.Certificatetb;
import entity.Companytb;
import entity.Departmenttb;
import entity.Jobtb;
import entity.Notificationtb;
import entity.Placementcoordinatetb;
import entity.Placementtb;
import entity.Placementtypetb;
import entity.Querytb;
import entity.Studenttb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author De
 */
@WebServlet(name = "CoordinateServlet", urlPatterns = {"/CoordinateServlet"})
public class CoordinateServlet extends HttpServlet {

     //Pbkdf2PasswordHashImpl pb;
     @EJB CoordinatorBeanLocal pbl;
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
            out.println("<title>Servlet CoordinateServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
           // out.println("Hash = " + pb.generate("coordinator".toCharArray()) + "");
            //pbl.updateCompanyStatus(15, 1);
            Date date = new Date();
            //java.util.Date date = new java.util.Date();    
            
            //pbl.addPlacementCoordinate("abc","abc@gmail.com","abc@134",11221423,2);
            //pbl.updatePlacementCoordinate(1,"abcupdated","abc@gmail.com","abc@134",11221423,2);
            //pbl.removePlacementCoordinate(2,2);
            
           //pbl.addPlacement(6, 9, date);
//            out.println("<table border=1");
//            out.println("<tr><td colspan=5 align=center>Placement Coordinator Details</td></tr>");
//            out.println("<tr><td>Name</td><td>Email</td><td>Phone No</td><td>Password</td><td>Department Name</td></tr>");
//            Collection<Placementcoordinatetb> coordinate = pbl.getAllPlacementCoordinates();
//            for(Placementcoordinatetb pc : coordinate)
//            {
//                out.println("<tr><td>"+pc.getName() + "</td><td>"+pc.getEmail()+"</td><td>"+pc.getPhoneno()+"</td><td>"+pc.getPassword()+
//                        "</td><td>"+pc.getDeptid().getDeptName());
//            }
//            out.println("</table>");
//            out.println("</br>");    
//          
//            Collection<Departmenttb> departments = pbl.getAllDepartments();
//            out.println("<table border=1");
//            out.println("<tr><td colspan=2 align=center>Department Details</td></tr>");
//            out.println("<tr><td>Department ID</td>"+"<td>Department Name</td></tr>");
//            for(Departmenttb c : departments)
//            {
//                out.println("<tr>");
//                out.println("<td>" + c.getDeptid()+"</td>");
//             out.println("<td>" + c.getDeptName()+"</td>");
//             out.println("</tr>");
//             
//            }
//            out.println("</table>");
//            out.println("</br>");
//            
//              Collection<Departmenttb> departmentbyname =pbl.getDepartmentByName("Msc ICT");
//            out.println("<table border=1");
//            out.println("<tr><td colspan=2 align=center>Department By Name</td></tr>");
//            out.println("<tr><td>Department ID</td>"+"<td>Department Name</td></tr>");
//            for(Departmenttb c : departmentbyname)
//            {
//                out.println("<tr>");
//                out.println("<td>" + c.getDeptid()+"</td>");
//             out.println("<td>" + c.getDeptName()+"</td>");
//             out.println("</tr>");
//             
//            }
//            out.println("</table>");
//            out.println("</br>");
//            
//            out.println("<table border=1>");
//            out.println("<tr><td colspan=2 align=center>Student By DepartmentName</td></tr>");
//            out.println("<tr><td>Student Name</td>"+"<td>Department Name</td></tr>");
//            Collection<Studenttb> student = pbl.getStudentOfDepartment(1);
//            for(Studenttb s : student)
//            {
//                out.println("<tr>");
//                out.println("<td>"+s.getFirstname()+" "+s.getLastname()+"</td><td>"+s.getDeptid().getDeptName());
//                out.println("<tr>");
//            }
//            out.println("</table>");
//            out.println("<br>");
//            
//            out.println("<table border=1>");
//            out.println("<tr><td colspan=2 align=center>Student By Address</td></tr>");
//            out.println("<tr><td>Student Name</td>"+"<td>Department Name</td></tr>");
//            Collection<Studenttb> studentbyaddress = pbl.getStudentByAddress("Sarthana jakatanaka");
//            for(Studenttb s : studentbyaddress)
//            {
//                out.println("<tr>");
//                out.println("<td>"+s.getFirstname()+" "+s.getLastname()+"</td><td>"+s.getDeptid().getDeptName());
//                out.println("<tr>");
//            }
//            out.println("</table>");
//            out.println("<br>");
//            
//            out.println("<table border=1>");
//            out.println("<tr><td colspan=2 align=center>Student By FirstName</td></tr>");
//            out.println("<tr><td>Student Name</td>"+"<td>Department Name</td></tr>");
//            Collection<Studenttb> studentbyfirstname = pbl.getStudentByFirstNamae("Riddhi");
//            for(Studenttb s : studentbyfirstname)
//            {
//                out.println("<tr>");
//                out.println("<td>"+s.getFirstname()+" "+s.getLastname()+"</td><td>"+s.getDeptid().getDeptName());
//                out.println("<tr>");
//            }
//            out.println("</table>");
//            out.println("<br>");
//            //out.println("<br>");
//            
//            out.println("<table border=1>");
//            out.println("<tr><td colspan=3 align=center>Student By Email</td></tr>");
//            out.println("<tr><td>Student Name</td>"+"<td>Email</td>"+"<td>Department Name</td></tr>");
//            Collection<Studenttb> studentbyemail = pbl.getStudentByEmail("jinali09@gmail.com");
//            for(Studenttb s : studentbyemail)
//            {
//                out.println("<tr>");
//                out.println("<td>Name: "+s.getFirstname()+" "+s.getLastname()+"</td><td>"+s.getEmail()+"</td><td>"+s.getDeptid().getDeptName());
//                out.println("<tr>");
//            }
//            out.println("</table>");
//            out.println("<br>");
//             
//
////            out.println("<table border=1>");
////            out.println("<tr><td colspan=2 align=center>Student By Date Of Birth</td></tr>");
////            out.println("<tr><td>Student Name</td>"+"<td>DOB</td>"+"<td>Department Name</td></tr>");
////            Collection<Studenttb> studentbydob = pbl.getStudentByDOB(20/03/2022);
////            for(Studenttb s : studentbydob)
////            {
////                out.println("<tr>");
////                out.println("<td>Name: "+s.getFirstname()+" "+s.getLastname()+"<td></td>"+s.getDob()+"</td><td>"+s.getEmail()+"</td><td>"+s.getDeptid().getDeptName());
////                out.println("<tr>");
////            }
////               out.println("</table>");
////              out.println("<br>");
//
////            
//
//            out.println("<table border=1>");
//            out.println("<tr><td colspan=3 align=center>Certificate Details</td>");
//            out.println("<tr><td>Title</td><td>Image</td><td>Student Name</td></tr>");
//            
//            Collection<Certificatetb> certificate = pbl.getAllCertificates();
//            for(Certificatetb c : certificate)
//            {
//                out.println("<tr><td>"+c.getTitle()+"</td><td>"+c.getImage() + "</td><td>"+ c.getStid().getFirstname()+"</td></tr>");
//            }
//            out.println("</table>");
//            out.println("</br>");
//            
//            out.println("<table border=1>");
//            out.println("<tr><td colspan=3 align=center>Certificate By StudentID</td>");
//            out.println("<tr><td>Title</td><td>Image</td><td>Student Name</td></tr>");
//            
//            Collection<Certificatetb> certificateofstudent = pbl.getCertificatesOfStudents(5);
//            for(Certificatetb c : certificateofstudent)
//            {
//                 out.println("<tr><td>"+c.getTitle()+"</td><td>"+c.getImage() + "</td><td>"+ c.getStid().getFirstname()+"</td></tr>");
//            }
//            out.println("</table>");
//            out.println("</br>");
//            
//            
//            out.println("<table border=1>");
//            out.println("<tr><td colspan=2 align=center>Query Details</td>");
//            out.println("<tr><td>Question</td><td>Student Name</td></tr>");             
//            Collection<Querytb> query = pbl.getAllQueries();
//            for(Querytb q : query)
//            {
//                out.println("<tr><td>"+q.getQuestion()+"</td><td>"+q.getStid().getFirstname()+"</td></tr>");
//            }   
//             out.println("</table>");
//            out.println("</br>");
//            
//            //pbl.addAnswer("No", 1);
//            //pbl.updateAnswer(1, "Yes", 1);
//            //pbl.removeAnswer(8,2);
//            
//             out.println("<table border=1>");
//            out.println("<tr><td colspan=3 align=center>Answer Details</td>");
//            out.println("<tr><td>Query</td><td>Answer</td><td>Student Name</td></tr>");
//            Collection<Answertb> answer = pbl.getAllAnswers();
//            for(Answertb a : answer)
//            {
//                    out.println("<tr><td>"+a.getQid().getQuestion()+"</td><td>"+a.getAnsDesc()+"</td><td>"+a.getQid().getStid().getFirstname());
//            }   
//            out.println("</table>");
//            out.println("</br>");
//                
            //pbl.addCompany("DhiWise","Lal Darwaja",360000,20,"57","76","7.0",date,5,1,2,1);
           // pbl.updateCompany(7,"DhiWise","Lal Darwaja",360000,20,"57","76","7.0",date,5,1,2,1);
           //pbl.removeCompany(13,7,2,2,2);
             out.println("<table border=1>");
            out.println("<tr><td colspan=11 align=center>Comapny Details</td></tr>");
            out.println("<tr><td>Company Name</td>"+"<td>Location</td><td>Location</td><td>NoOfVacancy</td><td>10th Percentage</td>"
                    + "<td>12th Percentage</td><td>Sem Aggregate</td><td>Passing Date</td><td>Job Role</td>"
                    + "<td>Department Name</td><td>Placement Type</td></tr>");
            
            Collection<Companytb> company = pbl.getAllCompaniesByStatus(1);
            for(Companytb c : company)
            {
                out.println("<tr>");out.println("<td>"+c.getCName()+"</td><td>"+c.getLocation()+"</td><td>"+c.getPackage1()+"</td><td>"+c.getNoOfVacancy()+
                      "</td><td>"+c.getPercentage10th()+"</td><td>"+c.getPercentage12th()+"</td><td>"+c.getSemAggregate()+
                      "</td><td>"+c.getPassingDate()+"</td><td>"+c.getJid().getTitle()+"</td><td>"+c.getDeptid().getDeptName()+
                      "</td><td>"+c.getPtid().getType());
              out.println("</tr>");
            }
            out.println("</table>");
            out.println("</br>");
            
            Collection<Certificatetb> certificates = pbl.getAllCertificates();
            out.println("<table border=1>");
            out.println("<tr><td colspan=4 align=center>Certificate Details</td>");
            out.println("<tr><td>Title</td><td>Image</td><td>Student Name</td></tr>");
            for(Certificatetb c : certificates )
            {
                out.println("<tr><td>"+c.getTitle()+"</td><td>"+c.getImage()+"</td><td>"+c.getStid().getFirstname()+" "+c.getStid().getLastname()+"</td></tr>");
            }
            out.println("</table>");
            out.println("</br>");
            
            
            //pbl.addNotification("hello","hy",2,4);
            //pbl.updateNotification(3, 2, "wf", "dsupdate", 4);
            //pbl.removeNotification(2,2,4);
            out.println("<table border=1>");
            out.println("<tr><td colspan=4 align=center>Notification Details</td>");
            out.println("<tr><td>Title</td><td>Description</td><td>Student Name</td><td>Company name</td></tr>");

            Collection<Notificationtb> notification = pbl.getAllNotifications();
            for(Notificationtb n : notification)
            {
                out.println("<tr><td>"+n.getTitle()+"</td><td>"+n.getDescription()+"</td><td>"+n.getStid().getFirstname()+" "+n.getStid().getLastname()+
                        "</td><td>"+n.getCid().getCName()+"</td></tr>");
            }
            out.println("</table>");
            out.println("</br>");

            
           // pbl.addPlacement(14, 11, date);
            //pbl.updatePlacement(4, 6,10, date);
            //pbl.removePlacement(6,6,9);
            
            out.println("<table border=1>");
            out.println("<tr><td colspan=4 align=center>Placement Details</td>");
            out.println("<tr><td>Student Name</td><td>Company Name</td><td>Date</td></tr>");
            
            Collection<Placementtb> placement = pbl.getAllPlacements();
            for(Placementtb p : placement)
            {
                out.println("<tr><td>"+p.getStid().getFirstname()+" "+p.getStid().getLastname()+"</td><td>"+p.getCid().getCName()+
                        "</td><td>"+p.getPlacementDate()+"</td></tr>");
            }
            out.println("</table>");
            out.println("</br>");
            
            
             out.println("<table border=1>");
            out.println("<tr><td colspan=4 align=center>Placement By Company</td>");
            out.println("<tr><td>Student Name</td><td>Company Name</td><td>Date</td></tr>");
            Collection<Placementtb> placementbycompany = pbl.getCompanyOfPlacement(9);
            for(Placementtb p : placementbycompany)
            {
                out.println("<tr><td>"+p.getStid().getFirstname()+" "+p.getStid().getLastname()+"</td><td>"+p.getCid().getCName()+
                        "</td><td>"+p.getPlacementDate()+"</td></tr>");
      
            }
            out.println("</table>");
            out.println("</br>");
            
             out.println("<table border=1>");
            out.println("<tr><td colspan=4 align=center>Placement By Student</td>");
            out.println("<tr><td>Student Name</td><td>Company Name</td><td>Date</td></tr>");
            Collection<Placementtb> placementbystudent = pbl.getStudentsOfPlacement(9);
            for(Placementtb p : placementbystudent)
            {
            out.println("<tr><td>"+p.getStid().getFirstname()+" "+p.getStid().getLastname()+"</td><td>"+p.getCid().getCName()+
                        "</td><td>"+p.getPlacementDate()+"</td></tr>");
            
            }
            out.println("</table>");
            out.println("</br>");
            
            Collection<Appliedcompanytb> appliedcompany = pbl.getAllAppliedCompanies();
            
            out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Applied Company Details</td>");
            out.println("<tr><td>Company Name</td><td>Student Name</td><td>Application Date</td></tr>");
            for(Appliedcompanytb a : appliedcompany)
            {
                out.println("<tr><td>"+a.getCid().getCName()+"</td><td>"+a.getStid().getFirstname()+" "+a.getStid().getLastname()+"</td><td>"+a.getApplicationDate()+"</td></tr>");
            }
            out.println("</table>");
            out.println("</br>");
            
            
            Collection<Placementtypetb> placementtype = pbl.getAllPlacementTypes();
            //pbl.addPlacementType("test");
            //pbl.updatePlacementType(4,"testupdate");
            //pbl.removePlacementType(4);
            out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Placement type Details</td>");
            out.println("<tr><td>Placement Type</td></tr>");
            for(Placementtypetb a : placementtype)
            {
                out.println("<tr><td>"+a.getType()+"</td></tr>");
            }
            out.println("</table>");
            out.println("</br>");
            
            
            Collection<Jobtb> job = pbl.getAllJobs();
            
            out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Applied Company Details</td>");
            out.println("<tr><td>Job Title</td></tr>");
            //pbl.addJob("test");
            //pbl.updateJob(16,"testupdate");
            //pbl.removeJob(16);
            for(Jobtb a : job)
            {
                out.println("<tr><td>"+a.getTitle()+"</td></tr>");
            }
            out.println("</table>");
            out.println("</br>");
            
            out.println("<h1>Servlet CoordinateServlet at " + request.getContextPath() + "</h1>");
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
