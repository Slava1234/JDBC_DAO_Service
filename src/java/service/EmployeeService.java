package service;

import util.Util;
import dao.EmployeeDAO;
import entity.Employee;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmployeeService extends Util implements EmployeeDAO {

    Connection connection = getConnection();

    @Override
    public void add(Employee employee) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO employee (id, first_name, last_name, birthday, address_id) VALUES(?, ?, ?, ?, ?)";

        try {
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, employee.getId());
            preparedStatement.setString(2, employee.getFirstName());
            preparedStatement.setString(3, employee.getLastName());
            preparedStatement.setDate(4, employee.getBirthday());
            preparedStatement.setInt(5, employee.getAddressID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Employee> getAll() {
        List<Employee> employeeList = new ArrayList<>();

        String query = "SELECT * FROM employee";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Employee employee = new Employee();
                employee.setId(resultSet.getInt("id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setBirthday(resultSet.getDate("birthday"));
                employee.setAddressID(resultSet.getInt("address_id"));

                employeeList.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return employeeList;
    }

    @Override
    public Employee getById(int id) {
        PreparedStatement preparedStatement = null;

        String query = "SELECT * FROM employee WHERE id = ?";
        Employee employee = new Employee();

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            employee.setId(resultSet.getInt("id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            employee.setBirthday(resultSet.getDate("birthday"));
            employee.setAddressID(resultSet.getInt("address_id"));

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        return employee;
    }

    @Override
    public void update(Employee employee) {
        PreparedStatement preparedStatement = null;

        String query = "UPDATE employee SET first_name=?, last_name=?, birthday=?, address_id=?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setDate(3, employee.getBirthday());
            preparedStatement.setInt(4, employee.getAddressID());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void remove(Employee employee) {
        PreparedStatement preparedStatement = null;

        String query = "DELETE FROM employee WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, employee.getId());

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

}
