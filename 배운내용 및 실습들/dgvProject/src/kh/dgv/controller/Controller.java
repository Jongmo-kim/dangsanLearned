package kh.dgv.controller;

/*
 * 	1일차 기본적인 클래스들 movies, product,popcorn클래스들을 만들어서 CRUD를 할수있게끔 토대를 짰다.
 * 하지만 상영시간을 구하는것에 애를먹어 상당히 지체되었다.
 * 
 * 	지체된 이유는 시간값이 들어있는 calendar.getTimesMill()함수는 1970년 1월 1일 9시부터 지금까지 1밀리세컨드씩 센 값을 리턴한는데
 * 여기서 두개의 Calendar 객체를 가지고 하나는 영화 시작시간 나머지는 영화 종료시간으로 설정후 getTimeInmill로 각각 long형 변수로 저장했다.
 * 하지만 약간씩 어긋나거나 년이 잘안나오는둥 시원찮은 결과만 나와서 여기에 시간을 다 쏟아 부었지만 결국 비슷한 클래스인 CalcBetweenTime을 만들었다.
 * 확실히 이전보단 꽤 괜찮은 값을 던져주지만 아직까진 만족스럽지 않아 나중에 다시 점검하거나 피드백을 요청해야겠다.
 * 
 * 	2일차 강사님이 아무런 기대없이 툭 던져준 작업물이지만 내가 괜한걸 추가하는 바람에 괜히 시간이 더 지체된거같다. 내가 아무렇게나 배치해 놓은 메소드들이
 * 눈에 거슬려 실행흐름을 파악하는데 어려움이 있었고, 분기가 매우 다양하게 나눠지는 프로그램이라 분기에 관련된 메소드인지, 직접적으로 값을 조정하는
 * 메소드들인지 구분하기 힘들었다. 그래서 메소드들을 긴 시간에 걸쳐 보기좋게 배열해놓았다.다음에 다시 프로그램을 짠다면 처음부터 배치를 고려하여 짜야겠다.
 * 
 * 3일차 영화와 음식들의 CRUD를 마무리 했다. 버그를 찾고 고쳤다. 그리고 생각보다 내가 생각 없이 짠코드를 수정하는일이 잦았다.
 * 삭제부분에서 drinking[foodsIdx] = ... 라던지 내가 코딩할때 어떤 부분을 하고잇는지 깜빡하면서 코딩을 해서 이런것 같다. 앞으로 코딩할땐 신경쓰며 내가 적어도
 * 뭘 코딩하고있는지 인지하면서 코딩해야겠다. 확실히 돌이켜보면 급한마음에 너무 앞뒤생각없이 코딩만 하긴했다. 이제 손님부분만 구현하면 끝이다. 4일차까지 갈줄이야..
 * public boolean isNestedNumber(int Number) {
		for(int List_i=0;List_i<moviesIdx;++List_i) {
			if(Number == customer[List_i].getId()) {
				return true;
			}
		}
		return false;
	}
	실수한것1 한번 찾아보시오 답은 밑에
	
	List_i<moviesIdx customerIdx를 감소해야하는데 movie를 감소시키고 있다 내가 이렇게 정신이 없습니다.
	하면할수록느낀게 자주쓰이는것들을 모듈화 하고 특히 선택> 같은것들.. 그리고 반드시 프로그램을 직접 코딩전에 밑그림을 쳘저하게 그려서
	코딩해야겠다 이게 내가 전에 해놨던것들이 프로그램을 구현화 하면 할수록 어긋나는것들이 생겨 이를 차단하려면 사전에 잘 해놓아야 후에 덜 고생을 할듯하다.
	결국 프로그램을 완벽히 만드는건 포기했다. 내프로그램도 아니고 지나가던말로 던져주신 과제였으니까 딱히동기가생각나지 않는다.
	그럼에도 불구하고 얻는건 많았다. 아까적었던 프로그램 밑그림 그리기라던가 생각하면서 코딩이라던가..
	그래도 두날짜사이 남는시간 구하기라는 클래스를 만들었으니 언젠가 물어봐서 피드백을 받는게 좋을것같다.
	아그리고 포기한이유는 customer객체에 영화 예매 정보를 넣으려했더니 영화 예매정보를 넣고 만약 영화 index값이 바뀌면
	버그가 나서 이를 방지하려면 꽤 엄청난 시간이 소요될까봐 그만두었다. 물론 가치는 있겠지만. 어제배운 collection, generic을 활용해서
	stack이나 heap queue등 자료구조를 직접 구현해볼 생각이다. 그래서 얻은건 있으니 이 프로그램은 여기까지만 구현하겠다.
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import kh.dgv.model.vo.Customer;
import kh.dgv.model.vo.Drinking;
import kh.dgv.model.vo.Food;
import kh.dgv.model.vo.Movies;
import kh.dgv.model.vo.Popcorn;
import kh.dgv.model.vo.Product;
import kh.dgv.model.vo.SelectedMenu;
import kh.dgv.view.View;

public class Controller {

	private final int MAX_MOVIES = 10;
	private Movies[] movies;
	private int moviesIdx;
	private final int MAX_DRINKING = 10;
	private final int MAX_FOOD = 10;
	private final int MAX_POPCORN = 10;
	private final int MAX_CUSTOMER = 10;
	private kh.dgv.model.vo.Drinking[] drinking;
	private kh.dgv.model.vo.Food[] foods;
	private kh.dgv.model.vo.Popcorn[] popcorns;
	private Customer[] customer;
	private int popcornsIdx;
	private int foodsIdx;
	private int drinkingIdx;
	private int customerIdx;
	private View view;
	private Scanner sc;

///////////////////////////////////////////초기화 부분
	public Controller() {
		movies = new Movies[MAX_MOVIES];
		moviesIdx = 0;
		drinking = new Drinking[MAX_DRINKING];
		popcornsIdx = 0;
		foods = new Food[MAX_FOOD];
		foodsIdx = 0;
		popcorns = new Popcorn[MAX_POPCORN];
		drinkingIdx = 0;
		customer = new Customer[MAX_CUSTOMER];
		customerIdx = 0;
		view = new View();
		initalize();
		sc = new Scanner(System.in);
	}

	private void initalize() {
		
		String[] drinkNameArr = { "펩시", "사이다", "환타", "주스", "냉커피" };
		int[] drinkAmountArr = { 30, 20, 25, 40, 10 };
		int[] drinkPriceArr = { 2500, 2500, 3000, 2000, 2000 };

		String[] foodNameArr = { "나쵸", "프레즐", "핫도그", "핫바", "오징어" };
		int[] foodAmountArr = { 10, 20, 17, 18, 19 };
		int[] foodPriceArr = { 2500, 2500, 3000, 2000, 2000 };

		String[] popcornNameArr = { "카랴멜팝콘", "팝콘\t", "치즈팝콘\t" };// 들여쓰기를 맞추기위해 \t추가
		int[] popcornAmountArr = { 200, 200, 200 };
		int[] popcornPriceArr = { 5000, 4500, 5000 };
		String[] popcornFlavorArr = { "달콤한맛", "짭짤한맛", "치즈맛" };
		for (int List_i = 0; List_i < 10; ++List_i) {
			Calendar startTime = Calendar.getInstance();
			startTime.set(Calendar.DATE, 3 + List_i);
			movies[moviesIdx++] = new Movies("김종모" + List_i + 1, startTime,
					Integer.toString(List_i * List_i * List_i * 1000) + ":"
							+ Integer.toString(List_i * List_i * List_i + List_i));
			movies[moviesIdx - 1].setIndex(List_i + 1);
			customer[List_i]= new Customer();
		}
		for (int List_i = 0; List_i < 5; ++List_i) {
			drinking[List_i] = new Drinking();
			foods[List_i] = new Food();

			drinking[List_i].setAmount(drinkAmountArr[List_i]);
			drinking[List_i].setName(drinkNameArr[List_i]);
			drinking[List_i].setPrice(drinkPriceArr[List_i]);

			foods[List_i].setAmount(foodAmountArr[List_i]);
			foods[List_i].setName(foodNameArr[List_i]);
			foods[List_i].setPrice(foodPriceArr[List_i]);
			drinking[List_i].setIndex(drinkingIdx++);
			foods[List_i].setIndex(foodsIdx++);
		}
		for (int List_i = 0; List_i < 3; ++List_i) {
			popcorns[List_i] = new Popcorn();
			popcorns[List_i].setAmount(popcornAmountArr[List_i]);
			popcorns[List_i].setName(popcornNameArr[List_i]);
			popcorns[List_i].setPrice(popcornPriceArr[List_i]);
			popcorns[List_i].setFlavor(popcornFlavorArr[List_i]);
			popcorns[List_i].setIndex(popcornsIdx++);
		}
	}

///////////////////////////////////////////사용자 메뉴 부분
	public void main() {
		while (true) {
			view.enterMessage();
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				initAsAdmin();
				break;
			case 2:
				initAsGuest();
				break;
			case 0:
				System.out.println("종료합니다.");
				System.exit(0);
			}
		}
	}

	private void initAsGuest() {
		int sel;
		boolean exit = true;
		while (exit) {
			view.enterGuestMessage();
			sel = sc.nextInt();
			switch (sel) {
			case 1:
				enterGuestMovie();
				break;
			case 2:
				enterGuestStore();
				break;
			case 0:
				exit = false;
				break;
			}
		}
	}

	private void initAsAdmin() {
		int sel;
		boolean exit = true;
		while (exit) {
			view.enterAdminMessage();
			sel = sc.nextInt();
			switch (sel) {
			case 1:
				initAdminInsertMovie();
				break;
			case 2:
				initAdminModifyMovie();
				break;
			case 3:
				initAdminDeleteMovie();
				break;
			case 4:
				view.printAllMovies(movies, moviesIdx);
				break;
			case 5:
				view.printAllStoreStuffs(drinking, drinkingIdx, foods, foodsIdx, popcorns, popcornsIdx);
				break;
			case 6:
				initAdminInsertProduct();
				break;
			case 7:
				initAdminModifyProduct();
				break;
			case 8:
				initAdminDeleteProduct();
				break;
			case 0:
				exit = false;
				break;

			}
		}
	}

	public void initAdminModifyMovie() {
		if (moviesIdx == 0) {
			view.printOutOfMovies();
			return;
		}
		view.printAllMovies(movies, moviesIdx);
		view.selectMoviesMessage("수정", moviesIdx);
		int idx = sc.nextInt() - 1;
		boolean exit = true;
		while (exit) {
			int sel = view.selectModifyNameOrTimeOrRunningTime();
			switch (sel) {
			case 1:
				modifyMovieName(idx);
				break;
			case 2:
				modifyMovieStartTime(idx);
				break;
			case 3:
				modifyMovieRunningTime(idx);
				break;
			case 0:
				exit = false;
			}
		}
	}

	public void initAdminInsertProduct() {
		if (!isProductRemains()) {
			view.printOutOfStocks();
			return;
		}
		int sel;
		boolean exit = true;
		while (exit) {
			view.initAdminInsertProductMessage();
			sel = sc.nextInt();
			switch (sel) {
			case 1:
				insertDrinking();
				break;
			case 2:
				insertFood();
				break;
			case 3:
				insertPopcorn();
				break;
			case 0:
				exit = false;
				break;
			}
		}
	}

	public void initAdminModifyProduct() {
		boolean exit = true;
		while (exit) {
			view.initAdminModifyProductMessage();
			int sel = sc.nextInt();
			switch (sel) {
			case 1:
				modifyDrinking();
				break;
			case 2:
				modifyFood();
				break;
			case 3:
				modifyPopcorn();
				break;
			case 0:
				exit = false;
				break;
			}
		}
	}

	public void initAdminDeleteProduct() {
		view.initAdminDeleteProductMessage();
		int sel = sc.nextInt();
		boolean exit = true;
		switch (sel) {
		case 1:
			deleteDrink();
			break;
		case 2:
			deleteFood();
			break;
		case 3:
			deletePopcorn();
			break;
		case 0:
			exit = false;
			break;
		}
	}

	private void enterGuestMovie() {
		int sel;
		boolean exit = true;
		while (exit) {
			view.enterGuestMovieMessage();
			sel = sc.nextInt();
			switch (sel) {
			case 1:
				ticketingMovie();
				break;
			case 2:
				tickectingCheck();
				break;
			case 3:
				cancelTicketing();
				break;
			case 0:
				exit = false;
				break;
			}
		}
	}

	private void enterGuestStore() {
		int sel;
		boolean exit = true;
		while (exit) {
			view.enterGuestStoreMessage();
			sel = sc.nextInt();
			switch (sel) {
			case 1:
				enterStoreShopping();
				break;
			case 0:
				exit = false;
				break;
			}
		}
	}

	private void enterStoreShopping() {
		int sel;
		boolean exit = true;
		while (exit) {
			view.enterStoreShoppingMessage();
			sel = sc.nextInt();
			switch (sel) {
			case 1:
				buyingDrinking();
				break;
			case 2:
				buyingFood();
				break;
			case 3:
				buyingPopcorn();
				break;
			case 0:
				exit = false;
				break;
			}
		}
	}
/////////////////////////////////////////////
////////////클래스별 기능부분

///////ticketing
	private void ticketingMovie() {
		if(isMoviesEmpty()) {
			view.printOutOfMovies();
			return;
		}
		view.printAllMovies(movies, moviesIdx);
		view.printSelectMovieNumber("예매");
		int sel = sc.nextInt()-1;
		view.printSelectedMovieName(movies[sel].getName());
		view.printAskingAmountOfTicket();
		int tickets = sc.nextInt();
		for(int List_i=0;List_i<tickets;++List_i) {
			view.printAskTicketSeats(List_i+1);
			char Seatslength = sc.next().charAt(0);
			view.printAskNumOfSeat(Seatslength);
			int SeatsWidth = sc.nextInt();
			while(!movies[sel].occupiesSeat(Seatslength-'A', SeatsWidth-1)) {
				view.printAlreadyOccupiedSeat();
			}
			customer[customerIdx].setLength(Seatslength-'A');
			customer[customerIdx].setWidth(SeatsWidth-1);
			customer[customerIdx++] = getInstanceOfCustomerAndNestCheck();
			view.printTicketDoneMessage(customer[customerIdx-1].getId());
		}
	}

	private void tickectingCheck() {
		// 변명 : 과제로 준 프로그램도 이런식으로 보여진다. 확실히 먼저 만든사람도 급했었는듯.
		view.printAllMovies(movies, moviesIdx);
	}

	private void cancelTicketing() {
		view.printCancelTicketId();
		int sel = sc.nextInt();
		int ticketId = getNestedId(sel);
		if(ticketId!=-1) {
			
			cancelTicket(ticketId);
			view.printCancelSucess();
		}
		else { 
			view.printCancelFail();
		}
	}
	private void cancelTicket(int ticketId) {
		for(int List_i=ticketId;List_i<customerIdx;++List_i) {
			customer[List_i] = customer[List_i+1];
		}
		customerIdx--;
	}
//////////////drinking
	private void buyingDrinking() {
		// TODO 4
	}

	public void deleteDrink() {
		if (!isDrinkingRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.productMenuMessage(drinking, "음료", drinkingIdx);
		System.out.print("선택 > ");
		int sel = sc.nextInt() - 1;
		deletingProduct(drinking, sel, drinkingIdx);
	}

	public void modifyDrinking() {
		if (!isDrinkingRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.modifyProductMessage(drinking, drinkingIdx);
		int sel = sc.nextInt() - 1;
		view.printProductSelectedMessage(drinking[sel]);
		int amount = sc.nextInt();
		drinking[sel].setAmount(amount);
		view.printProductModifyedMessage(amount);
	}

	public void insertDrinking() {
		if(isDrinkingFull()) {
			view.printFullOfStocks();
			return;
		}
		view.productNameInsertMessage("음료");
		String name = sc.next();
		view.productAmountInsertMessage("음료");
		int amount = sc.nextInt();
		view.productPriceInsertMessage("음료");
		int price = sc.nextInt();
		drinking[drinkingIdx] = new Drinking(name, amount, price,drinkingIdx++);		
		view.insertDoneMessage();
	}

/////food
	public void insertFood() {
		if(isFoodFull()) {
			view.printFullOfStocks();
			return;
		}
		view.productNameInsertMessage("음식");
		String name = sc.next();
		view.productAmountInsertMessage("음식");
		int amount = sc.nextInt();
		view.productPriceInsertMessage("음식");
		int price = sc.nextInt();
		foods[foodsIdx++] = new Food(name, amount, price,foodsIdx);
		view.insertDoneMessage();
	}
	public void modifyFood() {
		if (isFoodEmpty()) {
			view.printOutOfStocks();
			return;
		}
		view.modifyProductMessage(foods, foodsIdx);
		int sel = sc.nextInt() - 1;
		view.printProductSelectedMessage(foods[sel]);
		int amount = sc.nextInt();
		foods[sel].setAmount(amount);
		view.printProductModifyedMessage(amount);
	}
	public void deleteFood() {
		if (!isFoodsRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.productMenuMessage(foods, "음식", foodsIdx);
		System.out.print("선택 > ");
		int sel = sc.nextInt() - 1;
		
		deletingProduct(foods, sel, foodsIdx);
	}


	private void buyingFood() {
		if (!isFoodsRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.productMenuMessage(foods, "음식", foodsIdx);
		SelectedMenu sel = view.productSelectMessage();
		// TODO 5
		view.buyingDoneMessage();
	}



//////popcorn
	public void insertPopcorn() {
		if(isPopcornFull()) {
			view.printFullOfStocks();
			return;
		}
		view.productNameInsertMessage("팝콘");
		String name = sc.next();
		view.productAmountInsertMessage("팝콘");
		int amount = sc.nextInt();
		view.productPriceInsertMessage("팝콘");
		int price = sc.nextInt();
		view.popcornFlavorInsertMessage("팝콘");
		String flavor = sc.next();
		popcorns[popcornsIdx++] = new Popcorn(name, amount, price,popcornsIdx,flavor);
		view.insertDoneMessage();
	}
	public void modifyPopcorn() {
		if (!isPopcornsRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.modifyProductMessage(popcorns, popcornsIdx);
		int sel = sc.nextInt() - 1;
		view.printProductSelectedMessage(popcorns[sel]);
		int amount = sc.nextInt();
		popcorns[sel].setAmount(amount);
		view.printProductModifyedMessage(amount);
	}
	public void deletePopcorn() {
		if (!isPopcornsRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.popcornMenuMessage(popcorns, popcornsIdx);
		System.out.print("선택 > ");
		int sel = sc.nextInt() - 1;
		deletingPopcorn(sel, popcornsIdx);
	}
	public void deletingPopcorn(int deletingIdx, int ProductIdx) {
		for (int List_i = deletingIdx; List_i < ProductIdx-1; ++List_i) {
			popcorns[List_i] = popcorns[List_i + 1];
			popcorns[List_i].setIndex(List_i);
		}
		--popcornsIdx;
		view.deleteDoneMessage();
	}
	private void buyingPopcorn() {
		// TODO 6
	}
//////movie
	public void initAdminInsertMovie() {
		if (isMoviesFull()) {
			view.printFullOfMovies();
			return;
		}
		view.insertMovieMessage();
		String name = sc.next();
		Calendar startTime = makeStartTime(name);
		String runningTime = makeRunningTime(name);
		if (isMoviesFull()) {
			view.notEnoughSpaceMessage();
		} else {
			movies[moviesIdx++] = new Movies(name, startTime, runningTime);
			movies[moviesIdx-1].setIndex(moviesIdx-1);
			view.insertDoneMessage();
		}
	}
	public void modifyMovieName(int idx) {
		if (isMoviesEmpty()) {
			view.printOutOfMovies();
			return;
		}
		view.modifyMovieNameMessage();
		String name = sc.next();
		movies[idx].setName(name);
		view.modifyMovieDoneMessage(movies[idx].getName());
	}
	public void modifyMovieStartTime(int idx) {
		movies[idx].setStartTime(makeStartTime(movies[idx].getName()));
		view.modifyMovieDoneMessage(movies[idx].getStartTimeToString());
	}

	public void modifyMovieRunningTime(int idx) {
		movies[idx].setRunningTime(makeRunningTime(movies[idx].getName()));
		view.modifyMovieDoneMessage(movies[idx].getRunningTime());
	}

	public void initAdminDeleteMovie() {
		if (isMoviesEmpty()) {
			view.printOutOfMovies();
			return;
		}
		view.printAllMovies(movies, moviesIdx);
		view.selectMoviesMessage("삭제", moviesIdx);
		int sel = sc.nextInt() - 1;

		view.deleteConfrimMessage(movies[sel]);
		char choice = sc.next().charAt(0);
		if (Character.toUpperCase(choice) == 'N') {
			return;
		} else {
			deleteMovie(sel);
			System.out.println("삭제되었습니다.");
		}
	}

	public void deleteMovie(int idx) {
		for (int List_i = idx; List_i < moviesIdx - 1; ++List_i) {
			movies[List_i] = movies[List_i + 1];
			movies[List_i].setIndex(List_i + 1);
		}
		moviesIdx--;
	}

	

///////////////product
	public void deletingProduct(Product[] product, int deletingIdx, int ProductIdx) {
		for (int List_i = deletingIdx; List_i < ProductIdx-1; ++List_i) {
			product[List_i] = product[List_i + 1];
			product[List_i].setIndex(List_i);
		}
		view.deleteDoneMessage();
		decraseProductIndex(product[0]);
	}
	public void decraseProductIndex(Product product) {
		System.out.println(product.getclassName());
		if (product.getclassName().equals("Food")) {
			--foodsIdx;
		} else if(product.getclassName().equals("Drinking")) {
			--drinkingIdx;
		}
		else {
			System.out.println("못찾음");
		}
	}

	public void buyingProduct(Product[] product, int no, int amount) {
		int amountOfRemainedProduct = product[no - 1].getAmount() - amount;
		product[no - 1].setAmount(amountOfRemainedProduct);
	}

/////////////////계산 및 Boolean 판별 메소드들
	public Customer getInstanceOfCustomerAndNestCheck() {
		Customer temp = new Customer();
		while(isNestedNumber(temp.getId())) {
			temp.setNewRandomId();
		}
		return temp;
	}
	
	public int getNestedId(int Number) {
		for(int List_i=0;List_i<customerIdx;++List_i) {
			if(Number == customer[List_i].getId()) {
				return List_i;
			}
		}
		return -1;
	}
	public boolean isNestedNumber(int Number) {
		for(int List_i=0;List_i<customerIdx;++List_i) {
			if(Number == customer[List_i].getId()) {
				return true;
			}
		}
		return false;
	}
	public String makeRunningTime(String name) {
		String hour = null;
		boolean exit = true;
		while (exit) {
			System.out.printf("영화 %s의 상영시간을 입력해주세요[HH:mm]:", name);
			hour = sc.next();
			System.out.printf("%s 이 시간이  영화 %s의 상영 시간이 맞습니까? [Y/N]", hour, name);

			char answer = sc.next().charAt(0);

			if (Character.toUpperCase(answer) == 'N') {
				continue;
			} else {
				exit = false;
			}
		}
		return hour;
	}

	public Calendar makeStartTime(String name) {
		Date date = null;
		Calendar calendar = Calendar.getInstance();
		boolean exit = true;
		while (exit) {
			System.out.printf("%s 영화의 시작시간을 입력해주세요[YYYY:MM:DD:HH:mm]:", name);
			sc.nextLine();
			String startStr = sc.nextLine();
			System.out.printf("%s 이 시간이 %s영화의 시작시간이 맞습니까? [Y/N]", startStr, name);
			char answer = sc.next().charAt(0);
			if (Character.toUpperCase(answer) == 'N') {
				continue;
			} else {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy:M:d:HH:m");
				try {
					date = sdf.parse(startStr);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				calendar.setTime(date);
				exit = false;
			}
		}

		return calendar;

	}

	public boolean isMoviesFull() {
		return moviesIdx == MAX_MOVIES;
	}

	public boolean isFoodFull() {
		return foodsIdx == MAX_FOOD;
	}

	public boolean isDrinkingFull() {
		return drinkingIdx == MAX_DRINKING;
	}

	public boolean isPopcornFull() {
		return popcornsIdx == MAX_POPCORN;
	}

	public boolean isMoviesEmpty() {
		return moviesIdx == 0;
	}

	public boolean isFoodEmpty() {
		return foodsIdx == 0;
	}

	public boolean isDrinkingEmpty() {
		return drinkingIdx == 0;
	}

	public boolean isPopcornEmpty() {
		return popcornsIdx == 0;
	}

	public boolean isProductRemains() {
		return isDrinkingRemains()&&isFoodsRemains() &&isPopcornsRemains();
	}

	public boolean isDrinkingRemains() {
		return drinkingIdx > 0;
	}

	public boolean isFoodsRemains() {
		return foodsIdx > 0;
	}

	public boolean isPopcornsRemains() {
		return popcornsIdx > 0;
	}
}
