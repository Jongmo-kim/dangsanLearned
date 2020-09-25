package kh.member.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Scanner;

import kh.common.JDBCTemplate;
import kh.member.model.dao.MemberDao;
import kh.member.model.vo.Member;

public class MemberController {
	Scanner sc;
	MemberDao dao;

	public MemberController() {
		super();
		sc = new Scanner(System.in);
		dao = new MemberDao();

	}
	public void selectOneMember() {
		System.out.println("아이디 입력 :");
		String memberId = sc.next();
		Connection conn = JDBCTemplate.getConnection();
		Member e = dao.selectOneMember(conn,memberId);
		
		if (e == null) {
			System.out.println("멤버가 없음");
		} else {
			System.out.println("번호\t아이디\t비밀번호\t이름\t성별\t전화번호\t가입일자");
			
				System.out.printf("%s", e.getMemberNo());
				System.out.printf("\t%s", e.getMemberId());
				System.out.printf("\t%s", e.getMemberPw());
				System.out.printf("\t%s", e.getMemberName());
				System.out.printf("\t%s", e.getPhone());
				System.out.printf("\t%c", e.getGender());
				System.out.printf("\t%s", e.getEnrollDate());
				System.out.println();
			}
	}
	public void main() {
		while (true) {
			System.out.println("\n=== 회원 관리 프로그램 ===");
			System.out.println("1. 전체회원 정보 출력");
			System.out.println("2. 회원 정보 출력(1명)");
			System.out.println("3. 회원 등록");
			System.out.println("4. 회원 정보 수정");
			System.out.println("5. 회원 정보 삭제");
			System.out.println("6. 회원 정보 조회(이름 + 포함되면 전부다 조회)");
			System.out.println("0. 종료");
			System.out.print("선택 >");
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				selectAllMember();
				break;
			case 2:
				selectOneMember();
				break;
			case 3:
				insertMember();
				break;
			case 4:
		//		updateMember();
				break;
			case 5:
				deleteMember();
				break;
			case 6:
	//			selectChoiceMember();
				break;
			default:
				System.exit(0);
			}
		}
	}
//	private void updateMember() {
//		System.out.print("수정할 아이디 입력 :");
//		String Id = sc.next();
//		Member e = dao.selectOneMemberById(Id);
//		if (e == null) {
//			System.out.println("멤버가 없음");
//		} else {
//		System.out.print("비밀번호 입력: ");
//		e.setMemberPw(sc.next());
//		
//		System.out.print("성별 입력[남/여]: ");
//		e.setGender(sc.next().charAt(0));
//		
//		System.out.print("전화 번호 입력[000-0000-0000]: ");
//		e.setPhone(sc.next());
//		System.out.printf("%d 개 행이 수정 되었습니다.",dao.updateMember(e));
//		}
//		
//	}

	public void deleteMember() {
		System.out.println("=== 회원삭제 ===");
		System.out.print("삭제할 아이디 입력 :");
		String memberId = sc.next();
		Connection conn = JDBCTemplate.getConnection();
		
		int result1 = dao.deleteMember(conn,memberId);
		int result2 = dao.insertDelMember(conn,memberId);
		
		if( result1 > 0 && result2 > 0 ) {
			JDBCTemplate.commit(conn);
			System.out.println("삭제 성공");
		} else {
			JDBCTemplate.rollback(conn);
			System.out.println("삭제 실패");
		}
			JDBCTemplate.close(conn);
	}

	public void insertMember() {
		System.out.println("=== 회원등록 ===");
		Member e = new Member();
		Connection conn = JDBCTemplate.getConnection();
		System.out.print("아이디 입력: ");
		e.setMemberId(sc.next());
		
		System.out.print("비밀번호 입력: ");
		e.setMemberPw(sc.next());
		
		System.out.print("이름 입력: ");
		e.setMemberName(sc.next());
		
		System.out.print("나이 입력: ");
		e.setAge(sc.nextInt());
		
		System.out.print("성별 입력[남/여]: ");
		e.setGender(sc.next().charAt(0));
		
		System.out.print("전화 번호 입력[000-0000-0000]: ");
		e.setPhone(sc.next());
		
		int result1 = dao.insertMember(conn, e);
		int result2 = dao.insertInsMember(conn, e.getMemberId());
		if(result1 > 0 && result2 > 0) {
			System.out.println("삽입 성공");
			JDBCTemplate.commit(conn);
		}else {
			System.out.println("삽입 실패");
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
	}
//	public void selectChoiceMember() {
//			System.out.print("조회할 아이디 입력 :");
//			String Id = sc.next();
//			ArrayList<Member> list = dao.selectChoiceMember(Id);
//			if (list.isEmpty()) {
//				System.out.println("멤버가 없음");
//			} else {
//				System.out.println("번호\t아이디\t비밀번호\t이름\t성별\t전화번호\t가입일자");
//				for (Member e : list) {
//					System.out.printf("%s", e.getMemberNo());
//					System.out.printf("\t%s", e.getMemberId());
//					System.out.printf("\t%s", e.getMemberPw());
//					System.out.printf("\t%s", e.getMemberName());
//					System.out.printf("\t%s", e.getPhone());
//					System.out.printf("\t%c", e.getGender());
//					System.out.printf("\t%s", e.getEnrollDate());
//					System.out.println();
//				}
//			
//		}
//	}
	public void selectAllMember() {
		Connection conn = JDBCTemplate.getConnection();
		ArrayList<Member> list = dao.selectAllMember(conn);
		if (list.isEmpty()) {
			System.out.println("멤버가 없음");
		} else {
			System.out.println("번호\t아이디\t비밀번호\t이름\t성별\t전화번호\t가입일자");
			for (Member e : list) {
				System.out.printf("%s", e.getMemberNo());
				System.out.printf("\t%s", e.getMemberId());
				System.out.printf("\t%s", e.getMemberPw());
				System.out.printf("\t%s", e.getMemberName());
				System.out.printf("\t%c", e.getGender());
				System.out.printf("\t%s", e.getEnrollDate());
				System.out.println();
			}
		}
	}
}
