/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

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
public class CoordinatorBean implements CoordinatorBeanLocal {

    Pbkdf2PasswordHashImpl pb;
    @PersistenceContext(unitName="FinalAppPU")
    EntityManager em;
     
    @RolesAllowed("Coordinator")
    @Override
    public Collection<Placementcoordinatetb> getAllPlacementCoordinates() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
          return em.createNamedQuery("Placementcoordinatetb.findAll").getResultList();
    }
    

    @Override
    public Collection<Placementcoordinatetb> getDepartmentOfPlacementCoordinates(Integer did) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    Departmenttb d = em.find(Departmenttb.class, did);
//       return d.getPlacementcoordinatetbCollection();
        Departmenttb d = em.find(Departmenttb.class, did);        
        return em.createNamedQuery("Placementcoordinatetb.findCoordinateByDepartmentId").setParameter("Dept_id", d).getResultList();
    }

    @Override
    public void addPlacementCoordinate(String name, String email, String password, Integer phoneNo, Integer deptId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Departmenttb d = em.find(Departmenttb.class, deptId);
    Collection<Placementcoordinatetb> placementcoordinate = d.getPlacementcoordinatetbCollection();
     pb = new Pbkdf2PasswordHashImpl();
    String hashpass =  pb.generate(password.toCharArray());
    
    Placementcoordinatetb p = new Placementcoordinatetb();
    p.setEmail(email);
    p.setName(name);
    p.setPassword(hashpass);
    p.setPhoneno(phoneNo);
    p.setDeptid(d);
    
    placementcoordinate.add(p);
    d.setPlacementcoordinatetbCollection(placementcoordinate);
    
    em.persist(p);
    em.merge(d);
    }

    @Override
    public void updatePlacementCoordinate(Integer pcId, String name, String email, String password, Integer phoneNo, Integer deptId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Departmenttb d = em.find(Departmenttb.class, deptId);
    // Collection<Certificatetb> certificates = s.getCertificatetbCollection();
     Placementcoordinatetb p = em.find(Placementcoordinatetb.class, pcId);
     
      pb = new Pbkdf2PasswordHashImpl();
      String hashpass =  pb.generate(password.toCharArray());
       
     p.setEmail(email);
     p.setName(name);
     p.setPassword(hashpass);
     p.setPhoneno(phoneNo);
     p.setDeptid(d);
     em.merge(p);
    }

    @Override
    public void removePlacementCoordinate(Integer pcId,Integer deptId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Departmenttb d = em.find(Departmenttb.class,deptId);
    Placementcoordinatetb placementcoordinate = em.find(Placementcoordinatetb.class,  pcId);
    
    Collection<Placementcoordinatetb> p = d.getPlacementcoordinatetbCollection();
    
    if(p.contains(placementcoordinate))
    {
        p.remove(placementcoordinate);
        d.setPlacementcoordinatetbCollection(p);
        em.remove(placementcoordinate);
        em.merge(d);
    }
    }

     @Override
    public Collection<Departmenttb> getAllDepartments() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return em.createNamedQuery("Departmenttb.findAll").getResultList();
    }

    @Override
    public void addDepartment(String Dept_Name) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Departmenttb c = new Departmenttb(Dept_Name);
        em.persist(c);
    }

    @Override
    public void updateDepartment(Integer Dept_id, String Dept_Name) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Departmenttb d = (Departmenttb) em.find(Departmenttb.class, Dept_id);
        d.setDeptid(Dept_id);
        d.setDeptName(Dept_Name);
     
        em.merge(d);
    }

    @Override
    public void removeDepartment(Integer Dept_id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Departmenttb c = (Departmenttb) em.find(Departmenttb.class, Dept_id);
            em.remove(c);
    }

    @Override
    public Collection<Departmenttb> getDepartmentByName(String deptName) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       Collection<Departmenttb> departments = em.createNamedQuery("Departmenttb.findByDeptName")
             .setParameter("deptName", deptName)
             .getResultList();
     
     return departments;
    }

    
    @Override
    public Collection<Studenttb> getStudentOfDepartment(Integer deptId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    Departmenttb d = em.find(Departmenttb.class, deptId);
//    return d.getStudenttbCollection();
        Departmenttb d = em.find(Departmenttb.class, deptId);        
        return em.createNamedQuery("Studenttb.findStudentByDeptId").setParameter("Dept_id", d).getResultList();
    }

    @Override
    public Collection<Studenttb> getAllStudents() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return em.createNamedQuery("Companytb.findAll").getResultList();
    }

    @Override
    public void addCompany(String cName, String Location, Integer salaryPackage, Integer NoofVacancy, String percentage10, String percentage12, String semaggregate, Date passingdate, Integer jid, Integer deptid, Integer ptid,Integer sid) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Companytb company = new Companytb();
    Departmenttb d = em.find(Departmenttb.class, deptid);
    Statustb st = em.find(Statustb.class, sid);
    Jobtb j = em.find(Jobtb.class, jid);
    Placementtypetb p = em.find(Placementtypetb.class, ptid);
    
    company.setCName(cName);
    company.setLocation(Location);
    company.setPackage1(salaryPackage);
    company.setNoOfVacancy(NoofVacancy);
    company.setPercentage10th(percentage10);
    company.setPercentage12th(percentage12);
    company.setSemAggregate(semaggregate);
    company.setPassingDate(passingdate);
    company.setDeptid(d);
    company.setSid(st);
    company.setJid(j);
    company.setPtid(p);
   
    em.persist(company);
    
    Collection<Companytb> dept = d.getCompanytbCollection();
    Collection<Companytb> status = st.getCompanytbCollection();
    Collection<Companytb> job = j.getCompanytbCollection();
    Collection<Companytb> type = p.getCompanytbCollection();
    
    dept.add(company);
    d.setCompanytbCollection(dept);
    em.merge(d);
    
    status.add(company);
    st.setCompanytbCollection(status);
    em.merge(st);
    
    job.add(company);
    j.setCompanytbCollection(job);
    em.merge(j);
    
    type.add(company);
    p.setCompanytbCollection(type);
    em.merge(p);
    
    }

    @Override
    public void updateCompany(Integer cId, String cName, String Location, Integer salaryPackage, Integer NoofVacancy, String percentage10, String percentage12, String semaggregate, Date passingdate, Integer jid, Integer deptid, Integer ptid,Integer sid) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Companytb company = new Companytb();
    Departmenttb d = em.find(Departmenttb.class, deptid);
    Jobtb j = em.find(Jobtb.class, jid);
    Statustb s = em.find(Statustb.class, sid);
    Placementtypetb p = em.find(Placementtypetb.class, ptid);
    
    Companytb c = em.find(Companytb.class, cId);
    
    c.setCName(cName);
    c.setLocation(Location);
    c.setPackage1(salaryPackage);
    c.setNoOfVacancy(NoofVacancy);
    c.setPercentage10th(percentage10);
    c.setPercentage12th(percentage12);
    c.setPassingDate(passingdate);
    c.setJid(j);
    c.setDeptid(d);
    c.setPtid(p);
    c.setSid(s);
    
    em.merge(c);

    }

    @Override
    public void removeCompany(Integer cId, Integer jid, Integer deptid, Integer ptid,Integer sid) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    Departmenttb dept = em.find(Departmenttb.class, deptid);
    Statustb status = em.find(Statustb.class, sid);
    Placementtypetb type = em.find(Placementtypetb.class,ptid);
    Jobtb job= em.find(Jobtb.class,jid);
    Companytb company = em.find(Companytb.class, cId);
    
    Collection<Companytb> d = dept.getCompanytbCollection();
    Collection<Companytb> t = type.getCompanytbCollection();
    Collection<Companytb> j = job.getCompanytbCollection();
    Collection<Companytb> s = status.getCompanytbCollection();
    
    if(d.contains(company))
    {
        d.remove(company);
        s.remove(company);
        t.remove(company);
        j.remove(company);
        type.setCompanytbCollection(t);
        dept.setCompanytbCollection(d);
        job.setCompanytbCollection(j);
        status.setCompanytbCollection(s);
        em.remove(company);
        em.merge(dept);
        em.merge(status);
        em.merge(job);
        em.merge(type);
    }
    }

    @Override
    public Collection<Notificationtb> getAllNotifications() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return em.createNamedQuery("Notificationtb.findAll").getResultList();
    }

    @Override
    public void addNotification(String title, String description, Integer cId,Integer stId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Notificationtb n = new Notificationtb();
    Companytb c = em.find(Companytb.class, cId);
    Studenttb s = em.find(Studenttb.class,stId);
    
    n.setTitle(title);
    n.setDescription(description);
    n.setCid(c);
    n.setStid(s);
    
    em.persist(n);
    
    Collection<Notificationtb> student = s.getNotificationtbCollection();
    Collection<Notificationtb> company = c.getNotificationtbCollection();
    
    student.add(n);
    s.setNotificationtbCollection(student);
    em.merge(s);
    
    company.add(n);
    c.setNotificationtbCollection(company);
    em.merge(c);
    
    }

    @Override
    public void updateNotification(Integer nId, Integer cId, String title, String description,Integer stId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
    Studenttb s = em.find(Studenttb.class,stId);
    Companytb c = em.find(Companytb.class,cId);
    
    Notificationtb n = em.find(Notificationtb.class, nId);
    
    n.setDescription(description);
    n.setTitle(title);
    n.setCid(c);
    n.setStid(s);
    
    em.merge(n);

    }

    @Override
    public void removeNotification(Integer nId,Integer cId,Integer stId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    Studenttb student = em.find(Studenttb.class, stId);
    Companytb company = em.find(Companytb.class, cId);
    Notificationtb notification = em.find(Notificationtb.class, nId);
    
    Collection<Notificationtb> s = student.getNotificationtbCollection();
    Collection<Notificationtb> c = company.getNotificationtbCollection();
    
    if(s.contains(notification))
    {
        s.remove(notification);
        c.remove(notification);
        student.setNotificationtbCollection(s);
        company.setNotificationtbCollection(c);
        em.remove(notification);
        em.merge(student);
        em.merge(company);
    }
    }
    
    @Override
    public Collection<Notificationtb> getNotificationOfCompany(Integer cId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Companytb c = em.find(Companytb.class, cId);
    return c.getNotificationtbCollection();
    }
    
    @Override
    public Collection<Certificatetb> getAllCertificates() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return em.createNamedQuery("Certificatetb.findAll").getResultList();
    }

    @Override
    public Collection<Certificatetb> getCertificatesOfStudents(Integer stId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    Studenttb s = em.find(Studenttb.class, stId);
//       return s.getCertificatetbCollection();
        Studenttb s = em.find(Studenttb.class, stId);        
        return em.createNamedQuery("Certificatetb.findCertificateByStudentId").setParameter("St_id", s).getResultList();
    }

    @Override
    public Collection<Querytb> getAllQueries() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   return em.createNamedQuery("Querytb.findAll").getResultList();
    }
   

    @Override
    public Collection<Placementtb> getAllPlacements() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return em.createNamedQuery("Placementtb.findAll").getResultList();
    }

    @Override
    public Collection<Placementtb> getStudentsOfPlacement(Integer stId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        Studenttb s = em.find(Studenttb.class, stId);
//       return s.getPlacementtbCollection();
        Studenttb s = em.find(Studenttb.class, stId);        
        return em.createNamedQuery("Placementtb.findPlacementByStudentId").setParameter("St_id", s).getResultList();
    }

    @Override
    public Collection<Placementtb> getCompanyOfPlacement(Integer cId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    Companytb c = em.find(Companytb.class, cId);
//       return c.getPlacementtbCollection();
        Companytb c = em.find(Companytb.class, cId);        
        return em.createNamedQuery("Placementtb.findPlacementByCompanyId").setParameter("C_id", c).getResultList();
    }

    @RolesAllowed("Coordinator")
    @Override
    public void addPlacement(Integer stId, Integer cId, Date placementDate) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        Placementtb placement = new Placementtb();
        Studenttb s = em.find(Studenttb.class, stId);
        Companytb c = em.find(Companytb.class, cId);
        
        placement.setPlacementDate(placementDate);
        placement.setCid(c);
        placement.setStid(s);
        
        em.persist(placement);
        
        Collection<Placementtb> student = s.getPlacementtbCollection();
        Collection<Placementtb> company =c.getPlacementtbCollection();

        student.add(placement);
        s.setPlacementtbCollection(student);
        em.merge(s);
        
        company.add(placement);
        c.setPlacementtbCollection(company);
        em.merge(c);
        
    }

    @RolesAllowed("Coordinator")
    @Override
    public void updatePlacement(Integer pId, Integer stId, Integer cId, Date placementDate) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates
    Studenttb s = em.find(Studenttb.class, stId);
    Companytb c = em.find(Companytb.class, cId);
    Placementtb p = em.find(Placementtb.class, pId);
    
    p.setPlacementDate(placementDate);
    p.setCid(c);
    p.setStid(s);
    
    em.merge(p);
    
    }

    @RolesAllowed("Coordinator")
    @Override
    public void removePlacement(Integer pId,Integer stId,Integer cId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      Studenttb student = em.find(Studenttb.class, stId);
      Companytb company = em.find(Companytb.class, cId);
      Placementtb placement = em.find(Placementtb.class, pId);
      
      Collection<Placementtb> s = student.getPlacementtbCollection();
      Collection<Placementtb> c = company.getPlacementtbCollection();
      
      if(s.contains(placement))
      {
          s.remove(placement);
          c.remove(placement);
          student.setPlacementtbCollection(s);
          company.setPlacementtbCollection(c);
          em.remove(placement);
          em.merge(student);
          em.merge(company);
      }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    @Override
    public Collection<Answertb> getAllAnswers() {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return em.createNamedQuery("Answertb.findAll").getResultList();
    }
@Override
    public void addAnswer(String ans, Integer qId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Answertb answer = new Answertb();
    Querytb q = em.find(Querytb.class, qId);
    
    answer.setAnsDesc(ans);
    answer.setQid(q);
    
    em.persist(answer);
    
    Collection<Answertb> query = q.getAnswertbCollection();
    
    query.add(answer);
    q.setAnswertbCollection(query);
    em.merge(q);
    
    }


    @Override
    public void updateAnswer(Integer anId, String answer, Integer qId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Querytb q = em.find(Querytb.class, qId);
    Answertb a = em.find(Answertb.class, anId);
    a.setAnsDesc(answer);
    a.setQid(q);
    em.merge(a);
    
    }

    
    @Override
    public void removeAnswer(Integer anId, Integer qId) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Querytb query = em.find(Querytb.class, qId);
    Answertb answer = em.find(Answertb.class, anId);
    
    Collection<Answertb> q = query.getAnswertbCollection();
    if(q.contains(answer))
    {
        q.remove(answer);
        query.setAnswertbCollection(q);
        em.remove(answer);
        em.merge(query);
    }
    
    }
    
     @Override
    public Collection<Appliedcompanytb> getAllAppliedCompanies() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       return em.createNamedQuery("Appliedcompanytb.findAll").getResultList();
    }

    @Override
    public Collection<Jobtb> getAllJobs() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return em.createNamedQuery("Jobtb.findAll").getResultList();
    }

    @Override
    public void addJob(String Title) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Jobtb j = new Jobtb(Title);
        em.persist(j);
    }

    @Override
    public void updateJob(Integer jId, String Title) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Jobtb j = (Jobtb) em.find(Jobtb.class, jId);
        j.setJid(jId);
        j.setTitle(Title);
        em.merge(j);
    }

    @Override
    public void removeJob(Integer jId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Jobtb j = (Jobtb) em.find(Jobtb.class, jId);
        em.remove(j);
    }

    @Override
    public Collection<Placementtypetb> getAllPlacementTypes() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    return em.createNamedQuery("Placementtypetb.findAll").getResultList();
    }
    

    @Override
    public void addPlacementType(String type) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        Placementtypetb p = new Placementtypetb(type);
        em.persist(p);
    }

    @Override
    public void updatePlacementType(Integer pId, String type) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Placementtypetb p = (Placementtypetb) em.find(Placementtypetb.class, pId);
        p.setPtid(pId);
        p.setType(type);
     
        em.merge(p);
    }

    @Override
    public void removePlacementType(Integer pId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    Placementtypetb p = (Placementtypetb) em.find(Placementtypetb.class, pId);
        em.remove(p);
    }

    @Override
    public Collection<Companytb> getJobOfCompany(Integer jId) {
         Jobtb j = em.find(Jobtb.class, jId);        
        return em.createNamedQuery("Companytb.findCompanyByJob").setParameter("J_id", j).getResultList();
    }

    @Override
    public Collection<Notificationtb> getNotificationBytitle(String title) {
        Collection<Notificationtb> notifications = em.createNamedQuery("Notificationtb.findByTitle")
             .setParameter("title", title)
             .getResultList();
        return notifications;
    }

    @Override
    public void updateCompanyStatus(Integer cid, Integer sid) {
        Companytb c = (Companytb) em.find(Companytb.class, cid);
         Statustb st = em.find(Statustb.class, sid);
         c.setSid(st);
       
        em.merge(c);
    }

    @Override
    public Collection<Appliedcompanytb> getStudentsOfAppliedcompany(Integer stId) {
         Studenttb s = em.find(Studenttb.class, stId);        
        return em.createNamedQuery("Appliedcompanytb.findAppliedcompanyByStudentId").setParameter("St_id", s).getResultList();
    }

    @Override
    public Collection<Appliedcompanytb> getCompanyOfAppliedcompany(Integer cId) {
        Companytb c = em.find(Companytb.class, cId);        
        return em.createNamedQuery("Appliedcompanytb.findAppliedcompanyByCompanyId").setParameter("C_id", c).getResultList();
    }

    @Override
    public Collection<Placementcoordinatetb> getPlacementCoordinateByName(String name) {
        Collection<Placementcoordinatetb> pc = em.createNamedQuery("Placementcoordinatetb.findByName")
             .setParameter("name", name)
             .getResultList();
        
        return pc;
    }

    @Override
    public void updatepassword(Integer pcId, String password) {
        Placementcoordinatetb p = em.find(Placementcoordinatetb.class, pcId);
     
      pb = new Pbkdf2PasswordHashImpl();
      String hashpass =  pb.generate(password.toCharArray());
     p.setPassword(hashpass);
     em.merge(p);
    }

    @Override
    public int countplacements() {
         int maxResults = ((Long) em.createNamedQuery("countPlacements")
        .getSingleResult()).intValue();
        
        return maxResults;
    }

    @Override
    public int countnotification() {
       int maxResults = ((Long) em.createNamedQuery("countNotifications")
        .getSingleResult()).intValue();
        
        return maxResults;
    }

    @Override
    public int countjob() {
         int maxResults = ((Long) em.createNamedQuery("countJobs")
        .getSingleResult()).intValue();
        
        return maxResults;
    }

    @Override
    public int countdepartment() {
         int maxResults = ((Long) em.createNamedQuery("countDepartments")
        .getSingleResult()).intValue();
        
        return maxResults;
    }

    @Override
    public int countcompany() {
         int maxResults = ((Long) em.createNamedQuery("countCompanys")
        .getSingleResult()).intValue();
        
        return maxResults;
    }

    @Override
    public int countappliedcompany() {
         int maxResults = ((Long) em.createNamedQuery("countAppliedcompanys")
        .getSingleResult()).intValue();
        
        return maxResults;
    }

    @Override
    public int countanswer() {
         int maxResults = ((Long) em.createNamedQuery("countAnswers")
        .getSingleResult()).intValue();
        
        return maxResults;
    }

    @Override
    public int countAdmin() {
         int maxResults = ((Long) em.createNamedQuery("countAdmins")
        .getSingleResult()).intValue();
        
        return maxResults;
    }

    @Override
    public int countplacementcoordinator() {
         int maxResults = ((Long) em.createNamedQuery("countPlacementcoordinators")
        .getSingleResult()).intValue();
        
        return maxResults;
    }

    @Override
    public int countquery() {
         int maxResults = ((Long) em.createNamedQuery("countQuerys")
        .getSingleResult()).intValue();
        
        return maxResults;
    }

    @Override
    public int countuser() {
         int maxResults = ((Long) em.createNamedQuery("countUsers")
        .getSingleResult()).intValue();
        
        return maxResults;
    }

    @Override
    public Collection<Companytb> getAllCompaniesByStatus(int sid) {
        Statustb s = em.find(Statustb.class, sid);   
        return em.createNamedQuery("Companytb.findCompanyByStatus").setParameter("S_id", s).getResultList();
        
    }

    @Override
    public Collection<Studenttb> getAllStudentsByStatus(int sid) {
        
         Statustb s = em.find(Statustb.class, sid);
        Collection<Studenttb> students = em.createNamedQuery("Studenttb.findStudentBySId")
             .setParameter("S_id", s)
             .getResultList();
     
     return students;
    }

}
