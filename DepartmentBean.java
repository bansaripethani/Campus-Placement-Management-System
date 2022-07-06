/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import client.CampusClient;
import ejb.CoordinatorBeanLocal;
import entity.Departmenttb;
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
@Named(value = "departmentBean")
@ApplicationScoped
public class DepartmentBean {

    @EJB
    private CoordinatorBeanLocal coordinatorBean;

    Response res;
    CampusClient cl;
    
    Collection<Departmenttb> departmentList;
    GenericType<Collection<Departmenttb>> deptgeneric;
    
    Departmenttb department = new Departmenttb();
    
     String Dept_Name;
     int Dept_id,maxResults;

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

    public Departmenttb getDepartment() {
        return department;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public void setDepartment(Departmenttb department) {
        this.department = department;
    }

    public String getDept_Name() {
        return Dept_Name;
    }

    public void setDept_Name(String Dept_Name) {
        this.Dept_Name = Dept_Name;
    }

    public int getDept_id() {
        return Dept_id;
    }

    public void setDept_id(int Dept_id) {
        this.Dept_id = Dept_id;
    }

    
    public DepartmentBean() {
        cl = new CampusClient();
    }
    
    @PostConstruct
    public void init(){
        this.maxResults = coordinatorBean.countdepartment();
    }
    public Collection<Departmenttb> getAll()
    {
        deptgeneric = new GenericType<Collection<Departmenttb>>(){};
        res = cl.getAllDepartments(Response.class);
        Collection<Departmenttb> dept = res.readEntity(deptgeneric);
        return dept;
    }
    
    public String add()
    {
        cl.addDepartment(Dept_Name);
       return "display";
    }
    
    public void delete(Departmenttb d)
    {
        this.Dept_id = d.getDeptid();
       cl.removeDepartment(String.valueOf(Dept_id));
    }
    
    public String edit(Departmenttb d){
        
        this.Dept_id = d.getDeptid();
        this.Dept_Name = d.getDeptName();
        return "edit";
    }
    
    public String edit()
    {
         cl.updateDepartment(String.valueOf(Dept_id), Dept_Name);
        return "display";
    }
    
}
