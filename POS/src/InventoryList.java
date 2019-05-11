import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;


@XmlRootElement
@XmlSeeAlso({Product.class})
public class InventoryList implements Serializable{

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private List<Product> products = new LinkedList<Product>();
		
		@XmlElementWrapper(name = "Products")
	    @XmlElement(name = "Product")
	    public List<Product> getProducts() {
	        return products;
	    }
		
		public void addProduct(Product p) {
			if (!products.contains(p)) {
				products.add(p);
				products.sort(new ProductNameComparator());
			}
		}
		
		public void removeProduct(Product p) {
			products.remove(p);
		}
		
		
		public Product findProductByName(String productName) {
			ListBinarySearch<Product> search = new ListBinarySearch<Product>();
			Product prod = (Product) search.BinarySearchName(productName, 0, products.size(), products);
			if (prod != null)
				return prod;
			else
				return null;
		}

		public void removeInventoryAmount(ReceiptItem ri) {
			// TODO Auto-generated method stub
			Product p = ri.getType();
			p.removeInventoryAmount(ri.getAmount());
		}
		
		
}

class ProductNameComparator implements Comparator<Product> {
	@Override
	public int compare(Product p1, Product p2) {
		return p1.getName().compareToIgnoreCase(p2.getName());
	}
	
	
}


