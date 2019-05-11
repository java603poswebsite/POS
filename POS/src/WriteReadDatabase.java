import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class WriteReadDatabase {
	public static void main(String[] args) {}
	public void writeReceipt(UserReceiptList r) {
		Path currentRelativePath = Paths.get(""); 
		String s = currentRelativePath.toAbsolutePath().toString();
		File dir = new File(s+ "\\Database\\" + r.getRegisterId() + "\\" + r.getDate() + "\\"  + r.getUserName()+"\\");
	    boolean successful = dir.mkdirs();
	    boolean exists = dir.exists();
	    if (exists)
	    {
	      System.out.println("directory was created successfully");
	      ReadWriteXML<UserReceiptList> xml = new ReadWriteXML<UserReceiptList>();
			
			try {
				xml.UserReceiptListToXML(dir.getPath() + "/"+ r.getDate() + r.getUserName() + ".xml", r);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    else
	    {
	      System.out.println("failed trying to create the directory");
	    }
	}
	
	public void writeUserList(UserList ul) {
		Path currentRelativePath = Paths.get(""); 
		String s = currentRelativePath.toAbsolutePath().toString();
		File dir = new File(s+ "\\Database\\Credentials\\");
	    boolean successful = dir.mkdirs();
	    boolean exists = dir.exists();
	    if (exists)
	    {
	      System.out.println("directory was created successfully");
	      ReadWriteXML<UserList> xml = new ReadWriteXML<UserList>();
			
			try {
				xml.UserListToXML(dir.getPath() + "/UserList.xml", ul);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    else
	    {
	      System.out.println("failed trying to create the directory");
	    }
	}
	
	public void writeRegisterList(RegisterList rl) {
		Path currentRelativePath = Paths.get(""); 
		String s = currentRelativePath.toAbsolutePath().toString();
		File dir = new File(s+ "\\Database\\Registers\\");
	    boolean successful = dir.mkdirs();
	    boolean exists = dir.exists();
	    if (exists)
	    {
	      System.out.println("directory was created successfully");
	      ReadWriteXML<RegisterList> xml = new ReadWriteXML<RegisterList>();
			
			try {
				xml.RegisterListToXML(dir.getPath() + "/RegisterList.xml", rl);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    else
	    {
	      System.out.println("failed trying to create the directory");
	    }
	}
	
	public void writeInventoryList(InventoryList il) {
		Path currentRelativePath = Paths.get(""); 
		String s = currentRelativePath.toAbsolutePath().toString();
		File dir = new File(s+ "\\Database\\Inventory\\");
	    boolean successful = dir.mkdirs();
	    boolean exists = dir.exists();
	    if (exists)
	    {
	      System.out.println("directory was created successfully");
	      ReadWriteXML<InventoryList> xml = new ReadWriteXML<InventoryList>();
			
			try {
				xml.InventoryListToXML(dir.getPath() + "/InventoryList.xml", il);
			} catch (Exception e) {
				e.printStackTrace();
			}
	    }
	    else
	    {
	      // creating the directory failed
	      System.out.println("failed trying to create the directory");
	    }
	}
	
	public InventoryList ReadInventoryList() throws Exception {
		Path currentRelativePath = Paths.get(""); 
		String s = currentRelativePath.toAbsolutePath().toString();
		File file = new File(s+ "\\Database\\Inventory\\InventoryList.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(InventoryList.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (InventoryList) jaxbUnmarshaller.unmarshal(file);
	}
	
	public UserList ReadUserList() throws Exception {
		Path currentRelativePath = Paths.get(""); 
		String s = currentRelativePath.toAbsolutePath().toString();
		File file = new File(s+ "\\Database\\Credentials\\UserList.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(UserList.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (UserList) jaxbUnmarshaller.unmarshal(file);
	}
	
	public RegisterList ReadRegisterList() throws Exception {
		Path currentRelativePath = Paths.get(""); 
		String s = currentRelativePath.toAbsolutePath().toString();
		File file = new File(s+ "\\Database\\Registers\\RegisterList.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(RegisterList.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (RegisterList) jaxbUnmarshaller.unmarshal(file);
	}
	
	public UserReceiptList ReadReceiptList (int registerId, String date, String userName) throws Exception {
		Path currentRelativePath = Paths.get(""); 
		String s = currentRelativePath.toAbsolutePath().toString();
		File file = new File(s+ "\\Database\\" + registerId + "\\" + date + "\\" + userName +"\\" +date + userName + ".xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(UserReceiptList.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (UserReceiptList) jaxbUnmarshaller.unmarshal(file);
	}
	
}
