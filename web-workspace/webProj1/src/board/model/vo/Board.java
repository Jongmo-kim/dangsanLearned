package board.model.vo;

public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardwriter;
	private String boardContent;
	private String boardDate;
	private String boardFileName;
	private String boardFilePath;
	private int boardStatus;
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardwriter() {
		return boardwriter;
	}
	public void setBoardwriter(String boardwriter) {
		this.boardwriter = boardwriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public String getBoardFileName() {
		return boardFileName;
	}
	public void setBoardFileName(String boardFileName) {
		this.boardFileName = boardFileName;
	}
	public String getBoardFilePath() {
		return boardFilePath;
	}
	public void setBoardFilePath(String boardFilePath) {
		this.boardFilePath = boardFilePath;
	}
	public int getBoardStatus() {
		return boardStatus;
	}
	public void setBoardStatus(int boardStatus) {
		this.boardStatus = boardStatus;
	}
	public Board(int boardNo, String boardTitle, String boardwriter, String boardContent, String boardDate,
			String boardFileName, String boardFilePath, int boardStatus) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardwriter = boardwriter;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
		this.boardFileName = boardFileName;
		this.boardFilePath = boardFilePath;
		this.boardStatus = boardStatus;
	}
	public Board() {
		super();
	}
	
}
