import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({Product.class})
public class ProductMasterList {
	private List<Product> products = new LinkedList<Product>();
	
}
