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
public class StudentTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       MasterStudent masterStudent = new MasterStudent("David","M123456789","IM","A lab","Professor Lo","EMBA","Unfinished");
       PhDStudent phDStudent = new PhDStudent("Peter","D987654321","CS","B lab","Professor Lee","Passed","Unfinished");
       FullTimeStudent fullTimeStudent = new FullTimeStudent("Jack","B111111111","CE","Sophomore","Class A","Tennis club","Leader");
       PartTimeStudent partTimeStudent = new PartTimeStudent("Amy","B444444444","BA","Freshman","Class B","7-11","CEO");
        System.out.println(masterStudent);
        System.out.println(phDStudent);
        System.out.println(fullTimeStudent);
        System.out.println(partTimeStudent);
    }
    
}
