import java.sql.*;

public class Ex8_2 {
    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/ebookshop", "root", ""
                );
        ) {
            PreparedStatement pstmt = conn.prepareStatement(
                    "insert into book values(?,?,?,?,?)"
            );
            conn.setAutoCommit(false);

            pstmt.setInt(1, 8003);
            pstmt.setString(2,"Java 123");
            pstmt.setString(3, "Kevin Jones");
            pstmt.setDouble(4,12.34);
            pstmt.setInt(5,88);
            pstmt.addBatch();

            pstmt.setInt(1,8004);
            pstmt.setString(2, "Java 456");
            pstmt.addBatch();

            int[] returnCodes = pstmt.executeBatch();

            System.out.printf("Return codes are : ");
            for (int code : returnCodes) System.out.printf(code + "," );
            conn.commit();
        }

        catch (SQLException ex){
            ex.printStackTrace();
        }
        }
}
