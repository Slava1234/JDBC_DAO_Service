package dao;

import entity.Project;
import java.util.List;


public interface ProjectDAO {
     // create
    public void add(Project project);
    
    // read
    public List<Project> getAll();
    
    public Project getById(int id);
    
    // update
     public void update(Project project); 
     
    // delete
    public void remove(Project project);
}
