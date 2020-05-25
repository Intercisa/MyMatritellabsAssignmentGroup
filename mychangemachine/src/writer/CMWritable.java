package writer;

public interface CMWritable {
	String getFileName();
	String getWritableInformation();
	void persist();
}
