package model.repository;

import model.entity.CourseEntity;
import model.entity.TermCourseEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TermCourseRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;


    //------------CONSTRUCTOR-------------
    public TermCourseRepository() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GolestanSystem", "admin");
        connection.setAutoCommit(false);
    }

    public void insert(TermCourseEntity termCourseEntity) throws Exception
    {
        preparedStatement=connection.prepareStatement("INSERT INTO term_course " +
                "(gruop,course_id,teacher_id,day,time)VALUES (?,?,?,?,?)");
        preparedStatement.setLong(1,termCourseEntity.getgruop());
        preparedStatement.setLong(2,termCourseEntity.getCourse_id());
        preparedStatement.setLong(3,termCourseEntity.getTeacher_id());
        preparedStatement.setString(4,termCourseEntity.getDay());
        preparedStatement.setString(5,termCourseEntity.getTime());
        preparedStatement.executeUpdate();
    }

    public void update(TermCourseEntity termCourseEntity) throws Exception
    {
        preparedStatement=connection.prepareStatement("UPDATE term_course" +
                "set course_id=?,teacher_id=?,day=?,time=? WHERE code=?");
        preparedStatement.setLong(1,termCourseEntity.getCourse_id());
        preparedStatement.setLong(2,termCourseEntity.getTeacher_id());
        preparedStatement.setString(3,termCourseEntity.getDay());
        preparedStatement.setString(4,termCourseEntity.getTime());
        preparedStatement.setLong(5,termCourseEntity.getgruop());
        preparedStatement.executeUpdate();
    }

    public void delete(long code) throws Exception
    {
        preparedStatement=connection.prepareStatement("DELETE FROM term_course where code=?");
        preparedStatement.setLong(1,code);
        preparedStatement.executeUpdate();
    }

    public List<TermCourseEntity> select() throws Exception{
        List<TermCourseEntity> termCourseEntityList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("select * from term_course");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            termCourseEntityList.add(new TermCourseEntity().setgroup(resultSet.getLong("gruop"))
                    .setCourse_id(resultSet.getLong("course_id"))
                    .setTeacher_id(resultSet.getLong("teacher_id"))
                    .setDay(resultSet.getString("day"))
                    .setTime(resultSet.getString("time")));
        }
        return termCourseEntityList;
    }

    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }

    public void commit() throws Exception{
        connection.commit();
    }
    public void rollBack() throws Exception{
        connection.rollback();
    }
}
