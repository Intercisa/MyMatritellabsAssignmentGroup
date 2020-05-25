package writer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Writer {
	private static final String FS = System.getProperty("file.separator");
	private static final String dirName = "text";
	private static final String savePath = System.getProperty("user.dir") + FS + dirName;
	private static PrintWriter textFileWriter = null;
	private static int status = -1;
	
	private Writer() {}

	public static int persisitUser(final CMWritable writable) {
		File saveLocation = new File(savePath);
		if (!saveLocation.exists()) {
			saveLocation.mkdir();
			writeInFile(writable);
		}else {
			writeInFile(writable);
		}
		return status;
	}
	
	private static void writeInFile(final CMWritable writable) {
		File myFile = new File(savePath, writable.getFileName() + ".txt");

		try {
			textFileWriter = new PrintWriter(new FileWriter(myFile));
			textFileWriter.write(writable.getWritableInformation());
			
			status = 1;
		} catch (IOException e) {

			e.printStackTrace();
		} finally {
			textFileWriter.close();
		}
	}
}
