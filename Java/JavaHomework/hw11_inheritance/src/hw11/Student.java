/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw11;

/**
 *
 * @author MarkPeng
 */
public class Student {
    private String name;
    private String id;
    private String department;

    public Student(String name, String id, String department) {
        this.name = name;
        this.id = id;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDepartment() {
        return department;
    }
    
}

class GraduateStudent extends Student{
    private String lab;
    private String advisor;
    
    public GraduateStudent(String name, String id, String department, String lab, String advisor) {
        super(name, id, department);
        this.lab = lab;
        this.advisor = advisor;
    }

    public String getLab() {
        return lab;
    }

    public String getAdvisor() {
        return advisor;
    }
}

class UndergraduateStudent extends Student{
    private String grade;
    private String stuClass;
    
    public UndergraduateStudent(String name, String id, String department, String grade, String stuClass) {
        super(name, id, department);
        this.grade = grade;
        this.stuClass = stuClass;
    }

    public String getGrade() {
        return grade;
    }

    public String getStuClass() {
        return stuClass;
    }
}

class MasterStudent extends GraduateStudent{
    
    private String system;
    private String thesis;
    
    public MasterStudent(String name, String id, String department, String lab, String advisor, String system, String thesis) {
        super(name, id, department, lab, advisor);
        this.system = system;
        this.thesis = thesis;
    }

    public String getSystem() {
        return system;
    }

    public String getThesis() {
        return thesis;
    }
    
   @Override
    public String toString(){
        return "****MasterStudent*****\n"+
                String.format("name: %s\n"
                                + "id: %s\n"
                                + "department: %s\n"
                                + "lab: %s\n"
                                + "advisor: %s\n"
                                + "system: %s\n"
                                + "thesis: %s\n",
                this.getName(),this.getId(),this.getDepartment(),this.getLab(),this.getAdvisor(),this.getSystem(),this.getThesis());
    }
}

class PhDStudent extends GraduateStudent{
    
    private String qualify;
    private String dissertation;
    
    public PhDStudent(String name, String id, String department, String lab, String advisor, String qualify, String dissertation) {
        super(name, id, department, lab, advisor);
        this.qualify = qualify;
        this.dissertation = dissertation;
    }

    public String getQualify() {
        return qualify;
    }

    public String getDissertation() {
        return dissertation;
    }
   
   @Override
    public String toString(){
        return "****PhDStudent*****\n"+
                String.format("name: %s\n"
                                + "id: %s\n"
                                + "department: %s\n"
                                + "lab: %s\n"
                                + "advisor: %s\n"
                                + "qualify: %s\n"
                                + "dissertation: %s\n",
                this.getName(),this.getId(),this.getDepartment(),this.getLab(),this.getAdvisor(),this.getQualify(),this.getDissertation());
    }
}

class FullTimeStudent extends UndergraduateStudent{
    private String club;
    private String role;

    public FullTimeStudent(String name, String id, String department, String grade, String stuClass, String club, String role) {
        super(name, id, department, grade, stuClass);
        this.club = club;
        this.role = role;
    }

    public String getClub() {
        return club;
    }

    public String getRole() {
        return role;
    }
    
    @Override
    public String toString(){
        return "****FullTimeStudent*****\n"+
                String.format("name: %s\n"
                                + "id: %s\n"
                                + "department: %s\n"
                                + "grade: %s\n"
                                + "stuClass: %s\n"
                                + "club: %s\n"
                                + "role: %s\n",
                this.getName(),this.getId(),this.getDepartment(),this.getGrade(),this.getStuClass(),this.getClub(),this.getRole());
    }
}

class PartTimeStudent extends UndergraduateStudent{
    private String company;
    private String possition;

    public PartTimeStudent(String name, String id, String department, String grade, String stuClass, String company, String possition) {
        super(name, id, department, grade, stuClass);
        this.company = company;
        this.possition = possition;
    }

    public String getCompany() {
        return company;
    }

    public String getPossition() {
        return possition;
    }
    
    @Override
    public String toString(){
        return "****FullTimeStudent*****\n"+
                String.format("name: %s\n"
                                + "id: %s\n"
                                + "department: %s\n"
                                + "grade: %s\n"
                                + "stuClass: %s\n"
                                + "company: %s\n"
                                + "possition: %s\n",
                this.getName(),this.getId(),this.getDepartment(),this.getGrade(),this.getStuClass(),this.getCompany(),this.getPossition());
    }
}

