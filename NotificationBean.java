/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import client.CampusClient;
import ejb.CoordinatorBeanLocal;
import ejb.StudentBeanLocal;
import entity.Companytb;
import entity.Notificationtb;
import entity.Studenttb;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author De
 */
@Named(value = "notificationbean")
@ApplicationScoped
public class NotificationBean {

    @EJB
    private StudentBeanLocal studentBean;

    FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

    String loggedIn = (String) session.getAttribute("user");
    
    @EJB
    private CoordinatorBeanLocal coordinatorBean;

    Response res;
    CampusClient cl;
    Collection<Companytb> companyList;
    GenericType<Collection<Companytb>> companygeneric;
    Collection<Studenttb> studentList;
    GenericType<Collection<Studenttb>> studentgeneric;
    Collection<Notificationtb> notificationList;
    GenericType<Collection<Notificationtb>> notificationgeneric;
     Collection<Notificationtb> notificationSearchCollection;
     
    Notificationtb notification = new Notificationtb();
    int nid,cid,stid,maxResults,stdid;
    String title,discription,search="";

    public Response getRes() {
        return res;
    }

    public StudentBeanLocal getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBeanLocal studentBean) {
        this.studentBean = studentBean;
    }

    public String getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(String loggedIn) {
        this.loggedIn = loggedIn;
    }

    public int getStdid() {
        return stdid;
    }

    public void setStdid(int stdid) {
        this.stdid = stdid;
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

    public Collection<Companytb> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(Collection<Companytb> companyList) {
        this.companyList = companyList;
    }

    public GenericType<Collection<Companytb>> getCompanygeneric() {
        return companygeneric;
    }

    public void setCompanygeneric(GenericType<Collection<Companytb>> companygeneric) {
        this.companygeneric = companygeneric;
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

    public Collection<Notificationtb> getNotificationList() {
        return notificationList;
    }

    public void setNotificationList(Collection<Notificationtb> notificationList) {
        this.notificationList = notificationList;
    }

    public GenericType<Collection<Notificationtb>> getNotificationgeneric() {
        return notificationgeneric;
    }

    public void setNotificationgeneric(GenericType<Collection<Notificationtb>> notificationgeneric) {
        this.notificationgeneric = notificationgeneric;
    }

    public Notificationtb getNotification() {
        return notification;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public void setNotification(Notificationtb notification) {
        this.notification = notification;
    }

    public int getNid() {
        return nid;
    }

    public void setNid(int nid) {
        this.nid = nid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getStid() {
        return stid;
    }

    public CoordinatorBeanLocal getCoordinatorBean() {
        return coordinatorBean;
    }

    public void setCoordinatorBean(CoordinatorBeanLocal coordinatorBean) {
        this.coordinatorBean = coordinatorBean;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Collection<Notificationtb> getNotificationSearchCollection() {
        return notificationSearchCollection;
    }

    public void setNotificationSearchCollection(Collection<Notificationtb> notificationSearchCollection) {
        this.notificationSearchCollection = notificationSearchCollection;
    }
    
   
    public NotificationBean() {
        cl = new CampusClient();
    }
    
    @PostConstruct
    public void init()
    {
        cl = new CampusClient();
        
//        studentgeneric = new GenericType<Collection<Studenttb>>(){};
//        res = cl.getAllStudents(Response.class);
//        this.studentList = res.readEntity(studentgeneric);
//        
//        companygeneric = new GenericType<Collection<Companytb>>(){};
//        res = cl.getAllCompanies(Response.class);
//        this.companyList = res.readEntity(companygeneric);
  this.studentList = coordinatorBean.getAllStudentsByStatus(1);
   this.companyList = coordinatorBean.getAllCompaniesByStatus(1);
        
        
        this.maxResults = coordinatorBean.countnotification();
        
    }
    
    public Collection<Studenttb> getStudentData()
    {        
         studentgeneric = new GenericType<Collection<Studenttb>>(){};
         //        res = cl.getAllStudents(Response.class);
         res = cl.getStudentByFirstNamae(Response.class,loggedIn);
         Collection<Studenttb> st = res.readEntity(studentgeneric);
         return st;
    }
    
    public Collection<Notificationtb> getStudentId()
    {
        this.stdid = studentBean.studnetbyid(loggedIn);
        notificationgeneric = new GenericType<Collection<Notificationtb>>(){};
//        res = cl.getNotificationById(Response.class, String.valueOf(stid));
        res = cl.getNotificationById(Response.class, String.valueOf(stdid));
        Collection<Notificationtb> nt = res.readEntity(notificationgeneric);
        //return "/StudentDashboard/notificationdisplay.xhtml";
        return nt;
    }
    
    public Collection<Companytb> getCompanyData()
    {
        companygeneric = new GenericType<Collection<Companytb>>(){};
        res = cl.getAllCompanies(Response.class);
        return res.readEntity(companygeneric);      
    }
    
    public String getCompanyId()
    {
        notificationgeneric = new GenericType<Collection<Notificationtb>>(){};
        res = cl.getNotificationOfCompany(Response.class, String.valueOf(cid));
        notificationSearchCollection = res.readEntity(notificationgeneric);
        return "/StudentDashboard/notificationdisplay.xhtml";
    }
     
     public Collection<Notificationtb> getAll()
    {
        if(search.isEmpty()){
            notificationgeneric = new GenericType<Collection<Notificationtb>>(){};
            res = cl.getAllNotifications(Response.class);
            Collection<Notificationtb> nt = res.readEntity(notificationgeneric);
            return nt;
        }
        else{
           Collection<Notificationtb> nt  = coordinatorBean.getNotificationBytitle(search);
           return nt;
        }
            
    }            
            
    public String add()
    {
        
        cl.addNotification(title, discription, String.valueOf(cid), String.valueOf(stid));
        return "/CoordinatorDashboard/notification.xhtml";    
    }
    
    public void delete(Notificationtb n)
    {
        this.nid = n.getNid();
        Companytb c = n.getCid();
        this.cid = c.getCid();
       Studenttb s = n.getStid();
       this.stid = s.getStid();
       cl.removeNotification(String.valueOf(nid),String.valueOf(cid),String.valueOf(stid));
       
    }
    
    public String edit(Notificationtb n)
    {
      this.nid = n.getNid();
        Companytb c = n.getCid();
        this.cid = c.getCid();
       Studenttb s = n.getStid();
       this.stid = s.getStid();
       this.title = n.getTitle();
       this.discription = n.getDescription();
       return "/CoordinatorDashboard/editnotification.xhtml";
    }
   
     public String edit()
    {
        cl.updateNotification(String.valueOf(nid), title, discription, String.valueOf(cid), String.valueOf(stid));
        return "/CoordinatorDashboard/notification.xhtml";
    }
     
    public String searchData()
     {
         return "/CoordinatorDashboard/notification.xhtml";
         //return "Student/display.xhtml";
     }
    
}
