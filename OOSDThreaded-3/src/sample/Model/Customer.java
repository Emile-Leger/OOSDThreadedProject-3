package sample.Model;

import java.util.HashMap;
import java.util.Vector;

public class Customer {
    public final static String TableName = "customers";

    /*
    * constructor with each field provided
    * */

    public Customer(int customerId, String custFirstName, String custLastName, String custEmail,
                    String custHomePhone, String custBusPhone, String custAddress,String custPostal, String custCity,
                    String custCountry, String custProv, int agentId, String password, String userName)
        {
            CustomerId = customerId;
            CustFirstName = custFirstName;
            CustLastName = custLastName;
            CustEmail = custEmail;
            CustHomePhone = custHomePhone;
            CustBusPhone = custBusPhone;
            CustAddress = custAddress;
            CustPostal = custPostal;
            CustCity = custCity;
            CustCountry = custCountry;
            CustProv = custProv;
            AgentId = agentId;
            Password = password;
            UserName = userName;
        }

    public Customer() { }

    public static Customer getById(int CustomerId)
    {
        HashMap join = new HashMap();
        join.put("CustomerId",CustomerId);
        Factory factory = new Factory(Customer.class);
        factory.getSelectWhere(join);
        Customer myCust = (Customer) factory.makeEntity().firstElement();
        return myCust;
    }

    public static Vector<Customer> getWithoutAgent()
    {
        HashMap join = new HashMap();
        join.put("AgentId",null);
        return new Vector<Customer>();
    }

    public static Vector<Customer> getAll()
    {
        Factory factory = new Factory(Customer.class);
        factory.getSelectAll();
        Vector customers = factory.makeEntity();
        return customers;
    }

    private int CustomerId;
    public int getCustomerId() { return CustomerId; }
    public void setCustomerId(int customerId) { CustomerId = customerId; }

    private String CustFirstName;
    public String getCustFirstName() { return CustFirstName; }
    public void setCustFirstName(String custFirstName) { CustFirstName = custFirstName; }

    private String CustLastName;
    public String getCustLastName() { return CustLastName; }
    public void setCustLastName(String custLastName) { CustLastName = custLastName; }

    private String CustEmail;
    public String getCustEmail() { return CustEmail; }
    public void setCustEmail(String custEmail) { CustEmail = custEmail; }

    private String CustHomePhone;
    public String getCustHomePhone() { return CustHomePhone; }
    public void setCustHomePhone(String custHomePhone) { CustHomePhone = custHomePhone; }

    private String CustBusPhone;
    public String getCustBusPhone() { return CustBusPhone; }
    public void setCustBusPhone(String custBusPhone) { CustBusPhone = custBusPhone; }

    private String CustAddress;
    public String getCustAddress() { return CustAddress; }
    public void setCustAddress(String custAddress) { CustAddress = custAddress; }

    private String CustPostal;
    public String getCustPostal() { return CustPostal; }
    public void setCustPostal(String custPostal){ CustPostal = custPostal; }

    private String CustCity;
    public String getCustCity() { return CustCity; }
    public void setCustCity(String custCity) { CustCity = custCity; }

    private String CustCountry;
    public String getCustCountry() { return CustCountry; }
    public void setCustCountry(String custCountry) { CustCountry = custCountry; }

    private String CustProv;
    public String getCustProv() { return CustProv; }
    public void setCustProv(String custProv) { CustProv = custProv; }

    private int AgentId;
    public int getAgentId() { return AgentId; }
    public void setAgentId(int agentId) { AgentId = agentId; }
    //TODO deal with authentication
    private String Password;
    public String getPassword() { return Password; }
    public void setPassword(String password) { Password = password; }

    private String UserName;
    public String getUserName() { return UserName; }
    public void setUserName(String userName) { UserName = userName; }

}
