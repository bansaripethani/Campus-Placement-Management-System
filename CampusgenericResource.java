/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.AdminBeanLocal;
import ejb.CoordinatorBeanLocal;
import ejb.StudentBeanLocal;
import entity.Admintb;
import entity.Answertb;
import entity.Appliedcompanytb;
import entity.Certificatetb;
import entity.Companytb;
import entity.Departmenttb;
import entity.Jobtb;
import entity.Notificationtb;
import entity.Placementcoordinatetb;
import entity.Placementtb;
import entity.Placementtypetb;
import entity.Querytb;
import entity.Statustb;
import entity.Studenttb;
import java.util.Collection;
import java.util.Date;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author De
 */
@DeclareRoles({"Admin","Coordinator"})

@Path("Campusgeneric")
public class CampusgenericResource {

    
      @EJB CoordinatorBeanLocal db;
      @EJB AdminBeanLocal ad;
      @EJB StudentBeanLocal sd;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CampusgenericResource
     */
    public CampusgenericResource() {
    }

    /**
     * Retrieves representation of an instance of rest.CampusgenericResource
     * @return an instance of java.lang.String
     */
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Departmenttb> getAllDepartments(){
      return db.getAllDepartments();
    }
    
    @POST
    @Path("addDepartment/{Dept_Name}")
     public void addDepartment(@PathParam("Dept_Name")String Dept_Name) {
         db.addDepartment(Dept_Name);
     }

   @PUT
   @Path("updateDepartment/{Dept_id}/{Dept_Name}")
    public void updateDepartment(@PathParam("Dept_id")Integer Dept_id,@PathParam("Dept_Name")String Dept_Name) {
     db.updateDepartment(Dept_id, Dept_Name);
    }
    
    @DELETE
    @Path("removeDepartment/{Dept_id}")
    public void removeDepartment(@PathParam("Dept_id")Integer Dept_id) {
     db.removeDepartment(Dept_id);
    }
       
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getDepartmentByName/{deptName}")
    public Collection<Departmenttb> getDepartmentByName(@PathParam("deptName")String deptName) {
        return db.getDepartmentByName(deptName);
    }
  
    //===========Student============
    @POST
    @Path("addStudent/{FirstName}/{LastName}/{Email}/{Phoneno}/{Password}/{DOB}/{Address}/{Percentage10}/{Percentage12}/{Sem}/{Dept_id}/{S_id}")
    public void addStudent(@PathParam("FirstName")String FirstName,@PathParam("LastName")String LastName,@PathParam("Email")String Email,@PathParam("Phoneno")Integer Phoneno,@PathParam("Password")String Password,@PathParam("DOB")Date DOB,@PathParam("Address")String Address,
            @PathParam("Percentage10")String Percentage10,@PathParam("Percentage12")String Percentage12,@PathParam("Sem")String Sem,@PathParam("Dept_id")Integer Dept_id,
            @PathParam("S_id")Integer S_id) {
            sd.addStudent(FirstName, LastName, Email, Phoneno, Password, DOB, Address, Percentage10, Percentage12, Sem, Dept_id, S_id);
    }

     @PUT
     @Path("updateStudent/{St_id}/{FirstName}/{LastName}/{Email}/{Phoneno}/{Password}/{DOB}/{Address}/{Percentage10}/{Percentage12}/{Sem}/{Dept_id}/{S_id}")
    public void updateStudent(@PathParam("St_id")Integer St_id,@PathParam("FirstName")String FirstName,@PathParam("LastName")String LastName,@PathParam("Email")String Email,@PathParam("Phoneno")Integer Phoneno,@PathParam("Password")String Password,@PathParam("DOB")Date DOB,@PathParam("Address")String Address,
            @PathParam("Percentage10")String Percentage10,@PathParam("Percentage12")String Percentage12,@PathParam("Sem")String Sem,@PathParam("Dept_id")Integer Dept_id,
            @PathParam("S_id")Integer S_id) {
     sd.updateStudent(St_id, FirstName, LastName, Email, Phoneno, Password, DOB, Address, Percentage10, Percentage12, Sem, Dept_id, S_id);
    }

    @DELETE
    @Path("removeStudent/{St_id}/{Dept_id}/{S_id}")
    public void removeStudent(@PathParam("St_id")Integer St_id,@PathParam("Dept_id")Integer Dept_id,@PathParam("S_id")Integer S_id) {
        sd.removeStudent(St_id, Dept_id, S_id);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllStudents")
    public Collection<Studenttb> getAllStudents(){
        return db.getAllStudents();
    }
    
////    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getStudentOfDepartment/{deptId}")   
    public Collection<Studenttb> getStudentOfDepartment(@PathParam("deptId")Integer deptId){
       return db.getStudentOfDepartment(deptId);
    }   
//    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getStudentByFirstNamae/{firstname}")   
    public Collection<Studenttb> getStudentByFirstNamae(@PathParam("firstname")String firstname)
    {
        return db.getStudentByFirstNamae(firstname);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getStudentByDOB/{DOB}")   
    public Collection<Studenttb> getStudentByDOB(@PathParam("DOB")Date DOB){
        return db.getStudentByDOB(DOB);
    }
////    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getStudentByEmail/{email}")   
    public Collection<Studenttb> getStudentByEmail(@PathParam("email")String email){
        return db.getStudentByEmail(email);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getStudentByAddress/{address}") 
    public Collection<Studenttb> getStudentByAddress(@PathParam("address")String address){
        return db.getStudentByAddress(address);
    }

    //==============Company==========
    @GET
    @Path("getAllCompanies")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Companytb> getAllCompanies(){
        return db.getAllCompanies();
    }
  
    @POST
    @Path("addCompany/{cName}/{Location}/{salaryPackage}/{NoofVacancy}/{percentage10}/{percentage12}/{semaggregate}/{passingdate}/{jid}/{deptid}/{ptid}/{sid}")  
    public void addCompany(@PathParam("cName")String cName,@PathParam("Location")String Location, @PathParam("salaryPackage")Integer salaryPackage,@PathParam("NoofVacancy")Integer NoofVacancy, @PathParam("percentage10")String percentage10, @PathParam("percentage12")String percentage12, @PathParam("semaggregate")String semaggregate, @PathParam("passingdate")Date passingdate, @PathParam("jid")Integer jid, @PathParam("deptid")Integer deptid, @PathParam("ptid")Integer ptid,@PathParam("sid")Integer sid) {
      db.addCompany(cName, Location, salaryPackage, NoofVacancy, percentage10, percentage12, semaggregate, passingdate, jid, deptid, ptid, sid);
    }
//    
    @PUT
    @Path("updateCompany/{cId}/{cName}/{Location}/{salaryPackage}/{NoofVacancy}/{percentage10}/{percentage12}/{semaggregate}/{passingdate}/{jid}/{deptid}/{ptid}/{sid}")  
    public void updateCompany(@PathParam("cId")Integer cId,@PathParam("cName")String cName,@PathParam("Location")String Location, @PathParam("salaryPackage")Integer salaryPackage,@PathParam("NoofVacancy")Integer NoofVacancy, @PathParam("percentage10")String percentage10, @PathParam("percentage12")String percentage12, @PathParam("semaggregate")String semaggregate, @PathParam("passingdate")Date passingdate, @PathParam("jid")Integer jid, @PathParam("deptid")Integer deptid, @PathParam("ptid")Integer ptid,@PathParam("sid")Integer sid){
        db.updateCompany(cId, cName, Location, salaryPackage, NoofVacancy, percentage10, percentage12, semaggregate, passingdate, jid, deptid, ptid, sid);
    }
   
    @DELETE
    @Path("removeCompany/{cId}/{jid}/{deptid}/{ptid}/{sid}")
     public void removeCompany(@PathParam("cId")Integer cId,@PathParam("jid")Integer jid,@PathParam("deptid")Integer deptid,@PathParam("ptid")Integer ptid,@PathParam("sid")Integer sid){
        db.removeCompany(cId, jid, deptid, ptid, sid);
    }
     
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCompanyByName/{cname}")
    public Collection<Companytb> getCompanyByName(@PathParam("cname")String cname){
        return sd.getCompanyByName(cname);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCompanyByLocation/{location}")
    public Collection<Companytb> getCompanyByLocation(@PathParam("location")String location){
        return sd.getCompanyByLocation(location);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCompanyByPackage/{salarypackage}")
    public Collection<Companytb> getCompanyByPackage(@PathParam("salarypackage")Integer salarypackage){
        return sd.getCompanyByPackage(salarypackage);
    }
//    
////    //===========Notificationtb===================
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllNotifications")
    public Collection<Notificationtb> getAllNotifications(){
        return db.getAllNotifications();
    }
//    
    @POST
    @Path("addNotification/{title}/{description}/{cId}/{stId}")
    public void addNotification(@PathParam("title")String title,@PathParam("description")String description,@PathParam("cId")Integer cId,@PathParam("stId")Integer stId){
        db.addNotification(title, description, cId, stId);
    }
////    
    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    @Path("updateNotification/{nId}/{title}/{description}/{cId}/{stId}")
    public void updateNotification(@PathParam("nId")Integer nId,@PathParam("title")String title,@PathParam("description")String description,@PathParam("cId")Integer cId,@PathParam("stId")Integer stId){
        db.updateNotification(nId, cId, title, description, stId);
    }
//
    @DELETE
    @Path("removeNotification/{nId}/{cId}/{stId}")
    public void removeNotification(@PathParam("nId")Integer nId,@PathParam("cId")Integer cId,@PathParam("stId")Integer stId){
        db.removeNotification(nId, cId, stId);
   }
        
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getNotificationOfCompany/{cId}")
    public Collection<Notificationtb> getNotificationOfCompany(@PathParam("cId")Integer cId){
        return db.getNotificationOfCompany(cId);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getNotificationById/{stId}")
    public Collection<Notificationtb> getNotificationById(@PathParam("stId")Integer stId){
        return sd.getNotificationById(stId);
    }

    

////===========Certificate===================
//    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllCertificates")
    public Collection<Certificatetb> getAllCertificates(){
        return db.getAllCertificates();
    }
    
    @POST
    @Path("addCertificate/{title}/{image}/{stId}")
    public void addCertificate(@PathParam("title")String title,@PathParam("image")String image,@PathParam("stId")Integer stId){
        sd.addCertificate(title, image, stId);
    }
    
    @PUT
    @Path("updateCertificate/{crId}/{title}/{image}/{stId}")
    public void updateCertificate(@PathParam("crId")Integer crId,@PathParam("title")String title,@PathParam("image")String image,@PathParam("stId")Integer stId){
        sd.updateCertificate(crId, title, image, stId);
    }
    
    @DELETE
    @Path("removeCertificate/{crId}/{stId}")
    public void removeCertificate(@PathParam("crId")Integer crId,@PathParam("stId")Integer stId){
        sd.removeCertificate(crId, stId);
    }
    
////    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllCertificates/{stId}")
    public Collection<Certificatetb> getCertificatesOfStudents(@PathParam("stId")Integer stId){
        return db.getCertificatesOfStudents(stId);
    }
////    
//     //=========Query==========   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllQueries")
    public Collection<Querytb> getAllQueries(){
        return db.getAllQueries();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getQueriesOfStudent/{stId}")
    public Collection<Querytb> getQueriesOfStudent(@PathParam("stId")Integer stId){
        return sd.getQueriesOfStudent(stId);
    }
    
    @POST
    @Path("addQuery/{question}/{stId}")
    public void addQuery(@PathParam("question")String question,@PathParam("stId")Integer stId){
        sd.addQuery(question, stId);
    }
    
    @PUT
    @Path("updateQuery/{qId}/{question}/{stId}")
    public  void updateQuery(@PathParam("qId")Integer qId,@PathParam("question")String question,@PathParam("stId")Integer stId){
        sd.updateQuery(qId, question, stId);
    }
    
    @DELETE
    @Path("removeQuery/{qId}/{stId}")
    public void removeQuery(@PathParam("qId")Integer qId,@PathParam("stId")Integer stId){
        sd.removeQuery(qId, stId);
    }

//    //==========Answer=======
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllAnswers")
    public Collection<Answertb> getAllAnswers(){
        return db.getAllAnswers();
    }
//    
    @POST
    @Path("addAnswer/{answer}/{qId}")
    public void addAnswer(@PathParam("answer")String answer,@PathParam("qId")Integer qId){
        db.addAnswer(answer, qId);
    }
//    
    @PUT
    @Path("updateAnswer/{anId}/{answer}/{qId}")
    public void updateAnswer(@PathParam("anId")Integer anId,@PathParam("answer")String answer,@PathParam("qId")Integer qId){
        db.updateAnswer(anId, answer, qId);
    }
//    
    @DELETE
    @Path("removeAnswer/{anId}/{qId}")
    public void removeAnswer(@PathParam("anId")Integer anId,@PathParam("qId")Integer qId){
        db.removeAnswer(anId, qId);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAnswerOfQuery/{qId}")
    public Collection<Answertb> getAnswerOfQuery(@PathParam("qId")Integer qId){
        return sd.getAnswerOfQuery(qId);
    }
    
//    //===========Placementtb===================
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllPlacements")
    public Collection<Placementtb> getAllPlacements(){
        return db.getAllPlacements();
    }
            
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getStudentsOfPlacement/{stId}")
    public Collection<Placementtb> getStudentsOfPlacement(@PathParam("stId")Integer stId){
        return db.getStudentsOfPlacement(stId);
    }
//    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCompanyOfPlacement/{cId}")
    public Collection<Placementtb> getCompanyOfPlacement(@PathParam("cId")Integer cId){
        return  db.getCompanyOfPlacement(cId);
    }
    
    @RolesAllowed("Coordinator")
    @POST
    @Path("addPlacement/{stId}/{cId}/{placementDate}")
    public void addPlacement(@PathParam("stId")Integer stId,@PathParam("cId")Integer cId,@PathParam("placementDate")Date placementDate){
        db.addPlacement(stId, cId, placementDate);
    }
//   
    @RolesAllowed("Coordinator")
    @PUT
    @Path("updatePlacement/{pId}/{stId}/{cId}/{placementDate}")
    public void updatePlacement(@PathParam("pId")Integer pId,@PathParam("stId")Integer stId,@PathParam("cId")Integer cId,@PathParam("placementDate")Date placementDate){
       db.updatePlacement(pId, stId, cId, placementDate);
    }
    
    @RolesAllowed("Coordinator")
    @DELETE
    @Path("removePlacement/{pId}/{stId}/{cId}")
    public void removePlacement(@PathParam("pId")Integer pId,@PathParam("stId")Integer stId,@PathParam("cId")Integer cId){
        db.removePlacement(pId, stId, cId);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllAppliedCompanies")
    public Collection<Appliedcompanytb> getAllAppliedCompanies(){
        return db.getAllAppliedCompanies();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getStudentsAppliedCompanies/{stId}")
    public Collection<Appliedcompanytb> getStudentsAppliedCompanies(@PathParam("stId")Integer stId){
        return sd.getStudentsAppliedCompanies(stId);
    }
    
    @POST
    @Path("addAppliedCompany/{stId}/{cId}/{applicationDate}")
    public void addAppliedCompany(@PathParam("stId")Integer stId,@PathParam("cId")Integer cId,@PathParam("applicationDate")Date applicationDate){
        sd.addAppliedCompany(stId, cId, applicationDate);
    }
    
    @POST
    @Path("updateAppliedCompany/{acId}/{stId}/{cId}/{applicationDate}")
    public void updateAppliedCompany(@PathParam("acId")Integer acId,@PathParam("stId")Integer stId,@PathParam("cId")Integer cId,@PathParam("applicationDate")Date applicationDate){
        sd.updateAppliedCompany(acId, stId, cId, applicationDate);
    }
    
    @DELETE
    @Path("updateAppliedCompany/{acId}/{stId}/{cId}")
    public void removeAppliedCompany(@PathParam("acId")Integer acId,@PathParam("stId")Integer stId,@PathParam("cId")Integer cId){
        sd.removeAppliedCompany(acId, stId, cId);
    }
    
    //=============Admin============
    @RolesAllowed("Admin")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllAdmins")
    public Collection<Admintb> getAllAdmins(){
        return ad.getAllAdmins();
    }
    
    @RolesAllowed("Admin")
    @POST
    @Path("addAdmin/{adminName}/{email}/{password}/{phoneno}")
    public void addAdmin(@PathParam("adminName")String adminName,@PathParam("email")String email,@PathParam("password")String password,@PathParam("phoneno")Integer phoneno){
        ad.addAdmin(adminName, email, password, phoneno);
    }
    
    @PUT
    @Path("updateAdmin/{adminId}/{adminName}/{email}/{password}/{phoneno}")
    public void updateAdmin(@PathParam("adminId")Integer adminId,@PathParam("adminName")String adminName,@PathParam("email")String email,@PathParam("password")String password,@PathParam("phoneno")Integer phoneno){
        ad.updateAdmin(adminId, adminName, email, password, phoneno);
    }
    
    @DELETE
    @Path("removeAdmin/{adminId}")
    public void removeAdmin(@PathParam("adminId")Integer adminId){
        ad.removeAdmin(adminId);
    }
    
     // =============JOBtb===========
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllJobs")   
    public Collection<Jobtb> getAllJobs(){
        return db.getAllJobs();
    }
    
    @POST
    @Path("addJob/{Title}")
    public void addJob(@PathParam("Title")String Title){
        db.addJob(Title);
    }
    
    @PUT
    @Path("updateJob/{Title}")
    public void updateJob(@PathParam("jId")Integer jId,@PathParam("Title")String Title){
        db.updateJob(jId, Title);
    }
    
    @DELETE
    @Path("removeJob/{jId}")
    public void removeJob(@PathParam("jId")Integer jId){
        db.removeJob(jId);
    }
    
    //=========Placementtype==========
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllPlacementTypes")
    public Collection<Placementtypetb> getAllPlacementTypes(){
        return db.getAllPlacementTypes();
    }
    
    @POST
    @Path("addPlacementType/{type}")
    public void addPlacementType(@PathParam("type")String type){
        db.addPlacementType(type);
    }
    
    @PUT
    @Path("updatePlacementType/{pId}/{type}")
    public void updatePlacementType(@PathParam("pId")Integer pId,@PathParam("type")String type){
        db.updatePlacementType(pId, type);
    }
    
    @DELETE
    @Path("removePlacementType/{pId}")
    public void removePlacementType(@PathParam("pId")Integer pId){
        db.removePlacementType(pId);
    }
    
    @RolesAllowed("Coordinator")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllPlacementCoordinates")
    public Collection<Placementcoordinatetb> getAllPlacementCoordinates(){
     return db.getAllPlacementCoordinates();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getDepartmentOfPlacementCoordinates/{did}")
    public Collection<Placementcoordinatetb> getDepartmentOfPlacementCoordinates(@PathParam("did")Integer did){
        return db.getDepartmentOfPlacementCoordinates(did);
    }
    
    @POST
    @Path("addPlacementCoordinate/{name}/{email}/{password}/{phoneNo}/{deptId}")
    public void addPlacementCoordinate(@PathParam("name")String name,@PathParam("email")String email,@PathParam("password")String password,@PathParam("phoneNo")Integer phoneNo,@PathParam("deptId")Integer deptId){
        db.addPlacementCoordinate(name, email, password, phoneNo, deptId);
    }
    
    @PUT
    @Path("updatePlacementCoordinate/{pcId}/{name}/{email}/{password}/{phoneNo}/{deptId}")
    public void updatePlacementCoordinate(@PathParam("pcId")Integer pcId,@PathParam("name")String name,@PathParam("email")String email,@PathParam("password")String password,@PathParam("phoneNo")Integer phoneNo,@PathParam("deptId")Integer deptId){
        db.updatePlacementCoordinate(pcId, name, email, password, phoneNo, deptId);
    }
    
    @DELETE
    @Path("removePlacementCoordinate/{pcId}/{deptId}")
    public void removePlacementCoordinate(@PathParam("pcId")Integer pcId,@PathParam("deptId")Integer deptId){
        db.removePlacementCoordinate(pcId, deptId);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countstudent")
    public int countstudent(){
        return sd.countstudent();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countplacements")
    public int countplacements(){
       return db.countplacements();
    }
   
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countnotification")
   public int countnotification(){
       return db.countnotification();
   }
      
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countjob")
    public int countjob(){
        return db.countjob();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countdepartment")
    public int countdepartment(){
        return db.countdepartment();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countcompany")
    public int countcompany(){
        return db.countcompany();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countappliedcompany")
    public int countappliedcompany(){
        return db.countappliedcompany();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countanswer")
    public int countanswer(){
        return db.countanswer();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countAdmin")
    public int countAdmin(){
        return db.countAdmin();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countplacementcoordinator")
    public int countplacementcoordinator(){
        return db.countplacementcoordinator();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countquery")
    public int countquery(){
        return db.countquery();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("countuser")
    public int countuser(){
        return db.countuser();
    }
}
