/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author De
 */
@Local
public interface CoordinatorBeanLocal {
    
     
      //    //===========PlacementCoordinatetb===================
    Collection<Placementcoordinatetb> getAllPlacementCoordinates();
    Collection<Placementcoordinatetb> getPlacementCoordinateByName(String name);
    void updatepassword(Integer pcId,String password);
    Collection<Placementcoordinatetb> getDepartmentOfPlacementCoordinates(Integer did);
    void addPlacementCoordinate(String name,String email,String password,Integer phoneNo,Integer deptId);
    void updatePlacementCoordinate(Integer pcId,String name,String email,String password,Integer phoneNo,Integer deptId);
    void removePlacementCoordinate(Integer pcId,Integer deptId);
    
    //=========Department==========
    Collection<Departmenttb> getAllDepartments();
    void addDepartment(String Dept_Name);
    void updateDepartment(Integer Dept_id, String Dept_Name);
    void removeDepartment(Integer Dept_id);
    Collection<Departmenttb> getDepartmentByName(String deptName);
    
     //===========Studenttb==============
    Collection<Studenttb> getStudentOfDepartment(Integer deptId);   
    Collection<Studenttb> getAllStudents();
    Collection<Studenttb> getAllStudentsByStatus(int sid);
    Collection<Studenttb> getStudentByFirstNamae(String firstname);
    Collection<Studenttb> getStudentByDOB(Date DOB);
    Collection<Studenttb> getStudentByEmail(String email);
    Collection<Studenttb> getStudentByAddress(String address);
    
    //===========Companytb===================
    Collection<Companytb> getAllCompanies();
    Collection<Companytb> getAllCompaniesByStatus(int sid);
    void addCompany(String cName,String Location,Integer salaryPackage,Integer NoofVacancy,String percentage10,String percentage12,String semaggregate,
            Date passingdate,Integer jid,Integer deptid,Integer ptid,Integer sid);
    void updateCompany(Integer cId,String cName,String Location,Integer salaryPackage,Integer NoofVacancy,String percentage10,String percentage12,String semaggregate,
            Date passingdate,Integer jid,Integer deptid,Integer ptid,Integer sid);
    void removeCompany(Integer cId,Integer jid,Integer deptid,Integer ptid,Integer sid);
    Collection<Companytb> getJobOfCompany(Integer jId);
    void updateCompanyStatus(Integer cid,Integer sid);
    
    
     //===========Notificationtb===================
    Collection<Notificationtb> getAllNotifications();
    void addNotification(String title,String description,Integer cId,Integer stId);
    void updateNotification(Integer nId,Integer cId,String title,String description,Integer stId);
    void removeNotification(Integer nId,Integer cId,Integer stId);
    Collection<Notificationtb> getNotificationOfCompany(Integer cId);
    Collection<Notificationtb> getNotificationBytitle(String title);
            
            
    
    //===========Certificate===================
    Collection<Certificatetb> getAllCertificates();
    Collection<Certificatetb> getCertificatesOfStudents(Integer stId);
    
     //=========Query==========   
    Collection<Querytb> getAllQueries();
    
    //==========Answer=======
    Collection<Answertb> getAllAnswers();
    void addAnswer(String answer,Integer qId);
    void updateAnswer(Integer anId,String answer,Integer qId);
    void removeAnswer(Integer anId,Integer qId);
    
    
    // =============JOBtb===========
    Collection<Jobtb> getAllJobs();
    void addJob(String Title);
    void updateJob(Integer jId,String Title);
    void removeJob(Integer jId);
    
    //=========Placementtype==========
    
    Collection<Placementtypetb> getAllPlacementTypes();
    void addPlacementType(String type);
    void updatePlacementType(Integer pId,String type);
    void removePlacementType(Integer pId);
   
    //===========Placementtb===================
    Collection<Placementtb> getAllPlacements();
    Collection<Placementtb> getStudentsOfPlacement(Integer stId);
    Collection<Placementtb> getCompanyOfPlacement(Integer cId);
    void addPlacement(Integer stId,Integer cId,Date placementDate);
    void updatePlacement(Integer pId,Integer stId,Integer cId,Date placementDate);
    void removePlacement(Integer pId,Integer stId,Integer cId);
    
    Collection<Appliedcompanytb> getAllAppliedCompanies();
     Collection<Appliedcompanytb> getStudentsOfAppliedcompany(Integer stId);
    Collection<Appliedcompanytb> getCompanyOfAppliedcompany(Integer cId);

    
    //===================
    
    int countplacements();
    int countnotification();
    int countjob();
    int countdepartment();
    int countcompany();
    int countappliedcompany();
    int countanswer();
    int countAdmin();
    int countplacementcoordinator();
    int countquery();
    int countuser();
    
    
}
