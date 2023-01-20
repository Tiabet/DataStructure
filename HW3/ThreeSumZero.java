package HW3;

import static HW3.MyTextDataReader.readIntValues;

public class ThreeSumZero {

	public static void main(String args[]) {
		if (args.length < 1) {
			System.out.println("I need a txt file name to read.");
			return;
		}
		Stopwatch timer1 = new Stopwatch();
		int[] dataint = readIntValues(args[0]);
		int count = 0;
		for (int i = 0; i <16; i++) {
			for (int j = i + 1; j <16; j++) {
				for (int k = j + 1;  k<16; k++) {
					if (dataint[i] + dataint[j] + dataint[k]== 0) {
						count = count + 1;
						System.out.println(count + ": dataint[" + i + "]=" + dataint[i]);
						System.out.println(count + ": dataint[" + j + "]=" + dataint[j]);
						System.out.println(count + ": dataint[" + k + "]=" + dataint[k]);
					}
				}
			}
		}
		double time1 = timer1.elapsedTime();
		// System.out.println( "(" + time1 + " seconds)");
		System.out.printf("(%.5f seconds)\n", time1);
	}
}
