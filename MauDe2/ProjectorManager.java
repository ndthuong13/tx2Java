package MauDe2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProjectorManager {
    private List<Projector> projectors;
    private final ProjectorDAO projectorDAO;

    public ProjectorManager() {
    	projectorDAO = new ProjectorDAO();
    	try{
    		projectors =  projectorDAO.readFile();
    	}catch(IOException | ClassNotFoundException e) {
    		projectors = new ArrayList<>();
    	}
    }
    
    public boolean addProjector(Projector p) throws IOException {
        for (Projector projector : projectors) {
            if (projector.getProduct_id() == p.getProduct_id()) {
                System.out.println("ID sản phẩm đã tồn tại!");
                return false;
            }
        }
        return projectors.add(p);
    }


    public boolean editProjector(Projector p) throws IOException{
        for (int i = 0; i < projectors.size(); i++) {
            if (projectors.get(i).getProduct_id() == p.getProduct_id()) {
                projectors.set(i, p);
                System.out.println("Chỉnh sửa thành công.");
                return true;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với ID: " + p.getProduct_id());
        return false;
    }

    public boolean delProjector(int productId) throws IOException{
        for (int i = 0; i < projectors.size(); i++) {
            if (projectors.get(i).getProduct_id() == productId) {
                projectors.remove(i);
                System.out.println("Xoá thành công.");
                return true;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với ID: " + productId);
        return false;
    }


    public List<Projector> searchProjector(String name)  throws IOException{
        List<Projector> result = new ArrayList<>();
        for (Projector p : projectors) {
            if (p.product_name.toLowerCase().contains(name.toLowerCase())) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Projector> searchProjector(double minPrice, double maxPrice) throws IOException{
        List<Projector> result = new ArrayList<>();
        for (Projector p : projectors) {
            if (p.product_price >= minPrice && p.product_price <= maxPrice) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Projector> getProjectors() {
        return projectors;
    }
    
    public void hienThi() {
    	if(projectors != null) {
    		System.out.println("|================================================================================|");
    		System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n", "ID", "Ten", "Gia", "So luong", "Thuong hieu", "Nam san xuat");
    		System.out.println("|================================================================================|");
    		for(Projector p : projectors) {
        		System.out.printf("| %-10s | %-10s | %-10s | %-10s | %-11s | %-12s |\n", 
        				p.getProduct_id(), p.getProduct_name(), p.getProduct_price(), p.getProduct_total(), p.getProjector_brand(), p.getProjector_year());
    		}
    		System.out.println("|================================================================================|");
    	}else {
    		System.out.println("Khong tim thay danh sach!");
    	}
    }
    
    
}
