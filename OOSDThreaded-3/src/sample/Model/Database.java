package sample.Model;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashMap;
import java.util.Vector;




/**
 * Created by Emile.
 */
public class Database {
    private String connectionString = "jdbc:mysql://localhost:3306/travelexperts";
    private Connection mariaConn;
    public Database()
    {
        this.mariaConn = getConnection();
    }

    /*
    Fetches a connection to MySQL
     */
    public Connection getConnection()
    {
        try
        {
            Connection mariaConn = DriverManager.getConnection(connectionString, "root", "");
            return mariaConn;
        }
        catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    /*
    submits a SELECT SQL statement and returns a disconnected set of result data.
     */
    public Vector<HashMap> Select(String SQL)
    {
        Vector<HashMap> tableData = new Vector<>();
        try
        {
            Statement statement = mariaConn.createStatement();
            ResultSet result = statement.executeQuery(SQL);
            ResultSetMetaData metaData = result.getMetaData();
            while (result.next())
            {
                HashMap rowData = new HashMap();
                //constructs Key Values for the current row
                for (int i = 1; i <= result.getMetaData().getColumnCount(); i++)
                {
                    result.getObject(i);
                    if(result.wasNull()){

                        rowData.put(metaData.getColumnLabel(i), "null");
                    }
                    else if (result.getObject(i).getClass() == BigDecimal.class)
                    {
                        double cell = ((BigDecimal)result.getObject(i)).doubleValue();
                        rowData.put(metaData.getColumnLabel(i),cell);
                    }
                    else if (result.getObject(i).getClass() == Double.class)
                    {
                        int cell = ((Double)result.getObject(i)).intValue();
                        rowData.put(metaData.getColumnLabel(i),cell);
                    }
                    else
                    {
                        rowData.put(metaData.getColumnLabel(i), result.getObject(i));
                    }
                }
                tableData.add(rowData);
            }
            result.close();
            statement.close();
            mariaConn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return tableData;
    }
}
