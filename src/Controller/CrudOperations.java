/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.List;

/**
 *
 * @author glory
 */
public interface CrudOperations<T> {
    void insert(T t);
    List<T> search(String operator, String key, Object value);
    long update(String operator, String searchKey, Object searchValue, String updateKey, Object updateValue);
    long delete(String operator, String key, Object value);
    List<T> getAll();
}
