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
        double lambda = Double.parseDouble(args[0]);  // arrival rate --> 도착하는 사이의 텀
        double mu     = Double.parseDouble(args[1]);  // service rate --> 서비스시간이 더 빠름

        QueueInterface<Double> queue  = new LinkedQueue<Double>();       // arrival times of customers
        double thisArrival   = exponential(lambda);     // time of next arrival 도착한 시각
        double prevDeparture = -1;  // time of next departure 앞에게 나가는 시각

        double totalWait = 0.0;
        long customersServiced = 0;

        // simulate an M/M/1 queue
        while (customersServiced < TOTAL) {
            // it's an arrival
            if (queue.isEmpty() || thisArrival <= prevDeparture) {//대기자가 생김
                if (queue.isEmpty()) {
					prevDeparture = thisArrival + exponential(mu);//들어온 시각 + 처리하는 시간 = 나가는 시각
				}
                queue.enqueue(thisArrival);
                thisArrival += exponential(lambda);//들어오는 시간을 마킹함
            } else {
				// it's a departure
                double wait = prevDeparture - queue.dequeue();//기다린 시간 = 앞에 게 나가는 시각 - 들어온 시각           
                totalWait += wait;
                customersServiced++;
                if (queue.isEmpty()) {
					prevDeparture = -1;//대기자가 없으면 나간 시각을 초기화해줌
                } else {
					//The existing customer is in service, now.
					prevDeparture += exponential(mu);//대기자가 있으면 나간 시각에 처리한 시각을 더해줌
				}
            }
        }
        
		double expectedWait = 1.0 / (mu - lambda);        // W = expected time in system
		double observedWait = totalWait/customersServiced;
		System.out.println("expectedWait: " + expectedWait );
		System.out.println("observedWait: " + observedWait );

    }

}