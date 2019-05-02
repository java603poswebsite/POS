import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({Register.class, Product.class})
public class RegisterList implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Register> registers = new LinkedList<Register>();
	
	@XmlElementWrapper(name = "Registers")
    @XmlElement(name = "Register")
    public List<Register> getRegisters() {
        return registers;
    }
	
	public void addRegister(Register r) {
		if (!registers.contains(r)) {
			registers.add(r);
		}
	}
	
	public void removeRegister(Register r) {
		if (registers.contains(r)) {
			registers.remove(r);
		}
	}
}
