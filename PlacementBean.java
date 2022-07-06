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
import entity.Placementtb;
import entity.Studenttb;
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author De
 */
@Named(value = "placementBean")
@ApplicationScoped
public class PlacementBean {

    @EJB
    private StudentBeanLocal studentBean;

    @EJB
    private CoordinatorBeanLocal coordinatorBean;

    
     Response res;
    CampusClient cl;
     Collection<Placementtb> placementList;
    GenericType<Collection<Placementtb>> placementgeneric;
    Collection<Companytb> companyList;
    GenericType<Collection<Companytb>> companygeneric;
    Collection<Studenttb> studentList;
    GenericType<Collection<Studenttb>> studentgeneric;
    
    Collection<Placementtb> studentSearchCollection;
    Collection<Placementtb> companySearchCollection;
    
    int pid,stid,cid,maxResults;
    Date pdate;

    
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

    public Collection<Placementtb> getPlacementList() {
        return placementList;
    }

    public void setPlacementList(Collection<Placementtb> placementList) {
        this.placementList = placementList;
    }

    public GenericType<Collection<Placementtb>> getPlacementgeneric() {
        return placementgeneric;
    }

    public void setPlacementgeneric(GenericType<Collection<Placementtb>> placementgeneric) {
        this.placementgeneric = placementgeneric;
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

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
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

    public Collection<Placementtb> getStudentSearchCollection() {
        return studentSearchCollection;
    }

    public void setStudentSearchCollection(Collection<Placementtb> studentSearchCollection) {
        this.studentSearchCollection = studentSearchCollection;
    }

    public Collection<Placementtb> getCompanySearchCollection() {
        return companySearchCollection;
    }

    public void setCompanySearchCollection(Collection<Placementtb> companySearchCollection) {
        this.companySearchCollection = companySearchCollection;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

   
    
    public PlacementBean() {
        cl = new CampusClient();
    }
    
    @PostConstruct
    public void init()
    {
        cl = new CampusClient();
        
//        studentgeneric = new GenericType<Collection<Studenttb>>(){};
//        res = cl.getAllStudents(Response.class);
//        this.studentList = res.readEntity(studentgeneric);
        this.studentList = coordinatorBean.getAllStudentsByStatus(1);
        
//        companygeneric = new GenericType<Collection<Companytb>>(){};
//        res = cl.getAllCompanies(Response.class);
//        this.companyList = res.readEntity(companygeneric);
        this.companyList = coordinatorBean.getAllCompaniesByStatus(1);
        
        this.maxResults = coordinatorBean.countplacements();
    }
    
     public Collection<Studenttb> getStudentData()
    {
        studentgeneric = new GenericType<Collection<Studenttb>>(){};
        res = cl.getAllStudents(Response.class);
        return res.readEntity(studentgeneric);      
    }
    
    public String getStudentId()
    {
        placementgeneric = new GenericType<Collection<Placementtb>>(){};
        res = cl.getStudentsOfPlacement(Response.class, String.valueOf(stid));
        studentSearchCollection = res.readEntity(placementgeneric);
        return "Placement/displayByStudent.xhtml";
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
        placementgeneric = new GenericType<Collection<Placementtb>>(){};
        res = cl.getCompanyOfPlacement(Response.class, String.valueOf(cid));
        companySearchCollection = res.readEntity(placementgeneric);
        return "/CoordinatorDashboard/displayByCompany.xhtml";
         //return "displayByStudent.xhtml";
    }
    
    public Collection<Placementtb> getAll()
    {
        placementgeneric = new GenericType<Collection<Placementtb>>(){};
        res = cl.getAllPlacements(Response.class);
        Collection<Placementtb> pc = res.readEntity(placementgeneric);
        return pc;
    }            
            
    public String add()
    {
        //cl.addPlacement(String.valueOf(stid),String.valueOf(cid),String.valueOf(pdate));
        coordinatorBean.addPlacement(stid, cid, pdate);
        return "/CoordinatorDashboard/placedstudent.xhtml";    
        //return "display.xhtml";
    }
//    
    public void delete(Placementtb p)
    {
        this.pid = p.getPid();
        Studenttb s = p.getStid();
        this.stid = s.getStid();
        Companytb c = p.getCid();
        this.cid = c.getCid();
        cl.removePlacement(String.valueOf(pid), String.valueOf(stid), String.valueOf(cid));
    }
    
    public String edit(Placementtb p)
    {
        this.pid = p.getPid();
        Studenttb s = p.getStid();
        this.stid = s.getStid();
        Companytb c = p.getCid();
        this.cid = c.getCid();
        this.pdate = p.getPlacementDate();
       return "/CoordinatorDashboard/editplacedstudent.xhtml";
       //return "edit.xhtml";
    }
   
     public String edit()
    {
        coordinatorBean.updatePlacement(pid, stid, cid, pdate);
        //cl.updatePlacement(String.valueOf(pid), String.valueOf(stid), String.valueOf(cid),String.valueOf(pdate));
        return "/CoordinatorDashboard/placedstudent.xhtml";
       //return "display.xhtml";
    }
    
}
