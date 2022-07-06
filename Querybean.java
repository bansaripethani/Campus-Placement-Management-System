/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import client.CampusClient;
import ejb.CoordinatorBeanLocal;
import ejb.StudentBeanLocal;
import entity.Answertb;
import entity.Departmenttb;
import entity.Placementcoordinatetb;
import entity.Querytb;
import entity.Studenttb;
import java.util.ArrayList;
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
@Named(value = "querybean")
@ApplicationScoped
public class Querybean {

    @EJB
    private CoordinatorBeanLocal coordinatorBean;

     FacesContext facesContext = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);

    String loggedIn = (String) session.getAttribute("user");
    
    @EJB
    private StudentBeanLocal studentBean;
    
    Response res;
    CampusClient cl;
    Collection<Querytb> queryList;
    GenericType<Collection<Querytb>> querygeneric;
     Collection<Studenttb> studentList;
     Collection<Studenttb> studentNameList;
    GenericType<Collection<Studenttb>> studentgeneric;
    Collection<Querytb> querySearchCollection;
    private Collection<String> studenttNms;
    int qid,stid,maxResults;
    String question;
    
    Querytb query = new Querytb();

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

    public Collection<Querytb> getQueryList() {
        return queryList;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }

    public void setQueryList(Collection<Querytb> queryList) {
        this.queryList = queryList;
    }

    public GenericType<Collection<Querytb>> getQuerygeneric() {
        return querygeneric;
    }

    public void setQuerygeneric(GenericType<Collection<Querytb>> querygeneric) {
        this.querygeneric = querygeneric;
    }


    public Collection<Querytb> getQuerySearchCollection() {
        return querySearchCollection;
    }

    public void setQuerySearchCollection(Collection<Querytb> querySearchCollection) {
        this.querySearchCollection = querySearchCollection;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public int getStid() {
        return stid;
    }

    public void setStid(int stid) {
        this.stid = stid;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Querytb getQuery() {
        return query;
    }

    public void setQuery(Querytb query) {
        this.query = query;
    }

    public Collection<Studenttb> getStudentList() {
        return studentList;
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

    public void setStudentList(Collection<Studenttb> studentList) {
        this.studentList = studentList;
    }

    public GenericType<Collection<Studenttb>> getStudentgeneric() {
        return studentgeneric;
    }

    public void setStudentgeneric(GenericType<Collection<Studenttb>> studentgeneric) {
        this.studentgeneric = studentgeneric;
    }
    
    public Querybean() {
        cl = new CampusClient();
    }

    public StudentBeanLocal getStudentBean() {
        return studentBean;
    }

    public void setStudentBean(StudentBeanLocal studentBean) {
        this.studentBean = studentBean;
    }

    public Collection<String> getStudenttNms() {
        return studenttNms;
    }

    public void setStudenttNms(Collection<String> studenttNms) {
        this.studenttNms = studenttNms;
    }
    
    @PostConstruct
    public void init()
    {
        cl = new CampusClient();
        
        studentgeneric = new GenericType<Collection<Studenttb>>(){};
        res = cl.getAllStudents(Response.class);
        this.studentList = res.readEntity(studentgeneric);
        
       studentgeneric = new GenericType<Collection<Studenttb>>(){};
         //res = cl.getAllStudents(Response.class);
         res = cl.getStudentByFirstNamae(Response.class,loggedIn);
        this.studentNameList = res.readEntity(studentgeneric);
         
         this.studenttNms = new ArrayList<String>();
         
         this.maxResults = coordinatorBean.countquery();
         
    }
    
    public Collection<Studenttb> getStudentData()
    {
        studentgeneric = new GenericType<Collection<Studenttb>>(){};
         res = cl.getAllStudents(Response.class);
         Collection<Studenttb> st = res.readEntity(studentgeneric);
         return st;    
    }
    
    public Collection<Studenttb> getStudentName()
    {
        studentgeneric = new GenericType<Collection<Studenttb>>(){};
         //res = cl.getAllStudents(Response.class);
         res = cl.getStudentByFirstNamae(Response.class,loggedIn);
         Collection<Studenttb> st = res.readEntity(studentgeneric);
         return st;    
    }
    
    public Collection<Querytb> getStudentId()
    { 
        this.stid = studentBean.studnetbyid(loggedIn);
        querygeneric = new GenericType<Collection<Querytb>>(){};
        res = cl.getQueriesOfStudent(Response.class, String.valueOf(stid));
        Collection<Querytb> qr = res.readEntity(querygeneric);
        return qr;
        //return "/StudentDashboard/querydisplay.xhtml";
    }
     public Collection<Querytb> getAll()
    {
           if(studenttNms.isEmpty()){
            
            querygeneric = new GenericType<Collection<Querytb>>(){};
            res = cl.getAllQueries(Response.class);
            Collection<Querytb> qr = res.readEntity(querygeneric);
            return qr;
        }else{
            return this.studentBean.getQueriesByStudentNames(studenttNms);
        }
    }    
     
      public Collection<Querytb> getAllByName()
    {
           if(studenttNms.isEmpty()){
            
            querygeneric = new GenericType<Collection<Querytb>>(){};
            //res = cl.getAllQueries(Response.class);
            res = cl.getQueriesOfStudent(Response.class, String.valueOf(stid));
            Collection<Querytb> qr = res.readEntity(querygeneric);
            return qr;
        }else{
            return this.studentBean.getQueriesByStudentNames(studenttNms);
        }
    }   
            
    public String add()
    {
         int stdid = studentBean.studnetbyid(loggedIn);
        cl.addQuery(question, String.valueOf(stdid));
        
        //return "display.xhtml";    
        return "/StudentDashboard/querydisplay.xhtml";
    }
    
    public void delete(Querytb q)
    {
      int stdid = studentBean.studnetbyid(loggedIn);
        this.qid = q.getQid();
        Studenttb s = q.getStid();
        this.stid = s.getStid();
        cl.removeQuery(String.valueOf(qid), String.valueOf(stid));
    }
    
    public String edit(Querytb q)
    {
      int stdid = studentBean.studnetbyid(loggedIn);
       this.qid = q.getQid();
        Studenttb s = q.getStid();
        this.stid = s.getStid();
        this.question = q.getQuestion();
        return "/StudentDashboard/editquery.xhtml";
       //return "edit.xhtml";
    }
   
      public String editStudent(Querytb q)
    {
        int stdid = studentBean.studnetbyid(loggedIn);
       this.qid = q.getQid();
        Studenttb s = q.getStid();
        this.stid = s.getStid();
        this.question = q.getQuestion();
       //return "/StudentDashboard/editquery.xhtml";
       return "display.xhtml";
    }
     
     public String edit()
    {
        int stdid = studentBean.studnetbyid(loggedIn);
        cl.updateQuery(String.valueOf(qid), question, String.valueOf(stdid));
        return "/StudentDashboard/querydisplay.xhtml";
       //return "display.xhtml";
    }
}
