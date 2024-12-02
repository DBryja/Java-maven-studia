package lab4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class ShapeDAO {
    private final SessionFactory sessionFactory;
    private static final Logger logger = LoggerFactory.getLogger(ShapeDAO.class);

    public ShapeDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session openSessionWithLogging() {
        Session session = sessionFactory.openSession();
        logger.info("\u001B[32mConnection successful\u001B[0m"); // Green color for successful connection
        return session;
    }

    public void saveShape(Shape shape) {
        Transaction transaction = null;
        try (Session session = openSessionWithLogging()) {
            transaction = session.beginTransaction();
            session.persist(shape);
            transaction.commit();
        } catch (Exception e) {
            logger.error("Error saving shape", e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public Shape getShapeById(Class<? extends Shape> shapeClass, int id) {
        try (Session session = openSessionWithLogging()) {
            return session.get(shapeClass, id);
        } catch (Exception e) {
            logger.error("Error getting shape by id", e);
            return null;
        }
    }

    public <T extends Shape> List<T> getAllShapes(Class<T> shapeClass) {
        try (Session session = openSessionWithLogging()) {
            return session.createQuery("from " + shapeClass.getName(), shapeClass).list();
        } catch (Exception e) {
            logger.error("Error getting all shapes", e);
            return null;
        }
    }

    public void updateShape(Shape shape) {
        Transaction transaction = null;
        try (Session session = openSessionWithLogging()) {
            transaction = session.beginTransaction();
            session.merge(shape);
            transaction.commit();
        } catch (Exception e) {
            logger.error("Error updating shape", e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void deleteShape(Shape shape) {
        Transaction transaction = null;
        try (Session session = openSessionWithLogging()) {
            transaction = session.beginTransaction();
            session.remove(shape);
            transaction.commit();
        } catch (Exception e) {
            logger.error("Error deleting shape", e);
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    public void close() {
        if (sessionFactory != null)
            sessionFactory.close();
    }
}