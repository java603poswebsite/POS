import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({User.class})
public class UserList {
	private List<User> users = new LinkedList<User>();
}
