package kh.dgv.controller;

/*
 * 	1���� �⺻���� Ŭ������ movies, product,popcornŬ�������� ���� CRUD�� �Ҽ��ְԲ� ��븦 ®��.
 * ������ �󿵽ð��� ���ϴ°Ϳ� �ָ��Ծ� ����� ��ü�Ǿ���.
 * 
 * 	��ü�� ������ �ð����� ����ִ� calendar.getTimesMill()�Լ��� 1970�� 1�� 1�� 9�ú��� ���ݱ��� 1�и������徿 �� ���� �����Ѵµ�
 * ���⼭ �ΰ��� Calendar ��ü�� ������ �ϳ��� ��ȭ ���۽ð� �������� ��ȭ ����ð����� ������ getTimeInmill�� ���� long�� ������ �����ߴ�.
 * ������ �ణ�� ��߳��ų� ���� �߾ȳ����µ� �ÿ����� ����� ���ͼ� ���⿡ �ð��� �� ��� �ξ����� �ᱹ ����� Ŭ������ CalcBetweenTime�� �������.
 * Ȯ���� �������� �� ������ ���� ���������� �������� ���������� �ʾ� ���߿� �ٽ� �����ϰų� �ǵ���� ��û�ؾ߰ڴ�.
 * 
 * 	2���� ������� �ƹ��� ������ �� ������ �۾��������� ���� ���Ѱ� �߰��ϴ� �ٶ��� ���� �ð��� �� ��ü�ȰŰ���. ���� �ƹ����Գ� ��ġ�� ���� �޼ҵ����
 * ���� �Ž��� �����帧�� �ľ��ϴµ� ������� �־���, �бⰡ �ſ� �پ��ϰ� �������� ���α׷��̶� �б⿡ ���õ� �޼ҵ�����, ���������� ���� �����ϴ�
 * �޼ҵ������ �����ϱ� �������. �׷��� �޼ҵ���� �� �ð��� ���� �������� �迭�س��Ҵ�.������ �ٽ� ���α׷��� §�ٸ� ó������ ��ġ�� ����Ͽ� ¥�߰ڴ�.
 * 
 * 3���� ��ȭ�� ���ĵ��� CRUD�� ������ �ߴ�. ���׸� ã�� ���ƴ�. �׸��� �������� ���� ���� ���� §�ڵ带 �����ϴ����� ��Ҵ�.
 * �����κп��� drinking[foodsIdx] = ... ����� ���� �ڵ��Ҷ� � �κ��� �ϰ��մ��� �����ϸ鼭 �ڵ��� �ؼ� �̷��� ����. ������ �ڵ��Ҷ� �Ű澲�� ���� ���
 * �� �ڵ��ϰ��ִ��� �����ϸ鼭 �ڵ��ؾ߰ڴ�. Ȯ���� �����Ѻ��� ���Ѹ����� �ʹ� �յڻ������� �ڵ��� �ϱ��ߴ�. ���� �մԺκи� �����ϸ� ���̴�. 4�������� �����̾�..
 * public boolean isNestedNumber(int Number) {
		for(int List_i=0;List_i<moviesIdx;++List_i) {
			if(Number == customer[List_i].getId()) {
				return true;
			}
		}
		return false;
	}
	�Ǽ��Ѱ�1 �ѹ� ã�ƺ��ÿ� ���� �ؿ�
	
	List_i<moviesIdx customerIdx�� �����ؾ��ϴµ� movie�� ���ҽ�Ű�� �ִ� ���� �̷��� ������ �����ϴ�.
	�ϸ��Ҽ��ϴ����� ���־��̴°͵��� ���ȭ �ϰ� Ư�� ����> �����͵�.. �׸��� �ݵ�� ���α׷��� ���� �ڵ����� �ر׸��� �x���ϰ� �׷���
	�ڵ��ؾ߰ڴ� �̰� ���� ���� �س����͵��� ���α׷��� ����ȭ �ϸ� �Ҽ��� ��߳��°͵��� ���� �̸� �����Ϸ��� ������ �� �س��ƾ� �Ŀ� �� ����� �ҵ��ϴ�.
	�ᱹ ���α׷��� �Ϻ��� ����°� �����ߴ�. �����α׷��� �ƴϰ� ������������ �����ֽ� ���������ϱ� �������Ⱑ�������� �ʴ´�.
	�׷����� �ұ��ϰ� ��°� ���Ҵ�. �Ʊ������� ���α׷� �ر׸� �׸������� �����ϸ鼭 �ڵ��̶����..
	�׷��� �γ�¥���� ���½ð� ���ϱ��� Ŭ������ ��������� ������ ������� �ǵ���� �޴°� �����Ͱ���.
	�Ʊ׸��� ������������ customer��ü�� ��ȭ ���� ������ �������ߴ��� ��ȭ ���������� �ְ� ���� ��ȭ index���� �ٲ��
	���װ� ���� �̸� �����Ϸ��� �� ��û�� �ð��� �ҿ�ɱ�� �׸��ξ���. ���� ��ġ�� �ְ�����. ������� collection, generic�� Ȱ���ؼ�
	stack�̳� heap queue�� �ڷᱸ���� ���� �����غ� �����̴�. �׷��� ������ ������ �� ���α׷��� ��������� �����ϰڴ�.
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

///////////////////////////////////////////�ʱ�ȭ �κ�
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
		
		String[] drinkNameArr = { "���", "���̴�", "ȯŸ", "�ֽ�", "��Ŀ��" };
		int[] drinkAmountArr = { 30, 20, 25, 40, 10 };
		int[] drinkPriceArr = { 2500, 2500, 3000, 2000, 2000 };

		String[] foodNameArr = { "����", "������", "�ֵ���", "�ֹ�", "��¡��" };
		int[] foodAmountArr = { 10, 20, 17, 18, 19 };
		int[] foodPriceArr = { 2500, 2500, 3000, 2000, 2000 };

		String[] popcornNameArr = { "ī��������", "����\t", "ġ������\t" };// �鿩���⸦ ���߱����� \t�߰�
		int[] popcornAmountArr = { 200, 200, 200 };
		int[] popcornPriceArr = { 5000, 4500, 5000 };
		String[] popcornFlavorArr = { "�����Ѹ�", "¬©�Ѹ�", "ġ���" };
		for (int List_i = 0; List_i < 10; ++List_i) {
			Calendar startTime = Calendar.getInstance();
			startTime.set(Calendar.DATE, 3 + List_i);
			movies[moviesIdx++] = new Movies("������" + List_i + 1, startTime,
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

///////////////////////////////////////////����� �޴� �κ�
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
				System.out.println("�����մϴ�.");
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
		view.selectMoviesMessage("����", moviesIdx);
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
////////////Ŭ������ ��ɺκ�

///////ticketing
	private void ticketingMovie() {
		if(isMoviesEmpty()) {
			view.printOutOfMovies();
			return;
		}
		view.printAllMovies(movies, moviesIdx);
		view.printSelectMovieNumber("����");
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
		// ���� : ������ �� ���α׷��� �̷������� ��������. Ȯ���� ���� �������� ���߾��µ�.
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
		view.productMenuMessage(drinking, "����", drinkingIdx);
		System.out.print("���� > ");
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
		view.productNameInsertMessage("����");
		String name = sc.next();
		view.productAmountInsertMessage("����");
		int amount = sc.nextInt();
		view.productPriceInsertMessage("����");
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
		view.productNameInsertMessage("����");
		String name = sc.next();
		view.productAmountInsertMessage("����");
		int amount = sc.nextInt();
		view.productPriceInsertMessage("����");
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
		view.productMenuMessage(foods, "����", foodsIdx);
		System.out.print("���� > ");
		int sel = sc.nextInt() - 1;
		
		deletingProduct(foods, sel, foodsIdx);
	}


	private void buyingFood() {
		if (!isFoodsRemains()) {
			view.printOutOfStocks();
			return;
		}
		view.productMenuMessage(foods, "����", foodsIdx);
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
		view.productNameInsertMessage("����");
		String name = sc.next();
		view.productAmountInsertMessage("����");
		int amount = sc.nextInt();
		view.productPriceInsertMessage("����");
		int price = sc.nextInt();
		view.popcornFlavorInsertMessage("����");
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
		System.out.print("���� > ");
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
		view.selectMoviesMessage("����", moviesIdx);
		int sel = sc.nextInt() - 1;

		view.deleteConfrimMessage(movies[sel]);
		char choice = sc.next().charAt(0);
		if (Character.toUpperCase(choice) == 'N') {
			return;
		} else {
			deleteMovie(sel);
			System.out.println("�����Ǿ����ϴ�.");
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
			System.out.println("��ã��");
		}
	}

	public void buyingProduct(Product[] product, int no, int amount) {
		int amountOfRemainedProduct = product[no - 1].getAmount() - amount;
		product[no - 1].setAmount(amountOfRemainedProduct);
	}

/////////////////��� �� Boolean �Ǻ� �޼ҵ��
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
			System.out.printf("��ȭ %s�� �󿵽ð��� �Է����ּ���[HH:mm]:", name);
			hour = sc.next();
			System.out.printf("%s �� �ð���  ��ȭ %s�� �� �ð��� �½��ϱ�? [Y/N]", hour, name);

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
			System.out.printf("%s ��ȭ�� ���۽ð��� �Է����ּ���[YYYY:MM:DD:HH:mm]:", name);
			sc.nextLine();
			String startStr = sc.nextLine();
			System.out.printf("%s �� �ð��� %s��ȭ�� ���۽ð��� �½��ϱ�? [Y/N]", startStr, name);
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
