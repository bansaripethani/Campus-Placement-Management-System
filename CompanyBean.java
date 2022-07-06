/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import client.CampusClient;
import ejb.AdminBeanLocal;
import ejb.CoordinatorBeanLocal;
import entity.Companytb;
import entity.Departmenttb;
import entity.Jobtb;
import entity.Notificationtb;
import entity.Placementtypetb;
import entity.Statustb;
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
@Named(value = "companyBean")
@ApplicationScoped
public class CompanyBean {

    @EJB
    private AdminBeanLocal adminBean;

    @EJB
    private CoordinatorBeanLocal coordinatorBean;

    Response res;
    CampusClient cl;
    Collection<Companytb> companyList;
    GenericType<Collection<Companytb>> companygeneric;
    Collection<Departmenttb> departmentList;
    GenericType<Collection<Departmenttb>> deptgeneric;
    Collection<Jobtb> jobList;
    GenericType<Collection<Jobtb>> jobgeneric;
    Collection<Placementtypetb> placementtypeList;
    GenericType<Collection<Placementtypetb>> placementtypegeneric;

    Collection<Statustb> StatusList;

    Companytb company = new Companytb();

    int cid, salarypacakge, noofvacancy, jid, deptid, ptid, sid,maxResults;
    String cname, location, per10th, per12th, sem, search = "";
    //Date passingdate;
    private Date passingdate = new Date();
    
    public Response getRes() {
        return res;
    }

    public void setRes(Response res) {
        this.res = res;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public CampusClient getCl() {
        return cl;
    }

    public void setCl(CampusClient cl) {
        this.cl = cl;
    }

    public GenericType<Collection<Companytb>> getCompanygeneric() {
        return companygeneric;
    }

    public void setCompanygeneric(GenericType<Collection<Companytb>> companygeneric) {
        this.companygeneric = companygeneric;
    }

    public GenericType<Collection<Departmenttb>> getDeptgeneric() {
        return deptgeneric;
    }

    public void setDeptgeneric(GenericType<Collection<Departmenttb>> deptgeneric) {
        this.deptgeneric = deptgeneric;
    }

    public GenericType<Collection<Jobtb>> getJobgeneric() {
        return jobgeneric;
    }

    public void setJobgeneric(GenericType<Collection<Jobtb>> jobgeneric) {
        this.jobgeneric = jobgeneric;
    }

    public Collection<Companytb> getCompanyList() {
        return companyList;
    }

    public void setCompanyList(Collection<Companytb> companyList) {
        this.companyList = companyList;
    }

    public Collection<Departmenttb> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(Collection<Departmenttb> departmentList) {
        this.departmentList = departmentList;
    }

    public Collection<Jobtb> getJobList() {
        return jobList;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setJobList(Collection<Jobtb> jobList) {
        this.jobList = jobList;
    }

    public Collection<Placementtypetb> getPlacementtypeList() {
        return placementtypeList;
    }

    public void setPlacementtypeList(Collection<Placementtypetb> placementtypeList) {
        this.placementtypeList = placementtypeList;
    }

    public GenericType<Collection<Placementtypetb>> getPlacementtypegeneric() {
        return placementtypegeneric;
    }

    public void setPlacementtypegeneric(GenericType<Collection<Placementtypetb>> placementtypegeneric) {
        this.placementtypegeneric = placementtypegeneric;
    }

    public Companytb getCompany() {
        return company;
    }

    public void setCompany(Companytb company) {
        this.company = company;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSalarypacakge() {
        return salarypacakge;
    }

    public void setSalarypacakge(int salarypacakge) {
        this.salarypacakge = salarypacakge;
    }

    public int getNoofvacancy() {
        return noofvacancy;
    }

    public void setNoofvacancy(int noofvacancy) {
        this.noofvacancy = noofvacancy;
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

    public int getJid() {
        return jid;
    }

    public void setJid(int jid) {
        this.jid = jid;
    }

    public int getDeptid() {
        return deptid;
    }

    public void setDeptid(int deptid) {
        this.deptid = deptid;
    }

    public int getPtid() {
        return ptid;
    }

    public void setPtid(int ptid) {
        this.ptid = ptid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public CoordinatorBeanLocal getCoordinatorBean() {
        return coordinatorBean;
    }

    public void setCoordinatorBean(CoordinatorBeanLocal coordinatorBean) {
        this.coordinatorBean = coordinatorBean;
    }

    public Date getPassingdate() {
        return passingdate;
    }

    public void setPassingdate(Date passingdate) {
        this.passingdate = passingdate;
    }

    public CompanyBean() {
        cl = new CampusClient();
    }

    @PostConstruct
    public void init() {
        cl = new CampusClient();

        deptgeneric = new GenericType<Collection<Departmenttb>>() {};
        res = cl.getAllDepartments(Response.class);
        this.departmentList = res.readEntity(deptgeneric);

        jobgeneric = new GenericType<Collection<Jobtb>>() {};
        res = cl.getAllJobs(Response.class);
        this.jobList = res.readEntity(jobgeneric);

        placementtypegeneric = new GenericType<Collection<Placementtypetb>>() {};
        res = cl.getAllPlacementTypes(Response.class);
        this.placementtypeList = res.readEntity(placementtypegeneric);

        this.StatusList = adminBean.getAllStatus();
        this.maxResults = coordinatorBean.countcompany();

    }

    public Collection<Jobtb> getJobData()
    {
        jobgeneric = new GenericType<Collection<Jobtb>>(){};
        res = cl.getAllJobs(Response.class);
        return res.readEntity(jobgeneric);      
    }
    
//    public String getJobId()
//    {
//        
//        jobgeneric = new GenericType<Collection<Jobtb>>(){};
//        res = cl.(Response.class, String.valueOf(stid));
//        notificationSearchCollection = res.readEntity(notificationgeneric);
//        return "displayByStudent.xhtml?faces-redirect=true";
//    }
//    
//    public Collection<Companytb> getCompanyData()
//    {
//        companygeneric = new GenericType<Collection<Companytb>>(){};
//        res = cl.getAllCompanies(Response.class);
//        return res.readEntity(companygeneric);      
//    }
//    
//    public String getCompanyId()
//    {
//        notificationgeneric = new GenericType<Collection<Notificationtb>>(){};
//        res = cl.getNotificationOfCompany(Response.class, String.valueOf(cid));
//        notificationSearchCollection = res.readEntity(notificationgeneric);
//        return "displayByCompany.xhtml?faces-redirect=true";
//    }
    public Collection<Companytb> getAll() {
        if (search.isEmpty()) {
            companygeneric = new GenericType<Collection<Companytb>>() {
            };
            res = cl.getAllCompanies(Response.class);
            Collection<Companytb> cm = res.readEntity(companygeneric);
            return cm;
        } else {
            companygeneric = new GenericType<Collection<Companytb>>() {
            };
            res = cl.getCompanyByName(Response.class, search);
            Collection<Companytb> cm = res.readEntity(companygeneric);
            return cm;
        }
    }
        public Collection<Companytb> getAllverifiedCompany() {
        
            Collection<Companytb> cm = coordinatorBean.getAllCompaniesByStatus(1);
            return cm;
        
         }
          public Collection<Companytb> getAllnonverifiedCompany() {
        
            Collection<Companytb> cm = coordinatorBean.getAllCompaniesByStatus(2);
            return cm;
        
         }

    public String add() {
        coordinatorBean.addCompany(cname, location, salarypacakge, noofvacancy, per10th, per12th, sem, passingdate, jid, deptid, ptid, 2);
        cl = new CampusClient();
//        cl.addCompany(cname, location, String.valueOf(salarypacakge), String.valueOf(noofvacancy), per10th, per12th, sem, passingdate, String.valueOf(jid), String.valueOf(deptid), String.valueOf(ptid),String.valueOf(sid));
        return "displaycompanies.xhtml";
    }

    public void delete(Companytb c) {
        this.cid = c.getCid();
        Departmenttb d = c.getDeptid();
        this.deptid = d.getDeptid();
        Jobtb j = c.getJid();
        this.jid = j.getJid();
        Placementtypetb p = c.getPtid();
        this.ptid = p.getPtid();
        Statustb s = c.getSid();
        this.sid = s.getSid();
        cl.removeCompany(String.valueOf(cid), String.valueOf(jid), String.valueOf(deptid), String.valueOf(ptid), String.valueOf(sid));

    }

    public String edit(Companytb c) {
        this.cid = c.getCid();
        Departmenttb d = c.getDeptid();
        this.deptid = d.getDeptid();
        Jobtb j = c.getJid();
        this.jid = j.getJid();
        Placementtypetb p = c.getPtid();
        this.ptid = p.getPtid();
        Statustb s = c.getSid();
        this.sid = s.getSid();
        this.cname = c.getCName();
        this.location = c.getLocation();
        this.salarypacakge = c.getPackage1();
        this.noofvacancy = c.getNoOfVacancy();
        this.sem = c.getSemAggregate();
        this.per10th = c.getPercentage10th();
        this.per12th = c.getPercentage12th();
        this.passingdate = c.getPassingDate();

        return "editcompany.xhtml";
    }

    public String edit() {
        coordinatorBean.updateCompany(cid, cname, location, salarypacakge, noofvacancy, per10th, per12th, sem, passingdate, jid, deptid, ptid,sid);
        //cl.updateCompany(String.valueOf(cid), cname, location, String.valueOf(salarypacakge), String.valueOf(noofvacancy), per10th, per12th, sem, passingdate, String.valueOf(jid), String.valueOf(deptid), String.valueOf(ptid),String.valueOf(sid));
        return "displaycompanies.xhtml";
    }
    
    public String verify(Companytb c) {
        this.cid = c.getCid();
        Departmenttb d = c.getDeptid();
        this.deptid = d.getDeptid();
        Jobtb j = c.getJid();
        this.jid = j.getJid();
        Placementtypetb p = c.getPtid();
        this.ptid = p.getPtid();
        Statustb s = c.getSid();
        this.sid = s.getSid();
        this.cname = c.getCName();
       
        return "verifycompany.xhtml";

    }

    public String verify() {
        coordinatorBean.updateCompanyStatus(cid, sid);
        //cl.updateCompany(String.valueOf(cid), cname, location, String.valueOf(salarypacakge), String.valueOf(noofvacancy), per10th, per12th, sem, passingdate, String.valueOf(jid), String.valueOf(deptid), String.valueOf(ptid),String.valueOf(sid));
        return "companydisplay.xhtml";
    }

    public String searchData() {
        return "display.xhtml";
        //return "Student/display.xhtml";
    }
    
    public String searchCompany() {
        return "/StudentDashboard.xhtml";
        //return "Student/display.xhtml";
    }
 
}
