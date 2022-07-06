/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import client.CampusClient;
import entity.Admintb;
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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author De
 */
@WebServlet(name = "CampusRestServlet", urlPatterns = {"/CampusRestServlet"})
public class CampusRestServlet extends HttpServlet {

    Response res;
    CampusClient cl;
    Collection<Departmenttb> dept;
    GenericType<Collection<Departmenttb>> deptgeneric;
   
     Collection<Placementcoordinatetb> pcr;
    GenericType<Collection<Placementcoordinatetb>> coordinategeneric;
    
    Collection<Companytb> cm;
    GenericType<Collection<Companytb>> companygeneric;
    
    Collection<Studenttb> st;
    GenericType<Collection<Studenttb>> studentgeneric;
    
    Collection<Notificationtb> nt;
    GenericType<Collection<Notificationtb>> notificationgeneric;
    
    Collection<Jobtb> jb;
    GenericType<Collection<Jobtb>> jobgeneric;
    
    Collection<Placementtypetb> pt;
    GenericType<Collection<Placementtypetb>> placementtypegeneric;
    
    Collection<Certificatetb> cr;
    GenericType<Collection<Certificatetb>> certificategeneric;
    
    Collection<Placementtb> pc;
    GenericType<Collection<Placementtb>> placementgeneric;
    
    Collection<Appliedcompanytb> ac;
    GenericType<Collection<Appliedcompanytb>> appliedcompanygeneric;
    
    Collection<Querytb> qr;
    GenericType<Collection<Querytb>> querygeneric;
    
    Collection<Answertb> an;
    GenericType<Collection<Answertb>> answergeneric;
    
    Collection<Admintb> ad;
    GenericType<Collection<Admintb>> admingeneric;
    
    
//    
//    Collection<Answertb> an;
//    GenericType<Collection<Answertb>> answergeneric;
    
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
            out.println("<title>Servlet CampusRestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            Date date = new Date();
            cl = new CampusClient();
//      
            deptgeneric = new  GenericType<Collection<Departmenttb>>(){};
            res = cl.getAllDepartments(Response.class);
            //res = cl.getDepartmentByName(Response.class, "Msc ICT");
            //cl.addDepartment("B ed");
            //cl.updateDepartment("19","testupdate");        
            out.println("<table border=1");
            out.println("<tr><td colspan=2 align=center>Department Details</td></tr>");
            out.println("<tr><td>Department ID</td>"+"<td>Department Name</td></tr>");
           Collection<Departmenttb> d = res.readEntity(deptgeneric);
           for(Departmenttb dt : d)
            {
                out.println("<tr>");
                out.println("<td>" + dt.getDeptid()+"</td>");
             out.println("<td>" + dt.getDeptName()+"</td>");
             out.println("</tr>");
             
            }
            out.println("</table>");
            out.println("</br>");   
     
             studentgeneric = new GenericType<Collection<Studenttb>>(){};
             //cl.addStudent("jinali", "Malaviya", "jinali09gmail.com", "122338", "Jinali@123", "21-02-2012", "surat", "70.8", "78.9","7.8", "2", "2");
            res = cl.getAllStudents(Response.class);
            //res = cl.getStudentByFirstNamae(Response.class,"Bansari");  
            //res = cl.getStudentByEmail(Response.class, "bansaripethani57701@gmail.com");
            //res =  cl.getStudentByAddress(Response.class,"Sarthana jakatanaka");
            //cl.addStudent("test", "test", "test", "344", "test", "2000-02-02", "test", "test", "test", "test", "4","2");
            cl.updateStudent("12", "jinali", "Malaviya", "jinali09gmail.com", "123333", "Jinali@123", "2000-02-02", "surat", "70.8", "78.9","7.8", "3", "2");
           //cl.updateStudent("9", "test", "test", "test", "344", "test", "2000-02-02", "test", "test", "test", "test", "2","2");
           //cl.removeStudent("10","2","2");
            out.println("<table border=1>");
            out.println("<tr><td colspan=9 align=center>Students List</td></tr>");
            out.println("<tr><td>Student Name</td>"+"<td>Department Name</td><td>Email</td><td>Phone no</td><td>Address</td><td>DOB</td><td>10th Percentage</td>"
                    + "<td>12th Percentage</td><td>Sem Aggregate</td></tr>");
            Collection<Studenttb> student = res.readEntity(studentgeneric);
            for(Studenttb s : student)
            {
                out.println("<tr>");
                out.println("<td>"+s.getFirstname()+" "+s.getLastname()+"</td><td>"+s.getDeptid().getDeptName()+"</td><td>"+s.getEmail()+"</td><td>"+s.getPhoneNo()+
                        "</td><td>"+s.getAddress()+"</td><td>"+s.getDob()+"</td><td>"+s.getPercentage10th()+"</td><td>"+s.getPercentage12th()+"</td><td>"+s.getSemAggregate()+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("<br>");
            
            //===========Company============
            companygeneric = new GenericType<Collection<Companytb>>(){};
            //cl.addCompany("DhiWise","Lal Darwaja","360000","20","57","76","7.0","20-2-22","5","1","2","1");
            
            //cl.removeCompany("14","3","2","2","2");
           //res = cl.getCompanyByName(Response.class, "Lanet");
           //res = cl.getCompanyByLocation(Response.class, "Nanpuara,Surat");
           //res = cl.getCompanyByPackage(Response.class,"300000");
            res = cl.getAllCompanies(Response.class);
            Collection<Companytb> company = res.readEntity(companygeneric);
                        out.println("<table border=1>");
            out.println("<tr><td colspan=11 align=center>Comapny Details</td></tr>");
            out.println("<tr><td>Company Name</td>"+"<td>Location</td><td>Location</td><td>NoOfVacancy</td><td>10th Percentage</td>"
                    + "<td>12th Percentage</td><td>Sem Aggregate</td><td>Passing Date</td><td>Job Role</td>"
                    + "<td>Department Name</td><td>Placement Type</td></tr>");
  
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

            
            notificationgeneric = new GenericType<Collection<Notificationtb>>(){};
            //cl.addNotification("Hy","t5","9","6");
           // cl.updateNotification("7","fgd","fg", "9", "6");
           //cl.removeNotification("7","9","6");
            //res = cl.getNotificationOfCompany(Response.class,"9");
            //res = cl.getNotificationById(Response.class, "9");
            res = cl.getAllNotifications(Response.class);
            Collection<Notificationtb> notification = res.readEntity(notificationgeneric);
            out.println("<table border=1>");
            out.println("<tr><td colspan=4 align=center>Notification Details</td>");
            out.println("<tr><td>Title</td><td>Description</td><td>Student Name</td><td>Company name</td></tr>");
            for(Notificationtb n : notification)
            {
                out.println("<tr><td>"+n.getTitle()+"</td><td>"+n.getDescription()+"</td><td>"+n.getStid().getFirstname()+" "+n.getStid().getLastname()+
                        "</td><td>"+n.getCid().getCName()+"</td></tr>");
            }
            out.println("</table>");
            out.println("</br>");
    
            certificategeneric = new GenericType<Collection<Certificatetb>>(){};
            //cl.addCertificate("test","test","5");
            //cl.updateCertificate("17","update","test","5");
            //res = cl.getCertificatesOfStudents(Response.class, "5");
           // cl.removeCertificate("17","5");
            res = cl.getAllCertificates(Response.class);
           
            Collection<Certificatetb> certificate = res.readEntity(certificategeneric);
            out.println("<table border=1>");
            out.println("<tr><td colspan=4 align=center>Certificates By StudentId</td>");
            out.println("<tr><td>Title</td><td>Image</td><td>Student Name</td></tr>");
            for(Certificatetb c : certificate )
            {
                out.println("<tr><td>"+c.getTitle()+"</td><td>"+c.getImage()+"</td><td>"+c.getStid().getFirstname()+" "+c.getStid().getLastname()+"</td></tr>");
            }
            out.println("</table>");
            out.println("</br>");
            
            
            querygeneric = new GenericType<Collection<Querytb>>(){};
            //cl.addQuery("test", "6");
            cl.updateQuery("7","tested", "6");
            //cl.removeQuery("4","6");
            res = cl.getAllQueries(Response.class);
            Collection<Querytb> query = res.readEntity(querygeneric);
            out.println("<table border=1>");
            out.println("<tr><td colspan=2 align=center>Query</td>");
            out.println("<tr><td>Query</td><td>Student Name</td></tr>");
            for(Querytb q : query)
            {
                out.println("<tr><td>"+q.getQuestion()+"</td><td>"+q.getStid().getFirstname()+" "+q.getStid().getLastname()+"</td></tr>");
            }
             out.println("</table>");
            out.println("</br>");
            
            answergeneric = new GenericType<Collection<Answertb>>(){};
            //cl.addAnswer("test","3");
            //cl.removeAnswer("6","3");
            //cl.removeAnswer("5","2");
            //res = cl.getAnswerOfQuery(Response.class, "3");
            res = cl.getAllAnswers(Response.class);
            Collection<Answertb> answer = res.readEntity(answergeneric);
            out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Answer Details</td>");
            out.println("<tr><td>Query</td><td>Answer</td><td>Student Name</td></tr>");
            for(Answertb a : answer)
            {
                    out.println("<tr><td>"+a.getQid().getQuestion()+"</td><td>"+a.getAnsDesc()+"</td><td>"+a.getQid().getStid().getFirstname());
            }   
            out.println("</table>");
            out.println("</br>");
            
            
           placementgeneric = new GenericType<Collection<Placementtb>>(){};
           //cl.addPlacement("9", "12", "date");
           //cl.removePlacement("5","9","12");
           //cl.updatePlacement("4","6","9","date");
           res = cl.getAllPlacements(Response.class);
           //res = cl.getCompanyOfPlacement(Response.class,"9");
           //res = cl.getStudentsOfPlacement(Response.class, "5");
           Collection<Placementtb> placement = res.readEntity(placementgeneric);
            
            out.println("<table border=1>");
            out.println("<tr><td colspan=4 align=center>Placement Details</td>");
            out.println("<tr><td>Student Name</td><td>Company Name</td><td>Date</td></tr>");
            
            for(Placementtb p : placement)
            {
                out.println("<tr><td>"+p.getStid().getFirstname()+" "+p.getStid().getLastname()+"</td><td>"+p.getCid().getCName()+
                        "</td><td>"+p.getPlacementDate()+"</td></tr>");
            }
            out.println("</table>");
            out.println("</br>");
            
            
            appliedcompanygeneric = new GenericType<Collection<Appliedcompanytb>>(){};
            //cl.addAppliedCompany("12", "10","date");
            //cl.updateAppliedCompany("9", "9", "10", "date");
            //cl.removeAppliedCompany("8", "6","8");
           res = cl.getAllAppliedCompanies(Response.class);
           //res = cl.getCompanyOfPlacement(Response.class,"9");
           //res = cl.getStudentsOfPlacement(Response.class, "5");
           Collection<Appliedcompanytb> appliedcompany = res.readEntity(appliedcompanygeneric);
            
            out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Applied Company Details</td>");
            out.println("<tr><td>Company Name</td><td>Student Name</td><td>Application Date</td></tr>");
            for(Appliedcompanytb a : appliedcompany)
            {
                out.println("<tr><td>"+a.getCid().getCName()+"</td><td>"+a.getStid().getFirstname()+" "+a.getStid().getLastname()+"</td><td>"+a.getApplicationDate()+"</td></tr>");
            }
            out.println("</table>");
            out.println("</br>");
        
           admingeneric = new GenericType<Collection<Admintb>>(){};
          // cl.addAdmin("test","test","test","12344556");
          //cl.updateAdmin("2","testupdate","test","test","12344556");
          //cl.removeAdmin("3");
           res = cl.getAllAdmins(Response.class);
           Collection<Admintb> admin = res.readEntity(admingeneric);
           
            out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Admin Details</td></tr>");
            out.println("<tr><td>Admin Name</td>"+"<td>Admin Email</td><td>PhoneNo</td></tr>");
            for(Admintb a : admin)
            {
                out.println("<tr><td>" + a.getAdminName()+"</td><td>" + a.getEmail()+"</td><td>" + a.getPhoneNo()+"</td></tr>");
            }
            out.println("</table>");
            out.println("<br>");
            
            jobgeneric = new GenericType<Collection<Jobtb>>(){};
            //cl.addJob("test");
            //cl.removeJob("15");
           res = cl.getAllJobs(Response.class);
           Collection<Jobtb> job = res.readEntity(jobgeneric);
            out.println("<table border=1>");
            out.println("<tr><td colspan=3 align=center>Applied Company Details</td>");
            out.println("<tr><td>Job Title</td></tr>");
            for(Jobtb a : job)
            {
                out.println("<tr><td>"+a.getTitle()+"</td></tr>");
            }
            out.println("</table>");
            out.println("</br>");
           
           placementtypegeneric = new GenericType<Collection<Placementtypetb>>(){};
           res = cl.getAllPlacementTypes(Response.class);
           Collection<Placementtypetb> placementtype = res.readEntity(placementtypegeneric);
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
           
            coordinategeneric = new GenericType<Collection<Placementcoordinatetb>>(){};
            //cl.addPlacementCoordinate("test", "test", "test", "213214", "1");
            //cl.updatePlacementCoordinate("2", "testupdate", "test", "test", "213214", "1");
            //cl.removePlacementCoordinate("2","1");
           res = cl.getAllPlacementCoordinates(Response.class);
           Collection<Placementcoordinatetb> coordinate = res.readEntity(coordinategeneric);
            out.println("<table border=1");
            out.println("<tr><td colspan=5 align=center>Placement Coordinator Details</td></tr>");
            out.println("<tr><td>Name</td><td>Email</td><td>Phone No</td><td>Password</td><td>Department Name</td></tr>");
            for(Placementcoordinatetb pc : coordinate)
            {
                out.println("<tr><td>"+pc.getName() + "</td><td>"+pc.getEmail()+"</td><td>"+pc.getPhoneno()+"</td><td>"+pc.getPassword()+
                        "</td><td>"+pc.getDeptid().getDeptName());
            }
            out.println("</table>");
            out.println("</br>");   
           
           
            out.println("<h1>Servlet CampusRestServlet at " + request.getContextPath() + "</h1>");
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
