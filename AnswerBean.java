/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbean;

import client.CampusClient;
import ejb.CoordinatorBeanLocal;
import entity.Answertb;
import entity.Companytb;
import entity.Notificationtb;
import entity.Querytb;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author De
 */
@Named(value = "answerBean")
@ApplicationScoped
public class AnswerBean {

    @EJB
    private CoordinatorBeanLocal coordinatorBean;

  
    Response res;
    CampusClient cl;
    Collection<Querytb> queryList;
    GenericType<Collection<Querytb>> querygeneric;
    Collection<Answertb> answerList;
    GenericType<Collection<Answertb>> answergeneric;
    Collection<Answertb> answerSearchCollection;
    
    int anid,qid,maxResults;
    String ans;
    
    Answertb answer = new Answertb();

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

    public void setQueryList(Collection<Querytb> queryList) {
        this.queryList = queryList;
    }

    public GenericType<Collection<Querytb>> getQuerygeneric() {
        return querygeneric;
    }

    public void setQuerygeneric(GenericType<Collection<Querytb>> querygeneric) {
        this.querygeneric = querygeneric;
    }

    public Collection<Answertb> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(Collection<Answertb> answerList) {
        this.answerList = answerList;
    }

    public GenericType<Collection<Answertb>> getAnswergeneric() {
        return answergeneric;
    }

    public void setAnswergeneric(GenericType<Collection<Answertb>> answergeneric) {
        this.answergeneric = answergeneric;
    }

    public int getAnid() {
        return anid;
    }

    public void setAnid(int anid) {
        this.anid = anid;
    }

    public int getQid() {
        return qid;
    }

    public void setQid(int qid) {
        this.qid = qid;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public Answertb getAnswer() {
        return answer;
    }

    public void setAnswer(Answertb answer) {
        this.answer = answer;
    }

    public Collection<Answertb> getAnswerSearchCollection() {
        return answerSearchCollection;
    }

    public void setAnswerSearchCollection(Collection<Answertb> answerSearchCollection) {
        this.answerSearchCollection = answerSearchCollection;
    }

    public int getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(int maxResults) {
        this.maxResults = maxResults;
    }
    
    public AnswerBean() {
        cl = new CampusClient();
    }
    
     @PostConstruct
    public void init()
    {
        cl = new CampusClient();
        
        querygeneric = new GenericType<Collection<Querytb>>(){};
        res = cl.getAllQueries(Response.class);
        this.queryList = res.readEntity(querygeneric);
     
      this.maxResults = coordinatorBean.countanswer();
    }
    
    
    public Collection<Querytb> getQueryData()
    {
        querygeneric = new GenericType<Collection<Querytb>>(){};
        res = cl.getAllQueries(Response.class);
        return res.readEntity(querygeneric);      
    }
    
    public String getQueryId()
    {
        answergeneric = new GenericType<Collection<Answertb>>(){};
        res = cl.getAnswerOfQuery(Response.class, String.valueOf(qid));
        answerSearchCollection = res.readEntity(answergeneric);
        return "displayByQuery.xhtml?faces-redirect=true";
    }
     
     public Collection<Answertb> getAll()
    {
            answergeneric = new GenericType<Collection<Answertb>>(){};
            res = cl.getAllAnswers(Response.class);
            Collection<Answertb> an = res.readEntity(answergeneric);
            return an;
    }            
            
    public String add()
    {
        cl.addAnswer(ans,String.valueOf(qid));
        return "/CoordinatorDashboard/answerdisplay.xhtml";    
    }
    
    public void delete(Answertb a)
    {
        this.anid = a.getAnid();
        Querytb q = a.getQid();
        this.qid = q.getQid();
        cl.removeAnswer(String.valueOf(anid),String.valueOf(qid));
    }
    
    public String edit(Answertb a)
    {
         this.anid = a.getAnid();
        Querytb q = a.getQid();
        this.qid = q.getQid();
        this.ans = a.getAnsDesc();
       return "/CoordinatorDashboard/editanswer.xhtml";
      //return "edit.xhtml";
    }
   
     public String edit()
    {
        cl.updateAnswer(String.valueOf(anid),ans,String.valueOf(qid));
        return "/CoordinatorDashboard/answerdisplay.xhtml";
    }
   
}
