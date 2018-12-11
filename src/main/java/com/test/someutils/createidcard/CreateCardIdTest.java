package com.test.someutils.createidcard;
import java.util.Scanner;



public class CreateCardIdTest {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("请输入身份证号前17位：");
		String cardId_ = input.next();
		//7 9 10 5 8 4 2 1 6 3 7 9 10 5 8 4 2
		int[] xishu = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};
		System.out.println(xishu.length);
		String last = "";
		int sum = 0;
		for(int i=0;i<cardId_.length();i++) {
			sum+=Integer.parseInt(cardId_.substring(i, i+1))*xishu[i];
		}

		//41072119930512001X

		//1 0 X 9 8 7 6 5 4 3 2
		switch(sum%11) {
			case 0:
				last =1+"";
				break;
			case 1:
				last = 0+"";
				break;
			case 2:
				last = "X";
				break;
			case 3:
				last = 9+"";
				break;
			case 4:
				last = 8+"";
				break;
			case 5:
				last = 7+"";
				break;
			case 6:
				last = 6+"";
				break;
			case 7:
				last = 5+"";
				break;
			case 8:
				last = 4+"";
				break;
			case 9:
				last = 3+"";
				break;
			case 10:
				last = 2+"";
				break;
		}
		//41092319930829101
		//41092319890829101X
		System.out.println("身份证最后一位是"+last);
	}

}
