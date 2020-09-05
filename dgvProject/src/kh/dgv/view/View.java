package kh.dgv.view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import kh.dgv.model.vo.Drinking;
import kh.dgv.model.vo.Movies;
import kh.dgv.model.vo.Popcorn;
import kh.dgv.model.vo.Product;
import kh.dgv.model.vo.SelectedMenu;


public class View {

	Scanner sc;
	SimpleDateFormat timeFormat;
	SimpleDateFormat runningTimeFormat;
	public View(){
		timeFormat = new SimpleDateFormat("yyyy년 M월 d일 H시 m분");
		runningTimeFormat = new SimpleDateFormat("h시간 mm분");
		sc=new Scanner(System.in);
	}
	public void enterMessage() {
		System.out.println("\nDGV에 오신것을 환영합니다.\n");
		System.out.println("\n\t1.알바생\n\t2.손님\n\t0.종료\n");
		System.out.println("\t\t\t영화는 역시DGV");
		System.out.print("선택 >");
	}
	public void enterAdminMessage() {
		System.out.println("\n\t 안녕, 미소지기!\n");
		System.out.println("\t 1.영화 추가하기");
		System.out.println("\t 2.영화 수정하기");
		System.out.println("\t 3.영화 삭제하기");
		System.out.println("\t 4.상영중인 영화\n");
		
		System.out.println("\t DGV 매점");
		System.out.println("\t 5.재고 현황보기");
		System.out.println("\t 6.상품등록");
		System.out.println("\t 7.상품수정");
		System.out.println("\t 8.상품삭제\n");
		System.out.println("\t 0. 이전 화면으로\n");
		System.out.print("선택 >");
	}
	public void enterGuestMessage() {
		System.out.println("\n\t1. 영       화   \t관");
		System.out.println("\t2. 매\t\t점");
		System.out.println("\n\t0. 이전 화면 으로");
		System.out.print("\n선택 >");
	}
	public void enterGuestMovieMessage() {
		System.out.println("\n\t1. 영화 예매 하기");
		System.out.println("\t2. 예매 내역 확인");
		System.out.println("\t3. 영화 예매 취소");
		System.out.println("\n\t0. 이전 화면 으로");
		System.out.print("\n선택 >");
	}
	public void enterGuestStoreMessage() {
		System.out.println("\n\t1. 매점 쇼핑 하기\n");
		System.out.println("\t0. 이전 화면 으로");
		System.out.print("\n선택 >");
	}
	public void enterStoreShoppingMessage() {
		System.out.println("\n\t1.음료구매");
		System.out.println("\t2.음식구매");
		System.out.println("\t3.팝콘구매\n");
		System.out.println("\t0. 이전 화면 으로");
		System.out.print("\n선택 >");
	}
	public void initAdminInsertProductMessage() {
		System.out.println("\tDGV 매점");
		System.out.println("\t상품 등록");
		System.out.println("\n\t1.음료등록");
		System.out.println("\t2.음식등록");
		System.out.println("\t3.팝콘등록\n");
		System.out.println("\t0. 이전 화면 으로");
		System.out.print("\n선택 >");
	}
	public void insertMovieMessage() {
		System.out.println("\t새로운 영화가 개봉 됐나보군요.");
		System.out.printf("등록하고 싶은 영화의 제목을 입력하세요 >");

	}
	public void printOutOfMovies() {
		System.out.println("현재 상영중인 영화가 없습니다.");
	}
	public void printOutOfStocks() {
		System.out.println("현재 상품 및 재고가 없습니다.");
	}
	public void printFullOfMovies() {
		System.out.println("현재 상영관이 가득 찼습니다.");
	}
	public void printFullOfStocks() {
		System.out.println("현재 창고가 가득 찼습니다.");
	}
	public void insertDoneMessage() {
		System.out.println("성공적으로 추가되었습니다.");
	}
	public void notEnoughSpaceMessage() {
		System.out.println("공간이 부족하여 저장하지 못하였습니다.");
	}
	public void selectMoviesMessage(String purpose,int idx) {
		System.out.printf("\n%s하려는 영화의  No.를 선택해 주세요 [1~%d]:",purpose,idx);
	}
	public int selectModifyNameOrTimeOrRunningTime() {
		System.out.println("무엇을 수정하시겠습니까?");
		System.out.println("\n\t1.영화 제목");
		System.out.println("\t2.시작 시간");
		System.out.println("\t3.상영 시간");
		System.out.println("\t0. 이전 화면 으로");
		System.out.print("\n선택 >");
		return sc.nextInt();
	}
	public void modifyMovieNameMessage() {
		System.out.print("변경하고 싶은 새 제목을 입력하세요. :");
	}
	public void modifyMovieDoneMessage(String str) {
		System.out.printf("%s으로 변경되었습니다.\n",str);
	}
	public void modifyMovieStartTimeMessage() {
		System.out.print("변경하고 싶은 새 시작시간을 입력하세요. :");
	}
	
	public void modfiyMovieRunningTimeMessage() {
		System.out.print("변경하고 싶은 새 상영 시간을 입력하세요. [HH:mm]:");
	}
	
	public void deleteConfrimMessage(Movies movie) {
		System.out.printf("%s영화를 선택했습니다.\n",movie.getName());
		System.out.printf("정말 삭제하시겠습니까? [y/n] :");
	}
	public void printSelectMovieNumber(String purpose) {
		System.out.printf("%s하고싶은 영화의 No.를 입력해주세요",purpose);
	}
	public void printSelectedMovieName(String purpose) {
		System.out.printf("선택하신 영화의 제목은 %s입니다.\n",purpose);
	}
	public void printAskingAmountOfTicket() {
		System.out.print("몇 명 예약하시겠어요 ? :");
	}
	public void printAskTicketSeats(int NumberOfTickets) {
		System.out.printf("%d 번째 손님 예매 도와드리겠습니다. \n",NumberOfTickets);
		System.out.print("좌석중에 어디 열로 하시겠어요? (A~J): ");
	}
	public void printAskNumOfSeat(char ch) {
		System.out.printf("%c열의 몇 번자리로 하시겠어요? (1~10):",ch);
	}
	public void printAlreadyOccupiedSeat() {
		System.out.println("이미 지정된 자리가 있습니다.");
	}
	public void printCancelTicketId() {
		System.out.print("예매시 부여받은 ID를 입력하세요. :");
	}
	public void printCancelFail() {
		System.out.println("맞는 번호가 없습니다.");
	}
	public void printCancelSucess() {
		System.out.println("취소 되었습니다.");
	}
	public void printSeats(Movies movie){
		

		Date start,end;
		System.out.println("No.\t영화제목\t\t시작시간\t\t\t\t종료시간\t\t\t\t상영시간");
		end = new Date(movie.getEndTime().getTimeInMillis());
		start = new Date(movie.getStartTime().getTimeInMillis());
		System.out.printf("%d.\t%s\t\t%s\t\t%s\t\t%s\n",movie.getIndex(),movie.getName(),
								timeFormat.format(start),timeFormat.format(end),movie.getRunningTime());
		System.out.println("\t ┌───────────────────────────────────────────────────────────────────────────────────┐");
		System.out.println("\t └───────────────────────────────────────────────────────────────────────────────────┘");
		
		System.out.print("\t");
		for(int List_i=0;List_i<movie.horizontalSeats;++List_i) {
			System.out.print(List_i+1+"\t");
		}
		System.out.println();
		
		for(int width=0;width<movie.verticalSeats;++width) {
			System.out.print("\n "+(char)('A'+width)+"열\t");
			for(int length=0;length<movie.horizontalSeats;++length) {
				if(movie.isChecked(width,length)) {
					System.out.print("■\t");
				}
				else{
					System.out.print("□\t");
				}
			}
		}
		System.out.println();
	}

	public SelectedMenu productSelectMessage() {
		buyingMessage("No.");
		int no = sc.nextInt();
		buyingMessage("갯수");
		int amount = sc.nextInt();
		return new SelectedMenu(no,amount);
	}
	public void buyingMessage(String str) {
		System.out.printf("구매할 제품의 %s(을)를 선택해주세요 :",str);
	}
	public void productMenuMessage(Product[] product,String kind,int idx) {
		System.out.println("────────────────────────────────────────────────");
		System.out.printf("\t\t%s\n",kind);
		System.out.println("No.\t제품명\t수량\t가격");
		printAllProductForMenu(product,idx);
		System.out.println("────────────────────────────────────────────────");
	}
	public void printAllProductForMenu(Product[] product,int idx) {
		for(int List_i=0;List_i<idx;++List_i) {
			printProduct(product[List_i]);
		}
	}
	public void printProduct(Product product) {
		System.out.printf("No.%d\t%s\t%d\t%d\n",product.getIndex()+1,product.getName(),product.getAmount()
				,product.getPrice());
	}
	
	public void popcornMenuMessage(Popcorn[] popcorn,int idx) {
		System.out.println("────────────────────────────────────────────────");
		System.out.println("\t\t         팝콘\n");
		System.out.println("No.\t제품명\t\t수량\t가격\t맛\n");
		printAllPopcornForMenu(popcorn,idx);
		System.out.println("────────────────────────────────────────────────");
	}
	public void printAllPopcornForMenu(Popcorn[] popcorn,int idx) {
		for(int List_i=0;List_i<idx;++List_i) {
			printPopcorn(popcorn[List_i]);
		}
	}
	public void printPopcorn(Popcorn popcorn) {
		System.out.printf("No.%d\t%s\t%s\t%s\t%s\n",popcorn.getIndex()+1,popcorn.getName(),popcorn.getAmount()
				,popcorn.getPrice(),popcorn.getFlavor());
	}
	public void buyingDoneMessage() {

		System.out.println("구매 완료했습니다.");
	}
	
	public void deleteDoneMessage() {
		System.out.println("삭제 완료");
	}
	public void foodMenuMessage() {
		
	}
	public void productNameInsertMessage(String product) {
		System.out.printf("추가할 %s의 이름을 입력해주세요 : ",product);
	}
	public void productAmountInsertMessage(String product) {
		System.out.printf("추가할 %s의 재고를 입력해주세요 :", product);
	}
	public void productPriceInsertMessage(String product) {
		System.out.printf("추가할 %s의 가격을 입력해주세요 :",product);
	}
	public void popcornFlavorInsertMessage(String product) {
		System.out.printf("추가할 %s의 맛을 입력해주세요 :",product);
	}
	public void popcornMenuMessage() {

	}
	
	public void printTicketDoneMessage(int Id) {
		System.out.printf("고객님의 ID는 %d 입니다.\n",Id);
		System.out.println("부여받으신 ID는 예매내역 확인이나 예매취소시 사용됩니다. 잊지 말고 계세요!");
	}
	public void initAdminModifyProductMessage() {
		System.out.println("\tDGV 매점");
		System.out.println("\t상품 수정");
		System.out.println("\n\t1.음료수정");
		System.out.println("\t2.음식수정");
		System.out.println("\t3.팝콘수정\n");
		System.out.println("\t0. 이전 화면 으로");
		System.out.print("\n선택 >");
	}
	public void modifyProductMessage(Product[] product,int idx) {
		printAllProductForMenu(product, idx);
		System.out.println("재고를 변경할 제품의 No.를 선택해주세요.");
		System.out.print("선택 >");
	}
	public void printProductSelectedMessage(Product product) {
		System.out.printf("%s 제품을 선택하셨습니다.\n",product.getName());
		System.out.printf("현재 재고는 %d개입니다.\n",product.getAmount());
		System.out.println("몇개로 수정할지 입력해주세요.");
		System.out.print("\n선택 >");
	}
	public void printProductModifyedMessage(int amount) {
		System.out.printf("%d개로 수정 완료되었습니다.\n",amount);
	}
	
	public void initAdminDeleteProductMessage() {
		System.out.println("\tDGV 매점");
		System.out.println("\t상품 삭제");
		System.out.println("\n\t1.음료삭제");
		System.out.println("\t2.음식삭제");
		System.out.println("\t3.팝콘삭제\n");
		System.out.println("\t0. 이전 화면 으로");
		System.out.println("삭제할 제품의 카테고리를 선택해 주세요.");
		System.out.print("\n선택 >");
	}
 
	public void printAllStoreStuffs(Product[] drinking,int drinkingIdx
			,Product[] food,int foodIdx,Popcorn[] popcorn, int popcornIdx) {
		productMenuMessage(drinking,"음료",drinkingIdx);
		productMenuMessage(food,"음식",foodIdx);
		popcornMenuMessage(popcorn,popcornIdx);
	}
	public void printAllMovies(Movies[] movies,int idx) {
		for(int List_i=0;List_i<idx;++List_i) {
			printSeats(movies[List_i]);
		}
	}
	
}
