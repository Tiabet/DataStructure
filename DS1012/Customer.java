package DS1012;

public class  Customer
{
	private int arrivalTime;
	private int transactionTime;
	private int customerNumber;

	public Customer(int clock_tp, int transactionTime_tp, int numberOfArrivals_tp)
	{
		arrivalTime = clock_tp;
		transactionTime = transactionTime_tp;
		customerNumber = numberOfArrivals_tp;
	}

	public int getTransactionTime()
	{
		return transactionTime;
	}

	public int getArrivalTime()
	{
		return arrivalTime;
	}

	public int getCustomerNumber()
	{
		return customerNumber;
	}

	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
