package businessLogic;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serban Sebastian Mihai
 * <p>This class uses relfexion in order to build Table Headers and populate Tables with values</p>
 * @param <T>
 */
public class CreateTable<T> {
    public CreateTable(){

    }

    /**
     *
     * @param obj
     * @return list of strings
     */
    public List<String> getFields(Object obj){
        List<String> fields = new ArrayList<String>();

        for(Field field: obj.getClass().getDeclaredFields()){
            fields.add(field.getName());
        }

        return fields;
    }

    /**
     *
     * @param objects
     * @return 2 dimensional Array in order to construct a JTable
     */
    public Object[][] populateTable(List<T> objects) {
        Integer noOfFields = 0;
        for(Field field: objects.get(0).getClass().getDeclaredFields()){
            noOfFields = noOfFields + 1;
        }

        Object[][] data = new Object[objects.size()][noOfFields];
        try {
            int i;
            int j;
            i = 0;
            for (T obj : objects) {
                j = 0;
                for(Field field: obj.getClass().getDeclaredFields()){
                    String fieldName = field.getName();
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, obj.getClass());
                    Method method = propertyDescriptor.getReadMethod();
                    Object value = method.invoke(obj);
                    data[i][j] = value;
                    j++;
                }
                i++;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }

        return data;
    }
}
