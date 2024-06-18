/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author glory
 */
public class CashAccount {
    private String cashId;
    private String name;
    private String date;
    private String cashType;
    private String description;
    private int amount;

    public CashAccount(String cashId, String name, String date, String cashType, String description, int amount) {
        this.cashId = cashId;
        this.name = name;
        this.date = date;
        this.cashType = cashType;
        this.description = description;
        this.amount = amount;
    }

    public String getCashId() {
        return cashId;
    }

    public void setCashId(String cashId) {
        this.cashId = cashId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCashType() {
        return cashType;
    }

    public void setCashType(String cashType) {
        this.cashType = cashType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "CashAccount{" + "cashId=" + cashId + ", name=" + name + ", date=" + date + ", cashType=" + cashType + ", description=" + description + ", amount=" + amount + '}';
    }
}
