package model.repository;

import model.entity.LogEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazanin User on 1/29/2020.
 */
public class LogRepository implements AutoCloseable
{
    private Connection connection;
    private PreparedStatement preparedStatement;

    //------------CONSTRUCTOR-------------
    public LogRepository() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection
                ("jdbc:oracle:thin:@localhost:1521:xe",
                        "GolestanSystem", "admin");
        connection.setAutoCommit(false);
    }
    //------------Insertion----------------
    public void insert(LogEntity logEntity) throws Exception{
        preparedStatement = connection.prepareStatement
                ("insert into log (id, date_time, subject, text)" +
                        " values (?, ?, ?, ?)");
        preparedStatement.setLong(  1, logEntity.getId()  );
        preparedStatement.setString(  2, logEntity.getDateAndTime()  );
        preparedStatement.setString(  3, logEntity.getSubject()  );
        preparedStatement.setString(  4, logEntity.getText()  );
        preparedStatement.executeUpdate();
    }

    public void update(LogEntity logEntity) throws Exception{
        preparedStatement = connection.prepareStatement
                ("update log set date_time = ?, subject = ?, text = ?" +
                        "where id = ?");
        preparedStatement.setString(  1, logEntity.getDateAndTime() );
        preparedStatement.setString(  2, logEntity.getSubject() );
        preparedStatement.setString(  3, logEntity.getText() );
        preparedStatement.setLong(  4, logEntity.getId() );
        preparedStatement.executeUpdate();
    }

    public void delete(long id) throws Exception{
        preparedStatement = connection.prepareStatement("delete from log where id = ?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    public List<LogEntity> select() throws Exception{
        List<LogEntity> logEntityList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("select * from log");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            logEntityList.add(new LogEntity().setId(resultSet.getLong("id"))
                    .setDateAndTime(resultSet.getString("date_time"))
                    .setSubject(resultSet.getString("subject"))
                    .setText(resultSet.getString("text")));
        }
        return logEntityList;
    }

    public LogEntity selectById(long id) throws SQLException {
        LogEntity logEntity;
        preparedStatement = connection.prepareStatement("select from log where id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        logEntity = new LogEntity().setId(resultSet.getLong("id"))
                .setDateAndTime(resultSet.getString("date_time"))
                .setSubject(resultSet.getString("subject"))
                .setText(resultSet.getString("text"));
        return logEntity;
    }

    @Override
    public void close() throws Exception
    {
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
