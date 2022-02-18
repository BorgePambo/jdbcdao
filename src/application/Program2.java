package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.empl.DepartmentDaoJDBC;
import model.entities.Department;

public class Program2 {

	
	public static void main(String[] args) {
		
		
		 DepartmentDaoJDBC departmentDao = (DepartmentDaoJDBC) DaoFactory.createDepartmentDao();
		 
		 System.out.println("\n-----Department FindById------");
		 Department dep = departmentDao.findById(1);
		 System.out.println(dep);
		 
		 System.out.println("\n\n-----Department FindAll------");
		 List<Department> list = departmentDao.findAll();
		 for(Department dept: list) {
			 System.out.println(dept);
		 }
		 
		 
		 System.out.println("\n\n-----Department Insert------");
		 Department dep1 = new Department(null, "Food");
		 departmentDao.insert(dep1);
		 System.out.println("Inserted! New Id = " + dep1.getId());
		 
		  
		 System.out.println("\n\n-----Department Update------");
		 Department dep2 = departmentDao.findById(1);
		 dep2.setName("H.Resource");
		 departmentDao.update(dep2);
		 System.out.println("Updated Sucessfully!");
		 
		 
		 System.out.println("\n\n-----Department DeleteById------");
		 departmentDao.deleteById(16);
		 System.out.println("Deleted Sucessfully!");
		 
		 
	}

}
