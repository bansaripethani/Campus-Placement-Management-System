/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import client.CampusClient;
import ejb.CoordinatorBeanLocal;
import entity.Companytb;
import entity.Departmenttb;
import entity.Notificationtb;
import entity.Placementcoordinatetb;
import entity.Studenttb;
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
@Named(value = "placementCoordinateBean")
@ApplicationScoped
public class PlacementCoordinateBean {

    @EJB
    private CoordinatorBeanLocal coordinatorBean;

    Response res;
    CampusClient cl;
     Collection<Placementcoordinatetb> coordinateList;
    GenericType<Collection<Placementcoordinatetb>> coordinategeneric;
    Collection<Departmenttb> deptList;
    GenericType<Collection<Departmenttb>> deptgeneric;
    Collection<Placementcoordinatetb> coordinateSerachCollection;
    
    Placementcoordinatetb coordinate = new Placementcoordinatetb();
    
    int pcid,phoneno,did,maxResults;
    String name,email,password;

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

    public Collection<Placementcoordinatetb> getCoordinateList() {
        return coordinateList;
    }

    public void setCoordinateList(Collection<Placementcoordinatetb> coordinateList) {
        this.coordinateList = coordinateList;
    }

    public GenericType<Collection<Placementcoordinatetb>> getCoordinategeneric() {
        return coordinategeneric;
    }

    public void setCoordinategeneric(GenericType<Collection<Placementcoordinatetb>> coordinategeneric) {
        this.coordinategeneric = coordinategeneric;
    }

    public Collection<Departmenttb> getDeptList() {
        return deptList;
    }

    public void setDeptList(Collection<Departmenttb> deptList) {
        this.deptList = deptList;
    }

    public GenericType<Collection<Departmenttb>> getDeptgeneric() {
        return deptgeneric;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public void setDeptgeneric(GenericType<Collection<Departmenttb>> deptgeneric) {
        this.deptgeneric = deptgeneric;
    }

    public Placementcoordinatetb getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Placementcoordinatetb coordinate) {
        this.coordinate = coordinate;
    }

    public int getPcid() {
        return pcid;
    }

    public void setPcid(int pcid) {
        this.pcid = pcid;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Collection<Placementcoordinatetb> getCoordinateSerachCollection() {
        return coordinateSerachCollection;
    }

    public void setCoordinateSerachCollection(Collection<Placementcoordinatetb> coordinateSerachCollection) {
        this.coordinateSerachCollection = coordinateSerachCollection;
    }
    
    
    public PlacementCoordinateBean() {
        cl = new CampusClient();
    }
    
    @PostConstruct
    public void init()
    {
        cl = new CampusClient();
        
        deptgeneric = new GenericType<Collection<Departmenttb>>(){};
        res = cl.getAllDepartments(Response.class);
        this.deptList = res.readEntity(deptgeneric);
        
        this.maxResults = coordinatorBean.countplacementcoordinator();
    }
    
    public Collection<Departmenttb> getDepartmentData()
    {
        deptgeneric = new GenericType<Collection<Departmenttb>>(){};
        res = cl.getAllDepartments(Response.class);
        return res.readEntity(deptgeneric);      
    }
    public String getDepartmentId()
    {
        coordinategeneric = new GenericType<Collection<Placementcoordinatetb>>(){};
        res = cl.getDepartmentOfPlacementCoordinates(Response.class, String.valueOf(did));
        coordinateSerachCollection = res.readEntity(coordinategeneric);
        return "displayByDepartment.xhtml?faces-redirect=true";
    }
     public Collection<Placementcoordinatetb> getAll()
    {
            coordinategeneric = new GenericType<Collection<Placementcoordinatetb>>(){};
            res = cl.getAllPlacementCoordinates(Response.class);
            Collection<Placementcoordinatetb> pcr = res.readEntity(coordinategeneric);
            return pcr;
    }            
            
    public String add()
    {
        cl.addPlacementCoordinate(name, email, password, String.valueOf(phoneno), String.valueOf(did));
        return "display.xhtml";    
    }
    
    public void delete(Placementcoordinatetb p)
    {
        this.pcid = p.getPcid();
        Departmenttb d = p.getDeptid();
        this.did = d.getDeptid();
        cl.removePlacementCoordinate(String.valueOf(pcid),String.valueOf(did));
    }
    
    public String edit(Placementcoordinatetb p)
    {
        this.pcid = p.getPcid();
        Departmenttb d = p.getDeptid();
        this.did = d.getDeptid();
        this.name = p.getName();
        this.email = p.getEmail();
        this.phoneno = p.getPhoneno();
        this.password = p.getPassword();
       return "edit.xhtml";
    }
   
     public String edit()
    {
        cl.updatePlacementCoordinate(String.valueOf(pcid), name, email, password, String.valueOf(phoneno),String.valueOf(did));
        return "display.xhtml";
    }
 
    
}

