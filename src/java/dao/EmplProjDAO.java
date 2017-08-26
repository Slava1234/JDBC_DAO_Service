package dao;

import entity.EmplProj;
import java.util.List;


public interface EmplProjDAO {
     // create
    public void add(EmplProj emplProj);
    
    // read
    public List<EmplProj> getAll();
    
    public EmplProj getByEmployeeIdAndProjectId(int employeeId, int projectId);
    
    // update
     public void update(EmplProj emplProj); 
     
    // delete
    public void remove(EmplProj emplProj);
}
