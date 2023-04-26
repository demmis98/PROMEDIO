package dev.demis.game.worlds;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class WorldSave {
  public WorldSave(String save) {
    File myObj = new File("res/worlds/worldSave.txt");
    try {
		FileWriter saver = new FileWriter("res/worlds/worldSave.txt");
	      saver.write(save);
	      saver.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
  }
}