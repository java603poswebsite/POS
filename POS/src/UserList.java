import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({User.class})
public class UserList implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<User> users = new LinkedList<User>();
	
	@XmlElementWrapper(name = "Users")
    @XmlElement(name = "User")
    public List<User> getUsers() {
        return users;
    }
	
	public void addUser(User u) {
		if (!users.contains(u)) {
			users.add(u);
		}
	}
	
	public void removeUser(User u) {
		if (users.contains(u)) {
			users.remove(u);
		}
	}
}