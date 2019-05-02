import java.util.LinkedList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlRootElement
@XmlSeeAlso({Register.class})
public class RegisterList {
	private List<Register> registers = new LinkedList<Register>();
	
	@XmlElementWrapper(name = "Registers")
    @XmlElement(name = "Register")
    public List<Register> getRegisters() {
        return registers;
    }
}
