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
	
	public void receiptToXML(String filename, Receipt obj) throws Exception {  
	    File file = new File(filename);
	    JAXBContext jaxbContext = JAXBContext.newInstance(Receipt.class);

	    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

	    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	    jaxbMarshaller.marshal(obj, file);
	    jaxbMarshaller.marshal(obj, System.out);
	}
	
	
}
