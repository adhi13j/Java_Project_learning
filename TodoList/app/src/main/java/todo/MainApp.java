package todo ;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        //grid.setHgap(10);
        //grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setGridLinesVisible(true);

        Label userNameLabel = new Label("User Name:");
        TextField userNameField = new TextField();
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField();

        Button loginBtn = new Button("Sign in");
        loginBtn.setOnAction(event -> {
            String username = userNameField.getText();
            String password = passwordField.getText();
            if (username.isEmpty() || password.isEmpty()) {
                System.out.println("Please fill in all fields.");
            } else {
                System.out.println("Login attempted with username: " + username);
            }
        });

        grid.add(userNameLabel, 0, 0);
        grid.add(userNameField, 1, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(passwordField, 1, 1);
        grid.add(loginBtn, 1, 2);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setTitle("Login Form");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}