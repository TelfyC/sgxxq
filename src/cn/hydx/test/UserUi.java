package cn.hydx.test;
import java.util.Scanner;

import cn.hydx.service.UserBiz;
import cn.hydx.service.impl.UserBizImpl;
 public class UserUi {
 Scanner sc = new Scanner(System.in);
 public void welcome() {
	 System.out.println("------------------");
	 System.out.println("-------wxx shangcheng------");
	 System.out.println("------------------");
	 System.out.println("--1.×¢²á    2.µÇÂ¼     3.ÍË³ö----");
	 System.out.println("----choose---");
	 String chooseNum = sc.next();
	 switch(chooseNum) {
	 case "1":
		 UserBizImpl user = new UserBizImpl();
	 	user.regist();
	 	break;
	 case"2":
		 ;
	 case"3":
		 ;
	 }
 }
public static void main(String[] args)
{
	UserUi u= new UserUi();
	u.welcome();
}

}
