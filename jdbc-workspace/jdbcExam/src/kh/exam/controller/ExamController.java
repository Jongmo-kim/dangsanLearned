package kh.exam.controller;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import common.JDBCTemplate;
import kh.exam.model.dao.ExamDao;
import kh.exam.model.vo.Board;
import kh.exam.model.vo.Member;

public class ExamController {
	Scanner sc;
	Member loginMember;
	ExamDao dao;

	public ExamController() {
		sc = new Scanner(System.in);
		dao = new ExamDao();
	}
	public void main() {
		while (true) {
			if(loginMember == null) notLoggedIn();
			else	loggedIn();
		}
	}
	public void notLoggedIn() {
			System.out.println("\n\n\n---- KH 커뮤니티 ----");
			System.out.println("1. 로그인하기");
			System.out.println("2. 회원가입");
			System.out.println("3. 아이디 찾기");
			System.out.println("0. 프로그램 종료");
			System.out.printf("선택 >");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				login();
				break;
			case 2:
				signUp();
				break;
			case 3:
				findId();
				break;
			default:
				System.exit(0);
			}
		
	}

	public void loggedIn() {
			System.out.println("\n\n\n---- KH 커뮤니티 ----");
			System.out.println("1. 게시물 목록보기");
			System.out.println("2. 게시물 상세보기");
			System.out.println("3. 게시물 등록");
			System.out.println("4. 게시물 수정");
			System.out.println("5. 게시물 삭제");
			System.out.println("6. 내정보 보기");
			System.out.println("7. 내정보 변경");
			System.out.println("8. 회원탈퇴");

			System.out.println("0. 로그아웃");
			System.out.printf("선택 >");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				printBoardList();
				break;
			case 2:
				openBoard();
				break;
			case 3:
				insertBoard();
				break;
			case 4:
				updateBoard();
				break;
			case 5:
				deleteBoard();
				break;
			case 6:
				printMemberInfo();
				break;
			case 7:
				updateMember();
				break;
			case 8:
				deleteMember();
				break;
			default:
				logout();
			}
		
	}

	private void printBoardList() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Board> list = dao.getAllBoard(conn);
		Iterator<Board> iter = list.iterator();
		System.out.println("---- 게시물 목록 ----");
		System.out.println("번호\t제목\t이름\t조회수\t올린시간");

		while (iter.hasNext()) {
			Board b = iter.next();
			System.out.printf("%d\t%s\t%s\t%s\t%s\t", b.getBoardNo(), b.getBoardTitle(), b.getBoardWriter(),
					b.getReadCount(), b.getWriteDate());
		}
		JDBCTemplate.close(conn);
	}

	private void openBoard() {
		Connection conn = JDBCTemplate.getConnection();
		Board b = dao.openBoard(conn,inputBoardNo());
		if(b == null) System.out.println("해당 게시글이 없습니다.");
		else {
			System.out.printf("게시물 번호 : %d\n",b.getBoardNo());
			System.out.printf("게시물 제목 : %s\n",b.getBoardTitle());
			System.out.printf("게시물 내용 : %s\n",b.getBoardContent());
			System.out.printf("게시물 작성자 : %s\n",b.getBoardWriter());
			System.out.printf("게시물 조회수 : %d\n",b.getReadCount());
			System.out.printf("게시물 작성일 : %s\n",b.getWriteDate());
		}
		JDBCTemplate.close(conn);
	}


	private void insertBoard() {
		Connection conn = JDBCTemplate.getConnection();
		String boardTitle = inputBoardTitle();
		String boardContent = inputBoardContent();
		int result = dao.insertBoard(conn,boardTitle,boardContent,loginMember.getMemberId());
		if(result > 0 ) System.out.println("등록 성공!");
		else System.out.println("등록 실패!");
		JDBCTemplate.close(conn);
	}

	private void updateBoard() {
		Connection conn = JDBCTemplate.getConnection();
		int boardNo = inputBoardNo();
		if(boardNo == loginMember.getMemberNo()) {
			String boardTitle = inputBoardTitle();
			String boardContent = inputBoardContent();
			int result = dao.updateBoard(conn,boardTitle,boardContent,boardNo);
			if(result > 0) System.out.println("게시글 등록 성공");
			else System.out.println("게시글 등록 실패");
		} 
		else System.out.println("작성자만 수정이 가능합니다.");
		JDBCTemplate.close(conn);
	}

	private void deleteBoard() {
		Connection conn = JDBCTemplate.getConnection();
		int boardNo = inputBoardNo();
		if(boardNo == loginMember.getMemberNo()) {
			int result = dao.deleteBoard(conn,boardNo);
			if(result > 0) System.out.println("삭제 성공!");
			else System.out.println("삭제 실패!");
		} else System.out.println("작성자만 삭제가 가능합니다.");
			
		JDBCTemplate.close(conn);
	}

	private void printMemberInfo() {
		System.out.println("---- 내 정보 보기 ----");
		System.out.printf("회원 번호: %d\n",loginMember.getMemberNo());
		System.out.printf("아이디: %s\n",loginMember.getMemberId());
		System.out.printf("비밀번호: %s\n",loginMember.getMemberPw());
		System.out.printf("이름: %s\n",loginMember.getMemberName());
		System.out.printf("전화번호: %s\n",loginMember.getPhone());

	}

	private void updateMember() {
		Connection conn = JDBCTemplate.getConnection();
		String memberPw = inputPw();
		String Phone = inputPhone();
		int result = dao.updateMember(conn, memberPw,Phone,loginMember.getMemberNo());
		if(result > 0) System.out.println("정보 수정 성공");
		else System.out.println("정보 수정 실패");
		JDBCTemplate.close(conn);
	}

	private void deleteMember() {
		Connection conn = JDBCTemplate.getConnection();
		System.out.println("정말 탈퇴 하시겠습니까(1. YES / 2. NO) :");
		if(sc.nextInt() == 1) {
			System.out.println("ByeBye~");
			dao.deleteMember(conn,loginMember.getMemberNo());
			logout();
		}
		JDBCTemplate.close(conn);
	}

	private void logout() {
		loginMember = null;
	}

	public void login() {
		String memberId = inputId();

		String memberPw = inputPw();

		Connection conn = JDBCTemplate.getConnection();
		loginMember = dao.loginMember(conn, memberId, memberPw);
		if (loginMember == null) {
			System.out.println("입력정보를 확인하세요.");
		} else {
			System.out.println("로그인 성공");
		}
		JDBCTemplate.close(conn);
	}

	private void signUp() {
		System.out.print("ID 입력: ");
		String memberId = sc.next();

		System.out.print("PW 입력: ");
		String memberPw = sc.next();

		System.out.print("이름 입력: ");
		String memberName = sc.next();

		System.out.print("전화번호 입력(ex.01011112222) : ");
		String phone = sc.next();

		Connection conn = JDBCTemplate.getConnection();
		if (dao.insertMember(conn, memberId, memberPw, memberName, phone) != 0) {
			System.out.println("회원가입 성공");
		} else {
			System.out.println("회원가입 실패");
		}
		JDBCTemplate.close(conn);
	}

	private void findId() {
		String memberId = inputId();
		String phone = inputPhone();
		Connection conn = JDBCTemplate.getConnection();
		Member m = dao.findId(conn, memberId, phone);

		if (m == null) {
			System.out.println("일치하는 정보가 없습니다.");
		} else {
			System.out.printf("아이디는 [%s]입니다.", m.getMemberId());
		}
		JDBCTemplate.close(conn);
	}

///////////////////////////////////////////////////////
	private String inputId() {
		System.out.print("ID 입력: ");
		return sc.next();

	}

	private String inputPw() {
		System.out.print("PW 입력: ");
		return sc.next();

	}

	private String inputName() {
		System.out.print("이름 입력: ");
		return sc.next();
	}

	private String inputPhone() {
		System.out.print("전화번호 입력(ex.01011112222) : ");
		return sc.next();
	}
	private int inputBoardNo() {
		System.out.print("게시물 번호 입력 : ");
		return sc.nextInt();
	}
	private String inputBoardTitle() {
		System.out.print("게시물 제목 입력 : ");
		return sc.next();
	}
	
	private String inputBoardContent() {
		System.out.print("게시물 내용 입력 : ");
		return sc.next();
	}


}
