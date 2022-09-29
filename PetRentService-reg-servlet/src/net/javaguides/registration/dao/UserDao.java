package net.javaguides.registration.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import net.javaguides.registration.model.User;
import net.javaguides.login.bean.LoginBean;

public class UserDao {
    public int registeruser(User user) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO user" +
            "  (id, first_name, last_name, email, password, address, contact) VALUES " +
            " (?, ?, ?, ?, ?,?,?);";
        
        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");
        
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false", "root", "roots");
        	
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL,Statement.RETURN_GENERATED_KEYS)) {
	        preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, user.getfName());
            preparedStatement.setString(3, user.getlName());
            preparedStatement.setString(4, user.getEmail());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, user.getAddress());
            preparedStatement.setString(7, user.getContact());
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
        	preparedStatement.executeUpdate();
        	ResultSet rs = preparedStatement.getGeneratedKeys();
			while (rs.next()) {
				System.out.println("Auto Generated Primary Key " + rs.getInt(1));
			}
        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false", "root", "root");

                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO login " + "VALUES (?, ?)")) {
	            preparedStatement.setString(1, user.getEmail());
	            preparedStatement.setString(2, user.getPassword());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                // process sql exception
                printSQLException(e);
            }
        return result;
    }
    
	public boolean validate(LoginBean loginBean) throws ClassNotFoundException {
		boolean status = false;

		Class.forName("com.mysql.jdbc.Driver");
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false", "root", "root");
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection
						.prepareStatement("select * from login where email = ? and password = ? ")) {
			preparedStatement.setString(1, loginBean.getEmail());
			preparedStatement.setString(2, loginBean.getPassword());

			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();
			status = rs.next();

		} catch (SQLException e) {
			// process sql exception
			printSQLException(e);
		}
		return status;
	}

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
