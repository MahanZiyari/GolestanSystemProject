package model.repository;

import model.entity.CourseEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    //------------CONSTRUCTOR-------------
    public CourseRepository() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GolestanSystem", "admin");
        connection.setAutoCommit(false);
    }

    public void insert(CourseEntity courseEntity) throws Exception{
        preparedStatement = connection.prepareStatement("insert into course (code, name, field, unit, prerequisite, need) values " +
                "(?, ?, ?, ?, ?, ?)");
        preparedStatement.setLong(  1, courseEntity.getCode());
        preparedStatement.setString(2, courseEntity.getName());
        preparedStatement.setString(3, courseEntity.getField());
        preparedStatement.setInt(   4, courseEntity.getUnit());
        preparedStatement.setLong(  5, courseEntity.getPrerequisite());
        preparedStatement.setLong(  6, courseEntity.getNeed());
        preparedStatement.executeUpdate();
    }

    public void update(CourseEntity courseEntity) throws Exception{
        preparedStatement = connection.prepareStatement("update course set name = ?, field = ?, unit = ?, prerequisite = ?, need = ? where " +
                "code = ?");
        preparedStatement.setString(1, courseEntity.getName());
        preparedStatement.setString(2, courseEntity.getField());
        preparedStatement.setInt(   3, courseEntity.getUnit());
        preparedStatement.setLong(  4, courseEntity.getPrerequisite());
        preparedStatement.setLong(  5, courseEntity.getNeed());
        preparedStatement.setLong(  6, courseEntity.getCode());
        preparedStatement.executeUpdate();
    }

    public void delete(long code) throws Exception{
        preparedStatement = connection.prepareStatement("delete from course where code = ?");
        preparedStatement.setLong(1, code);
        preparedStatement.executeUpdate();
    }

    public List<CourseEntity> select() throws Exception{
        List<CourseEntity> courseEntityList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("select * from course");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            courseEntityList.add(new CourseEntity().setCode(resultSet.getLong("code"))
            .setName(resultSet.getString("name"))
            .setField(resultSet.getString("field"))
            .setUnit(resultSet.getInt("unit"))
            .setPrerequisite(resultSet.getLong("prerequisite"))
            .setNeed(resultSet.getLong("need")));
        }
        return courseEntityList;
    }

    public CourseEntity selectById(long id) throws SQLException {
        CourseEntity courseEntity;
        preparedStatement = connection.prepareStatement("select from course where code = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        courseEntity = new CourseEntity().setCode(resultSet.getLong("code"))
                .setName(resultSet.getString("name"))
                .setField(resultSet.getString("field"))
                .setUnit(resultSet.getInt("unit"))
                .setPrerequisite(resultSet.getLong("prerequisite"))
                .setNeed(resultSet.getLong("need"));
        return courseEntity;
    }




    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }

    public void commit() throws Exception{
        connection.commit();
    }

    public void rollback() throws Exception{
        connection.rollback();
    }
}
