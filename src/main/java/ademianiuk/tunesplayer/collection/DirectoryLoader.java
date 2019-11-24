package ademianiuk.tunesplayer.collection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Supplier;

public class DirectoryLoader< T extends Container<Path> > {
	
	public Container<Path> paths;
	private Supplier<T> supplier;
	
	public DirectoryLoader(Supplier<T> supplier) {
		this.supplier = supplier;
	}
	
	public Container<Path> load(Path rootDirectory) {
		paths = supplier.get();
		tryFillContainerFromRootDirectory(rootDirectory);
		
		return paths;
	}

	private void tryFillContainerFromRootDirectory(Path pathFolder) {
		try {
			Files.walk(pathFolder)
				.filter(Files::isRegularFile)
				.sorted()
				.forEach(paths::add);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
