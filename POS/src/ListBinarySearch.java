import java.util.Comparator;
import java.util.List;

public class ListBinarySearch<T> {
	public T BinarySearchName(String productName, int start, int end, List<T> list) {
		T ri = null;
		if (list.size() > 0) {
			int indx = ((end - start) / 2) + start;
			ri = list.get(indx);
			NameBinarySearch riBin = (NameBinarySearch)ri;
			String name = riBin.getName();
			if (name.compareToIgnoreCase(productName) == 0) {
				return ri;
			}
			else if (indx == 0 && list.size() == 2) {
				ri = list.get(1);
				riBin = (NameBinarySearch)ri;
				name = riBin.getName();
				if (name.compareToIgnoreCase(productName) == 0) {
					return ri;
				}
				else ri = null;
			}
			else if (start == indx || start >= list.size()-1 || indx <= 0 || indx >= list.size() - 1) {
				ri = null;
			}
			else if (indx > 0 && indx < list.size()-1) {
				int dir = productName.compareToIgnoreCase(name);
				if (dir > 0) {
					ri = BinarySearchName(productName, indx, end, list);
				}
				else if (dir < 0 && end != 1) {
					ri = BinarySearchName(productName, 0, indx, list);
				}
				else if (end == 1) {
					ri = BinarySearchName(productName, 0, 0, list);
				}
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

