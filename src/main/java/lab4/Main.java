package lab4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.*;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main (String[]args){
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        ShapeDAO shapeDAO = new ShapeDAO(sessionFactory);

        try {
            // Create and save rectangles
            Rectangle rectangle1 = new Rectangle(5.0, 10.0);
            Rectangle rectangle2 = new Rectangle(3.0, 6.0);
            Rectangle rectangle3 = new Rectangle(7.0, 14.0);
            shapeDAO.saveShape(rectangle1);
            shapeDAO.saveShape(rectangle2);
            shapeDAO.saveShape(rectangle3);

            // Create and save triangles
            Triangle triangle1 = new Triangle(3.0, 4.0, 5.0);
            Triangle triangle2 = new Triangle(5.0, 12.0, 13.0);
            Triangle triangle3 = new Triangle(8.0, 15.0, 17.0);
            shapeDAO.saveShape(triangle1);
            shapeDAO.saveShape(triangle2);
            shapeDAO.saveShape(triangle3);

            // Retrieve and print all shapes
            List<Rectangle> rectangles = shapeDAO.getAllShapes(Rectangle.class);
            List<Triangle> triangles = shapeDAO.getAllShapes(Triangle.class);

            System.out.println("Rectangles:");
            rectangles.forEach(Rectangle::print);
            System.out.println("Triangles:");
            triangles.forEach(Triangle::print);
        } catch (Exception e) {
            logger.error("Error during database operations", e);
        } finally {
            shapeDAO.close();
        }
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

