/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import client.CampusClient;
import com.sun.istack.NotNull;
import ejb.CoordinatorBeanLocal;
import entity.Jobtb;
import java.util.Collection;
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
@Named(value = "jobBean")
@ApplicationScoped
public class JobBean {

    @EJB
    private CoordinatorBeanLocal coordinatorBean;

    Response res;
    CampusClient cl;
    
    Collection<Jobtb> jobList;
    GenericType<Collection<Jobtb>> jbgeneric;
    
    
    Jobtb job = new Jobtb();
    
    
     String Title;
     int jId,maxResults;

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

    public Collection<Jobtb> getJobList() {
        return jobList;
    }

    public void setJobList(Collection<Jobtb> jobList) {
        this.jobList = jobList;
    }

    public GenericType<Collection<Jobtb>> getJbgeneric() {
        return jbgeneric;
    }

    public void setJbgeneric(GenericType<Collection<Jobtb>> jbgeneric) {
        this.jbgeneric = jbgeneric;
    }

    public Jobtb getJob() {
        return job;
    }

    public void setJob(Jobtb job) {
        this.job = job;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public int getjId() {
        return jId;
    }

    public void setjId(int jId) {
        this.jId = jId;
    }

     
     
    public JobBean() {
        cl = new CampusClient();
    }
    
    @PostConstruct
    public void init(){
        this.maxResults = coordinatorBean.countjob();
    }
    
    public Collection<Jobtb> getAll()
    {
            jbgeneric = new GenericType<Collection<Jobtb>>(){};
            res = cl.getAllJobs(Response.class);
            Collection<Jobtb> jb = res.readEntity(jbgeneric);
            return jb;
    }
     
    public String add()
    {
        cl.addJob(Title);
        return "display";
    }
    
    public void delete(Jobtb j)
    {
        this.jId = j.getJid();
        cl.removeJob(String.valueOf(jId));
        
    }
    
    public String edit(Jobtb j){
        
        this.jId = j.getJid();
        this.Title = j.getTitle();
        
        return "edit";
    }
    
    public String edit()
    {
        cl.updateJob(Title);
        return "display";
    }
    
}
