package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		SellerDao sellerDao = DaoFactory.crateSellerDao();
		
		System.out.println("------1° SELLER Find By Id-------");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		
		System.out.println("\n-----2° SELLER Find Department Id-------");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(dep);
		for(Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n-----3° SELLER Find All---------");
		list = sellerDao.findAll();
		for(Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n------4° DELETE Seller Id---------");
		sellerDao.deleteById(51);
		
		System.out.println("\n\n------5° UPDATE Seller ---------");
		seller = sellerDao.findById(3);
		seller.setName("Borge Bastos");
		seller.setBaseSalary(15000);
		sellerDao.update(seller);
		System.out.println("Update Sucessfully!");		
				
		System.out.println("\n\n------6° Insert Seller ---------");
		Seller newseller = new Seller(null, "Pedro Basto", "pedro@gmail.com", new Date(), 7500.0,  dep );
		sellerDao.insert(newseller);
		System.out.println("Data Inserted! new Id = " + newseller.getId() );
		
		
	}
}
