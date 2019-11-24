package ademianiuk.tunesplayer;

import ademianiuk.tunesplayer.collection.Container;
import ademianiuk.tunesplayer.collection.LinkedListContainer;
import java.nio.file.Path;

public class TrackListController {

    private Container<Path> trackPaths;
    
    public TrackListController() {
        trackPaths = new LinkedListContainer<>();
    }
}
