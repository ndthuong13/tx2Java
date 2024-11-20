package LamLaiMau1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SinhVienDAO {
	private final String filePath = "sinhvien.txt";
	
	public void writeFile(List<SinhVien> sinhVienList) throws IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
			oos.writeObject(sinhVienList);
		}
	}
	
	public List<SinhVien> readFile() throws IOException, ClassNotFoundException{
		File file = new File(filePath);
		if(!file.exists()) {
			return new ArrayList<>();
		}
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file ))){
			return (List<SinhVien>) ois.readObject();		
		}
	}
	
}
