/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author glory
 */
public class ControllerFactory {
    public static CrudOperations getController(String type) {
        if (type.equalsIgnoreCase("USER")) {
            return new UserController();
        } else if (type.equalsIgnoreCase("CASH")) {
            return new CashController();
        } else if (type.equalsIgnoreCase("ADMIN")) {
            return new AdminController();
        }
        throw new IllegalArgumentException("Unknown controller type");
    }
}
