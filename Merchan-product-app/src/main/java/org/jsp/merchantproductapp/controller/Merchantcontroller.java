package org.jsp.merchantproductapp.controller;
import java.util.Scanner;
import org.jsp.merchantproductapp.dao.MerchantDao;
import org.jsp.merchantproductapp.dto.Merchant;

public class Merchantcontroller {
	public static void main(String[] args) {	
	MerchantDao dao=new MerchantDao();
	Scanner sc=new Scanner(System.in);
    System.out.println("1.save Merchant");
    System.out.println("2.update Merchant");
    System.out.println("3.find by id");
    System.out.println("4.verify by phone and password");
    System.out.println("5.verify by email and password");
    switch(sc.nextInt()) {
    
case 1:{
	System.out.println("enter phone,email,gst_number and password");
	Merchant m=new Merchant();
	m.setPhone(sc.nextLong());
	m.setEmail(sc.next());
	m.setGst_number(sc.nextInt());
	m.setPassword(sc.next());
	m=dao.SaveMerchant(m);
	System.out.println("merchant save with Id: "+m.getId());
}

case 2:{
	System.out.println("enter the id ,phone,email,gst_number and password");
    Merchant m=new Merchant();
	m.setId(sc.nextInt());
	m.setPhone(sc.nextLong());
	m.setEmail(sc.next());
	m.setGst_number(sc.nextInt());
	m.setPassword(sc.next());
	m=dao.updateMerchant(m);
	if(m!=null) {
     System.out.println("merchant update successfull");
   }else
	System.out.println("cannot be update merchnat as id is invalid");
	break;
}
case 3:{
	System.out.println("enter find by id");
	int id=sc.nextInt();
	Merchant merchant=dao.findById(id);
	if(merchant!=null) {
	System.out.println("merchent is found");
	System.out.println(merchant);
	}else
		System.out.println("invalid  id");
	break;
}
case 4:{
	
	System.out.println("enter the phone and password");
	long phone=sc.nextInt();
	String password=sc.next();
	Merchant merchant=dao.verify(phone, password);
	if(merchant!=null) {
    System.out.println(merchant);
	}else
		System.out.println("invalid   phone and password");
	break;
}

case 5:{
	System.out.println("enter the email and password");
	String email=sc.next();
	String password=sc.next();
	Merchant merchant=dao.verify(email, password);
	if(merchant!=null) {
    System.out.println(merchant);
	}else
		System.out.println("invalid   email and password");
	break;
	
}

}

}
}