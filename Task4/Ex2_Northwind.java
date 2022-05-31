import java.sql.*;
import java.util.Scanner;

public class Ex2_Northwind {
    public static void main(String[] args) {
        try (
                Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/northwind",
                        "root", ""
                );
                Statement statement = connection.createStatement();
        ) {
//Hien thi khach hang
            String strSelect = "select CustomerID, CompanyName, ContactName, Address, Phone from Customers";
            System.out.println("The SQL Statement is: " + strSelect + "\n");

            ResultSet resultSet = statement.executeQuery(strSelect);
            System.out.println("The record selected are: ");
            int rowCount = 0;
            while (resultSet.next()) {
                String CustomerID = resultSet.getString("CustomerID");
                String CompanyName = resultSet.getString("CompanyName");
                String ContactName = resultSet.getString("ContactName");
                String Address = resultSet.getString("Address");
                String Phone = resultSet.getString("Phone");
                System.out.println(CustomerID + ", " + CompanyName + ", " + ContactName + ", " + Address + ", " + Phone);
                rowCount++;
            }
            System.out.println("Total number of record = " + rowCount);

// Tim kiem khach hang
            Scanner scanner = new Scanner(System.in);  // Create a Scanner scanner
            System.out.println("Enter CustomerID: ");
            String customerID = scanner.nextLine();  // Read CustomerID input
            System.out.println("CustomerID is: " + customerID);
            String findbyID = "SELECT * FROM Customers where CustomerID like '%"+customerID+"'";
            System.out.println(findbyID);
            //
            Scanner scanner1 = new Scanner(System.in);  // Create a Scanner scanner1
            System.out.println("Enter CompanyName: ");
            String companyName = scanner1.nextLine();  // Read CompanyName input
            System.out.println("CompanyName is: " + companyName);
            String findbyCpName ="SELECT * FROM Customers where CompanyName like '%"+companyName+"'";
            System.out.println(findbyCpName);
            //
            String query[] ={findbyID,
                    findbyCpName};
            for(String q : query){
                ResultSet resultSet1 = statement.executeQuery(q);
                System.out.println("ContactName for query "+q+" is(CompanyName, ContactName, Address, Phone): ");
                while (resultSet1.next()) {
                    String CustomerID = resultSet1.getString("CustomerID");
                    String CompanyName = resultSet1.getString("CompanyName");
                    String ContactName = resultSet1.getString("ContactName");
                    String Address = resultSet1.getString("Address");
                    String Phone = resultSet1.getString("Phone");
                    System.out.println(CustomerID + ", " + CompanyName + ", " + ContactName + ", " + Address + ", " + Phone);
                }
                System.out.println();
            }

//Hien thi san pham o Bang Category
            String strSelectCategory = "select CategoryID, CategoryName, Description, Picture from Categories";
            System.out.println("The SQL Statement is: " + strSelectCategory + "\n");

            ResultSet resultSet2 = statement.executeQuery(strSelectCategory);
            System.out.println("The record selected are: ");
            int rowCount1 = 0;
            while (resultSet2.next()) {
                String CategoryID = resultSet2.getString("CategoryID");
                String CategoryName = resultSet2.getString("CategoryName");
                String Description = resultSet2.getString("Description");
                String Picture = resultSet2.getString("Picture");
                System.out.println(CategoryID + ", " + CategoryName + ", " + Description + ", " + Picture);
                rowCount1++;
            }
            System.out.println("Total number of record = " + rowCount1);


//Tim kiem san pham o bang Product
            Scanner scanner2 = new Scanner(System.in);  // Create a Scanner scanner2
            System.out.println("Enter productID: ");
            String productId = scanner2.nextLine();  // Read productID input
            System.out.println("productID is: " + productId);
            String findbyProductID = "SELECT * FROM Product where productID like '%"+productId+"'";
            System.out.println(findbyProductID);
            //
            Scanner scanner3 = new Scanner(System.in);  // Create a Scanner scanner3
            System.out.println("Enter productName: ");
            String productNameF = scanner3.nextLine();  // Read productName input
            System.out.println("productName is: " + productNameF);
            String findbyProductName ="SELECT * FROM Product where productName like '%"+productNameF+"'";
            System.out.println(findbyProductName);
            //
            String jquery[] ={findbyProductID,
                    findbyProductName};
            for(String q : query){
                ResultSet resultSet3 = statement.executeQuery(q);
                System.out.println("ContactName for query "+q+" is(productID, productName, price, qty): ");
                while (resultSet3.next()) {
                    String productID = resultSet3.getString("productID");
                    String productName = resultSet3.getString("productName");
                    String price = resultSet3.getString("price");
                    String qty = resultSet3.getString("qty");
                    System.out.println(productID + ", " + productName + ", " + price + ", " + qty );
                }
                System.out.println();
            }


//Hien thi thong tin chi tiet don hang o bang ProductDetails
            String strSelectProductDetails = "select name, title, expirytime, version, picture from ProductDetails";
            System.out.println("The SQL Statement is: " + strSelectProductDetails + "\n");

            ResultSet resultSet4 = statement.executeQuery(strSelectProductDetails);
            System.out.println("The record selected are: ");
            int rowCount2 = 0;
            while (resultSet4.next()) {
                String name = resultSet4.getString("name");
                String title = resultSet4.getString("title");
                String expirytime = resultSet4.getString("expirytime");
                String version = resultSet4.getString("version");
                String picture = resultSet4.getString("picture");
                System.out.println(rowCount2+":" + name + ", " + title + ", " + expirytime + ", " + "\n" + version + ", " + picture + ".");
                System.out.println();
                rowCount2++;
            }
            System.out.println();
            System.out.println("Total number of record = " + rowCount2);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}