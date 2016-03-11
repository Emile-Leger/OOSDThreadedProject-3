package sample.Controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Model.*;
import sample.Model.Package;
import java.util.Vector;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("View/sample.fxml"));
        primaryStage.setTitle("Hello World");
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

        Vector<Agent> agents = Agent.getAll();
        for (Agent prod : agents)
        {
            System.out.println(prod.getAgtFirstName()+"- -"+prod.getAgtMiddleInitial()+"- -"+ prod.getAgtLastName() );
        }
        //launch(args);
    }

}
