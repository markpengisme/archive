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
public class PersonTest {

    public static void main(String[] args) {
        Person[] persons = new Person[3];
        persons[0]= new Staff("Alice","BA",22000);
        persons[1]= new Student("Bob","CS","Master");
        persons[2]= new TeachingAssistant("Alex","MI","PhD","MI",3000.0,"");
        
        for(Person p : persons){
            System.out.println(p);
        }   
    }
}