/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import client.CampusClient;
import ejb.AdminBeanLocal;
import ejb.CoordinatorBeanLocal;
import ejb.StudentBeanLocal;
import entity.Answertb;
import entity.Certificatetb;
import entity.Departmenttb;
import entity.Querytb;
import entity.Statustb;
import entity.Studenttb;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author De
 */
@Named(value = "studentController")
@ApplicationScoped
public class StudentController {

    @EJB
    private CoordinatorBeanLocal coordinatorBean;

    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

    String loggedIn = (String) session.getAttribute("user");

    @EJB
    private AdminBeanLocal adminBean;

    @EJB
    private StudentBeanLocal studentBean;
    
//        Collection<Packages> multipleSearchOfPackage;
    Response res;
    CampusClient cl;
    Collection<Studenttb> studentList;
    GenericType<Collection<Studenttb>> studentgeneric;
    Collection<Departmenttb> departmentList;
    GenericType<Collection<Departmenttb>> deptgeneric;
    Collection<Studenttb> studentSearchCollection;
    
    
     Collection<Statustb> StatusList;
     
    int stid,did,sid,phoneno,maxResults;
    String firstname,lastname,email,password,address,per10th,per12th,sem,filename,search="";
    Date DOB;
    
    Studenttb student = new Studenttb();
    
     private String folder = "E:\\Sem8_Project\\FinalApp\\web\\uploads\\";
     private String fullpath = "";
     
     private Part uploadedFile;

//      int stdid = studentBean.studnetbyid(loggedIn);
       
       
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }

    public String getFullpath() {
        return fullpath;
    }

    public void setFullpath(String fullpath) {
        this.fullpath = fullpath;
    }

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
     
     

    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public CampusClient getCl() {
        return cl;
    }

    public void setCl(CampusClient cl) {
        this.cl = cl;
    }

    public Collection<Studenttb> getStudentList() {
        return studentList;
    }

    public void setStudentList(Collection<Studenttb> studentList) {
        this.studentList = studentList;
    }

    public GenericType<Collection<Studenttb>> getStudentgeneric() {
        return studentgeneric;
    }

    public void setStudentgeneric(GenericType<Collection<Studenttb>> studentgeneric) {
        this.studentgeneric = studentgeneric;
    }

    public Collection<Departmenttb> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(Collection<Departmenttb> departmentList) {
        this.departmentList = departmentList;
    }

    public GenericType<Collection<Departmenttb>> getDeptgeneric() {
        return deptgeneric;
    }

    public void setDeptgeneric(GenericType<Collection<Departmenttb>> deptgeneric) {
        this.deptgeneric = deptgeneric;
    }

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPer10th() {
        return per10th;
    }

    public void setPer10th(String per10th) {
        this.per10th = per10th;
    }

    public String getPer12th() {
        return per12th;
    }

    public void setPer12th(String per12th) {
        this.per12th = per12th;
    }

    public String getSem() {
        return sem;
    }

    public void setSem(String sem) {
        this.sem = sem;
    }

    public Studenttb getStudent() {
        return student;
    }

    public void setStudent(Studenttb student) {
        this.student = student;
    }

    public StudentBeanLocal getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBeanLocal studentBean) {
        this.studentBean = studentBean;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }


    public Collection<Studenttb> getStudentSearchCollection() {
        return studentSearchCollection;
    }

    public void setStudentSearchCollection(Collection<Studenttb> studentSearchCollection) {
        this.studentSearchCollection = studentSearchCollection;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public AdminBeanLocal getAdminBean() {
        return adminBean;
    }

    public void setAdminBean(AdminBeanLocal adminBean) {
        this.adminBean = adminBean;
    }

    public Collection<Statustb> getStatusList() {
        return StatusList;
    }

    public void setStatusList(Collection<Statustb> StatusList) {
        this.StatusList = StatusList;
    }
    
    
    public StudentController() {
        cl = new CampusClient();
    }
    
    @PostConstruct
    public void init()
    {
        cl = new CampusClient();
      
         this.StatusList = adminBean.getAllStatus();
         
         this.maxResults = studentBean.countstudent();
        
    }
    
    
   
     public Collection<Studenttb> getAll()
    {
//        studentgeneric = new GenericType<Collection<Studenttb>>(){};
//            res = cl.getStudentByFirstNamae(Response.class,loggedIn);
//            Collection<Studenttb> st = res.readEntity(studentgeneric);
//            return st;
        if(search.isEmpty())
        {
            studentgeneric = new GenericType<Collection<Studenttb>>(){};
            res = cl.getAllStudents(Response.class);
            Collection<Studenttb> st = res.readEntity(studentgeneric);
            return st;
        }
        else{
            studentgeneric = new GenericType<Collection<Studenttb>>(){};
            res = cl.getStudentByFirstNamae(Response.class,search);
            Collection<Studenttb> st = res.readEntity(studentgeneric);
            return st;
        }
            
    }   
     
      public Collection<Studenttb> getAllNonVerifiedStudent()
     {
        
         return this.coordinatorBean.getAllStudentsByStatus(2);

     }
         
    public String verify(Studenttb st)
    {
        this.stid = st.getStid();
        Departmenttb d = st.getDeptid();
        this.did = d.getDeptid();
        Statustb s = st.getSid();
        this.sid = s.getSid();
        this.firstname = st.getFirstname();
        this.lastname = st.getLastname();
        
        //return "Student/verifystudent.xhtml";
        return "verifystudent.xhtml";
    }
    
      public String verify()
    {
        adminBean.updateStudentStatus(stid, sid);
        //studentBean.updateStudent(stid, firstname, lastname, email, phoneno, password, DOB, address, per10th, per12th, sem, did,1);
        //cl.updateStudent(String.valueOf(stid), firstname, lastname, email, String.valueOf(phoneno), password, DOB, address, per10th, per12th, sem,  String.valueOf(did),"2");
        return "studentdisplay.xhtml";
    }
    
   
   
     public String searchData()
     {
         return "display.xhtml";
         //return "Student/display.xhtml";
     }
     
}
