package Lambda;

import java.util.function.IntPredicate;

public class Ex8 {

	public static void main(String[] args) {
		/*
		 * 5. Predicate 계열
		 * - Function, Operator와 같이 파라미터와 리턴을 갖는다.
		 * - 리턴타입이 boolean 으로 고정되어있다.
		 * - 매개변수로 전달받은 데이터를 "어떠한 판단" 후 true/false 리턴
		 * */
		
		PredicateTest pt = new PredicateTest();
		pt.printSome(new IntPredicate() {
			
			@Override
			public boolean test(int value) {
				return value%3 == 0;
			}
		});
		pt.printSome(value -> value%3 == 0);
		pt.printSome(value -> value > 5);
		
	}

}

class PredicateTest {
	int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	public void printSome(IntPredicate pred) {
		for(int num : nums) {
			if(pred.test(num)) {
				System.out.print(num + " ");
			}
		}
		System.out.println();
	}
	
}



