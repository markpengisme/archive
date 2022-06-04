/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ntust.mis.test;

/**
 *
 * @author MarkPeng
 */

import ntust.mis.oo.*;
import java.util.Scanner;
        
public class DeliveryTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person sender;
        Person receiver;
        Goods good;
        String name;
        String phoneNum;
        Double weight;
        Type type;
        City city;
        String c;
        do{

            System.out.println("Please enter the sender's name");
            name = scanner.next();
            System.out.println("Please enter the sender's phone");
            phoneNum = scanner.next();
            System.out.println("Please enter the sender's address(1~5)");
            System.out.println("1.TAIPEI,2.TAICHUNG,3.KAOHSIUNG,4.HSINCHU,5.HUALIEN;");
            city = City.getCity(scanner.next());
            sender = new Person(name, phoneNum, city);


            System.out.println("Please enter the reveiver's name");
            name = scanner.next();
            System.out.println("Please enter the reveiver's phone");
            phoneNum = scanner.next();
            System.out.println("Please enter the reveiver's address(1~5)");
            System.out.println("1.TAIPEI,2.TAICHUNG,3.KAOHSIUNG,4.HSINCHU,5.HUALIEN:");
            city = City.getCity(scanner.next());
            receiver = new Person(name, phoneNum, city);


            System.out.println("Please enter the good's name");
            name = scanner.next();
            System.out.println("Please enter the good's weight");
            weight = Double.parseDouble(scanner.next()); 
            System.out.println("Please enter the good's type(1~2)");
            System.out.println("1.PERSONAL,2.BUSSINESS:");
            type = Type.getType(scanner.next());
            good = new Goods(name, weight, type);
            Delivery delivery = new Delivery(sender,receiver,good);
            delivery.send();
            System.out.println("");
            System.out.println(delivery.toString());
            if(Delivery.getAvailableWeight()==0){
                System.out.println("Out of available weight,88");
                break;
            }
            System.out.println("Do you want to continute?(y/n)");
            c = scanner.next();
            
            
        }while(c.equals("y"));
    }
}