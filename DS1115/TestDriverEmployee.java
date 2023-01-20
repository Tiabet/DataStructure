package DS1115;
import java.util.*;

public class TestDriverEmployee 
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
		Employee emp1 = new Employee(10, "Company1");
		Employee emp2 = new Employee(10+31, "Company1");
		System.out.println("emp1:" + emp1.hashCode());
		System.out.println("emp2:" + emp2.hashCode());

		System.out.println("emp1.equals(emp2):" + emp1.equals(emp2) );

		HashMap<Employee, Integer> map = new HashMap<Employee, Integer>();
		map.put(emp1, 1); 
		map.put(emp2, 5); 

		System.out.println("value for emp1:" + map.get(emp1));
		System.out.println("value for emp2:" + map.get(emp2));
		
	}
}
