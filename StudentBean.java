/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import static com.oracle.wls.shaded.org.apache.xpath.XPath.SELECT;
import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import entity.Admintb;
import entity.Answertb;
import entity.Appliedcompanytb;
import entity.Certificatetb;
import entity.Companytb;
import entity.Departmenttb;
import entity.Notificationtb;
import entity.Querytb;
import entity.Statustb;
import entity.Studenttb;
import entity.Users;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.annotation.security.DeclareRoles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author De
 */

@DeclareRoles({"Admin","Coordinator","Student"})
@Stateless
public class StudentBean implements StudentBeanLocal {

     Pbkdf2PasswordHashImpl pb;
    @PersistenceContext(unitName="FinalAppPU")
    EntityManager em;
    
    @Override
    public Collection<Studenttb> getStudentByName(String firstname) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//       Studenttb s = (Studenttb) em.createNamedQuery("Studenttb.findByFirstname")
//             .setParameter("firstname", firstname).getSingleResult();
//       s.getStid();
//      System.out.println(s.getStid());
        
     Collection<Studenttb> students = em.createNamedQuery("Studenttb.findByFirstname")
             .setParameter("firstname", firstname)
             .getResultList();
     
     return students;
    
    }
    
    @Override
    public void addStudent(String FirstName, String LastName, String Email, Integer Phoneno, String Password, Date DOB, String Address, String Percentage10, String Percentage12, String Sem, Integer Dept_id, Integer S_id) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
  Studenttb student = new Studenttb();
  Departmenttb d = em.find(Departmenttb.class, Dept_id);
  Statustb st = em.find(Statustb.class, S_id);
    
    student.setFirstname(FirstName);
    student.setLastname(LastName);
    student.setEmail(Email);
    student.setPhoneNo(Phoneno);
    student.setPassword(Password);
    student.setDob(DOB);
    student.setAddress(Address);
    student.setPercentage10th(Percentage10);
    student.setPercentage12th(Percentage12);
    student.setSemAggregate(Sem);
    student.setDeptid(d);
    student.setSid(st);
   
    student.getStid();
    em.persist(student);
    
    Collection<Studenttb> dept = d.getStudenttbCollection();
    Collection<Studenttb> status = st.getStudenttbCollection();
    
    dept.add(student);
    d.setStudenttbCollection(dept);
    em.merge(d);
    
    status.add(student);
    st.setStudenttbCollection(status);
    em.merge(st);
    
   
    }

    @Override
    public void updateStudent(Integer St_id, String FirstName, String LastName, String Email, Integer Phoneno, String Password, Date DOB, String Address, String Percentage10, String Percentage12, String Sem, Integer Dept_id, Integer S_id) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Departmenttb d = em.find(Departmenttb.class, Dept_id);
    Statustb st = em.find(Statustb.class, S_id);
    
    Studenttb s = em.find(Studenttb.class, St_id);
    
    s.setFirstname(FirstName);
    s.setLastname(LastName);
    s.setEmail(Email);
    s.setPhoneNo(Phoneno);
    s.setPassword(Password);
    s.setDob(DOB);
    s.setAddress(Address);
    s.setPercentage10th(Percentage10);
    s.setPercentage12th(Percentage12);
    s.setSemAggregate(Sem);
    s.setDeptid(d);
    s.setSid(st);
   
     em.merge(s);
    }

    @Override
    public void removeStudent(Integer St_id,Integer Dept_id,Integer S_id) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        Departmenttb dept = em.find(Departmenttb.class, Dept_id);
        Statustb status = em.find(Statustb.class, S_id);
        Studenttb student = em.find(Studenttb.class, St_id);

        Collection<Studenttb> s = dept.getStudenttbCollection();
        Collection<Studenttb> st = status.getStudenttbCollection();

        if(s.contains(student))
        {
            s.remove(student);
            st.remove(student);
            dept.setStudenttbCollection(s);
            status.setStudenttbCollection(st);
            em.remove(student);
            em.merge(dept);
            em.merge(status);
        }

    }

    @Override
    public Collection<Certificatetb> getAllCertificates() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return em.createNamedQuery("Certificatetb.findAll").getResultList();
    }

    @Override
    public void addCertificate(String title, String image, Integer stId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   Studenttb s = em.find(Studenttb.class, stId);
    Collection<Certificatetb> certificates = s.getCertificatetbCollection();
    
    Certificatetb c = new Certificatetb();
    c.setImage(image);
    c.setTitle(title);
    c.setStid(s);
    
   certificates.add(c);
    s.setCertificatetbCollection(certificates);
    
    em.persist(c);
    em.merge(s);
    }

    @Override
    public void updateCertificate(Integer crId, String title, String image, Integer stId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Studenttb s = em.find(Studenttb.class, stId);
    // Collection<Certificatetb> certificates = s.getCertificatetbCollection();
     Certificatetb c = (Certificatetb) em.find(Certificatetb.class, crId);
     c.setCrid(crId);
     c.setImage(image);
     c.setTitle(title);
     c.setStid(s);
     em.merge(c);
    }

    @Override
    public void removeCertificate(Integer crId, Integer stId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Studenttb s = em.find(Studenttb.class, stId);
    Certificatetb certificate = em.find(Certificatetb.class, crId);
    
    Collection<Certificatetb> c = s.getCertificatetbCollection();
    
    if(c.contains(certificate))
    {
        c.remove(certificate);
        s.setCertificatetbCollection(c);
        em.remove(certificate);
        em.merge(s);
    }
    }

    @Override
    public Collection<Notificationtb> getNotificationById(Integer stId) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    Studenttb s = em.find(Studenttb.class, stId);
//    return s.getNotificationtbCollection();
        Studenttb st = em.find(Studenttb.class, stId);        
        return em.createNamedQuery("Notificationtb.findNotificationByStudentId").setParameter("St_id", st).getResultList();
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
    public Collection<Querytb> getQueriesOfStudent(Integer stId) {
       //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    Studenttb s = em.find(Studenttb.class, stId);
//    return s.getQuerytbCollection();
        Studenttb st = em.find(Studenttb.class, stId);        
        return em.createNamedQuery("Querytb.findQueryByStudentId").setParameter("St_id", st).getResultList();
    }

    @Override
    public void addQuery(String question, Integer stId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Studenttb s = em.find(Studenttb.class, stId);
    Collection<Querytb> queries = s.getQuerytbCollection();
    
    Querytb q = new Querytb();
    q.setQuestion(question);
    q.setStid(s);
    
    queries.add(q);
    s.setQuerytbCollection(queries);
    
    em.persist(q);
    em.merge(s);
    }

    @Override
    public void updateQuery(Integer qId, String question, Integer stId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Studenttb s = em.find(Studenttb.class, stId);
    // Collection<Certificatetb> certificates = s.getCertificatetbCollection();
     Querytb q = (Querytb) em.find(Querytb.class, qId);
     q.setQuestion(question);
     q.setStid(s);
     em.merge(q);
    }

    @Override
    public void removeQuery(Integer qId, Integer stId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Studenttb s = em.find(Studenttb.class, stId);
    Querytb query = em.find(Querytb.class, qId);
    
    Collection<Querytb> q = s.getQuerytbCollection();
    
    if(q.contains(query))
    {
        q.remove(query);
        s.setQuerytbCollection(q);
        em.remove(query);
        em.merge(s);
    }
    }
    
    @Override
    public Collection<Answertb> getAnswerOfQuery(Integer qId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//      Querytb s = em.find(Querytb.class, qId);
//       return s.getAnswertbCollection();
        Querytb q = em.find(Querytb.class, qId);        
        return em.createNamedQuery("Answertb.findAnserByQueryId").setParameter("Q_id", q).getResultList();
    }

    @Override
    public Collection<Notificationtb> getNotificationsOfCompany(Integer cId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//      Companytb c = em.find(Companytb.class, cId);
//       return c.getNotificationtbCollection();
        Companytb cm = em.find(Companytb.class, cId);        
        return em.createNamedQuery("Notificationtb.findNotificationByComapanyId").setParameter("C_id", cm).getResultList();
    }

    @Override
    public Collection<Appliedcompanytb> getStudentsAppliedCompanies(Integer stId) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Studenttb s = em.find(Studenttb.class, stId);
     
       return s.getAppliedcompanytbCollection();
    }

    @Override
    public void addAppliedCompany(Integer stId, Integer cId, Date applicationDate) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Appliedcompanytb appliedcompany = new Appliedcompanytb();
    Studenttb s = em.find(Studenttb.class, stId);
    Companytb c = em.find(Companytb.class, cId);
    
    appliedcompany.setApplicationDate(applicationDate);
    appliedcompany.setCid(c);
    appliedcompany.setStid(s);
    em.persist(appliedcompany);
    
    Collection<Appliedcompanytb> student = s.getAppliedcompanytbCollection();
    Collection<Appliedcompanytb> company = c.getAppliedcompanytbCollection();
    
    student.add(appliedcompany);
    s.setAppliedcompanytbCollection(student);
    em.merge(s);
    
    company.add(appliedcompany);
    c.setAppliedcompanytbCollection(company);
    em.merge(c);
    
    }

    @Override
    public void updateAppliedCompany(Integer acId, Integer stId, Integer cId, Date applicationDate) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
     Studenttb s = em.find(Studenttb.class, stId);
     Companytb c = em.find(Companytb.class, cId);
             
    // Collection<Certificatetb> certificates = s.getCertificatetbCollection();
     Appliedcompanytb appliedcompany = em.find(Appliedcompanytb.class, acId);
     appliedcompany.setApplicationDate(applicationDate);
     appliedcompany.setCid(c);
     appliedcompany.setStid(s);
     em.merge(appliedcompany);
    }

    @Override
    public void removeAppliedCompany(Integer acId,Integer stId,Integer cId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Studenttb student = em.find(Studenttb.class, stId);
    Companytb company = em.find(Companytb.class, cId);
    Appliedcompanytb appliedcompany = em.find(Appliedcompanytb.class, acId);
    
    Collection<Appliedcompanytb> s = student.getAppliedcompanytbCollection();
    Collection<Appliedcompanytb> c = company.getAppliedcompanytbCollection();
   
    if(s.contains(appliedcompany))
    {
        s.remove(appliedcompany);
        c.remove(appliedcompany);
        student.setAppliedcompanytbCollection(s);
        company.setAppliedcompanytbCollection(c);
        em.remove(appliedcompany);
        em.merge(student);
        em.merge(company);
        
    }
    
    }  

    @Override
    public Collection<Certificatetb> getCertificateByStudentName(Integer stId) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Studenttb s = em.find(Studenttb.class, stId);
     
       return s.getCertificatetbCollection();
    }

    @Override
    public void adduser(String username, String password) {
         pb = new Pbkdf2PasswordHashImpl();
       String hashpass =  pb.generate(password.toCharArray());
        Users c = new Users(username,hashpass);
        em.persist(c);
    }

    @Override
    public Collection<Querytb> getQueriesByStudentNames(Collection<String> firstnames) {
        
         Collection<Studenttb> student = em.createNamedQuery("Studenttb.findByStudentnames")
                .setParameter("firstnames", firstnames)
                .getResultList();
        
        Collection<Querytb> querylist = new ArrayList<Querytb>();
        
        for(Studenttb s: student){
            querylist.addAll(s.getQuerytbCollection());
        }
        return querylist;
    }

//    @Override
//    public Collection<Studenttb> countstudent() {
////         Collection<Studenttb> student = em.createNamedQuery("Studenttb.countstudents").getResultList();
////         return student;
//    }

    @Override
    public int countstudent() {
        int maxResults = ((Long) em.createNamedQuery("countStudents")
        .getSingleResult()).intValue();
        
        return maxResults;
    }

// 
//    @Override
//   public Collection<Object[]>  studnetbyid(String firstname) {
//        System.out.println("Test");
//        System.out.println(firstname);
//        
//        String fname = "Bansari";
//        System.out.println(fname);
////        
////        String ejbql = "From Studenttb s where s.firstname like ?1 ";
////        
////        Query query = em.createQuery(ejbql);
////        
////        query.setParameter(1,"%Bansari%");
////        
////         System.out.println(query);
////        
////        return query.getResultList();
//        
////         Query query = (Query) em.createQuery(
////          "SELECT s.stid,s.address,s.lastname FROM Studenttb s WHERE s.firstname like ?firstname").getResultList();
////           query.setParameter("firstname", firstname);
////        
////        Query query = (Query) em.createQuery(
////          "SELECT s.stid,s.address,s.lastname FROM Studenttb As s").getResultList();
////           query.setParameter("firstname", firstname);
//        
//           System.out.println(query);
//           
//           
////          Long l = (Long) em.createQuery(
////          "SELECT s.lastname FROM Studenttb s WHERE "
////              + " s.firstname = :firstname ").setParameter(
////          "firstname", firstname).getSingleResult();
////                  
////         System.out.println(l);
//        Collection<Object[]> obj = query.getResultList();
//        return obj;
//        
//        
//         
//    }

//    @Override
//    public int studnetbyid(String firstname) {
//        
//        int students = ((Long) em.createNamedQuery("findstudents")
//             .setParameter("firstname", firstname)
//             .getSingleResult()).intValue();
//    
//     return students;
//    }

    @Override
    public int studnetbyid(String firstname) {
         Studenttb s = (Studenttb) em.createNamedQuery("Studenttb.findByFirstname")
             .setParameter("firstname", firstname).getSingleResult();
      int maxid =  s.getStid();
      //System.out.println(s.getStid());
      return maxid;
      
    }

    @Override
    public void insertStudent(String FirstName, String LastName, String Email, Integer Phoneno, String Password, Date DOB, String Address, String Percentage10, String Percentage12, String Sem, String Profilepic, Integer Dept_id, Integer S_id) {
        Studenttb student = new Studenttb();
  Departmenttb d = em.find(Departmenttb.class, Dept_id);
  Statustb st = em.find(Statustb.class, S_id);
    
    student.setFirstname(FirstName);
    student.setLastname(LastName);
    student.setEmail(Email);
    student.setPhoneNo(Phoneno);
    student.setPassword(Password);
    student.setDob(DOB);
    student.setAddress(Address);
    student.setPercentage10th(Percentage10);
    student.setPercentage12th(Percentage12);
    student.setSemAggregate(Sem);
    student.setProfilepic(Profilepic);
    student.setDeptid(d);
    student.setSid(st);
   
    student.getStid();
    em.persist(student);
    
    Collection<Studenttb> dept = d.getStudenttbCollection();
    Collection<Studenttb> status = st.getStudenttbCollection();
    
    dept.add(student);
    d.setStudenttbCollection(dept);
    em.merge(d);
    
    status.add(student);
    st.setStudenttbCollection(status);
    em.merge(st);
    
   System.out.println(student);
    }

    @Override
    public void editStudent(Integer St_id, String FirstName, String LastName, String Email, Integer Phoneno, String Password, Date DOB, String Address, String Percentage10, String Percentage12, String Sem, String Profilepic, Integer Dept_id, Integer S_id) {
     Departmenttb d = em.find(Departmenttb.class, Dept_id);
    Statustb st = em.find(Statustb.class, S_id);
    
    Studenttb s = em.find(Studenttb.class, St_id);
    
    s.setFirstname(FirstName);
    s.setLastname(LastName);
    s.setEmail(Email);
    s.setPhoneNo(Phoneno);
    s.setPassword(Password);
    s.setDob(DOB);
    s.setAddress(Address);
    s.setPercentage10th(Percentage10);
    s.setPercentage12th(Percentage12);
    s.setSemAggregate(Sem);
    s.setProfilepic(Profilepic);
    s.setDeptid(d);
    s.setSid(st);
   
     em.merge(s);
    }

    @Override
    public Collection<Studenttb> getStudentById(int stid) {
      Collection<Studenttb> students = em.createNamedQuery("Studenttb.findByStid")
             .setParameter("stid", stid)
             .getResultList();
     
     return students;
    }

    @Override
    public Collection<Companytb> getAllByStatus(int sid) {
        Statustb s = em.find(Statustb.class, sid);
               
     Collection<Companytb> companies = em.createNamedQuery("Companytb.findCompanyByStatus")
             .setParameter("S_id", s)
             .getResultList();
     
     return companies;
    }

  
}
