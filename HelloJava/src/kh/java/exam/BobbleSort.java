package kh.java.exam;
import java.util.Scanner; //추가

public class BobbleSort {

	public void bobbleSort() {

		Scanner scanner = new Scanner(System.in);

		int[] arr = new int[5];

// 반복문을 통한 입력

		int sum = 0;

		for (int i = 0; i < 5; i++) {

			System.out.print((i + 1) + "번째 숫자 입력 : ");

			arr[i] = scanner.nextInt();

			sum += arr[i]; // 추가

		}

// 버블정렬 코드

		for (int i = 0; i < arr.length - 1; i++) {// 1번더 돌 필요가 없음

			for (int j = 0; j < arr.length - 1 - i; j++) {

				if (arr[j] < arr[j + 1]) { // 내림차순으로 출력하므로 부등호 반대

					int temp = arr[j];

					arr[j] = arr[j + 1];

					arr[j + 1] = temp;

				}

			}

		}

// 출력 코드

		System.out.print("정렬 결과 : ");

		for (int i = 0; i < arr.length; i++) {

			System.out.print(arr[i] + "\t");

		}

		System.out.println("\n가장 큰 수와 작은 수의 합은 : " + sum);

	}
	public static void main(String args[]) {
		BobbleSort f = new BobbleSort();
			f.bobbleSort();
		}
	}
