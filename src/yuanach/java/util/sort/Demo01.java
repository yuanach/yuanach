package yuanach.java.util.sort;

public class Demo01 {

	public static void main(String[] args) {
		CSort<Integer> s = new BubbleSort<Integer>();
		CSort<String> ss = new BubbleSort<String>();
		Integer[] arr = { 34, 16, 45, 62, 63, 234, 5, 12 };
		s.sort(arr, new CComparator<Integer>());

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
