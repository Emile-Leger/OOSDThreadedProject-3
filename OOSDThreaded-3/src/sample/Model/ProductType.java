package sample.Model;

import java.util.HashMap;
import java.util.Vector;

/**
 * Created by user1 on 3/9/16.
 */
public class ProductType
{
    public static final String TableName = "producttypes";

    public ProductType(String prodTypeName, int productTypeId) {
        ProdTypeName = prodTypeName;
        ProductTypeId = productTypeId;
    }

    public ProductType() { }

    public static ProductType getById(int ProductTypeId)
    {
        HashMap join = new HashMap();
        join.put("ProductTypeId",ProductTypeId);
        Factory factory = new Factory(ProductType.class);
        factory.getSelectWhere(join);
        ProductType prodType = (ProductType) factory.makeEntity().firstElement();
        return prodType;
    }

    public static Vector<ProductType> getAll()
    {
        Factory factory = new Factory(ProductType.class);
        factory.getSelectAll();
        Vector prodTypes = factory.makeEntity();
        return prodTypes;
    }

    private String ProdTypeName;
    public String getProdTypeName() { return ProdTypeName; }
    public void setProdTypeName(String prodTypeName) { ProdTypeName = prodTypeName; }

    private int ProductTypeId;
    public int getProductTypeId() { return ProductTypeId; }
    public void setProductTypeId(int productTypeId) { ProductTypeId = productTypeId; }
}
