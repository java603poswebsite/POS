import java.io.Serializable;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.*;
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
	 /* public String toString() {
	        //return products.toString();
	      return Arrays.toString(products.toArray());
	       
	    }*/
		public String toString() {
			if (products != null) {
				for (Product i : products)
					System.out.println(i);
				return products.toString();
			}
			else
				return null;
		}
		//	Iterator<Product> i = products.iterator();
			//while(i.hasNext())
			  //  System.out.print(i.next()+"\t");}
			/*Iterator<Product> i = products.iterator();
		    if (! i.hasNext()) {
		        return "[]";
		    }

		    StringBuilder sb = new StringBuilder();
		    sb.append('[');
		    for (;;) {
		        Object element = i.next();
		        sb.append(i == this ? "(this Collection)" : element);
		        if (! i.hasNext()) {
		            return sb.append(']').toString();
		        }
		        sb.append(", ");
		    }
		}
		/*public String toString() {
		    String listRepresentation = "";
		    List<Product> currentNode = products;

		    while (currentNode != null) {
		        listRepresentation += currentNode.getInfo() + "\n";
		        currentNode = currentNode.getNextNode();
		    }

		    return listRepresentation;
		}*/
		public List<Product> getProduct() {
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
			Product prod = BinarySearchName(productName, 0, products.size());
			if (prod != null)
				return prod;
			else
				return null;
		}
		
		
		private Product BinarySearchName(String productName, int start, int end) {
			int indx = ((end - start) / 2) + start;
			Product prod = products.get(indx);
			if (prod.getName().compareToIgnoreCase(productName) == 0) {
				return prod;
			}
			
			else if (indx > 0) {
				int dir = productName.compareToIgnoreCase(prod.getName());
				if (dir > 1) {
					prod = BinarySearchName(productName, indx, end);
				}
				else if (dir < 1 && end != 1) {
					prod = BinarySearchName(productName, 0, indx);
				}
				else if (end == 1) {
					prod = BinarySearchName(productName, 0, 0);
				}
			}
			else if (indx <= 0) {
				prod = null;
			}
			return prod;
		}
		
		
}

class ProductNameComparator implements Comparator<Product> {
	@Override
	public int compare(Product p1, Product p2) {
		return p1.getName().compareToIgnoreCase(p2.getName());
	}
	
	
}


