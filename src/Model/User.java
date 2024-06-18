/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author glory
 */
public class User {

    private String accountId;
    private String password;
    private String name;
    private String gender;
    private String phone;
    private String email;
    private int balance;

    public User(String accountId, String password, String name, String gender, String phone, String email, int balance) {
        this.accountId = accountId;
        this.password = password;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.balance = balance;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" + "accountId=" + accountId + ", password=" + password + ", name=" + name + ", gender=" + gender + ", phone=" + phone + ", email=" + email + ", balance=" + balance + '}';
    }

}