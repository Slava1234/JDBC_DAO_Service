
import entity.Address;
import entity.EmplProj;
import entity.Employee;
import entity.Project;
import java.sql.SQLException;
import java.util.Calendar;
import service.AddressService;
import service.EmplProjSerivice;
import service.EmployeeService;
import service.ProjectService;

public class Domain {

    public static void main(String[] args) {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();
        EmplProjSerivice emplProjSerivice = new EmplProjSerivice();

        Calendar calendar = Calendar.getInstance();

        Address address = new Address();
        address.setId(1);
        address.setCountry("USA");
        address.setCity("New-Yourk");
        address.setStreet("Sikar street 10");

        Employee employee = new Employee();
        employee.setId(1);
        employee.setFirstName("Donald");
        employee.setLastName("Franklin");
        calendar.set(1968, Calendar.APRIL, 14);
        employee.setBirthday(new java.sql.Date(calendar.getTime().getTime()));

        Project project = new Project();
        project.setId(1);
        project.setTitle("Almaty secure system");

        EmplProj emplProj = new EmplProj();
        emplProj.setEmployee_id(employee.getId());
        emplProj.setProject_id(project.getId());

        addressService.add(address);
        employeeService.add(employee);
        projectService.add(project);
        emplProjSerivice.add(emplProj);
       

    }

}
