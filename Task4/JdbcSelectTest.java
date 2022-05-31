import java.sql.*;

public class JdbcSelectTest {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop","root", ""
                );
                Statement statement= connection.createStatement();
        ) {
            String strSelect = "select title, price, qty from book";
            System.out.println("The SQL Statement is: "+strSelect +"\n");

            ResultSet resultSet=statement.executeQuery(strSelect);
            System.out.println("The record selected are: ");
            int rowCount = 0;
            while (resultSet.next()){
                String title = resultSet.getString("title");
                double price = resultSet.getDouble("price");
                int qty = resultSet.getInt("qty");
                System.out.println(title + ", "+ price +", "+qty);
                ++rowCount;
            }
            System.out.println("Total number of record = "+rowCount);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}
