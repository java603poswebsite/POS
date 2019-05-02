import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WriteReceipt {
	
	public void writeReceipt(Receipt r) {
		Path currentRelativePath = Paths.get(""); 
		String s = currentRelativePath.toAbsolutePath().toString();
		File dir = new File(s+ "\\POSFiles\\" + r.getDate() + "\\" + r.getRegisterId() + "\\" + r.getUserId()+"\\");
	    boolean successful = dir.mkdirs();
	    if (successful)
	    {
	      System.out.println("directory was created successfully");
	      ReadWriteXML<Receipt> xml = new ReadWriteXML<Receipt>();
			
			try {
				xml.receiptToXML(dir.getPath() + "/"+ r.getReceiptName() + ".xml", r);
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
	
}
