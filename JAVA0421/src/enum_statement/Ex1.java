package enum_statement;

import java.util.Scanner;

enum PayGroup {
	CASH("현금", new String[] {"ACCOUNT_TRANSFER", "REMITTANCE", "ON_SITE_PAYMENT", "TOSS"}),
	CARD("카드", new String[] {"PAYCO", "CARD", "KAKAO_PAY", "BEMIN_PAY", "NAVER_PAY", "XXX_PAY"}),
	ETC("기타", new String[] {"POINT", "COUPON"}),
	EMPTY("없음", new String[] {""});
	
	private String title;
	private String[] payTypes;
	
	// Alt + Shift + S -> O
	private PayGroup(String title, String[] payTypes) {
		this.title = title;
		this.payTypes = payTypes;
	}
	
	public String getTitle() {
		return title;
	}
	
	public static PayGroup findByPayType(String str){
		PayGroup result = EMPTY;
		
		for(PayGroup pg : PayGroup.values()) {	// pg: CASH, CARD, ETC, EMPTY
			for(String s : pg.payTypes) {
				if(s.equals(str))	result = pg;
			}
		}
		
		return result;
	}
	
	
}

public class Ex1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String data = sc.nextLine();
		
		PayGroup pg = PayGroup.findByPayType(data);
		
		switch (pg) {
		case CASH:	System.out.println(pg.getTitle() + " 결재 로직으로 이동");	break;
		case CARD:	System.out.println(pg.getTitle() + " 결재 로직으로 이동");	break;
		case ETC:	System.out.println(pg.getTitle() + " 결재 로직으로 이동");	break;
		case EMPTY: 
			System.out.println(pg.getTitle());
			System.out.println("존재하지 않는 결재 코드 입니다.");
			System.out.println("에러 처리 로직으로 이동");
			break;
		}
		
		
		
	}

	
}
