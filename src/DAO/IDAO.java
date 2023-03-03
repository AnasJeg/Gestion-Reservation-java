/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAO;

import java.util.List;

/**
 *
 * @author anace
 */
public interface IDAO<T> {
    
		public boolean create(T o);
		public boolean update(T o);
		public boolean delete(T o);
		public T findById(int id);
		public List<T> findAll();

}
