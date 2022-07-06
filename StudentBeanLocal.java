/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import entity.Answertb;
import entity.Appliedcompanytb;
import entity.Certificatetb;
import entity.Companytb;
import entity.Notificationtb;
import entity.Querytb;
import entity.Studenttb;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author De
 */
@Local
public interface StudentBeanLocal {
 
    void adduser(String username,String password);

    int studnetbyid(String firstname);
    Collection<Studenttb> getStudentById(int stid); 
//    
   void insertStudent(String FirstName,String LastName,String Email,Integer Phoneno,String Password,Date DOB,String Address,
            String Percentage10, String Percentage12,String Sem,String Profilepic,Integer Dept_id,Integer S_id);
    void editStudent(Integer St_id,String FirstName,String LastName,String Email,Integer Phoneno,String Password,Date DOB,String Address,
            String Percentage10, String Percentage12,String Sem,String Profilepic,Integer Dept_id,Integer S_id);
   //void insertStudent(String Profilepic,Integer Dept_id,Integer S_id);
    int countstudent();
     Collection<Studenttb> getStudentByName(String firstname); 
    void addStudent(String FirstName,String LastName,String Email,Integer Phoneno,String Password,Date DOB,String Address,
            String Percentage10, String Percentage12,String Sem,Integer Dept_id,Integer S_id);
    void updateStudent(Integer St_id,String FirstName,String LastName,String Email,Integer Phoneno,String Password,Date DOB,String Address,
            String Percentage10, String Percentage12,String Sem,Integer Dept_id,Integer S_id);
    void removeStudent(Integer St_id,Integer Dept_id,Integer S_id);
     //Collection<Studenttb> countstudent();
    
    //    //===========Certificatetb===================
     Collection<Certificatetb> getAllCertificates();
    void addCertificate(String title,String image,Integer stId);
    void updateCertificate(Integer crId,String title,String image,Integer stId);
    void removeCertificate(Integer crId,Integer stId);
     Collection<Certificatetb> getCertificateByStudentName(Integer stId);
    
    //    //===========Notificationtb===================
        Collection<Notificationtb> getNotificationById(Integer stId);
  
   //=============Company=============
      Collection<Companytb> getAllCompanies();
      Collection<Companytb> getAllByStatus(int sid);
      Collection<Companytb> getCompanyByName(String cname);
      Collection<Companytb> getCompanyByLocation(String location);
      Collection<Companytb> getCompanyByPackage(Integer salarypackage);
      
    //===========Querytb===================
    
    Collection<Querytb> getQueriesOfStudent(Integer stId);
    Collection<Querytb> getQueriesByStudentNames(Collection<String> firstnames);
    void addQuery(String question,Integer stId);
    void updateQuery(Integer qId,String question,Integer stId);
    void removeQuery(Integer qId,Integer stId);
      
    
    Collection<Answertb> getAnswerOfQuery(Integer qId);
    
   Collection<Notificationtb> getNotificationsOfCompany(Integer cId);
   
//===========AppliedCompanytb===================
    
    Collection<Appliedcompanytb> getStudentsAppliedCompanies(Integer stId);
    void addAppliedCompany(Integer stId,Integer cId,Date applicationDate);
    void updateAppliedCompany(Integer acId,Integer stId,Integer cId,Date applicationDate);
    void removeAppliedCompany(Integer acId,Integer stId,Integer cId);
    
       
}
