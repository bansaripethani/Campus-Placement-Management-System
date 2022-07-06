/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import client.CampusClient;
import ejb.StudentBeanLocal;
import entity.Certificatetb;
import entity.Studenttb;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
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
@Named(value = "certificateBean")
@ApplicationScoped
public class CertificateBean {

    /**
     * Creates a new instance of CertificateBean
     */
    public CertificateBean() {
    }
    
     @EJB
    private StudentBeanLocal studentBean;

   Response res;
    CampusClient cl;
    Collection<Studenttb> studentList;
    GenericType<Collection<Studenttb>> studentgeneric;
    Collection<Certificatetb> certificateList;
    GenericType<Collection<Certificatetb>> certificategeneric;
    Collection<Certificatetb> cerdoc;
    
    String title,filename;
    int crid,stid;
    
//     private String folder = "C:\\Users\\Lenovo\\Downloads\\EventManagement\\EventManagement\\web\\resources\\VenueDocument\\";
     private String folder = "E:\\Sem8_Project\\FinalApp\\web\\uploads\\";
     private String fullpath = "";
     
     private Part uploadedFile;

    public StudentBeanLocal getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBeanLocal studentBean) {
        this.studentBean = studentBean;
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

    public Collection<Certificatetb> getCertificateList() {
        return certificateList;
    }

    public void setCertificateList(Collection<Certificatetb> certificateList) {
        this.certificateList = certificateList;
    }

    public GenericType<Collection<Certificatetb>> getCertificategeneric() {
        return certificategeneric;
    }

    public void setCertificategeneric(GenericType<Collection<Certificatetb>> certificategeneric) {
        this.certificategeneric = certificategeneric;
    }

    public Collection<Certificatetb> getCerdoc() {
        return cerdoc;
    }

    public void setCerdoc(Collection<Certificatetb> cerdoc) {
        this.cerdoc = cerdoc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public int getCrid() {
        return crid;
    }

    public void setCrid(int crid) {
        this.crid = crid;
    }

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
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
    
     
      @PostConstruct
     public void init()
    { 
        cl = new CampusClient();
       studentgeneric = new GenericType<Collection<Studenttb>>(){};
        res = cl.getAllStudents(Response.class);
        this.studentList = res.readEntity(studentgeneric);
    }
      public Collection<Certificatetb> showdata() {
        
        certificategeneric = new GenericType<Collection<Certificatetb>>(){};
        res = cl.getAllCertificates(Response.class);
        cerdoc = res.readEntity(certificategeneric);
        return cerdoc;
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
       studentBean.addCertificate(title, getFilename(uploadedFile), stid);
        
        return "display.xhtml?faces-redirect=true";
    }
     
       public String edit(Certificatetb c)
       {
           this.crid  = c.getCrid();
           this.title = c.getTitle();
           this.filename = c.getImage();
           Studenttb s = c.getStid();
           this.stid = s.getStid();
           return "edit.xhtml";
       }
       
       public String edit(){
        System.out.println("saveFile method invoked..");
        System.out.println( "content-type:{0}" + uploadedFile.getContentType());
        System.out.println("filename:{0}" + uploadedFile.getName());
        System.out.println( "submitted filename:{0}"+ uploadedFile.getSubmittedFileName());
        System.out.println( "size:{0}" + uploadedFile.getSize());
         String fileName = "";

          try {

                  fileName = getFilename(uploadedFile);

                  System.out.println("fileName  " + fileName);

                  uploadedFile.write(folder+fileName);


        } catch (IOException ex) {
            System.out.println(ex);

        }
		  
	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("File " + fileName+ " Uploaded!"));
        studentBean.updateCertificate(crid, title, filename, stid);
     
        return "display.xhtml";
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
