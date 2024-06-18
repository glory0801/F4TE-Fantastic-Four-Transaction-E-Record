/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Database.DBConnection;
import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author glory
 */
public class UserController implements CrudOperations<User> {

    @Override
    public void insert(User user) {
        String query = "INSERT INTO user (accountId, name, password, gender, phone, email, balance) VALUES (?,?,?,?,?,?,?)";
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query)) {
            pstmt.setString(1, user.getAccountId());
            pstmt.setString(2, user.getName());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getGender());
            pstmt.setString(5, user.getPhone());
            pstmt.setString(6, user.getEmail());
            pstmt.setInt(7, user.getBalance());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> search(String operator, String key, Object value) {
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM user WHERE " + key + " " + operator + "?";
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query)) {
            pstmt.setObject(1, value);
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    User user = new User(
                            rs.getString("accountId"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getString("gender"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getInt("balance")
                    );
                    list.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public long update(String operator, String searchKey, Object searchValue, String updateKey, Object updateValue) {
        String query = "UPDATE user SET " + updateKey + " =? WHERE " + searchKey + " " + operator + "?";
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
        String query = "DELETE FROM user WHERE " + key + " " + operator + "?";
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query)) {
            pstmt.setObject(1, value);
            return pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public List<User> getAll() {
        List<User> list = new ArrayList<>();
        String query = "SELECT * FROM user";
        try (PreparedStatement pstmt = DBConnection.getConnection().prepareStatement(query)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    User user = new User(
                            rs.getString("accountId"),
                            rs.getString("password"),
                            rs.getString("name"),
                            rs.getString("gender"),
                            rs.getString("phone"),
                            rs.getString("email"),
                            rs.getInt("balance")
                    );
                    list.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
