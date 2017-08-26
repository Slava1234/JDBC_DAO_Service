package entity;

import java.util.Objects;


public class Address {
    // Если больше двух полешй, лучше использовать геттеры и сеттеры
    private int id;
    private String country;
    private String city;
    private String street;

    public Address() {
        
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.id;
        hash = 17 * hash + Objects.hashCode(this.country);
        hash = 17 * hash + Objects.hashCode(this.city);
        hash = 17 * hash + Objects.hashCode(this.street);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass())  return false;
        final Address other = (Address) obj;
        if (this.id != other.id) return false;
        if (!Objects.equals(this.country, other.country))  return false;
        if (!Objects.equals(this.city, other.city))  return false;
        if (!Objects.equals(this.street, other.street))  return false;
        return true;
    }

    @Override
    public String toString() {
        return "Address{" + "id=" + id + ", country=" + country + ", city=" + city + ", street=" + street + '}';
    }
    
    
    
}
