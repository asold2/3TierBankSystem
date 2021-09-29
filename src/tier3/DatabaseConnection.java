package tier3;

import java.sql.*;

public class DatabaseConnection
{
  private Connection connection;
  public DatabaseConnection(String password){
    String driver = "org.postgresql.Driver";
    String url = "jdbc:postgresql://localhost:5432/postgres";
    String user = "postgres";
//    connection = null;

    try
    {
      Class.forName(driver);
    }
    catch (ClassNotFoundException e)
    {
      e.printStackTrace();
    }
    try
    {
      connection = DriverManager.getConnection(url, user, password);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  public ResultSet getAccountById(int id){
    String sql = "select * from ThreeTierBankSystem.Customer where id = "+ id +";";
    PreparedStatement preparedStatement  = null;
    try
    {
      preparedStatement = connection.prepareStatement(sql);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    try
    {
      return preparedStatement.executeQuery();
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
    return null;
  }

  public void createAccount(int id, String name, String lastname, double amount){
    System.out.println("New account is being created:");
    String sql = "INSERT INTO ThreeTierBankSystem.Customer(id, name, lastname, amount) VALUES("+"'"+ id + "','" + name + "','" + lastname + "','" + amount + "'"+ " );";
    PreparedStatement preparedStatement = null;
    try
    {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.execute();
      System.out.println("Client added: " + name);
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }

  public void updateAmount(int id, double amount){
    String sql = "update ThreeTierBankSystem.Customer\n" + "set amount = amount + "+ amount+ "\n"
        + "where id = "+id+";";
    PreparedStatement preparedStatement = null;
    try
    {
      preparedStatement = connection.prepareStatement(sql);
      preparedStatement.execute();
      System.out.println("Account updated somehow");
    }
    catch (SQLException throwables)
    {
      throwables.printStackTrace();
    }
  }
}
