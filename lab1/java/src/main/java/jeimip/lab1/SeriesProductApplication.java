package jeimip.lab1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SeriesProductApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(SeriesProductApplication.class.getResource("series-product-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 250);
        stage.setTitle("Series Product Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
