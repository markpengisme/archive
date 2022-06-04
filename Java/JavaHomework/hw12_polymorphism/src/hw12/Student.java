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
public class Student extends Person implements Study {
    private String major;
    private String degree;
    
    Student(String name, String major, String degree){
        super(name);
        this.major=major;
        this.degree=degree;
    }

    @Override
    public String getMajor() {
        return this.major;
    }

    @Override
    public void setMajor(String major) {
        this.major=major;
    }

    @Override
    public String getDegree() {
        return this.degree;
    }

    @Override
    public void setDegree(String degree) {
        this.degree=degree;
    }
    
        @Override
    public String toString() {
        return "Student name = "+this.getName()+",\nwho studies in "+this.getMajor()+",\nwhose degree is "+this.getDegree()+".\n";
    }
    
}
