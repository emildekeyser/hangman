package db;

import java.io.File;

public class DBPath {

	public static String getPath() {

		if (File.listRoots()[0].getName() == "/") {
			return "../groep5_hangman_app/hangman.txt";
		} else {
			return "..\\groep5_hangman_app\\hangman.txt";
		}
	}
}
