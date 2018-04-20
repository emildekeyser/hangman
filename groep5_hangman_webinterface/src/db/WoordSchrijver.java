package db;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javax.swing.JOptionPane;

public class WoordSchrijver {
	
	private String fileName;

	public WoordSchrijver(String path) {
		 
		this.fileName = path;
	}

	public void schrijf(String nieWoord) {
		try {
		    Files.write(Paths.get(this.fileName), "the text".getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		    JOptionPane.showMessageDialog(null, "DB is kill");
		}
	}

}
