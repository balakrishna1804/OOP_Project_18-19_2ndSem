package sample;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;

public class Main extends Application {

    Stage window;
    Scene scene1, scene2;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("Management System");

        window.setOnCloseRequest(e ->{
            e.consume();
            closeProgram();
        });

        //Button 1
        Label scene1_label = new Label("This is the main page for data input");
        GridPane.setConstraints(scene1_label, 0, 0);

        Label scene2_label = new Label("This is the second page for data entry");
        GridPane.setConstraints(scene2_label, 0, 0);

        Label pincode_label = new Label("Pinoode of Project");
        GridPane.setConstraints(pincode_label, 0, 0);
        TextField pincode = new TextField();
        pincode.setPromptText("6 digit pincode");
        GridPane.setConstraints(pincode, 1, 0);

        Label area_label = new Label("Area of the project");
        GridPane.setConstraints(area_label, 0, 1);
        TextField area = new TextField();
        area.setPromptText("Area in sqft. ");
        GridPane.setConstraints(area, 1, 1);

        Label budget_label = new Label("Budget of the Project");
        GridPane.setConstraints(budget_label, 0, 2);
        TextField budget = new TextField();
        budget.setPromptText("In Indian Rupees");
        GridPane.setConstraints(budget, 1, 2);



        Button Button1N2 = new Button("Next");
        GridPane.setConstraints(Button1N2, 1, 3);

        // Exit Button
        Button exit_button = new Button("Close");
        GridPane.setConstraints(exit_button, 1, 4);

        //Button 2
        Button Button2N3 = new Button("Back");
        GridPane.setConstraints(Button2N3, 0, 3);

        //GridPane with 10px padding around edge
        GridPane grid1 = new GridPane();
        GridPane grid2 = new GridPane();

        grid1.setPadding(new Insets(10, 10, 10, 10));
        grid1.setVgap(20);
        grid1.setHgap(20);

        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(20);
        grid2.setHgap(20);


        grid1.getChildren().addAll(pincode_label, pincode, area_label, area, budget_label ,budget , Button1N2, exit_button);
        grid2.getChildren().addAll(scene2_label, exit_button, Button2N3);

        //Layout 1 - children laid out in vertical column
        //VBox layout1 = new VBox(20);
        //layout1.getChildren().addAll(scene1_label, Button1N2, exit_button);
        scene1 = new Scene(grid1, 500, 500);


        //Layout 2
        //VBox layout2 = new VBox(30);
        //layout2.getChildren().addAll(scene2_label, Button2N3, exit_button);
        scene2 = new Scene(grid2, 500, 500);

        Button1N2.setOnAction(e -> window.setScene(scene2));
        Button2N3.setOnAction(e -> window.setScene(scene1));
        exit_button.setOnAction(e -> closeProgram());

        //Display scene 1 at first
        window.setScene(scene1);
        window.show();


    }

    private void closeProgram(){
       boolean ans = ConfirmationBox.display("Exiting", "Are you sure you want to quit? All your unsaved progress will be lost");
        
       if(ans)
        window.close();
    }

}