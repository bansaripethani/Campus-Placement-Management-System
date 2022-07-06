/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import client.CampusClient;
import ejb.CoordinatorBeanLocal;
import ejb.StudentBeanLocal;
import entity.Appliedcompanytb;
import entity.Companytb;
import entity.Placementtb;
import entity.Querytb;
import entity.Studenttb;
import java.util.Collection;
import java.util.Date;
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
@Named(value = "appliedCompanyBean")
@ApplicationScoped
public class AppliedCompanyBean {

    @EJB
    private StudentBeanLocal studentBean1;

    @EJB
    private StudentBeanLocal studentBean;

 FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

    String loggedIn = (String) session.getAttribute("user");
    @EJB
    private CoordinatorBeanLocal coordinatorBean;

    Response res;
    CampusClient cl;
    
    Collection<Appliedcompanytb> applieldcompanyList;
    GenericType<Collection<Appliedcompanytb>> applygeneric;
    Collection<Studenttb> studentList;
    Collection<Studenttb> studentNameList;
    GenericType<Collection<Studenttb>> studentgeneric;
    Collection<Companytb> companyList;
    GenericType<Collection<Companytb>> companygeneric;
     
    Collection<Appliedcompanytb> companySearchCollection;
     Collection<Appliedcompanytb> studentSearchCollection;
             
    Appliedcompanytb appliedcompany = new Appliedcompanytb();
    
     //Date applicationDate;
     private Date applicationDate = new Date();
     int acId,stId,cId,maxResults,stdid;

     
     //int stdid = studentBean.studnetbyid(loggedIn);
     
    public CoordinatorBeanLocal getCoordinatorBean() {
        return coordinatorBean;
    }

    public void setCoordinatorBean(CoordinatorBeanLocal coordinatorBean) {
        this.coordinatorBean = coordinatorBean;
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

    public Collection<Appliedcompanytb> getApplieldcompanyList() {
        return applieldcompanyList;
    }

    public void setApplieldcompanyList(Collection<Appliedcompanytb> applieldcompanyList) {
        this.applieldcompanyList = applieldcompanyList;
    }

    public GenericType<Collection<Appliedcompanytb>> getApplygeneric() {
        return applygeneric;
    }

    public void setApplygeneric(GenericType<Collection<Appliedcompanytb>> applygeneric) {
        this.applygeneric = applygeneric;
    }

    public int getStdid() {
        return stdid;
    }

    public void setStdid(int stdid) {
        this.stdid = stdid;
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

    public Collection<Companytb> getCompanyList() {
        return companyList;
    }

    public FacesContext getFacesContext() {
        return facesContext;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public String getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(String loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Collection<Studenttb> getStudentNameList() {
        return studentNameList;
    }

    public void setStudentNameList(Collection<Studenttb> studentNameList) {
        this.studentNameList = studentNameList;
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

    public Collection<Appliedcompanytb> getCompanySearchCollection() {
        return companySearchCollection;
    }

    public void setCompanySearchCollection(Collection<Appliedcompanytb> companySearchCollection) {
        this.companySearchCollection = companySearchCollection;
    }

    public Collection<Appliedcompanytb> getStudentSearchCollection() {
        return studentSearchCollection;
    }

    public void setStudentSearchCollection(Collection<Appliedcompanytb> studentSearchCollection) {
        this.studentSearchCollection = studentSearchCollection;
    }

    public Appliedcompanytb getAppliedcompany() {
        return appliedcompany;
    }

    public void setAppliedcompany(Appliedcompanytb appliedcompany) {
        this.appliedcompany = appliedcompany;
    }

    public StudentBeanLocal getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBeanLocal studentBean) {
        this.studentBean = studentBean;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    
    public int getAcId() {
        return acId;
    }

    public void setAcId(int acId) {
        this.acId = acId;
    }

    public int getStId() {
        return stId;
    }

    public void setStId(int stId) {
        this.stId = stId;
    }

    public int getcId() {
        return cId;
    }

    public void setcId(int cId) {
        this.cId = cId;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
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

        studentgeneric = new GenericType<Collection<Studenttb>>(){};
        res = cl.getStudentByFirstNamae(Response.class,loggedIn);
        this.studentNameList = res.readEntity(studentgeneric);
        
        this.maxResults = coordinatorBean.countappliedcompany();
        
    }

    public Collection<Appliedcompanytb> getAll()
    {
        applygeneric = new GenericType<Collection<Appliedcompanytb>>(){};
        res = cl.getAllAppliedCompanies(Response.class);
        Collection<Appliedcompanytb> a = res.readEntity(applygeneric);
        return a;
    }

     public Collection<Studenttb> getStudentData()
    {
        studentgeneric = new GenericType<Collection<Studenttb>>(){};
        res = cl.getAllStudents(Response.class);
        return res.readEntity(studentgeneric);      
    }
     
     public Collection<Studenttb> getStudentName()
    {
          studentgeneric = new GenericType<Collection<Studenttb>>(){};
         //        res = cl.getAllStudents(Response.class);
         res = cl.getStudentByFirstNamae(Response.class,loggedIn);
         Collection<Studenttb> st = res.readEntity(studentgeneric);
         return st;     
    }
    
    public Collection<Appliedcompanytb> getStudentId()
    {
        //studentSearchCollection = coordinatorBean.getStudentsOfAppliedcompany(stdid);
        this.stdid = studentBean.studnetbyid(loggedIn);
        Collection<Appliedcompanytb> st = coordinatorBean.getStudentsOfAppliedcompany(stdid);
        return st;
        
        //return "/CoordinatorDashboard/appliedcompanydisplayByStudent.xhtml";    
    }
    
    public String getStudentNameData()
    {
         this.stdid = studentBean.studnetbyid(loggedIn);
       studentSearchCollection = coordinatorBean.getStudentsOfAppliedcompany(stId);
        return "/StudentDashboard/appliedcompany.xhtml";
        //return "displayByStudent.xhtml";
    }
    
    public Collection<Companytb> getCompanyData()
    {
        companygeneric = new GenericType<Collection<Companytb>>(){};
        res = cl.getAllCompanies(Response.class);
        return res.readEntity(companygeneric);      
    }
    
    public String getCompanyId()
    {
        companySearchCollection = coordinatorBean.getCompanyOfAppliedcompany(cId);
        return "/CoordinatorDashboard/appliedcompanydisplayByCompany.xhtml";
         //return "displayByStudent.xhtml";
    }
    
    
    public AppliedCompanyBean() {
        cl = new CampusClient();
    }
    
    public String add()
    {
       //cl.addAppliedCompany(String.valueOf(stId),String.valueOf(cId),applicationDate);
        int stdid = studentBean.studnetbyid(loggedIn);
       studentBean.addAppliedCompany(stdid, cId, applicationDate);
       return "/StudentDashboard/appliedcompany.xhtml";
       //return "display.xhtml";
    }
    
    public void delete(Appliedcompanytb a)
    {    
        this.acId = a.getAcid();
        Studenttb s = a.getStid();
        this.stId = s.getStid();
        Companytb c = a.getCid();
        this.cId = c.getCid();
        int stdid = studentBean.studnetbyid(loggedIn);
        cl.removeAppliedCompany(String.valueOf(acId),String.valueOf(stdid),String.valueOf(cId));
 
    }
    
    public String edit(Appliedcompanytb a){
        
        this.acId = a.getAcid();
        Studenttb s = a.getStid();
        this.stId = s.getStid();
        Companytb c = a.getCid();
        this.cId = c.getCid();
        this.applicationDate = a.getApplicationDate();
        
        return "edit";
    }
    
    
    public String edit()
    {     
        //cl.updateAppliedCompany(String.valueOf(acId), String.valueOf(stId), String.valueOf(cId),applicationDate);
        int stdid = studentBean.studnetbyid(loggedIn);
        studentBean.updateAppliedCompany(acId, stdid, cId, applicationDate);
        return "display";
    }
    
}
