package try_catch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 하나의 try 블록에서 복수개의 예외를 처리하는 경우
		 * - try 블록 내에서 처리해야하는 예외가 두 종류 이상일 경우
		 *   catch 블록을 해당 예외 종류만큼 작성하거나
		 *   하나의 catch블록에서 복수개의 예외를 모두 처리하는 클래스를 사용하면 된다.
		 * - 복수개의 catch 블록은 첫번째 catch블록 부터 차례대로 탐색  
		 *   => 만약, 끝까지 탐색했음에도 일치하는 catch 블록이 없으면 실행 시 예외 발생함
		 * - 만약, 복수개의 catch 블록 지정 시 하위 타입부터 상위 타입순으로 나열해야함  
		 *   => 상위 타입이 먼저 기술되면 하위 타입 예외는 실행될 수 없다!
		 *   (ex. ArithmeticException 보다 Exception 클래스가 위에 있을 수 없다!)
		 * - 만약, 하나의 catch 블록으로 복수개의 예외를 처리 하려면
		 * 	1) catch 블록의 클래스를 복수개의 예외클래스의 상위 타입으로 지정하면 된다!
		 *     (ex. 모든 예외를 처리하기 위해서는 Exception 클래스 지정)
		 *  2) catch 블록의 클래스에 | 기호를 사용하여 복수개의 클래스를 기술해도 된다!
		 *     => 유사한 성격을 갖는 예외를 하나의 catch 블록에서 묶어서 처리 가능
		 *     (ex. FileNotFoundException 과 ClassNotFoundException 은 유사한 기능이므로
		 *          catch(FileNotFoundException | ClassNotFoundException e) {} 형태로 기술     
		 * 
		 * < 기본 문법 >
		 * try {
		 * 		// 예외발생1코드
		 * 		// 예외발생2코드
		 * 		// 예외발생3코드
		 * 
		 * } catch(예외발생1클래스 변수명){
		 * 
		 * 		// 예외발생1 코드에서 예외 발생시 처리할 코드들...
		 * 
		 * } catch(예외발생2클래스 변수명){
		 * 
		 * 		// 예외발생2 코드에서 예외 발생시 처리할 코드들...
		 * 
		 * } catch(Exception e){
		 * 		
		 * 		// 위의 모든 예외가 일치하지 않을 경우 나머지 예외를 모두 처리하는 코드
		 * 		// 마치 if문에서 else문(switch-case문에서 default문)과 같은 역할 수행
		 * 
		 * }
		 * */
		
		System.out.println("프로그램 시작!");
		
		try {
			// 첫번째 예외 : ArithmeticException
//			int num1 = 3, num2 = 0;
			int num1 = 3, num2 = 1;
			System.out.println(num1 / num2);
			
			// 두번째 예외 : NullPointerException
//			String str = null;
			String str = "홍길동";
			System.out.println(str.length());
			
			// 세번째 예외 : ArrayIndexOutOfBoundsException
			int[] arr = {1};
			System.out.println(arr[1]);
		} catch(ArithmeticException e) {
			System.out.println("예외 발생 : 0으로 나눌 수 없습니다!");
		} catch(NullPointerException e) {
			System.out.println("예외 발생 : null 값을 참조할 수 없습니다!");
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("예외 발생 : 잘못된 인덱스를 참조합니다!");
		} catch (Exception e) {	// 마지막으로 확인하는 catch 블록
			// 위의 세가지 예외에 해당되지 않는 예외를 모두 Exception 타입으로 catch 함
			// => if문에서 else문 역할과 동일함
			System.out.println("예외 발생 : 나머지 예외를 모두 처리합니다!");
		}
		
		System.out.println("프로그램 종료!");
		
		try {
			// ClassNotFoundException 발생 예상 코드...
			Class.forName("");
			
			// FileNotFoundException 발생 예상 코드...
			FileInputStream fis = new FileInputStream("");
		} catch (FileNotFoundException | ClassNotFoundException e) {
			System.out.println("FileNotFoundException 또는 ClassNotFoundException 발생!");
		}
		
		
		
		
	}

}
