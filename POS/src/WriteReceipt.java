import java.io.File;
import java.net.URL;

public class WriteReceipt {
	
	public void writeReceipt(Receipt r) {
		URL url = getClass().getResource("/POSFiles/");
		File dir = new File(url.getPath() + r.getDate() + "/" + r.getRegisterId() + "/" + r.getUserId());
	    boolean successful = dir.mkdir();
	    if (successful)
	    {
	      System.out.println("directory was created successfully");
	      ReadWriteXML<Receipt> xml = new ReadWriteXML<Receipt>();
			
			try {
				xml.receiptToXML(r.getReceiptName() + ".xml", r);
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
