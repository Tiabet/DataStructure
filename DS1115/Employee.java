package DS1115;
public class Employee {
    int        employeeId;
    String     name;
    //Department dept;
	public Employee(int _id, String _name)
	{
		this.employeeId = _id;
		this.name = _name;
	}

    // other methods would be in here

    @Override
    public int hashCode() {
        int hash = 1;
        //hash = hash * 17 + employeeId % 31;
        hash = this.employeeId * 31 + name.hashCode() + + employeeId % 31;
        //hash = hash * 13 + (dept == null ? 0 : dept.hashCode());
        return hash;
    }
    
	//@Override
    //public boolean equals(Object obj) {
    //    return obj instanceof Employee && this.name.equals( ((Employee) obj).name );
    //}


}