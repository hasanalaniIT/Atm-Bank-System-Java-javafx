package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MainLoginPage.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("ATM Bank System");
        primaryStage.getIcons().add(new Image("sample\\pics\\bank_60px.png"));
        primaryStage.setResizable(false);
        //primaryStage.sizeToScene();
        //primaryStage.showAndWait();
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
