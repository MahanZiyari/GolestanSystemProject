package model.repository;

import model.entity.StudentEntity;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    //------------CONSTRUCTOR-------------
    public StudentRepository() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GolestanSystem", "admin");
        connection.setAutoCommit(false);
    }



    //-------------INSERTION---------------
    public void insert(StudentEntity studentEntity) throws Exception{
        preparedStatement = connection.prepareStatement("insert into student(id, name, pass, major, entry, grade) " +
                "values (?, ?, ?, ?, ?, ?)");
        preparedStatement.setLong(  1, studentEntity.getId());
        preparedStatement.setString(2, studentEntity.getName());
        preparedStatement.setString(3, studentEntity.getPass());
        preparedStatement.setString(4, studentEntity.getMaajor());
        preparedStatement.setLong(  5, studentEntity.getEntry());
        preparedStatement.setString(6, studentEntity.getGrade());
        preparedStatement.executeUpdate();
    }

    //------------UPDATE-------------------
    public void update(StudentEntity studentEntity) throws Exception{
        preparedStatement = connection.prepareStatement("update student set name = ?" +
                ",pass = ?, major = ?, entry = ?, grade = ? where id = ?");
        preparedStatement.setString(1, studentEntity.getName());
        preparedStatement.setString(2, studentEntity.getPass());
        preparedStatement.setString(3, studentEntity.getMaajor());
        preparedStatement.setLong(  4, studentEntity.getEntry());
        preparedStatement.setString(5, studentEntity.getGrade());
        preparedStatement.setLong(  6, studentEntity.getId());
        preparedStatement.executeUpdate();
    }

    //--------------DELETE----------------
    public void delete(long id) throws Exception{
        preparedStatement = connection.prepareStatement("delete from student where id = ?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    //--------------SELECTION-----------------
    public List<StudentEntity> select() throws Exception{
        List<StudentEntity> entities = new ArrayList<>();
        preparedStatement = connection.prepareStatement("select * from student");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            StudentEntity entity = new StudentEntity()
                    .setId(resultSet.getLong("id"))
                    .setName(resultSet.getString("name"))
                    .setPass(resultSet.getString("pass"))
                    .setMaajor(resultSet.getString("major"))
                    .setEntry(resultSet.getLong("entry"))
                    .setGrade(resultSet.getString("grade"));
            entities.add(entity);
        }
        System.out.println(entities.size());
        return entities;
    }


    //---------------CLOSE---------------
    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }

    //----------------COMMIT-----------------
    public void commit() throws Exception{
        connection.commit();
    }

    //------------ROLL BACK--------------
    public void rollback() throws Exception{
        connection.rollback();
    }
}
