package sample.Model;

import sample.Model.Database;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


/**
 * Created by user1 on 3/8/16.
 */
public class Factory
{
    private final String  SELECT = "SELECT * FROM ";
    private final String WHERE = " WHERE ";
    private final String TableName = "TableName";
    private Vector<HashMap> resultData;
    private Class dataClass;
    private String SQL;

    public Factory(Class c)
    {
        this.dataClass = c;
    }

    public void getSelectAll()
    {
        SQL = SELECT;
        try
        {
            Field f = dataClass.getDeclaredField(TableName);
            String table = new String();
            table = (String) f.get(table);
            SQL += table;
        }
        catch (NoSuchFieldException e){ e.printStackTrace(); }
        catch (IllegalAccessException e){ e.printStackTrace(); }
    }
    /*
    Build a list of Objects of the Type specified by the 'Class' property of this class.
     */

    public Vector makeEntity() {

        Database database = new Database();
        Vector objects = new Vector();
        resultData = database.Select(SQL);//submit the SQL
        ArrayList<Field> fields = getFields();//Retrieve references to all fields of the currently selected class
        for (HashMap map : resultData)//iterate one row of data
        {
            try
            {
                Object myObj = dataClass.newInstance();
                for (Field field : fields)
                {
                    if (field.getName() != TableName)
                    {
                        //get the name on the field
                        String fieldName = field.getName();
                        field.set(myObj, map.get(fieldName));
                    }
                }
                objects.add(myObj);
            }
            catch (InstantiationException e) { e.printStackTrace(); }
            catch (IllegalAccessException e) { e.printStackTrace(); }

        }
        return objects;
    }

    private ArrayList<Field> getFields()
    {
        ArrayList<Field> fields = new ArrayList<Field>();
        for (Object k : resultData.get(0).keySet())
        {
            try
            {
                Field f = dataClass.getDeclaredField(k.toString());
                f.setAccessible(true);
                fields.add(f);
            }
            catch (NoSuchFieldException e)
            {
                e.printStackTrace();
            }
        }
        return fields;
    }

    //Adds a where clause to the active SQL statement
    public void getSelectWhere(HashMap where)
    {
        if (where.size() > 1)
        {

        }
        String Where = where.toString().replace("{","").replace("}","");
        getSelectAll();
        SQL += WHERE+Where;
        //return SQL;
    }

    public void getAdditionalWhere(HashMap where)
    {

    }
}
