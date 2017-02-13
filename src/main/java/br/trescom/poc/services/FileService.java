package br.trescom.poc.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author johngomes
 */
public class FileService {
    
    public static final String TARGET_PATH = "/Users/johngomes/Downloads/uploads/";
    
    public void saveFileInDirectory(byte[] file) throws FileNotFoundException, IOException{
        
        String filePath = TARGET_PATH + "arquivo.jpg";
        File fileTarget = new File(filePath);
        
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(fileTarget));
        
        stream.write(file);
        stream.close();
            
    }
    
}
