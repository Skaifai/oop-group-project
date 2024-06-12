import java.sql.DriverManager;
import java.sql.Connection;
import java.util.Properties;

public class DatabaseOperations {
    Connection conn = null;
    public void connectToDB(Properties props) {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5433/clothes", props);
            if (conn != null) {
                System.out.println("Connection Established");
            } else {
                System.out.println("Connection Failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
<<<<<<< Updated upstream
=======
        return null;
    }

    // This method closes the connection.
    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This method was created to check conn status.
    public void Check() {
        System.out.println(conn.toString());
    }

    // This program is trying to create a new table of products.
    public void createTable() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS products" +
                    "(ID    INT PRIMARY KEY     NOT NULL," +
                    " NAME              TEXT    NOT NULL," +
                    " PRICE             REAL    NOT NULL," +
                    " STATUS            BOOLEAN NOT NULL," +
                    " TYPE              TEXT    NOT NULL)";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Table products created successfully.");
    }

    // This method deletes the products table. It is used to get rid of the leftovers.
    public void deleteTable() {
        try {
            Statement stmt = conn.createStatement();
            String sql = "DROP TABLE IF EXISTS products";
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // This method adds product to the product table, assigns the DB entry an id that auto increments.
    public void addProduct(Product product) {
        try {
            String productName = product.getName();
            double productPrice = product.getPrice();
            boolean productStatus = product.getStatus();
            String productType = product.getClass().getSimpleName();

            // The query.
            String sql = "INSERT INTO products (ID, NAME, PRICE, STATUS, TYPE) " +
                    "VALUES (?, ?, ?, ?, ?)";

            // Preparing the statement.
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Setting an ID to the product.
            stmt.setInt(1, productID);
            productID = productID + 1;
            // Setting a name to the product.
            stmt.setString(2, productName);
            // Setting a price to the product.
            stmt.setDouble(3, productPrice);
            // Setting the status to the product.
            stmt.setBoolean(4, productStatus);
            // Setting the type of the product.
            stmt.setString(5, productType);

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Product successfully added to the database.");
    }

    // Deletes the product based on the product's information.
    public void deleteProduct(Product product) {
        try {
            String productName = product.getName();
            double productPrice = product.getPrice();
            boolean productStatus = product.getStatus();
            String productType = product.getClass().getSimpleName();

            // The query.
            String sql = "DELETE FROM products " +
                    "WHERE name = ? AND price = ? AND status = ? AND type = ?";

            // Preparing the statement.
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Setting the name to the condition.
            stmt.setString(1, productName);
            // Setting the price to the condition.
            stmt.setDouble(2, productPrice);
            // Setting the status to the condition.
            stmt.setBoolean(3, productStatus);
            // Setting the type to the condition.
            stmt.setString(4, productType);

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Product successfully added to the database.");
    }

    // Reads products from the DB.
    public void readProducts() {
        try {
            // The query.
            String sql = "SELECT * FROM products";

            // Create the statement.
            Statement stmt = conn.createStatement();

            // Variable to save results to.
            ResultSet res = stmt.executeQuery(sql);

            while ( res.next() ) {
                int id = res.getInt("id");
                String  name = res.getString("name");
                double price  = res.getDouble("price");
                boolean status = res.getBoolean("status");
                String type = res.getString("type");

                System.out.println( "ID = " + id );
                System.out.println( "NAME = " + name );
                System.out.println( "PRICE = " + price );
                System.out.println( "STATUS = " + status );
                System.out.println( "TYPE = " + type );
                System.out.println();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Updates the product entry based on the name and the type of the product.
    // Only the price and the status can change.
    public void updateProduct (Product product) {
        try {
            String productName = product.getName();
            double productPrice = product.getPrice();
            boolean productStatus = product.getStatus();
            String productType = product.getClass().getSimpleName();

            // The query.
            String sql = "UPDATE products " +
                    "SET price = ?, status = ?" +
                    "WHERE name = ? AND type = ?";

            // Preparing the statement.
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Setting the price to the condition.
            stmt.setDouble(1, productPrice);
            // Setting the status to the condition.
            stmt.setBoolean(2, productStatus);
            // Setting the name to the condition.
            stmt.setString(3, productName);
            // Setting the type to the condition.
            stmt.setString(4, productType);

            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Product successfully added to the database.");
>>>>>>> Stashed changes
    }
}
