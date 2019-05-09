import java.util.Comparator;
import java.util.List;

public class ListBinarySearch<T> {
	public T BinarySearchName(String productName, int start, int end, List<T> list) {
		int indx = ((end - start) / 2) + start;
		T ri = list.get(indx);
		NameBinarySearch riBin = (NameBinarySearch)ri;
		String name = riBin.getName();
		if (name.compareToIgnoreCase(productName) == 0) {
			return ri;
		}
		else if (indx <= 0) {
			ri = null;
		}
		else if (start == list.size()-1) {
			ri = null;
		}
		else if (indx > 0) {
			int dir = productName.compareToIgnoreCase(name);
			if (dir > 1) {
				ri = BinarySearchName(productName, indx+1, end, list);
			}
			else if (dir < 1 && end != 1) {
				ri = BinarySearchName(productName, 0, indx, list);
			}
			else if (end == 1) {
				ri = BinarySearchName(productName, 0, 0, list);
			}
		}
		return ri;
	}
}

class NameComparator implements Comparator<NameBinarySearch> {
	@Override
	public int compare(NameBinarySearch ri1, NameBinarySearch ri2) {
		return ri1.getName().compareToIgnoreCase(ri2.getName());
	}
	
	
}

