package model.repository;
import model.entity.RecordsEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nazanin
 */
public class RecordsRepository implements AutoCloseable
{
    private Connection connection;
    private PreparedStatement preparedStatement;

    //------------CONSTRUCTOR-------------
    public RecordsRepository() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection
                ("jdbc:oracle:thin:@localhost:1521:xe",
                        "GolestanSystem", "admin");
        connection.setAutoCommit(false);
    }


    public void insert(RecordsEntity recordsEntity) throws Exception
    {
        preparedStatement = connection.prepareStatement("insert into records " +
                "(id, subject, text) values (?, ?, ?)");
        preparedStatement.setLong(  1, recordsEntity.getId());
        preparedStatement.setString(2, recordsEntity.getSubject());
        preparedStatement.setString(3, recordsEntity.getText());
        preparedStatement.executeUpdate();
    }

    public void update(RecordsEntity recordsEntity) throws Exception
    {
        preparedStatement = connection.prepareStatement
                ("update records set subject = ?, text = ? where id = ?");
        preparedStatement.setString(1,recordsEntity.getSubject() );
        preparedStatement.setString(2, recordsEntity.getText());
        preparedStatement.setLong( 3, recordsEntity.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(long id) throws Exception{
        preparedStatement = connection.prepareStatement
                ("delete from records where id = ?");
        preparedStatement.setLong(1, id);
        preparedStatement.executeUpdate();
    }

    public List<RecordsEntity> select() throws Exception{
        List<RecordsEntity> list = new ArrayList<>();
        preparedStatement = connection.prepareStatement("select * from records");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            list.add(new RecordsEntity()
                    .setId(resultSet.getLong("id"))
                    .setSubject(resultSet.getString("subject"))
                    .setText(resultSet.getString("text")));
        }
        return list;
    }


    public void commit() throws Exception{
        connection.commit();
    }

    public void rollback() throws Exception{
        connection.rollback();
    }
    @Override
    public void close() throws Exception
    {
        preparedStatement.close();
        connection.close();
    }
}
