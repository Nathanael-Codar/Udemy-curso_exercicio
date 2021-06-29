package entities;

public class OrderItem {
	private Integer quantity;
	private Double price;
	private String product;
	
	public OrderItem() {
	}

	public OrderItem(Integer quantity, Double price, String product) {
		this.quantity = quantity;
		this.price = price;
		this.setProduct(product);
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double subTotal() {
		return quantity * price;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}
	
}
