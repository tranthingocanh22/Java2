//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//    public static void main(String[] args) throws SQLException {
//        try (
//                Connection  conn = DriverManager.getConnection(
//                        "jdbc:mysql://localhost:3306/ebookshop","root", ""
//                );
//                Statement stmt = conn.createStatement();
//                ){
//            try {
//                conn.setAutoCommit(false);
//                stmt.executeUpdate("insert into book values (898, 'Paul Chan', 'Mahjong 101', 4.4,4)");
//                stmt.executeUpdate("insert into book values (777, 'Peter Chan', 'Mahjong 103',4.4,4)");
//                conn.commit();
//            }
//            catch (SQLException ex){
//                System.out.println(" -- Rolling back changes -- ");
//                conn.rollback();
//                ex.printStackTrace();
//            }
//
//        }
//    }
//}
