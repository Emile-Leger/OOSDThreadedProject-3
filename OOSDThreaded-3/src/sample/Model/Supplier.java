package sample.Model;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by user1 on 3/9/16.
 */
public class Supplier
{
    public static final String TableName = "suppliers";

    public Supplier(String supName, int supplierId) {
        SupName = supName;
        SupplierId = supplierId;
    }


    public Supplier() { }

    public static Supplier getById(int supplierId)
    {
        HashMap join = new HashMap();
        join.put("SupplierId",supplierId);
        Factory factory = new Factory(Supplier.class);
        factory.getSelectWhere(join);
        Supplier supplier = (Supplier) factory.makeEntity().firstElement();
        return supplier;
    }

    public static Vector<Supplier> getAll()
    {
        Factory factory = new Factory(Supplier.class);
        System.out.println(Supplier.class);
        factory.getSelectAll();
        Vector suppliers = factory.makeEntity();
        return suppliers;
    }

    private String SupName;
    public String getSupName() { return SupName; }
    public void setSupName(String supName) { SupName = supName; }

    private int SupplierId;
    public int getSupplierId() { return SupplierId; }
    public void setSupplierId(int supplierId) { SupplierId = supplierId; }

}
