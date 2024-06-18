/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DBConnection;
import Model.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author glory
 */
public class AdminController implements CrudOperations<Admin> {

    @Override
    public void insert(Admin admin) {
        String query = "INSERT INTO admin (name, password) VALUES (?,?)";
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query)) {
            pstmt.setString(1, admin.getName());
            pstmt.setString(2, admin.getPassword());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Admin> search(String operator, String key, Object value) {
        List<Admin> list = new ArrayList<>();
        String query = "SELECT * FROM admin WHERE " + key + " " + operator + "?";
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query)) {
            pstmt.setObject(1, value);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Admin admin = new Admin(
                            rs.getString("name"),
                            rs.getString("password")
                    );
                    list.add(admin);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public long update(String operator, String searchKey, Object searchValue, String updateKey, Object updateValue) {
        String query = "UPDATE admin SET " + updateKey + " =? WHERE " + searchKey + " " + operator + "?";
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
        String query = "DELETE FROM admin WHERE " + key + " " + operator + "?";
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query)) {
            pstmt.setObject(1, value);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<Admin> getAll() {
        List<Admin> list = new ArrayList<>();
        String query = "SELECT * FROM admin";
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Admin admin = new Admin(
                            rs.getString("name"),
                            rs.getString("password")
                    );
                    list.add(admin);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
