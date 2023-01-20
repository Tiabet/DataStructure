package DS1012;

import java.util.Random;
public class WaitServiceQueueMM1 { 
	final static Random random = new Random ();
	static double exponential (double mu) {
		return -Math.log (random.nextDouble()) / mu;
    }
	public static final int TOTAL = 500000;

	public static void main(String[] args)
	{
		String[] myargs = {"20", "40"};
		MM1Test(myargs);
		//expTest(4);
	}

	public static void expTest(double rate)
	{
		int iter = 0;
		double arrivalTimeSum = 0;
		while(iter < TOTAL)
		{
			arrivalTimeSum += exponential(rate);
			iter++;
		}
		System.out.println("average inter-arrival time:" + (  arrivalTimeSum/ TOTAL ) );
	}

    public static void MM1Test(String[] args) { 
        double lambda = Double.parseDouble(args[0]);  // arrival rate --> �����ϴ� ������ ��
        double mu     = Double.parseDouble(args[1]);  // service rate --> ���񽺽ð��� �� ����

        QueueInterface<Double> queue  = new LinkedQueue<Double>();       // arrival times of customers
        double thisArrival   = exponential(lambda);     // time of next arrival ������ �ð�
        double prevDeparture = -1;  // time of next departure �տ��� ������ �ð�

        double totalWait = 0.0;
        long customersServiced = 0;

        // simulate an M/M/1 queue
        while (customersServiced < TOTAL) {
            // it's an arrival
            if (queue.isEmpty() || thisArrival <= prevDeparture) {//����ڰ� ����
                if (queue.isEmpty()) {
					prevDeparture = thisArrival + exponential(mu);//���� �ð� + ó���ϴ� �ð� = ������ �ð�
				}
                queue.enqueue(thisArrival);
                thisArrival += exponential(lambda);//������ �ð��� ��ŷ��
            } else {
				// it's a departure
                double wait = prevDeparture - queue.dequeue();//��ٸ� �ð� = �տ� �� ������ �ð� - ���� �ð�           
                totalWait += wait;
                customersServiced++;
                if (queue.isEmpty()) {
					prevDeparture = -1;//����ڰ� ������ ���� �ð��� �ʱ�ȭ����
                } else {
					//The existing customer is in service, now.
					prevDeparture += exponential(mu);//����ڰ� ������ ���� �ð��� ó���� �ð��� ������
				}
            }
        }
        
		double expectedWait = 1.0 / (mu - lambda);        // W = expected time in system
		double observedWait = totalWait/customersServiced;
		System.out.println("expectedWait: " + expectedWait );
		System.out.println("observedWait: " + observedWait );

    }

}