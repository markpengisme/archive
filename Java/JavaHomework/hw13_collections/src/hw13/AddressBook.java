/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw13;

/**
 *
 * @author MarkPeng
 */
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AddressBook {
    private Map<String, Contact> contacts = new TreeMap<String, Contact>();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scan = new Scanner(System.in);
        String input;
        do{
            showMenu();
            while(true){
                input = scan.nextLine();
                if(input.matches("[0-7]")) break;
                else System.out.println("Invalid input!");
            }

            switch (input){
                case "0":
                    break;
                case "1":
                    addressBook.addContact();
                    break;
                case "2":
                    addressBook.showContacts();
                    break;
                case "3":
                    addressBook.editContact();
                    break;
                case "4":
                    addressBook.deleteContact();
                    break;
                case "5":
                    addressBook.importContact();
                    break;
                case "6":
                    addressBook.exportContact();
                    break;
                case "7":
                    addressBook.clearList();
                    break;
                default:
                    break;
            }



        } while (!input.equals("0"));

    }

    public static void showMenu(){
        System.out.println("***** Address Book *****");
        System.out.println("1) Add a New Contact");
        System.out.println("2) Show Contact List");
        System.out.println("3) Edit the Contact");
        System.out.println("4) Delete the Contact");
        System.out.println("5) Import Contacts");
        System.out.println("6) Export Contact");
        System.out.println("7) Clear Contact List");
        System.out.println("0) Exit");
        System.out.println("************************");
        System.out.printf("Please enter a number in [1,2,3,4,5,6,7,0]: ");
    }

    public void addContact(){
        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.printf("Name: ");
        String name = scan.nextLine();
        System.out.printf("Phone: ");
        String phone = scan.nextLine();
        System.out.printf("E-mail: ");
        String email = scan.nextLine();
        System.out.printf("Birthday(yyyy/mm/dd): ");
        String birthday = scan.nextLine();

        if(isValidFormat(name, phone, email, birthday)){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            Date date = null;
            try {
                date = sdf.parse(birthday);
                contacts.put(name, new Contact(name, date, phone, email));
                System.out.println("The contact has been added.\n");
            } catch (ParseException e){
                e.printStackTrace();
            }
        }
    }

    public void showContacts(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println();
        System.out.println("Name\tBirthday\tPhone\t\tEmail");
        System.out.println("-----------------------------------------------");
        for(Map.Entry<String, Contact> contact : contacts.entrySet()){
            System.out.printf("%s\t%s\t%s\t%s\n", contact.getValue().getName(),
                    sdf.format(contact.getValue().getBirthday()), contact.getValue().getPhone(), contact.getValue().getEmail());
        }
        System.out.println();
    }

    public void editContact(){
        System.out.println("Please enter the name of contact that you want to edit.");
        System.out.printf("Name: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        if(contacts.containsKey(name)){
            System.out.printf("Phone: ");
            String phone = scan.nextLine();
            System.out.printf("E-mail: ");
            String email = scan.nextLine();
            System.out.printf("Birthday(yyyy/mm/dd): ");
            String birthday = scan.nextLine();

            if(isValidFormat(name, phone, email, birthday)){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                try {
                    contacts.get(name).setPhone(phone);
                    contacts.get(name).setEmail(email);
                    contacts.get(name).setBirthday(sdf.parse(birthday));
                } catch (ParseException pe){
                    pe.printStackTrace();
                }
                System.out.println("The contact has been changed.\n");
            }
        } else {
            System.out.println("Not found!\n");
        }
    }

    public void deleteContact(){
        System.out.println();
        System.out.println("Please enter the name of contact that you want to delete.");
        System.out.printf("Name: ");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        if(contacts.containsKey(name)){
            contacts.remove(name);
            System.out.println("The contact has been deleted.\n");
        } else {
            System.out.println("Not found!\n");
        }
    }

    public void importContact(){
        String line;
        String[] index;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            
            BufferedReader br = new BufferedReader(new FileReader(new File("data.txt")));
            while (br.ready()){
                line = br.readLine();
                index = line.split("\t");
                try {
                    contacts.put(index[0], new Contact(index[0], sdf.parse(index[1]), index[2], index[3]));
                } catch (ParseException pe){
                    pe.printStackTrace();
                }
            }
            System.out.println();
            System.out.println("All of the contacts have been imported.\n");
            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void exportContact(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("contacts.txt")));

            for(Map.Entry<String, Contact> contact : contacts.entrySet()){
                bw.write(contact.getValue().getName() + '\t' + sdf.format(contact.getValue().getBirthday()) + '\t' + contact.getValue().getEmail() + '\t' + contact.getValue().getPhone());
                bw.newLine();
            }
            System.out.println();
            System.out.println("The contact list has been exported.\n");
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void clearList(){
        contacts.clear();
        System.out.println();
        System.out.println("The contact list is empty.\n");
    }

    public static boolean isValidFormat(String name, String phone, String email, String birthday){

        if(!name.matches("^[a-zA-z]+$")){
            System.out.println("Invalid name format!\n");
            return false;
        }
        if(!phone.matches("^09[0-9]{2}-[0-9]{3}-[0-9]{3}$")){
            System.out.println("Invalid phone format!\n");
            return false;
        }
        if(!email.matches("^[\\w-]+([\\.][ \\w-]+)*@[\\w-]+([\\.][ \\w-]+)*$")){
            System.out.println("Invalid email format!\n");
            return false;
        }
        if(!birthday.matches("^((19|20)?[0-9]{2}/(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01]))$")){
            System.out.println("Invalid birthday format!\n");
            return false;
        }

        return true;
    }
}