package todo;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        Circle circle = new Circle();
        circle.setCenterX(300.0f);
        circle.setCenterY(135.0f);
        circle.setRadius(100.0f);
        Group root = new Group(circle);
        Scene scene = new Scene(root, 600, 300);
        stage.setTitle("JavaFX Circle");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        
        launch(args);
    }
}
