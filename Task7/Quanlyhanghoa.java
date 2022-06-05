import java.sql.*;
import java.util.Scanner;

public class Quanlyhanghoa {
    public static void main(String[] args) throws SQLException {
//        String sqlDelete = "delete from thucpham where id = ?";
//        String sqlInsert = "INSERT INTO thucpham VALUES(?,?,?,?,?)";
//        String sqlPrint = "select*from thucpham";

        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Quanlyhanghoa", "root", ""
                );
                PreparedStatement ppStmt = conn.prepareStatement("Delete from thucpham where id =?  ");
                PreparedStatement ppStmt1 = conn.prepareStatement("INSERT INTO thucpham VALUES (?,?,?,?,?)");
                PreparedStatement ppStmt2 = conn.prepareStatement("Select * from thucpham ");
                Statement stmt = conn.createStatement();
        ) {
            ppStmt.setString(1, "05");
            int rowDelete = ppStmt.executeUpdate();
            System.out.println(rowDelete + "Colum delete done ");
            ResultSet re = ppStmt1.executeQuery();
            while (re.next()) {
                String id = re.getString("id");
                String name = re.getString("name");
                int price = re.getInt("price");
                int qty = re.getInt("qty");

                System.out.println(id + ", " + name + ", " + price + ", " + qty);
            }
            System.out.println();

            ppStmt1.setString(1, "06");
            ppStmt1.setString(2, "Nuoc ngot");
            ppStmt1.setString(3, "15");
            ppStmt1.setString(4, "90");
            int row = ppStmt1.executeUpdate();
            System.out.println(row + "Colum Update done");

            ResultSet re1 = ppStmt2.executeQuery();
            while (re1.next()) {
                String id = re1.getString("id");
                String name = re1.getString("name");
                int price = re1.getInt("price");
                int qty = re1.getInt("qty");

                System.out.println(id + ", " + name + ", " + price + ", " + qty);
            }
            System.out.println();

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter data to search: ");
            String Search = sc.next();
            System.out.println("Data to search is: " + Search);
            System.out.println();

            String tpID = "SELECT * FROM testFind where id like '%" + Search + "%'";
            String tpName = "SELECT * FROM testFind where name like '%" + Search + "%'";
            String tpPrice = "SELECT * FROM testFind where age like '%" + Search + "%'";
            String tpQty = "SELECT * FROM testFind where gender like '%" + Search + "%'";
            String query[] = {tpID,
                    tpName, tpPrice
                    , tpQty};
            for (String q : query) {

                ResultSet re2 = stmt.executeQuery(q);
                System.out.println("Corresponding searched data at column: " + q + ":");
////
                while (re2.next()) {
                    String id = re2.getString("id");
                    String name = re2.getString("name");
                    int price = re2.getInt("price");
                    int qty = re2.getInt("qty");
                    System.out.println("Data:" + id + ", " + name + ", " + price + ", " + qty);
//
                }
                System.out.println();
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }
}