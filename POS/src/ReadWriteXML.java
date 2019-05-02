import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class ReadWriteXML<T> {
	
	@SuppressWarnings({ "unchecked" })
	public T XMLReadFile (String filename) throws Exception {
		try {
        File file = new File(filename);
        JAXBContext jaxbContext = JAXBContext.newInstance(Object.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (T) jaxbUnmarshaller.unmarshal(file);
		}
		catch (Exception e) {
			e.printStackTrace();
			return (T) null;
		}
    }
	
	public void ObjectToXML(String filename, Object obj) throws Exception {  
	    File file = new File(filename);
	    JAXBContext jaxbContext = JAXBContext.newInstance(Object.class);

	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    jaxbMarshaller.marshal(obj, file);
	    jaxbMarshaller.marshal(obj, System.out);
	}
	
	public void UserReceiptListToXML(String filename, UserReceiptList obj) throws Exception {  
	    File file = new File(filename);
	    JAXBContext jaxbContext = JAXBContext.newInstance(UserReceiptList.class);

	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    jaxbMarshaller.marshal(obj, file);
	    jaxbMarshaller.marshal(obj, System.out);
	}
	
	public void registerToXML(String filename, Register obj) throws Exception {  
	    File file = new File(filename);
	    JAXBContext jaxbContext = JAXBContext.newInstance(Register.class);

	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    jaxbMarshaller.marshal(obj, file);
	    jaxbMarshaller.marshal(obj, System.out);
	}
	
	public void InventoryListToXML(String filename, InventoryList obj) throws Exception {  
	    File file = new File(filename);
	    JAXBContext jaxbContext = JAXBContext.newInstance(InventoryList.class);

	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    jaxbMarshaller.marshal(obj, file);
	    jaxbMarshaller.marshal(obj, System.out);
	}
	
	
	public void RegisterListToXML(String filename, RegisterList obj) throws Exception {  
	    File file = new File(filename);
	    JAXBContext jaxbContext = JAXBContext.newInstance(RegisterList.class);

	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    jaxbMarshaller.marshal(obj, file);
	    jaxbMarshaller.marshal(obj, System.out);
	}
	
	public void UserListToXML(String filename, UserList obj) throws Exception {  
	    File file = new File(filename);
	    JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);

	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    jaxbMarshaller.marshal(obj, file);
	    jaxbMarshaller.marshal(obj, System.out);
	}
	
	

	
	
}
