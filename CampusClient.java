/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:CampusgenericResource
 * [Campusgeneric]<br>
 * USAGE:
 * <pre>
 *        CampusClient client = new CampusClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author De
 */
public class CampusClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/FinalApp/webresources";

    public CampusClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("Campusgeneric");
    }

    public <T> T countappliedcompany(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countappliedcompany");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addAdmin(String adminName, String email, String password, String phoneno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addAdmin/{0}/{1}/{2}/{3}", new Object[]{adminName, email, password, phoneno})).request().post(null);
    }

    public void updateCompany(String cId, String cName, String Location, String salaryPackage, String NoofVacancy, String percentage10, String percentage12, String semaggregate, String passingdate, String jid, String deptid, String ptid, String sid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCompany/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{cId, cName, Location, salaryPackage, NoofVacancy, percentage10, percentage12, semaggregate, passingdate, jid, deptid, ptid, sid})).request().put(Entity.json(""));
    }

    public <T> T getAllNotifications(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllNotifications");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllPlacementCoordinates(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPlacementCoordinates");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countcompany(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countcompany");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllDepartments(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllJobs(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllJobs");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getNotificationById(Class<T> responseType, String stId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getNotificationById/{0}", new Object[]{stId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateAnswer(String anId, String answer, String qId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateAnswer/{0}/{1}/{2}", new Object[]{anId, answer, qId})).request().put(Entity.json(""));
    }

    public void removePlacementType(String pId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removePlacementType/{0}", new Object[]{pId})).request().delete();
    }

    public void addDepartment(String Dept_Name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addDepartment/{0}", new Object[]{Dept_Name})).request().post(null);
    }

    public void addNotification(String title, String description, String cId, String stId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addNotification/{0}/{1}/{2}/{3}", new Object[]{title, description, cId, stId})).request().post(null);
    }

    public <T> T countstudent(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countstudent");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addAppliedCompany(String stId, String cId, String applicationDate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addAppliedCompany/{0}/{1}/{2}", new Object[]{stId, cId, applicationDate})).request().post(null);
    }

    public void addPlacementType(String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPlacementType/{0}", new Object[]{type})).request().post(null);
    }

    public <T> T getAnswerOfQuery(Class<T> responseType, String qId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAnswerOfQuery/{0}", new Object[]{qId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getStudentByFirstNamae(Class<T> responseType, String firstname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getStudentByFirstNamae/{0}", new Object[]{firstname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getStudentByEmail(Class<T> responseType, String email) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getStudentByEmail/{0}", new Object[]{email}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countjob(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countjob");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeQuery(String qId, String stId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeQuery/{0}/{1}", new Object[]{qId, stId})).request().delete();
    }

    public <T> T countAdmin(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countAdmin");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllAnswers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllAnswers");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updatePlacement(String pId, String stId, String cId, String placementDate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePlacement/{0}/{1}/{2}/{3}", new Object[]{pId, stId, cId, placementDate})).request().put(Entity.json(""));
    }

    public void updateAdmin(String adminId, String adminName, String email, String password, String phoneno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateAdmin/{0}/{1}/{2}/{3}/{4}", new Object[]{adminId, adminName, email, password, phoneno})).request().put(Entity.json(""));
    }

    public void updateAppliedCompany(String acId, String stId, String cId, String applicationDate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateAppliedCompany/{0}/{1}/{2}/{3}", new Object[]{acId, stId, cId, applicationDate})).request().post(null);
    }

    public <T> T getAllStudents(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllStudents");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllAppliedCompanies(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllAppliedCompanies");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countnotification(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countnotification");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCompanyByName(Class<T> responseType, String cname) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCompanyByName/{0}", new Object[]{cname}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeCompany(String cId, String jid, String deptid, String ptid, String sid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeCompany/{0}/{1}/{2}/{3}/{4}", new Object[]{cId, jid, deptid, ptid, sid})).request().delete();
    }

    public void addQuery(String question, String stId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addQuery/{0}/{1}", new Object[]{question, stId})).request().post(null);
    }

    public void removeDepartment(String Dept_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeDepartment/{0}", new Object[]{Dept_id})).request().delete();
    }

    public <T> T countplacements(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countplacements");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addAnswer(String answer, String qId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addAnswer/{0}/{1}", new Object[]{answer, qId})).request().post(null);
    }

    public <T> T getStudentsOfPlacement(Class<T> responseType, String stId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getStudentsOfPlacement/{0}", new Object[]{stId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeAppliedCompany(String acId, String stId, String cId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateAppliedCompany/{0}/{1}/{2}", new Object[]{acId, stId, cId})).request().delete();
    }

    public <T> T getStudentByAddress(Class<T> responseType, String address) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getStudentByAddress/{0}", new Object[]{address}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllCompanies(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCompanies");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateNotification(String nId, String title, String description, String cId, String stId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateNotification/{0}/{1}/{2}/{3}/{4}", new Object[]{nId, title, description, cId, stId})).request().put(Entity.json(""));
    }

    public <T> T getCompanyByPackage(Class<T> responseType, String salarypackage) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCompanyByPackage/{0}", new Object[]{salarypackage}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCertificatesOfStudents(Class<T> responseType, String stId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAllCertificates/{0}", new Object[]{stId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countdepartment(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countdepartment");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllQueries(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllQueries");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCompanyByLocation(Class<T> responseType, String location) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCompanyByLocation/{0}", new Object[]{location}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getStudentOfDepartment(Class<T> responseType, String deptId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getStudentOfDepartment/{0}", new Object[]{deptId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllPlacements(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPlacements");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getDepartmentOfPlacementCoordinates(Class<T> responseType, String did) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getDepartmentOfPlacementCoordinates/{0}", new Object[]{did}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T countquery(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countquery");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCertificate(String title, String image, String stId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCertificate/{0}/{1}/{2}", new Object[]{title, image, stId})).request().post(null);
    }

    public void updatePlacementType(String pId, String type) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePlacementType/{0}/{1}", new Object[]{pId, type})).request().put(Entity.json(""));
    }

    public <T> T getAllAdmins(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllAdmins");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeStudent(String St_id, String Dept_id, String S_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeStudent/{0}/{1}/{2}", new Object[]{St_id, Dept_id, S_id})).request().delete();
    }

    public void addPlacementCoordinate(String name, String email, String password, String phoneNo, String deptId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPlacementCoordinate/{0}/{1}/{2}/{3}/{4}", new Object[]{name, email, password, phoneNo, deptId})).request().post(null);
    }

    public void removePlacementCoordinate(String pcId, String deptId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removePlacementCoordinate/{0}/{1}", new Object[]{pcId, deptId})).request().delete();
    }

    public void addStudent(String FirstName, String LastName, String Email, String Phoneno, String Password, String DOB, String Address, String Percentage10, String Percentage12, String Sem, String Dept_id, String S_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addStudent/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{FirstName, LastName, Email, Phoneno, Password, DOB, Address, Percentage10, Percentage12, Sem, Dept_id, S_id})).request().post(null);
    }

    public void addPlacement(String stId, String cId, String placementDate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPlacement/{0}/{1}/{2}", new Object[]{stId, cId, placementDate})).request().post(null);
    }

    public void removeNotification(String nId, String cId, String stId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeNotification/{0}/{1}/{2}", new Object[]{nId, cId, stId})).request().delete();
    }

    public <T> T countanswer(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countanswer");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateJob(String Title) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateJob/{0}", new Object[]{Title})).request().put(Entity.json(""));
    }

    public void updateStudent(String St_id, String FirstName, String LastName, String Email, String Phoneno, String Password, String DOB, String Address, String Percentage10, String Percentage12, String Sem, String Dept_id, String S_id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateStudent/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}/{12}", new Object[]{St_id, FirstName, LastName, Email, Phoneno, Password, DOB, Address, Percentage10, Percentage12, Sem, Dept_id, S_id})).request().put(Entity.json(""));
    }

    public <T> T getStudentByDOB(Class<T> responseType, String DOB) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getStudentByDOB/{0}", new Object[]{DOB}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getStudentsAppliedCompanies(Class<T> responseType, String stId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getStudentsAppliedCompanies/{0}", new Object[]{stId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addJob(String Title) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addJob/{0}", new Object[]{Title})).request().post(null);
    }

    public <T> T getQueriesOfStudent(Class<T> responseType, String stId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getQueriesOfStudent/{0}", new Object[]{stId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getNotificationOfCompany(Class<T> responseType, String cId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getNotificationOfCompany/{0}", new Object[]{cId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updatePlacementCoordinate(String pcId, String name, String email, String password, String phoneNo, String deptId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePlacementCoordinate/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{pcId, name, email, password, phoneNo, deptId})).request().put(Entity.json(""));
    }

    public <T> T countplacementcoordinator(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countplacementcoordinator");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateDepartment(String Dept_id, String Dept_Name) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateDepartment/{0}/{1}", new Object[]{Dept_id, Dept_Name})).request().put(Entity.json(""));
    }

    public <T> T getAllPlacementTypes(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllPlacementTypes");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateQuery(String qId, String question, String stId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateQuery/{0}/{1}/{2}", new Object[]{qId, question, stId})).request().put(Entity.json(""));
    }

    public void removeAnswer(String anId, String qId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeAnswer/{0}/{1}", new Object[]{anId, qId})).request().delete();
    }

    public <T> T getAllCertificates(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllCertificates");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeJob(String jId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeJob/{0}", new Object[]{jId})).request().delete();
    }

    public void addCompany(String cName, String Location, String salaryPackage, String NoofVacancy, String percentage10, String percentage12, String semaggregate, String passingdate, String jid, String deptid, String ptid, String sid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCompany/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{cName, Location, salaryPackage, NoofVacancy, percentage10, percentage12, semaggregate, passingdate, jid, deptid, ptid, sid})).request().post(null);
    }

    public void removeAdmin(String adminId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeAdmin/{0}", new Object[]{adminId})).request().delete();
    }

    public void removePlacement(String pId, String stId, String cId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removePlacement/{0}/{1}/{2}", new Object[]{pId, stId, cId})).request().delete();
    }

    public <T> T countuser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("countuser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getCompanyOfPlacement(Class<T> responseType, String cId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCompanyOfPlacement/{0}", new Object[]{cId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateCertificate(String crId, String title, String image, String stId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCertificate/{0}/{1}/{2}/{3}", new Object[]{crId, title, image, stId})).request().put(Entity.json(""));
    }

    public <T> T getDepartmentByName(Class<T> responseType, String deptName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getDepartmentByName/{0}", new Object[]{deptName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeCertificate(String crId, String stId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeCertificate/{0}/{1}", new Object[]{crId, stId})).request().delete();
    }

    public void close() {
        client.close();
    }
    
}
