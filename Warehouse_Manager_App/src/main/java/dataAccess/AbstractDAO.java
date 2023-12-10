package dataAccess;

import connection.ConnectionFactory;
import model.Bill;
import model.Client;
import model.Order;
import model.Product;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    /**
     *
     * @param field
     * @return String
     */
    private String selectQueryBuilder(String field){
        StringBuilder string = new StringBuilder();
        string.append("SELECT * FROM warehousedb.");
        string.append(type.getSimpleName());
        string.append(" WHERE " + field + " =?");
        return string.toString();
    }

    /**
     *
     * @param field
     * @return String
     */
    private String deleteQueryBuilder(String field){
        StringBuilder string = new StringBuilder();
        string.append("DELETE FROM warehousedb.");
        string.append(type.getSimpleName().toLowerCase());
        string.append(" WHERE " + field + " =?");
        return string.toString();
    }

    /**
     *
     * @return a list of all the records that were found after SELECT statement
     */
    public List<T> findAll(){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = "SELECT * FROM " + type.getSimpleName().toLowerCase();

        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            result = statement.executeQuery();

            return createObjects(result);
        }catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        }
        finally{
            ConnectionFactory.close(result);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }

    /**
     *
     * @param id
     * @return T object
     * <p>This method is meant to be used in order to recycle code</p>
     */
    public T findByID(Integer id){
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet result = null;
        String query = selectQueryBuilder("id");
        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            result = statement.executeQuery();

            List<T> list = createObjects(result);
            if(list.isEmpty())
                return null;
            else
                return list.get(0);
        }catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findByID " + e.getMessage());
        }
        finally{
            ConnectionFactory.close(result);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     *
     * @param resultSet
     * @return List<T>
     *     <p>This Method uses reflection to build up a list of records from a table</p>
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    public T insert(T object){
        Connection connection = null;
        Statement statement = null;
        String query;
        switch(type.getSimpleName()){
            case "Client":
                    query = ClientDAO.insertQueryBuilder((Client) object);
                break;
            case "Order":
                    query = OrderDAO.insertQueryBuilder((Order) object);
                break;
            case "Product":
                    query = ProductDAO.insertQueryBuilder((Product) object);
                break;
            case "Bill":
                    query = BillDAO.insertQueryBuilder((Bill) object);
                break;
            default:
                throw new IllegalArgumentException("The table " + type.getSimpleName() + " does not exist in the database");
        }

        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            return object;
        }catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        }finally{
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     *
     * @param object
     * @return Object of type T
     * <p> This method can be used in order to execute update statements</p>
     */
    public T update(T object){
        Connection connection = null;
        PreparedStatement statement = null;
        String query;
        switch(type.getSimpleName()){
            case "Client":
                query = ClientDAO.updateQueryBuilder((Client) object);
                break;
            case "Order":
                query = OrderDAO.updateQueryBuilder((Order) object);
                break;
            case "Product":
                query = ProductDAO.updateQueryBuilder((Product)object);
                break;
            default:
                throw new IllegalArgumentException("The table " + type.getSimpleName() + " does not exist in the database");
        }

        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.executeUpdate();
            return object;
        }catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        }finally{
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

        return null;
    }

    /**
     *
     * @param id
     * @return Boolean value
     */
    public Boolean deleteById(Integer id){
        Connection connection = null;
        PreparedStatement statement = null;
        String query = deleteQueryBuilder("id");

        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();

            return true;
        }catch(SQLException e){
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        }finally{
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
}
