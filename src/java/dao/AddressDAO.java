package dao;

import entity.Address;
import java.util.List;

/*
* данный интерфейс должен содержать все части работы с бд
*/
public interface AddressDAO {
    // create
    public void add(Address address);
    
    // read
    public List<Address> getAll();
    
    public Address getById(int id);
    
    // update
     public void update(Address address); 
     
    // delete
    public void remove(Address address);
    
    // getMaxId
    public int newId();
}
