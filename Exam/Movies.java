import java.sql.*;
import java.util.Scanner;

public class Movies {
    public static void main(String[] args) throws SQLException{
        String sqlDelete = "Delete from Movies1 where ID = ?";
        String sqlInsert = "INSERT INTO Movies1 VALUE (?,?,?,?,?)";
        String sqlUpdate = "UPDATE Movies1 set Name = ? where ID =? ";
        String sqlSelect = "Select * from Movies1";
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/Manage", "root", ""
                );
                PreparedStatement ppSmtDelete = conn.prepareStatement(sqlDelete);
                PreparedStatement ppSmtInsert = conn.prepareStatement(sqlInsert);
                PreparedStatement ppSmtSelect = conn.prepareStatement(sqlSelect);
                PreparedStatement ppSmtUpdate = conn.prepareStatement(sqlUpdate);
                Statement stmt = conn.createStatement();
        ) {
            conn.setAutoCommit(false);

            try {
                int chon1;
                int chon2;
                String ID;
                String Name;
                String premiere_time;
                String Author_name;
                String time;
                Scanner sc = new Scanner(System.in);

                do {
                    System.out.println("Moi chon : \n 1.Them\t 2.Sua \t 3.Xoa \t 4.Tim kiem");
                    chon1 = sc.nextInt();
                    if (chon1 == 1) {
                        System.out.println("Them phim ");
                        sc.nextLine();
                        System.out.println("Enter ID: ");
                        ID = sc.nextLine();
                        System.out.println("Enter Name: ");
                        Name = sc.nextLine();
                        System.out.println("Enter premiere_time: ");
                        premiere_time = sc.nextLine();
                        System.out.println("Enter Author_name: ");
                        Author_name = sc.nextLine();
                        System.out.println("Enter time: ");
                        time = sc.nextLine();

                        ppSmtInsert.setString(1, ID);
                        ppSmtInsert.setString(2, Name);
                        ppSmtInsert.setString(3, premiere_time);
                        ppSmtInsert.setString(4, Author_name);
                        ppSmtInsert.setString(5, time);

                        ppSmtInsert.executeUpdate();
                        System.out.println("SUCCESSFUL");
                    } else if (chon1 == 2) {
                        System.out.println("Sua thong tin phim ");
                        sc.nextLine();
                        System.out.println("Nhap ID phim muon sua: ");
                        ID = sc.nextLine();
                        System.out.println("\nBan muon sua thong tin gi? ");
                        System.out.println("1.Ten phim \t2.Thoi gian chieu \t 3.Ten tac gia \t 4.Thoi luong phim");
                        chon2 = sc.nextInt();

                        if (chon2 == 1) {
                            System.out.println("Sua ten phim");
                            sc.nextLine();
                            System.out.println("Nhap ten phim: ");
                            Name = sc.nextLine();
                            ppSmtUpdate.setString(1, ID);
                            ppSmtUpdate.setString(2, Name);

                        }
                        if (chon2 == 2) {
                            System.out.println("Sua ngay chieu phim");
                            sc.nextLine();
                            System.out.println("Nhap ngay chieu phim: ");
                            Name = sc.nextLine();
                            ppSmtUpdate.setString(1, ID);
                            ppSmtUpdate.setString(2, Name);
                            ppSmtUpdate.setString(3, premiere_time);
                            ppSmtUpdate.setString(4, Author_name);
                            ppSmtUpdate.setString(5, time);
                        }
                        if (chon2 == 3) {
                            System.out.println("Sua ten tac gia");
                            sc.nextLine();
                            System.out.println("Nhap ten tac gia: ");
                            Name = sc.nextLine();
                            ppSmtUpdate.setString(1, ID);
                            ppSmtUpdate.setString(2, Name);
                            ppSmtUpdate.setString(3, premiere_time);
                            ppSmtUpdate.setString(4, Author_name);
                            ppSmtUpdate.setString(5, time);
                        }
                        if (chon2 == 4) {
                            System.out.println("Sua thoi luong phim");
                            sc.nextLine();
                            System.out.println("Nhap thoi luong phim: ");
                            Name = sc.nextLine();
                            ppSmtUpdate.setString(1, ID);
                            ppSmtUpdate.setString(2, Name);
                            ppSmtUpdate.setString(3, premiere_time);
                            ppSmtUpdate.setString(4, Author_name);
                            ppSmtUpdate.setString(5, time);
                        }
                    } else if (chon1 == 3) {
                        System.out.println("Xoa phim");
                        sc.nextLine();
                        System.out.println("Nhap ID phim muon xoa");
                        ID = sc.nextLine();
                        ppSmtDelete.setString(1, ID);
                        ppSmtDelete.executeUpdate();
                    } else if (chon1 == 4) {
                        System.out.println("Tim kiem phim");
                        sc.nextLine();
                        System.out.println("\nNhap ID phim muon tim: ");
                        ID = sc.nextLine();
                        ppSmtSelect.setString(1, ID);
                        ResultSet rset = ppSmtSelect.executeQuery();
                        while (rset.next()) {
                            System.out.println(rset.getString("ID") + ", "
                                    + rset.getString("Name") + ", "
                                    + rset.getString("premiere_time") + ", "
                                    + rset.getString("Author_name") + ", "
                                    + rset.getString("Time") + ", "
                            );
                        }
                    }
                    conn.commit();
                    System.out.println("Ban co muon tiep tuc khong? ");
                    System.out.println("5.Yes\n 6.No");
                    chon1 = sc.nextInt();
                    if (chon1 == 6) {
                        break;
                    }
                } while (chon1 != 1||chon1 != 2 || chon1 != 3 || chon1 != 4 || chon1 != 5 );

            } catch (SQLException ex) {
                System.out.println("KHONG TON TAI");
                conn.rollback();
                ex.printStackTrace();
            }
        }
    }
}
