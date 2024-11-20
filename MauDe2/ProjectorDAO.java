package MauDe2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class ProjectorDAO {
    private static final String filePath = "projector_data.txt";
    
    public void writeFile(List<Projector> projectorList) throws IOException{
    	try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
    		oos.writeObject(projectorList);
    	}
    }
   
	public List<Projector> readFile() throws IOException, ClassNotFoundException{
    	File file = new File(filePath);
    	if(!file.exists()) {
    		return new ArrayList<>();
    	}
    	try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
    		return (List<Projector>) ois.readObject();
    	}
    }
}
