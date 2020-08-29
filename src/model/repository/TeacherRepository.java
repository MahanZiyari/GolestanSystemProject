package model.repository;

import model.entity.TeacherEntity;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherRepository implements AutoCloseable{
    private Connection connection;
    private PreparedStatement preparedStatement;

    //------------CONSTRUCTOR-------------
    public TeacherRepository() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GolestanSystem", "admin");
        connection.setAutoCommit(false);
    }

    //--------------INSERTION-----------
    public void insert(TeacherEntity teacherEntity) throws Exception{
        preparedStatement = connection.prepareStatement("insert into teacher (id, name, pass, experties, salary) " +
                "values (?, ?, ?, ?, ?)");
        preparedStatement.setLong(  1, teacherEntity.getId());
        preparedStatement.setString(2, teacherEntity.getName());
        preparedStatement.setString(3, teacherEntity.getPass());
        preparedStatement.setString(4, teacherEntity.getExperties());
        preparedStatement.setLong(  5, teacherEntity.getSalary());
        preparedStatement.executeUpdate();

    }


    //---------------UPDATE--------------
    public void update(TeacherEntity teacherEntity) throws Exception{
        preparedStatement = connection.prepareStatement("update teacher set name = ?, pass = ?, experties = ?, salary = ?" +
                " where id = ?");
        preparedStatement.setString(1, teacherEntity.getName());
        preparedStatement.setString(2, teacherEntity.getPass());
        preparedStatement.setString(3, teacherEntity.getExperties());
        preparedStatement.setLong(  4, teacherEntity.getSalary());
        preparedStatement.setLong(  5, teacherEntity.getId());
        preparedStatement.executeUpdate();
    }

    //------------------DELETE----------------
    public void delete(long id) throws Exception{
        preparedStatement = connection.prepareStatement("delete from teacher where id = ?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    //-----------------SELECTION------------
    public List<TeacherEntity> select() throws Exception{
        List<TeacherEntity> teacherEntitiesList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("select * from teacher");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            teacherEntitiesList.add(new TeacherEntity()
                .setName(resultSet.getString("name"))
                .setId(resultSet.getLong("id"))
                .setPass(resultSet.getString("pass"))
                .setExperties(resultSet.getString("experties"))
                .setSalary(resultSet.getLong("salary")));
        }
        return teacherEntitiesList;
    }

    //------------COMMIT--------------
    public void commit() throws Exception{
        connection.commit();
    }

    //------------ROLL BACK--------------
    public void rolback() throws Exception{
        connection.rollback();
    }


    //------------CLOSE----------------
    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }
}
