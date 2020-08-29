package model.repository;

import model.entity.EmployeeEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    //------------CONSTRUCTOR-------------
    public EmployeeRepository() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GolestanSystem", "admin");
        connection.setAutoCommit(false);
    }


    public void insert(EmployeeEntity employeeEntity) throws Exception{
        preparedStatement = connection.prepareStatement("insert into employee " +
                "(id, name, pass, post, salary) values (?, ?, ?, ?, ?)");
        preparedStatement.setLong(  1, employeeEntity.getId());
        preparedStatement.setString(2, employeeEntity.getName());
        preparedStatement.setString(3, employeeEntity.getPass());
        preparedStatement.setString(4, employeeEntity.getPost());
        preparedStatement.setLong(  5, employeeEntity.getSalary());
        preparedStatement.executeUpdate();
    }

    public void update(EmployeeEntity employeeEntity) throws Exception{
        preparedStatement = connection.prepareStatement("update  employee set name = ?, pass = ? where id = ?");
        preparedStatement.setString(1, employeeEntity.getName());
        preparedStatement.setString(2, employeeEntity.getPass());
        preparedStatement.setLong( 3, employeeEntity.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(long id) throws Exception{
        preparedStatement = connection.prepareStatement("delete from employee where id = ?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    public List<EmployeeEntity> select() throws Exception{
        List<EmployeeEntity> list = new ArrayList<>();
        preparedStatement = connection.prepareStatement("select * from employee");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            list.add(new EmployeeEntity()
                .setId(resultSet.getLong("id"))
                .setName(resultSet.getString("name"))
                .setPass(resultSet.getString("pass"))
                .setPost(resultSet.getString("post"))
                .setSalary(resultSet.getLong("salary")));
        }
        return list;
    }


    public void commit() throws Exception{
        connection.commit();
    }



    public void rollback() throws Exception{
        connection.rollback();
    }




    //--------------CLOSE-------------
    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }
}
