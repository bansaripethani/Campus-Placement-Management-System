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
import entity.Departmenttb;
import entity.Statustb;
import entity.Studenttb;
import entity.Users;
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
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author De
 */
@Named(value = "usersBean")
@ApplicationScoped
public class UsersBean {

    @EJB
    private CoordinatorBeanLocal coordinatorBean;
    @EJB
    private StudentBeanLocal studentBean;

   Users user = new Users();
   Studenttb student = new Studenttb();
   
    String username,password;
    int stid,did,sid,phoneno,maxResults;
    String firstname,lastname,email,pass,address,per10th,per12th,sem,filename,search="";
    Date DOB;

    Collection<Departmenttb> deptList;
    
     private String folder = "E:\\Sem8_Project\\FinalApp\\web\\uploads\\";
     private String fullpath = "";
     
     private Part uploadedFile;

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

     
    public StudentBeanLocal getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBeanLocal studentBean) {
        this.studentBean = studentBean;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Studenttb getStudent() {
        return student;
    }

    public void setStudent(Studenttb student) {
        this.student = student;
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

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public CoordinatorBeanLocal getCoordinatorBean() {
        return coordinatorBean;
    }

    public void setCoordinatorBean(CoordinatorBeanLocal coordinatorBean) {
        this.coordinatorBean = coordinatorBean;
    }

    public Collection<Departmenttb> getDeptList() {
        return deptList;
    }

    public void setDeptList(Collection<Departmenttb> deptList) {
        this.deptList = deptList;
    }
   
   
    public UsersBean() {
    }
    
     @PostConstruct
    public void init()
    {
         this.deptList = coordinatorBean.getAllDepartments();
         
         this.maxResults = coordinatorBean.countuser();
    }
    public String add()
    {
      studentBean.adduser(username, password);
      studentBean.addStudent(firstname, lastname, email, phoneno, password, DOB, address, per10th, per12th, sem, did, 2);
 
      return "index.jsp";
    }
    
      public String insert(){
        System.out.println("saveFile method invoked..");
        System.out.println( "content-type:{0}" + uploadedFile.getContentType());
        System.out.println("filename:{0}" + uploadedFile.getName());
        System.out.println( "submitted filename:{0}"+ uploadedFile.getSubmittedFileName());
        System.out.println( "size:{0}" + uploadedFile.getSize());
         String fileName = "";
          try {
              
            byte[] fileContent = new byte[(int) uploadedFile.getSize()];
                InputStream in = uploadedFile.getInputStream();
                in.read(fileContent);

                File fileToCreate = new File("E:\\Sem8_Project\\FinalApp\\web\\uploads\\", getFilename(uploadedFile));
                File f = new File("E:\\Sem8_Project\\FinalApp\\web\\uploads\\");
                if (!f.exists()) {
                        f.mkdirs();
                }
                FileOutputStream fileOutStream = new FileOutputStream(fileToCreate);
                fileOutStream.write(fileContent);
                fileOutStream.flush();
                fileOutStream.close();

            fileName = getFilename(uploadedFile);
            System.out.println("File Name:"+fileName);
                

        } catch (IOException ex) {
            System.out.println(ex);
        }
		  
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File " + fileName+ " Uploaded!"));
        
       fullpath = "E:\\Sem8_Project\\FinalApp\\web\\uploads\\"+getFilename(uploadedFile);
       
      studentBean.adduser(firstname, password);
      studentBean.insertStudent(firstname, lastname, email, phoneno, password, DOB, address, per10th, per12th, sem, getFilename(uploadedFile) , did, 2);
       return "index.jsp";
    }
      
      
         private static String getFilename(Part part) {
        for(String cd : part.getHeader("content-disposition").split(";")){
            if(cd.trim().startsWith("filename")){
                String filename = cd.substring(cd.indexOf('=')+1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\')+1);
            }
        }
        return null;   
    }
         
       
}
