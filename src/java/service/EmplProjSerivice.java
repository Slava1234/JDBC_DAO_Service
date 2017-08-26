package service;

import util.Util;
import dao.EmplProjDAO;
import entity.EmplProj;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class EmplProjSerivice extends Util implements EmplProjDAO {

    Connection connection = getConnection();

    @Override
    public void add(EmplProj emplProj) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO empl_proj (employee_id, project_id) VALUES(?, ?)";

        try {
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, emplProj.getEmployee_id());
            preparedStatement.setInt(2, emplProj.getProject_id());

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
    public List<EmplProj> getAll() {
        List<EmplProj> emplProjList = new ArrayList<>();

        String query = "SELECT * FROM empl_proj";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                EmplProj emplProj = new EmplProj();
                emplProj.setEmployee_id(resultSet.getInt("employee_id"));
                emplProj.setProject_id(resultSet.getInt("project_id"));

                emplProjList.add(emplProj);
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

        return emplProjList;
    }

    @Override
    public EmplProj getByEmployeeIdAndProjectId(int employeeId, int projectId) {
        PreparedStatement preparedStatement = null;

        String query = "SELECT * FROM empl_proj WHERE employee_id = ? AND project_id = ?";
        EmplProj emplProj = new EmplProj();

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, employeeId);
            preparedStatement.setInt(2, projectId);

            ResultSet resultSet = preparedStatement.executeQuery();

            emplProj.setEmployee_id(resultSet.getInt("employee_id"));
            emplProj.setProject_id(resultSet.getInt("project_id"));

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

        return emplProj;
    }

    @Override
    public void update(EmplProj emplProj) {
        PreparedStatement preparedStatement = null;

        String query = "UPDATE empl_proj SET employee_id=?, project_id=?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, emplProj.getEmployee_id());
            preparedStatement.setInt(2, emplProj.getProject_id());

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
    public void remove(EmplProj emplProj) {
        PreparedStatement preparedStatement = null;

        String query = "DELETE FROM empl_proj WHERE employee_id = ? AND project_id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, emplProj.getEmployee_id());
            preparedStatement.setInt(2, emplProj.getProject_id());

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
