package org.jsp.merchantproductapp.controller;

import java.util.List;
import java.util.Scanner;


import org.jsp.merchantproductapp.dao.ProductDao;
import org.jsp.merchantproductapp.dto.Merchant;
import org.jsp.merchantproductapp.dto.Product;

public class Productcontroller {
	public static void main(String[] args) {	
		ProductDao dao=new ProductDao();
	
		System.out.println("1.Save Product");
		System.out.println("2.Update Product");
		System.out.println("3.Find Products By Brand");
		System.out.println("4.Find Products By Category");
		System.out.println("5.Find Products By Name");
		System.out.println("6.Find Product By id");
		System.out.println("7.Find Products By Merchant Id");
		System.out.println("8.Find All Products");
		Scanner sc=new Scanner(System.in);	
		switch (sc.nextInt()) {
		case 1: {
			System.out.println("Enter the Merchant Id to add product");
			int merchant_id = sc.nextInt();
			System.out.println("Enter the name,brand,category,description,cost  to add product");
			Product product = new Product();
			product.setName(sc.next());
			product.setBrand(sc.next());
			product.setCategory(sc.next());
			product.setDescription(sc.next());
			product.setCost(sc.nextDouble());
			
			product =dao.saveProduct(product, merchant_id);
			if (product != null)
				System.out.println("Product added with Id:" + product.getId());
			else
				System.err.println("Cannot Add Product as Merchant Id is Invalid");
			break;
		}
		case 2: {
			System.out.println("Enter the id,name,brand,category,description,cost and add product");
			Product product = new Product();
			product.setId(sc.nextInt());
			product.setName(sc.next());
			product.setBrand(sc.next());
			product.setCategory(sc.next());
			product.setDescription(sc.next());
			product.setCost(sc.nextDouble());
			
			product = dao.updateProduct(product);
			if (product != null)
				System.out.println("Product with Id:" + product.getId() + " updated");
			else
				System.err.println("Cannot Update Product as  Id is Invalid");
			break;
		}
		case 3: {
			System.out.println("Enter the brand to find products");
			String brand = sc.next();
			List<Product> products = dao.findProductbybrand(brand);
			if (products.isEmpty())
				System.err.println("No Product found with entered brand");
			else
				for (Product p : products) {
					System.out.println(p);
					System.out.println("----------------------------------");
				}
			break;
		}
		case 4: {
			System.out.println("Enter the category to find products");
			String category = sc.next();
			List<Product> products = dao.findProductbycategory(category);
			if (products.isEmpty())
				System.err.println("No Product found with entered category");
			else
				for (Product p : products) {
					System.out.println(p);
					System.out.println("----------------------------------");
				}
			break;
		}
		case 5: {
			System.out.println("Enter the name to find products");
			String name = sc.next();
			List<Product> products =dao.findProductbyname(name);
			if (products.isEmpty())
				System.err.println("No Product found with entered name");
			else
				for (Product p : products) {
					System.out.println(p);
					System.out.println("----------------------------------");
				}
			break;
		}
		case 6: {
			System.out.println("Enter the id to find product");
			int id = sc.nextInt();
			Product product =dao.findById(id);
			if (product != null)
				System.out.println(product);
			else
				System.err.println("Invalid Product Id");
			break;
		}
		case 7: {
			System.out.println("Enter the Merchant Id to find products");
			int merchant_id = sc.nextInt();
			List<Product> products = dao.findbymerchantid(merchant_id);
			if (products.isEmpty())
				System.err.println("No Product found for entered Merchant Id");
			else
				for (Product p : products) {
					System.out.println(p);
					System.out.println("----------------------------------");
				}
			break;
		}
		case 8: {
			List<Product> products = dao.findAll();
			for (Product p : products) {
				System.out.println(p);
				System.out.println("----------------------------------");
			}
			break;
		}
		default: {
			sc.close();
			System.err.println("Invalid Choice");
		}
		}

}
}