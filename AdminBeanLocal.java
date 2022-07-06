/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Admintb;
import entity.Companytb;
import entity.Placementtb;
import entity.Statustb;
import entity.Studenttb;
import java.util.Collection;
import java.util.Date;
import javax.ejb.Local;

/**
 *
 * @author De
 */
@Local
public interface AdminBeanLocal {
     //=======Admin===========
    Collection<Admintb> getAllAdmins();
    Collection<Admintb> getAdminByName(String name);
    void updateAdminPassword(Integer adminId,String password);
    void addAdmin(String adminName,String email,String password,Integer phoneno);
    void updateAdmin(Integer adminId,String adminName,String email,String password,Integer phoneno);
    void removeAdmin(Integer adminId);
    
    //========Status=============
    
    Collection<Statustb> getAllStatus();
    
     //===========Studenttb==============
    Collection<Studenttb> getStudentOfDepartment(Integer deptId);   
    Collection<Studenttb> getAllStudents();
    Collection<Studenttb> getStudentByFirstNamae(String firstname);
    Collection<Studenttb> getStudentByDOB(Date DOB);
    Collection<Studenttb> getStudentByEmail(String email);
    Collection<Studenttb> getStudentByAddress(String address);
    void updateStudentStatus(Integer stid,Integer sid);
    
    //===========Companytb===================
   Collection<Companytb> getAllCompanies();
      Collection<Companytb> getCompanyByName(String cname);
      Collection<Companytb> getCompanyByLocation(String location);
      Collection<Companytb> getCompanyByPackage(Integer salarypackage);
    
    //===========Placementtb===================
    Collection<Placementtb> getAllPlacements();
    Collection<Placementtb> getStudentsOfPlacement(Integer stId);
    Collection<Placementtb> getCompanyOfPlacement(Integer cId);
}
