package ademianiuk.tunesplayer;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit5.ApplicationTest;

import ademianiuk.tunesplayer.collection.Container;
import ademianiuk.tunesplayer.collection.LinkedListContainer;
import ademianiuk.tunesplayer.controller.MediaPlayerController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;

public class MainAppTest extends ApplicationTest {
    
    private Scene scene;

    private Container<Path> trackList;
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("controller/MediaPlayerView.fxml"));
        scene = new Scene(loader.load());
        stage.setScene(scene);
        MediaPlayerController mediaPlayerController = loader.getController();
        trackList = new LinkedListContainer<>();
        trackList.add(Paths.get(MainAppTest.class.getResource("media/TestTrackOne.wav").toURI()));
        trackList.add(Paths.get(MainAppTest.class.getResource("media/TestTrackTwo.wav").toURI()));
        mediaPlayerController.setTrackList(trackList);

        stage.show();
        stage.toFront();
    }

    @BeforeEach
    public void setUp() throws Exception {
    }

    @AfterEach
    public void tearDown() throws Exception {
        FxToolkit.hideStage();
        release(new KeyCode[]{});
        release(new MouseButton[]{});
    }

    @Test
    public void testChangeButtonBackgroundOnPause() throws InterruptedException  {
        Path pauseButton = Paths.get(MainApp.class.getResource("controller/button/pause.png").toString());
        clickOn("#play");
        clickOn("#play");
        TimeUnit.SECONDS.sleep(3);

        String expectedStyle = String.format("-fx-background-image: url('%s');", pauseButton.toString());
        assertEquals(scene.lookup("#play").getStyle(), expectedStyle);
    }
    
    @Test
    public void testForwardWhenEmptyTrackList() {
        clickOn("#next");
    }
    
    @Test
    public void testPrevWhenEmptyTrackList() {
        clickOn("#prev");
        
    }
    
}

