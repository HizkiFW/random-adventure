package com.hizkifw.randventure;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SaveLoad {
	public static String base = System.getProperty("user.home") + "/.randventure/";

	public static void createDirs() {
		new File(base).mkdirs();
	}

	public static List<String> listFiles() {
		createDirs();

		List<String> listNames = new ArrayList<>();
		File dir = new File(base);
		File[] files = dir.listFiles();
		for(File file : files) {
			listNames.add(file.getName());
		}
		return listNames;
	}

	public static void saveObject(Object obj, String filename) throws Exception {
		createDirs();

		FileOutputStream fileOut = new FileOutputStream(base + filename);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		objectOut.writeObject(obj);
		objectOut.close();
		fileOut.close();

		System.out.println("Saved as " + base + filename);
	}

	public static Object loadObject(String filename) throws Exception {
		createDirs();

		FileInputStream fileIn = new FileInputStream(base + filename);
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		Object o = objectIn.readObject();
		objectIn.close();
		fileIn.close();
		return o;
	}
}
