/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntust.mis.oo;

/**
 *
 * @author MarkPeng
 */
public class Person {
    private String name;
    private String phoneNum;
    private City city;

    public Person(String Name, String Phone, City City) {
        this.name = Name;
        this.phoneNum = Phone;
        this.city = City;
    }

    public String toString(){
        String output = String.format("%s-%s-%s", this.name, this.phoneNum, this.city);
        return output;
    }
}