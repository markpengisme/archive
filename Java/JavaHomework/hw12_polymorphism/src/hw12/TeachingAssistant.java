/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw12;

/**
 *
 * @author MarkPeng
 */
public class TeachingAssistant extends Student implements Work{

    private String department;
    private double salary;
    private String course;

    TeachingAssistant(String name, String major, String degree, String department, double salary, String course) {
        super(name, major, degree);
        this.department = department;
        this.salary = salary;
        this.course = course;
    }

    @Override
    public String getDepartment() {
        return this.department;
    }

    @Override
    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "TA name = "+this.getName()+",\nwho studies in "+this.getMajor()+",\nwhose degree is "+this.getDegree()+",\nwho works in "+this.getDepartment()+",\nwhose salary is "+this.getSalary()+".\n";
    }
}
