package service;

import util.Util;
import dao.ProjectDAO;
import entity.Project;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProjectService extends Util implements ProjectDAO {

    Connection connection = getConnection();

    @Override
    public void add(Project project) {
        PreparedStatement preparedStatement = null;
        String query = "INSERT INTO project (id, title) VALUES(?, ?)";

        try {
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, project.getId());
            preparedStatement.setString(2, project.getTitle());

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
    public List<Project> getAll() {
        List<Project> projectList = new ArrayList<>();

        String query = "SELECT * FROM project";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setTitle(resultSet.getString("title"));

                projectList.add(project);
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

        return projectList;
    }

    @Override
    public Project getById(int id) {
        PreparedStatement preparedStatement = null;

        String query = "SELECT * FROM project WHERE id = ?";
        Project project = new Project();

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            project.setId(resultSet.getInt("id"));
            project.setTitle(resultSet.getString("title"));

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

        return project;
    }

    @Override
    public void update(Project porject) {
        PreparedStatement preparedStatement = null;

        String query = "UPDATE project SET title=? WHERE id=?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, porject.getTitle());
            preparedStatement.setInt(2, porject.getId());

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
    public void remove(Project project) {
        PreparedStatement preparedStatement = null;

        String query = "DELETE FROM project WHERE id = ?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, project.getId());

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
