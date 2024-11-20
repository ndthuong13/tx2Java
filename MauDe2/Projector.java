package MauDe2;

public class Projector extends Product {
	private String projector_brand;
	private int projector_year;

	public Projector() {
		super();
	}

	public Projector(int product_id, String product_name, double product_price, int product_total,
			String projector_brand, int projector_year) {
		super(product_id, product_name, product_price, product_total);
		this.projector_brand = projector_brand;
		this.projector_year = projector_year;
	}

	public String getProjector_brand() {
		return projector_brand;
	}

	public void setProjector_brand(String projector_brand) {
		this.projector_brand = projector_brand;
	}

	public int getProjector_year() {
		return projector_year;
	}

	public void setProjector_year(int projector_year) {
		this.projector_year = projector_year;
	}

	@Override
	public String toString() {
		return super.toString() + ", Brand: " + projector_brand + ", Year: " + projector_year;
	}
}