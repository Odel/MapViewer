
// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   K

import java.io.*;

public class FileUtil {

    public FileUtil() {
    }

    public static final byte[] readFile(String fileName) {
    	//System.out.println("readFile:"+fileName);
        File file = new File(fileName);
        int length = 0;
        length = (int) file.length();
        if(length == 0){  //when packaged in a jar File doesn't work so the sizes are hard coded here
        	if(fileName.equals("worldmap317.dat")){
        		length = 330292;
        	}
        	if(fileName.equals("worldmap357.dat")){
        		length = 342273;
        	}
        	if(fileName.equals("worldmap377.dat")){
        		length = 354341;
        	}
        }
        byte buffer[] = new byte[length];
        InputStream inputstream = (new FileUtil()).getClass().getResourceAsStream(fileName);
        try (DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(inputstream))) {
            datainputstream.readFully(buffer, 0, length);
            return buffer;
        } catch (IOException ex) {
            System.out.println("readFile error:" + (new StringBuilder()).append(IResourceLoader.I(1385)).append(fileName).toString());
        }
        return null;
    }
}
