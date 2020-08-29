package model.repository;

import model.entity.CreditCardEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CreditCardRepository implements AutoCloseable
{
    private Connection connection;
    private PreparedStatement preparedStatement;


    //------------CONSTRUCTOR-------------
    public CreditCardRepository() throws Exception
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "GolestanSystem", "admin");
        connection.setAutoCommit(false);
    }

    public void insert(CreditCardEntity creditCardEntity) throws Exception
    {
        preparedStatement=connection.prepareStatement("INSERT INTO credit_card " +
                "(card_number,name,second_pass,cvv2,expire_year,expire_month, fund)" +
                "VALUES (?,?,?,?,?,?, ?)");
        preparedStatement.setString(1,creditCardEntity.getCardNumber());
        preparedStatement.setString(2,creditCardEntity.getName());
        preparedStatement.setString(3,creditCardEntity.getSecondPass());
        preparedStatement.setInt(4,creditCardEntity.getCvv2());
        preparedStatement.setInt(5,creditCardEntity.getExpireYear());
        preparedStatement.setInt(6,creditCardEntity.getExpireMonth());
        preparedStatement.setLong(7, creditCardEntity.getFund());
        preparedStatement.executeUpdate();
    }

    public void update(CreditCardEntity creditCardEntity) throws Exception
    {
        preparedStatement = connection.prepareStatement("update credit_card set fund = ? where card_number = ?");
        preparedStatement.setLong(1, creditCardEntity.getFund());
        preparedStatement.setString(2, creditCardEntity.getCardNumber());
        preparedStatement.executeUpdate();
        System.out.println(creditCardEntity.toString());
    }

    public void delete(String cardNumber) throws Exception
    {
        preparedStatement=connection.prepareStatement("DELETE FROM credit_card" +
                " where card_number=?");
        preparedStatement.setString(1,cardNumber);
        preparedStatement.executeUpdate();
    }

    public List<CreditCardEntity> select() throws Exception
    {
        List<CreditCardEntity> creditCardEntityList = new ArrayList<>();
        preparedStatement = connection.prepareStatement("select * from credit_card");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            creditCardEntityList.add(new CreditCardEntity()
                    .setCardNumber(resultSet.getString("card_number"))
                    .setName(resultSet.getString("name"))
                    .setSecondPass(resultSet.getString("second_pass"))
                    .setCvv2(resultSet.getInt("cvv2"))
                    .setExpireYear(resultSet.getInt("expire_year"))
                    .setExpireMonth(resultSet.getInt("expire_month"))
                    .setFund(resultSet.getLong("fund")));
        }
        return creditCardEntityList;
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

    public void rollBack() throws Exception{
        connection.rollback();
    }
}
