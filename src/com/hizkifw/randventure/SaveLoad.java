package com.hizkifw.randventure;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SaveLoad {
	public static void saveObject(Object obj, String filename) throws Exception {
		FileOutputStream fileOut = new FileOutputStream(filename);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		objectOut.writeObject(obj);
		objectOut.close();
		fileOut.close();
	}
	
	public static Object loadObject(String filename) throws Exception {
		FileInputStream fileIn = new FileInputStream(filename);
		ObjectInputStream objectIn = new ObjectInputStream(fileIn);
		Object o = objectIn.readObject();
		objectIn.close();
		fileIn.close();
		return o;
	}
}
