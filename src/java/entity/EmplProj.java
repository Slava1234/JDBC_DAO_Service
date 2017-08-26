package entity;


public class EmplProj {
    private int employee_id;
    private int project_id;

    public EmplProj() {
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.employee_id;
        hash = 97 * hash + this.project_id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EmplProj other = (EmplProj) obj;
        if (this.employee_id != other.employee_id) {
            return false;
        }
        if (this.project_id != other.project_id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EmplProj{" + "employee_id=" + employee_id + ", project_id=" + project_id + '}';
    }
    
    
}
