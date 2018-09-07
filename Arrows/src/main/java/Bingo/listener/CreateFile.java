package Bingo.listener;

import java.io.File;
import java.io.IOException;

import Bingo.tool.IFile;

public class CreateFile implements IFile {
	public static File CreateFile(File file) throws IOException {
		if(!file.exists()) {
			file.createNewFile();
		}else {
			return file;
		}
		return file;
	}
	public static File CreatePath(File path) {
		if(!path.exists()) {
			path.mkdirs();
		}else {
			return path;
		}
		return path;
}

}
