package com.hizkifw.randventure;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

public class SaveLoad {
	public static void saveObject(Object obj, String filename) throws Exception {
		//byte[] stateData = SerializationUtils.serialize((Serializable) new CurrentState());
		FileOutputStream fileOut = new FileOutputStream(filename);
		ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
		objectOut.writeObject(obj);
		objectOut.close();
		fileOut.close();
		
		//System.out.println(stateData);
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
