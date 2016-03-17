package sample.Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.Package;
import sample.Model.Product;
import sample.Model.ProductType;
import sample.Model.Supplier;

import java.util.Vector;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../View/sample.fxml"));
        primaryStage.setTitle("Agents");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        /*Vector<Agent> agents = Agent.getAll();
        for(Agent agent : agents)
        System.out.println(agent.getAgtFirstName()+" "+ agent.getAgtLastName());
        Factory fact = new Factory(Product.class);
        HashMap join = new HashMap();
        join.put(PackageProduct.TableName + "." + "PackageId",1);
        join.put(Product.TableName + "." + "ProductId",PackageProduct.TableName+"."+"ProductId");
        fact.getSelectWhere(join);*/

        /*Vector<Package> packages = Package.getAll();


        for (Package pack : packages){
            System.out.println(pack.getPkgName() + " " + pack.getPkgDesc());

            Vector<Product> prods =  pack.getProducts();
            for (Product prod : prods)
            {
                System.out.println(ProductType.getById(prod.getProductTypeId()).getProdTypeName() + " " + Supplier.getById(prod.getSupplierId()).getSupName());
            }
            System.out.println("----------------------------------------");
        }*/
        /*Vector<SupplierContact> supcons = SupplierContact.getAll();

        for (SupplierContact supplierContact : supcons)
        {
            if (supplierContact.getSupConFirstName() != null)
            {
                System.out.print(supplierContact.getSupConFirstName()+"------------");
                System.out.println(supplierContact.getSupConCompany());
            }
        }*/

        /*SupplierContact supcon = new SupplierContact();
        SupplierContact supcon2 = SupplierContact.getById(18);

        Vector<Agent> agents = Agent.getAll();

        for (Agent a : agents){
            Agent newAgent = a.clone();
            newAgent.setActive(true);
            Agent.update(a,newAgent);
        }*/

       /* supcon.setSupConAddress("123 fake st.");
        supcon.setSupConCompany("SAIT");
        supcon.setSupConCity("Calgary");
        supcon.setSupConCountry("Sweeeeeeten");
        supcon.setSupConProv("Alberta");
        supcon.setAffiliationId("helpme");
        supcon.setSupConBusPhone("1234567");
        supcon.setSupConFax("7654321");
        supcon.setSupConPostal("t2t-2b5");
        supcon.setSupConEmail("thisisdumb@gmail.com");
        supcon.setSupConURL("www.Ruby.com");
        supcon.setSupplierId(4);
        supcon.setSupConFirstName("Stan Lee");
        //SupplierContact.add(supcon);

        SupplierContact.update(supcon2,supcon);

        Supplier oldSupp = Supplier.getById(1);
        Supplier newSupp = new Supplier();
        newSupp.setSupName("Todd Packer");

        System.out.println(Supplier.update(oldSupp,newSupp));*/

        /*Supplier supp = Supplier.getById(1);

        System.out.println(Supplier.delete(supp));*/

        Vector<Product> products = Product.getAll();
        int i = 0;
        for (Product p : products)
        {
            i++;
            Product newProd = p.clone();
            newProd.setProductDesc(newProd.getProductDesc()+" "+i);
            newProd.setProductName(newProd.getProductName()+" "+i);
            Product.update(p,newProd);
        }

        //launch(args);
    }

}
