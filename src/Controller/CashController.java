/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DBConnection;
import Model.CashAccount;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author glory
 */
public class CashController implements CrudOperations<CashAccount> {

    @Override
    public void insert(CashAccount cash) {
        String query = "INSERT INTO cash (cashId, name, date, cashType, description, amount) VALUES (?,?,?,?,?,?)";
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query)) {
            pstmt.setString(1, cash.getCashId());
            pstmt.setString(2, cash.getName());
            pstmt.setString(3, cash.getDate());
            pstmt.setString(4, cash.getCashType());
                        pstmt.setString(5, cash.getDescription());
            pstmt.setDouble(6, cash.getAmount());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CashAccount> search(String operator, String key, Object value) {
        List<CashAccount> list = new ArrayList<>();
        String query = "SELECT * FROM cash WHERE " + key + " " + operator + "?";
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query)) {
            pstmt.setObject(1, value);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    CashAccount cashAccount = new CashAccount(
                            rs.getString("cashId"),
                            rs.getString("name"),
                            rs.getString("date"),
                            rs.getString("cashType"),
                            rs.getString("description"),
                            rs.getInt("amount")
                    );
                    list.add(cashAccount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public long update(String operator, String searchKey, Object searchValue, String updateKey, Object updateValue) {
        String query = "UPDATE cash SET " + updateKey + " =? WHERE " + searchKey + " " + operator + "?";
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query)) {
            pstmt.setObject(1, updateValue);
            pstmt.setObject(2, searchValue);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public long delete(String operator, String key, Object value) {
        String query = "DELETE FROM cash WHERE " + key + " " + operator + "?";
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query)) {
            pstmt.setObject(1, value);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<CashAccount> getAll() {
        List<CashAccount> list = new ArrayList<>();
        String query = "SELECT * FROM cash";
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    CashAccount cashAccount = new CashAccount(
                            rs.getString("cashId"),
                            rs.getString("name"),
                            rs.getString("date"),
                            rs.getString("cashType"),
                            rs.getString("description"),
                            rs.getInt("amount")
                    );
                    list.add(cashAccount);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
