package dao;

import entity.Employee;
import java.util.List;


public interface EmployeeDAO {
    // create
    public void add(Employee employee);
    
    // read
    public List<Employee> getAll();
    
    public Employee getById(int id);
    
    // update
     public void update(Employee employee); 
     
    // delete
    public void remove(Employee employee);
}
