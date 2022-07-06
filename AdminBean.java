/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Admintb;
import entity.Companytb;
import entity.Departmenttb;
import entity.Placementtb;
import entity.Statustb;
import entity.Studenttb;
import java.util.Collection;
import java.util.Date;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author De
 */
@DeclareRoles({"Admin","Coordinator","Student"})
@Stateless
public class AdminBean implements AdminBeanLocal {

    Pbkdf2PasswordHashImpl pb;
    @PersistenceContext(unitName="FinalAppPU")
    EntityManager em;
    
    @RolesAllowed("Admin")
    @Override
    public Collection<Admintb> getAllAdmins() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("Admintb.findAll").getResultList();

    }
    
@RolesAllowed("Admin")
    @Override
    public void addAdmin(String adminName, String email, String password, Integer phoneno) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     pb = new Pbkdf2PasswordHashImpl();
       String hashpass =  pb.generate(password.toCharArray());
      Admintb c = new Admintb(adminName,email,hashpass,phoneno);
        em.persist(c);
    }

    @Override
    public void updateAdmin(Integer adminId, String adminName, String email, String password, Integer phoneno) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      pb = new Pbkdf2PasswordHashImpl();
       String hashpass =  pb.generate(password.toCharArray());
        Admintb a = (Admintb) em.find(Admintb.class, adminId);
        a.setAdminName(adminName);
        a.setEmail(email);
        a.setPassword(hashpass);
        a.setPhoneNo(phoneno);
     
        em.merge(a);
    }

    @Override
    public void removeAdmin(Integer adminId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Admintb a = (Admintb) em.find(Admintb.class, adminId);
    em.remove(a);
    }

    @Override
    public Collection<Studenttb> getStudentOfDepartment(Integer deptId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Departmenttb c = em.find(Departmenttb.class, deptId);
   
       return c.getStudenttbCollection();
    }

    @Override
    public Collection<Studenttb> getAllStudents() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      return em.createNamedQuery("Studenttb.findAll").getResultList();
    }

    @Override
    public Collection<Studenttb> getStudentByFirstNamae(String firstname) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Collection<Studenttb> students = em.createNamedQuery("Studenttb.findByFirstname")
             .setParameter("firstname", firstname)
             .getResultList();
     
     return students;
 
    }

    @Override
    public Collection<Studenttb> getStudentByDOB(Date DOB) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Collection<Studenttb> students = em.createNamedQuery("Studenttb.findByDob")
             .setParameter("dob", DOB)
             .getResultList();
     
     return students;
    }

    @Override
    public Collection<Studenttb> getStudentByEmail(String email) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Collection<Studenttb> students = em.createNamedQuery("Studenttb.findByEmail")
             .setParameter("email", email)
             .getResultList();
     
     return students;
    
    }

    @Override
    public Collection<Studenttb> getStudentByAddress(String address) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Collection<Studenttb> students = em.createNamedQuery("Studenttb.findByAddress")
             .setParameter("address", address)
             .getResultList();
     
     return students;
    
    }

   @Override
    public Collection<Companytb> getAllCompanies() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            return em.createNamedQuery("Companytb.findAll").getResultList();
    }

    @Override
    public Collection<Companytb> getCompanyByName(String cname) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Collection<Companytb> companies = em.createNamedQuery("Companytb.findByCName")
             .setParameter("cName", cname)
             .getResultList();
     
     return companies;
    }

    @Override
    public Collection<Companytb> getCompanyByLocation(String location) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Collection<Companytb> companies = em.createNamedQuery("Companytb.findByLocation")
             .setParameter("location", location)
             .getResultList();
     
     return companies;
    }
    
    @Override
    public Collection<Companytb> getCompanyByPackage(Integer salarypackage) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Collection<Companytb> companies = em.createNamedQuery("Companytb.findByPackage1")
             .setParameter("package1", salarypackage)
             .getResultList();
     
     return companies;
    }
    

    @Override
    public Collection<Placementtb> getAllPlacements() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return em.createNamedQuery("Placementtb.findAll").getResultList();
    }

    @Override
    public Collection<Placementtb> getStudentsOfPlacement(Integer stId) {
//        throw new UnsupportedOperationException("No*t supported yet."); //To change body of generated methods, choose Tools | Templates.
       Studenttb s = em.find(Studenttb.class, stId);
   
       return s.getPlacementtbCollection();
    }

    @Override
    public Collection<Placementtb> getCompanyOfPlacement(Integer cId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Companytb c = em.find(Companytb.class, cId);
   
       return c.getPlacementtbCollection();
    }

    @Override
    public Collection<Statustb> getAllStatus() {
      return em.createNamedQuery("Statustb.findAll").getResultList();
    }

    @Override
    public void updateStudentStatus(Integer stid, Integer sid) {
          Studenttb s = (Studenttb) em.find(Studenttb.class, stid);
         Statustb st = em.find(Statustb.class, sid);
         s.setSid(st);
       System.out.println(sid);
        em.merge(s);
        
    }

    @Override
    public Collection<Admintb> getAdminByName(String name) {
        Collection<Admintb> admins = em.createNamedQuery("Admintb.findByAdminName")
             .setParameter("adminName", name)
             .getResultList();
        
        return admins;
    }

    @Override
    public void updateAdminPassword(Integer adminId, String password) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Admintb a = (Admintb) em.find(Admintb.class, adminId);
        pb = new Pbkdf2PasswordHashImpl();
       String hashpass =  pb.generate(password.toCharArray());
        a.setPassword(hashpass);
        em.merge(a);
    }

   

}
