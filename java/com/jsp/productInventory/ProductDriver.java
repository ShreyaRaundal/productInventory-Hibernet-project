package com.jsp.productInventory;

public class ProductDriver {

	public static void main(String[] args) {

		ProductDao dao = new ProductDao();

		// 1. Add product
		Product p = new Product("Laptop", 45000, 10);
		dao.save(p);

		// 2. Fetch product
		System.out.println(dao.get(1));

		// 3. Fetch all
		System.out.println(dao.getAll());

		// 4. Delete
		// dao.delete(1);
	}
}
