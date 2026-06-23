/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package za.ac.tut.bl;

import java.util.List;

/**
 *
 * @author olwet
 */
public interface DAO<T> {
    T get(String id);
    List<T> getAll();
    boolean remove(String id);
    boolean update(T t);
    boolean add(T t);
    
    
}
