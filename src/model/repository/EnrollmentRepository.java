package model.repository;

import model.entity.EnrollmentEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EnrollmentRepository implements AutoCloseable {
    private Connection connection;
    private PreparedStatement preparedStatement;

    public EnrollmentRepository() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GolestanSystem", "admin");
        connection.setAutoCommit(false);
    }

    public void insert(EnrollmentEntity entity) throws Exception{
        preparedStatement = connection.prepareStatement("insert into enrollment (indexx, std_id, id, term) " +
                "values (?, ?, ?, ?)");
        preparedStatement.setInt(1, entity.getIndex());
        preparedStatement.setLong(2, entity.getStdId());
        preparedStatement.setString(3, entity.getId());
        preparedStatement.setInt(4, entity.getTerm());
        preparedStatement.executeUpdate();
    }

    public void update(EnrollmentEntity entity) throws Exception{
        preparedStatement = connection.prepareStatement("update enrollment set mark = ?, absence = ?, state = ? where indexx = ?");
        preparedStatement.setFloat(1, entity.getMark());
        preparedStatement.setInt(2, entity.getAbsence());
        preparedStatement.setString(3, entity.getState());
        preparedStatement.setInt(4, entity.getIndex());
        preparedStatement.executeUpdate();
    }

    public void delete(int index) throws Exception{
        preparedStatement = connection.prepareStatement("delete from enrollment where indexx = ?");
        preparedStatement.setInt(1, index);
        preparedStatement.executeUpdate();
    }

    public List<EnrollmentEntity> select() throws Exception{
        List<EnrollmentEntity> list = new ArrayList<>();
        preparedStatement = connection.prepareStatement("select * from enrollment");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            EnrollmentEntity enrollmentEntity = new EnrollmentEntity().setId(resultSet.getString("id"))
                    .setStdId(resultSet.getLong("std_id"))
                    .setMark(resultSet.getInt("mark"))
                    .setAbsence(resultSet.getInt("absence"))
                    .setState(resultSet.getString("state"))
                    .setTerm(resultSet.getInt("term"))
                    .setIndex(resultSet.getInt("indexx"));
            list.add(enrollmentEntity);
        }
        return list;
    }

    public void commit() throws Exception{
        connection.commit();
    }
    public void rollBack() throws Exception{
        connection.rollback();
    }


    @Override
    public void close() throws Exception {
        connection.close();
        preparedStatement.close();
    }
}
