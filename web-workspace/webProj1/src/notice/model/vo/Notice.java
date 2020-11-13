package notice.model.vo;

public class Notice {
	private int noticeNo;
	private String noticeTitle;
	private String noticewriter;
	private String noticeContent;
	private String noticeDate;
	private String noticeFileName;
	private String noticeFilePath;
	private int noticeStatus;
	public Notice(int noticeNo, String noticeTitle, String noticewriter, String noticeContent, String noticeDate,
			String noticeFileName, String noticeFilePath, int noticeStatus) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticewriter = noticewriter;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.noticeFileName = noticeFileName;
		this.noticeFilePath = noticeFilePath;
		this.noticeStatus = noticeStatus;
	}
	public Notice() {
		super();
	}
	public int getNoticeNo() {
		return noticeNo;
	}
	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}
	public String getNoticeTitle() {
		return noticeTitle;
	}
	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}
	public String getNoticeWriter() {
		return noticewriter;
	}
	public void setNoticewriter(String noticewriter) {
		this.noticewriter = noticewriter;
	}
	public String getNoticeContent() {
		return noticeContent;
	}
	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}
	public String getNoticeDate() {
		return noticeDate;
	}
	public void setNoticeDate(String noticeDate) {
		this.noticeDate = noticeDate;
	}
	public String getNoticeFileName() {
		return noticeFileName;
	}
	public void setNoticeFileName(String noticeFileName) {
		this.noticeFileName = noticeFileName;
	}
	public String getNoticeFilePath() {
		return noticeFilePath;
	}
	public void setNoticeFilePath(String noticeFilePath) {
		this.noticeFilePath = noticeFilePath;
	}
	public int getNoticeStatus() {
		return noticeStatus;
	}
	public void setNoticeStatus(int noticeStatus) {
		this.noticeStatus = noticeStatus;
	}

}
