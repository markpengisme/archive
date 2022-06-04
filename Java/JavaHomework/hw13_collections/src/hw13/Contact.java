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
import java.util.Date;

public class Contact implements Comparable<Contact> {
    private String name;
    private Date birthday;
    private String phone;
    private String email;


    public Contact(String name, Date birthday, String phone, String email) {
        this.name = name;
        this.birthday = birthday;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int compareTo(Contact other) {
        return (this.name.compareTo(other.name));
    }
}
