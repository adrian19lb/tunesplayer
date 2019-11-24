package ademianiuk.tunesplayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Path;

import ademianiuk.tunesplayer.collection.Container;
import ademianiuk.tunesplayer.collection.LinkedListContainer;
import ademianiuk.tunesplayer.controller.ErrorController;
import ademianiuk.tunesplayer.controller.MediaPlayerController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

 public class MainApp extends Application {

     public static void main(String[] args) {
         launch(args);
     }

     @Override
     public void start(Stage primaryStage) throws Exception {
         Thread.setDefaultUncaughtExceptionHandler(MainApp::show);
         FXMLLoader loader = new FXMLLoader(getClass().getResource("controller/MediaPlayerView.fxml"));
         primaryStage.setScene(new Scene(loader.load()));
         MediaPlayerController mediaPlayerController = loader.getController();
         Container<Path> trackList = new LinkedListContainer<>();
         mediaPlayerController.setTrackList(trackList);
         primaryStage.setTitle("Tunes Player");
         primaryStage.show();
     }

     private static void show(Thread t, Throwable e) {
        System.err.println("***Default exception handler***");
        if (Platform.isFxApplicationThread()) {
            showErrorDialog(e);
        } else {
            System.err.println("An unexpected error occurred in "+t);

        } 
     }

    private static void showErrorDialog(Throwable e) {
        StringWriter errorMsg = new StringWriter();
        e.printStackTrace(new PrintWriter(errorMsg));
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("controller/ErrorView.fxml"));
        try {
            Parent root = loader.load();
            ((ErrorController)loader.getController()).setErrorText(errorMsg.toString());
            dialog.setScene(new Scene(root, 250, 400));
            dialog.show();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }


 }
