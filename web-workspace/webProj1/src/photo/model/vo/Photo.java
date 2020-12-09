package photo.model.vo;

public class Photo {
	private int photoNo;
	private String photoWriter;
	private String photoContent;
	private String filepath;
	private String photoDate;
	private int readCount;
	public int getPhotoNo() {
		return photoNo;
	}
	public void setPhotoNo(int photoNo) {
		this.photoNo = photoNo;
	}
	public String getPhotoWriter() {
		return photoWriter;
	}
	public void setPhotoWriter(String photoWriter) {
		this.photoWriter = photoWriter;
	}
	public String getPhotoContent() {
		return photoContent;
	}
	public void setPhotoContent(String photoContent) {
		this.photoContent = photoContent;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public String getPhotoDate() {
		return photoDate;
	}
	public void setPhotoDate(String photoDate) {
		this.photoDate = photoDate;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Photo(int photoNo, String photoWriter, String photoContent, String filepath, String photoDate,
			int readCount) {
		super();
		this.photoNo = photoNo;
		this.photoWriter = photoWriter;
		this.photoContent = photoContent;
		this.filepath = filepath;
		this.photoDate = photoDate;
		this.readCount = readCount;
	}
	public Photo() {
		super();
	}
	
}