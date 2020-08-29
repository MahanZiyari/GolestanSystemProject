package model.repository;

import model.entity.EvaluationEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EvaluationRepository implements  AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    //------------CONSTRUCTOR-------------
    public  EvaluationRepository() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GolestanSystem", "admin");
        connection.setAutoCommit(false);
    }

    //--------------SELECTION-----------------
    public List<EvaluationEntity> select(long id) throws Exception {
       List<EvaluationEntity> list= new ArrayList<>();
        preparedStatement = connection.prepareStatement("select * from evaluation where teacher_id=?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {

            EvaluationEntity entity = new EvaluationEntity()
                    .setCourse_id(resultSet.getLong("course_id"))
                    .setTeacher_id(resultSet.getLong("teacher_id"))
                    .setScore(resultSet.getDouble("score"));
            list.add(entity);
        }
        return list;
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
