package sample.Model;

import sun.management.*;

import java.lang.reflect.Field;
import java.util.*;


/**
 * Created by user1 on 3/8/16.
 */
public class Factory
{
    private final String  SELECT = "SELECT * FROM ";
    private final String WHERE = " WHERE ";
    private final String TableName = "TableName";
    private final String AND = " AND";
    private Vector<HashMap> resultData;
    private Class dataClass;
    private String SQL;

    public Factory(Class c)
    {
        this.dataClass = c;
    }
    /*
    These methods deal with building the SQL string that will be sent to the database.
    TODO evaluate the placement of them in this class
    */
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

    //Adds a where clause to the active SQL statement
    public String getSelectWhere(HashMap where)
    {
        String Where = where.toString().replace("{" , "").replace("}" , "").replace("," , AND);
        getSelectAll();
        SQL += WHERE + Where;
        return SQL;
    }
    /*
    These methods deal with building objects. for this to work, the class being instatiated must have a
    set of fields that correspond directly to the table in the database they represent. Classes that do not follow
    this structure will be instantiated but will break this code when their fields are set.
     */
    public Vector makeEntity() {

        Database database = new Database();
        Vector objects = new Vector();
        resultData = database.Select(SQL);//submit the SQL

        if (resultData.isEmpty())//No results, return empty list
            return objects;

        ArrayList<Field> fields = getFields();//Retrieve references to all fields of the currently selected class
        for (HashMap map : resultData)//iterate one row of data
        {
            try
            {
                Object myObj = dataClass.newInstance();
                for (Field field : fields)
                {
                    if (field.getName() != TableName)//all other fields on data classes instantiated here will hold data
                    {
                        //get the name on the field
                        String fieldName = field.getName();
                        field.set(myObj, map.get(fieldName));//set the field to the appropriate value in the Data HashMap
                    }
                }
                objects.add(myObj);
            }
            catch (InstantiationException e) { e.printStackTrace(); }
            catch (IllegalAccessException e) { e.printStackTrace(); }
        }
        return objects;
    }
    //retrieves each field of the assigned Class and returns the accessible version of each in an array.
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
}
