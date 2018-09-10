package frontend;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.lang.reflect.InvocationTargetException;

import static frontend.Enum.CONST.LENGTH;
import static frontend.Enum.CONST.SIZE;


public class Chess extends Application{


    @Override
    public void start(Stage primaryStage) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        GridPane chessBoard = new Chessboard().getChessBoard();
        Scene scene = new Scene(chessBoard, LENGTH * SIZE, LENGTH * SIZE);
        primaryStage.setMaximized(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

}
