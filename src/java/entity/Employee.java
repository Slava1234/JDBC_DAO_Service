package entity;

import java.sql.Date;
import java.util.Objects;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private int addressId;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getAddressID() {
        return addressId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setAddressID(int addressID) {
        this.addressId = addressID;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.id;
        hash = 97 * hash + Objects.hashCode(this.firstName);
        hash = 97 * hash + Objects.hashCode(this.lastName);
        hash = 97 * hash + Objects.hashCode(this.birthday);
        hash = 97 * hash + this.addressId;
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
        final Employee other = (Employee) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.addressId != other.addressId) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday + ", addressId=" + addressId + '}';
    }
    
    
}
