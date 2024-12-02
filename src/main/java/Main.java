import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

//public class Main {
//    public static void main(String[] args) {
//        Rectangle whiteRect = new Rectangle(10, 15);
//        Triangle yellowTriangle = new Triangle(15, 25, 36, new Color(255, 255, 0));
//
//        ShapeDescriber.describe(whiteRect);
//        ShapeDescriber.describe(yellowTriangle);
//
//        ShapeRenderer.render(whiteRect);
//        ShapeRenderer.render(yellowTriangle);
//    }
//}

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main (String[]args){
        printDatabaseStructure();

//        ShapeDAO shapeDAO = new ShapeDAO();
//        // Przykładowe operacje na bazie danych
//        try {
//            Rectangle rectangle = new Rectangle(5.0, 10.0);
//            shapeDAO.saveShape(rectangle);
//            logger.info("Rectangle saved successfully");
//            Shape retrievedShape = shapeDAO.getShapeById(Rectangle.class, rectangle.id);
//            logger.info("Retrieved Shape: " + retrievedShape);
//            // Dodaj inne operacje, jeśli potrzebne
//        } catch (Exception e) {
//            logger.error("Error during database operations", e);
//        }
    }


    private static void printDatabaseStructure() {
        String url = "jdbc:postgresql://localhost:5432/java-laby";
        String username = "postgres";
        String password = "postgres";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            logger.info("Database connection successful");

            DatabaseMetaData metaData = connection.getMetaData();
            ResultSet tables = metaData.getTables(null, null, "%", new String[]{"TABLE"});

            if (!tables.isBeforeFirst()) {
                logger.info("No tables found in the database");
            }

            while (tables.next()) {
                String tableName = tables.getString("TABLE_NAME");
                System.out.println("Table: " + tableName);

                ResultSet columns = metaData.getColumns(null, null, tableName, "%");
                while (columns.next()) {
                    String columnName = columns.getString("COLUMN_NAME");
                    String columnType = columns.getString("TYPE_NAME");
                    System.out.println("    Column: " + columnName + " - " + columnType);
                }
            }
        } catch (SQLException e) {
            logger.error("Error retrieving database structure", e);
        }
    }
}

