package kh.dgv.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

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
	private kh.dgv.model.vo.Drinking[] drinking;
	private kh.dgv.model.vo.Food[] foods;
	private kh.dgv.model.vo.Popcorn[] popcorns;
	private int popcornsIdx;
	private int foodsIdx;
	private int drinkingIdx;
	private View view;
	private Scanner sc;

	public Controller() {
		movies = new Movies[MAX_MOVIES];
		moviesIdx = 0;
		drinking = new Drinking[MAX_DRINKING];
		foods = new Food[MAX_FOOD];
		popcorns = new Popcorn[MAX_POPCORN];
		view = new View();
		initalize();
		sc = new Scanner(System.in);
	}

	private void initalize() {
		
		for (int List_i = 0; List_i < 10; ++List_i) {
			Calendar startTime = Calendar.getInstance();
			startTime.set(Calendar.DATE, 3+List_i);
			movies[moviesIdx++] = new Movies("김종모"+List_i+1, startTime,
					Integer.toString(List_i*List_i*List_i*1000)+":"+Integer.toString(List_i*List_i*List_i+List_i));
		}
	}

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
				insertMovie();
				break;
			case 2:
				modifyMovie();
				break;
			case 3:
				deleteMovie();
				break;
			case 4:
				view.printAllMovies(movies, moviesIdx);
				break;
			case 5:
				// view.printAllStoreStuffs();
				break;
			case 6:
				insertProduct();
				break;
			case 7:
				modifyProduct();
				break;
			case 8:
				deleteProduct();
				break;
			case 0:
				exit = false;
				break;

			}
		}
	}
	
	public void insertMovie() {
		if(isMoviesFull()) {
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
			view.insertDoneMessage();
		}
	}

	

	public void modifyMovie() {
		if (moviesIdx == 0) {
			view.printOutOfMovies();
			return;
		}
		view.printAllMovies(movies, moviesIdx);
		view.selectMoviesMessage("수정", moviesIdx);
		int idx = sc.nextInt();
		boolean exit = true;
		while (exit) {
			int sel = view.selectModifyNameOrTime();
			switch (sel) {
			case 1:
				modifyMovieName(idx);
				break;
			case 2:
				modifyMovieStartTime(idx);
				break;
			case 3:
				modifyMovieRunningTime(idx);
			case 0:
				exit = false;
			}
		}
	}

	public void modifyMovieName(int idx) {
		if (moviesIdx == 0) {
			view.printOutOfMovies();
			return;
		}
		view.modifyMovieNameMessage();
		String name = sc.next();
		movies[idx].setName(name);
		view.modifyMovieDoneMessage(movies[idx].getName());
	}

	public void modifyMovieStartTime(int idx) {
		view.modifyMovieStartTimeMessage();
		movies[idx].setStartTime(makeStartTime(movies[idx].getName()));
		view.modifyMovieDoneMessage(movies[idx].getStartTimeToString());
	}

	public void modifyMovieRunningTime(int idx) {
		view.modifyMovieStartTimeMessage();
		movies[idx].setRunningTime(makeRunningTime(movies[idx].getName()));
		view.modifyMovieDoneMessage(movies[idx].getRunningTime());
	}

	public void deleteMovie() {
		if (moviesIdx == 0) {
			view.printOutOfMovies();
			return;
		}
		view.printAllMovies(movies, moviesIdx);
		view.selectMoviesMessage("삭제", moviesIdx);
		int sel = sc.nextInt();
		
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
		for (int List_i = idx; List_i < moviesIdx-1; ++List_i) {
			movies[List_i] = movies[List_i + 1];
			movies[List_i].setIndex(List_i+1);
		}
		moviesIdx--;
	}

	

	public void insertProduct() {
		if (!isProductRemains()) {
			view.printOutOfStocks();
			return;
		}
		int sel;
		boolean exit = true;
		while (exit) {
			view.insertProductMessage();
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

	public void insertDrinking() {
		if(!isDrinkingRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.productMenuMessage(drinking, "음료", drinkingIdx);
		SelectedMenu sel = view.productSelectMessage();
		buyingProduct(drinking, sel.no, sel.amount);
		view.buyingDoneMessage();
	}

	public void insertFood() {
		if(!isFoodsRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.productMenuMessage(foods, "음식", foodsIdx);
		SelectedMenu sel = view.productSelectMessage();
		buyingProduct(foods, sel.no, sel.amount);
		view.buyingDoneMessage();
	}

	public void insertPopcorn() {
		if(!isPopcornsRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.productMenuMessage(popcorns, "팝콘", popcornsIdx);
		SelectedMenu sel = view.productSelectMessage();
		buyingProduct(popcorns, sel.no, sel.amount);
		view.buyingDoneMessage();
	}

	public void buyingProduct(Product[] product, int no, int amount) {
		int amountOfRemainedProduct = product[no - 1].getAmount() - amount;
		product[no - 1].setAmount(amountOfRemainedProduct);
	}

	public void modifyProduct() {
		
		boolean exit = true;
		while (exit) {
			view.modifyProductMessage();
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

	public void modifyDrinking() {
		if(!isDrinkingRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.modifyProductMessage(drinking, drinkingIdx);
		int sel = sc.nextInt();
		view.printProductSelectedMessage(drinking[sel]);
		int amount = sc.nextInt();
		drinking[sel].setAmount(amount);
		view.printProductModifyedMessage(amount);
	}

	public void modifyFood() {
		if(!isFoodsRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.modifyProductMessage(foods, foodsIdx);
		int sel = sc.nextInt();
		view.printProductSelectedMessage(foods[sel]);
		int amount = sc.nextInt();
		foods[sel].setAmount(amount);
		view.printProductModifyedMessage(amount);
	}

	public void modifyPopcorn() {
		if(!isPopcornsRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.modifyProductMessage(popcorns, popcornsIdx);
		int sel = sc.nextInt();
		view.printProductSelectedMessage(popcorns[sel]);
		int amount = sc.nextInt();
		popcorns[sel].setAmount(amount);
		view.printProductModifyedMessage(amount);
	}

	public void deleteProduct() {
		
		view.deleteProductMessage();
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

	public void deleteDrink() {
		if(!isDrinkingRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.printAllProduct(drinking, drinkingIdx);
		System.out.println("선택 > ");
		int sel = sc.nextInt();
		deletingProduct(drinking, sel, drinkingIdx);
	}

	public void deleteFood() {
		if(!isFoodsRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.printAllProduct(foods, foodsIdx);
		System.out.println("선택 > ");
		int sel = sc.nextInt();
		deletingProduct(drinking, sel, foodsIdx);
	}

	public void deletePopcorn() {
		if(!isPopcornsRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.printAllPopcorn(popcorns, popcornsIdx);
		;
		System.out.println("선택 > ");
		int sel = sc.nextInt();
		deletingPopcorn(sel, popcornsIdx);
	}

	public void deletingProduct(Product[] product, int deletingIdx, int ProductIdx) {
		for (int List_i = deletingIdx; List_i < ProductIdx; ++List_i) {
			product[List_i] = product[List_i + 1];
			product[List_i+1].setIndex(List_i);
		}
		view.deleteDoneMessage();
		decraseProductIndex(product[0]);
	}
	public void decraseProductIndex(Product product) {
		if((product instanceof Drinking)) {
			--drinkingIdx;
		} else {
			--foodsIdx;
		}
	}
	public void deletingPopcorn(int deletingIdx, int ProductIdx) {
		for (int List_i = deletingIdx; List_i < ProductIdx; ++List_i) {
			popcorns[List_i] = popcorns[List_i + 1];
			popcorns[List_i].setIndex(List_i);
		}
		--popcornsIdx;
		view.deleteDoneMessage();
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

	private void ticketingMovie() {
		// TODO 1
	}

	private void tickectingCheck() {
		// TODO 2
	}

	private void cancelTicketing() {
		// TODO 3
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

	private void buyingDrinking() {
		// TODO 4
	}

	private void buyingFood() {
		// TODO 5
	}

	private void buyingPopcorn() {
		// TODO 6
	}
/////////////////계산 및 Boolean 판별 메소드들
	public String makeRunningTime(String name) {
		String hour = null;
		boolean exit = true;
		while (exit) {
			System.out.printf("영화 %s의 상영시간을 입력해주세요[HH:mm]:", name);
			hour = sc.next();
			System.out.printf("%s 이 시간이  영화 %s의 상영 시간이 맞습니까? [Y/N]", hour, name);

			char answer = sc.next().charAt(0);

			if ( Character.toUpperCase(answer) =='N') {
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
			if (Character.toUpperCase(answer)== 'N') {
				continue;
			}
			else {
				exit = false;
			}
		}
		calendar.setTime(date);
		return calendar;

	}
	public boolean isMoviesFull() {
		return moviesIdx==MAX_MOVIES;
	}
	public boolean isFoodFull() {
		return foodsIdx==MAX_FOOD;
	}
	public boolean isDrinkingFull() {
		return drinkingIdx==MAX_DRINKING;
	}
	public boolean isPopcornFull() {
		return popcornsIdx==MAX_POPCORN;
	}
	public boolean isMoviesEmpty() {
		return moviesIdx==0;
	}
	public boolean isFoodEmpty() {
		return foodsIdx==0;
	}
	public boolean isDrinkingEmpty() {
		return drinkingIdx==0;
	}
	public boolean isPopcornEmpty() {
		return popcornsIdx==0;
	}
	public boolean isProductRemains() {
		return (moviesIdx > 0) && (foodsIdx > 0) && (popcornsIdx > 0);
	}

	public boolean isDrinkingRemains() {
		return drinkingIdx>0;
	}

	public boolean isFoodsRemains() {
		return foodsIdx>0;
	}

	public boolean isPopcornsRemains() {
		return popcornsIdx>0;
	}
}
