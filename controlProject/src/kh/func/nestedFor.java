package kh.func;

public class nestedFor {
	public void forTest2() {

		for (int List_i = 1; List_i < 10; ++List_i) {

			for (int Just_j = 2; Just_j < 10; ++Just_j)
				System.out.printf("%1d * %1d = %-2d ", Just_j, List_i, List_i * Just_j); //%-2d -는 왼족으로 정렬해라 2는 공간을 2개 확보해라
			System.out.println();
		}

	}
	
	public void forExam1() {
		for(int List_i=0;List_i<5;++List_i)
			System.out.print('*');
	}
	public void forExam2() {
		for(int List_i=0;List_i<5;++List_i)
			System.out.print('*');
	}
	public void forExam3() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				System.out.print('*');
			System.out.println();
		}
	}
	public void forExam4() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				System.out.print(List_i);
			System.out.println();
		}
	}
	public void forExam5() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				System.out.print(Just_j+1);
			System.out.println();
		}
	}
	public void forExam6() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				System.out.print(Just_j+List_i);
			System.out.println();
		}
	}
	public void forExam7() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				System.out.print(5-List_i+Just_j);
			System.out.println();
		}
	}
	public void forExam8() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				if(List_i-Just_j >= 0)
					System.out.print('*');
			System.out.println();
		}
	}
	public void forExam9() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5-List_i;++Just_j)
				System.out.print('*');
			System.out.println();
		}
	}
	public void forExam10() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				if(Just_j - List_i >= 0) {
					System.out.print('*');
				}
				else{
					System.out.print(" ");
				}
			System.out.println();
		}
	}
	public void forExam11() {
		for(int List_i=0;List_i<5;++List_i) {
			for(int Just_j=0;Just_j<5;++Just_j)
				if(Just_j + List_i >= 4) {
					System.out.print('*');
				}
				else{
					System.out.print(" ");
				}
			System.out.println();
		}
	}
	public void forExam12() {
		boolean center = false;
		for(int List_i=0;List_i!=-1;)
		{
			for(int Just_j=0;Just_j<5;++Just_j)
				if(List_i - Just_j >0) {
					System.out.print("*");
				}
				else{
					System.out.print(" ");
				}
			System.out.println();
			if(List_i==5)
				center=true;
			if(center)
				--List_i;
			else
				++List_i;
		}
	}
	public void forExam13() {
		boolean center = false;
		for(int List_i=1;List_i != 0;)
		{
			for (int Just_j = 0; Just_j < 5 ; ++Just_j) {
				if (5-List_i - Just_j < 0) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}

			System.out.println();
			if(List_i==5)
				center=true;
			if(center)
				--List_i;
			else
				++List_i;
		}
	}

}
