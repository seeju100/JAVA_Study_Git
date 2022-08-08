package Lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Ex11 {

	public static void main(String[] args) {
		/*
		 * 1. Customer 객체 5개 생성
		 * 2. ArrayList에 추가
		 * */
		Customer customer1 = new Customer("홍길동", 40, 100);
		Customer customer2 = new Customer("소지섭", 50, 200);
		Customer customer3 = new Customer("세정", 30, 20);
		Customer customer4 = new Customer("송강", 20, 30);
		Customer customer5 = new Customer("박민영", 25, 50);
		
		List<Customer> list = new ArrayList<Customer>();
		list.add(customer1);
		list.add(customer2);
		list.add(customer3);
		list.add(customer4);
		list.add(customer5);
		
		System.out.println("===== 고객 이름 추가된 순서대로 출력 =====");
		for(Customer customer : list) {
			System.out.println(customer.getName());
		}
		System.out.println("------------------------------------------");
		list.stream().forEach(customer -> System.out.println(customer.getName()));
		
		int sum = 0;
		for(Customer customer : list) {
			sum += customer.getPrice();
		}
		System.out.println("총 요금은: "+sum+" 입니다." );
		
		int sum2 = list.stream().mapToInt(c -> c.getPrice()).sum();
		System.out.println("총 요금은: " + sum2 + " 입니다." );
		
		System.out.println("===== 30세 이상 고객중 요금(price)이 큰순으로 출력 =====");
		list.stream().filter(c -> c.getAge() >= 30)
					 .sorted((o1, o2) -> (o2.getPrice() - o1.getPrice()))
					 .forEach(s -> System.out.println(s));
			
		System.out.println("===== 가장 어린 사람 출력 =====");
		int minAge = Integer.MAX_VALUE;
		for(Customer customer : list) {
			if(minAge > customer.getAge()) {
				minAge = customer.getAge();
			}
		}
		for(Customer customer: list) {
			if(customer.getAge() == minAge) {
				System.out.println(customer);
				break;
			}
		}
		
		Customer customer = list.stream().min((o1, o2) -> o1.getAge() - o2.getAge()).get();
		System.out.println(customer);
		
		System.out.println("===== 가장 요금(price)이 적은 사람 출력 =====");
		customer = list.stream().min((o1, o2) -> o1.getPrice() - o2.getPrice()).get();
		System.out.println(customer);
		
		System.out.println("===== 가장 요금(price)이 많은 사람 출력 =====");
		customer = list.stream().max((o1, o2) -> o1.getPrice() - o2.getPrice()).get();
		System.out.println(customer);
	}

}

/*
 * Customer 클래스 정의
 * - 멤버변수: 이름(문자열, name), 나이(정수, age), 요금(정수, price)
 * - 생성자: 모든 멤버변수를 초기화하는 생성자
 * - 모든 멤버변수에 대한 Getter/Setter 메서드 정의
 * - 모든 멤버변수에 대한 toString() 메서드 오버라이딩
 * */
class Customer {
	private String name;
	private int age;
	private int price;
	
	public Customer(String name, int age, int price) {
		this.name = name;
		this.age = age;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", price=" + price + "]";
	}
	
}















