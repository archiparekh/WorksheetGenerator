import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.Math;
import java.util.Date;
public class Worksheet {
	File f; 
	public Worksheet(String fileName) {
		f = new File(fileName);
	}
	public Worksheet() {
		
	}
	public String negativeAddition() {
		String problemSet = "";
		for (int i = 0; i < 4; i++) {
			int factor1 = (int) (Math.random() * (50 - (-50)) + (-50));
			int factor2 = (int) (Math.random() * (50 - (-50)) + (-50));
			if (i % 2 ==0) {
				problemSet = problemSet + factor1 +" + " + factor2 + " =\n";
			}
			else {
				problemSet = problemSet + factor1 +" - " + factor2 + " =\n";
			}
		}
		return problemSet;
	}
	
	public String negativeMultiplication() {
		String problemSet = "";
		for (int i = 0; i < 4; i++) {
			int factor1 = (int) (Math.random() * (15 - (-15)) + (-15));
			int factor2 = (int) (Math.random() * (15 - (-15)) + (-15));
			problemSet = problemSet + factor1 +" * " + factor2 + " =\n";
		}
		return problemSet;
	}
	
	public String primeFactorization() {
		String primes = "";
		String tester ="";
		int num = 0;
		do {
		num = (int) (Math.random() * (100 - (1)) + (1));
		primes = "2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97";
		tester = num + ",";
		} while (primes.contains(tester));
		
		return "Find the prime factorization of " + num + "\n\n\n\n\n";
	}
	
	public String GCF() {
		int common = (int) (Math.random() * (30 - (2)) + (2));
		int factor1 = (int) (Math.random() * (50 - (1)) + (1));
		int factor2 = (int) (Math.random() * (50 - (1)) + (1));
		return "Find the GCF of " + factor1*common + " and " + factor2*common + ".\n\n\n\n\n";
	}
	
	public String LCM() {
		int common = (int) (Math.random() * (10 - (2)) + (2));
		int factor1 = (int) (Math.random() * (50 - (1)) + (1));
		int factor2 = (int) (Math.random() * (50 - (1)) + (1));
		return "Find the LCM of " + factor1*common + " and " + factor2*common + ".\n\n\n\n\n";
	}
	
	public String decimalOperations() {
		double factor1 =  Math.round((Math.random() * (100 - (1)) + (1))*100);
		double factor2 = Math.round((Math.random() * (100 - (1)) + (1))*100);
		String problemSet = factor1/100 + " * " + factor2/100 + "\n\n\n\n\n";
		factor1 =  Math.round((Math.random() * (1000 - (1)) + (1))*100);
		factor2 = Math.round((Math.random() * (100 - (1)) + (1))*100);
		double dividend = Math.round(factor1*factor2*100);
		problemSet = problemSet + dividend/10000 + " / " + factor2/100 + "\n\n\n\n\n";
		return problemSet;
	}
	
	public String exponents() {
		String problemSet = "";
	
		for (int i = 0; i < 4; i++) {
			int base = (int) (Math.random() * (10 - 1) + 1);
			int exponent = (int) (Math.random() * (4 - 1) + 1);
			if (i % 2 == 1)
				base = base * -1;
			if (i == 3)
				exponent = exponent * -1;
			problemSet = problemSet + "(" + base + ")^(" + exponent + ") = \n";
		}
		return problemSet;
	}
	
	public void writeToFile() throws IOException 
	{
	     
	    BufferedWriter writer = new BufferedWriter(new FileWriter(f));
	    writer.write("TUTORING REVIEW: " + java.time.LocalDate.now() + "\n\n\n");
	    writer.write("DECIMALS\n" + decimalOperations());
	    writer.write("NEGATIVE NUMBERS\nFind the sums/differences:\n" + negativeAddition());
	    writer.write("Find the products: \n" + negativeMultiplication());
	    writer.write("EXPONENTS\nSolve the following\n" + exponents());
	    writer.write(primeFactorization());
	    writer.write(GCF());
	    writer.write(LCM());
	    writer.close();
	}
	
	public static void main(String[] args) throws IOException {
		String fileName = "reviewSheet_" + java.time.LocalDate.now() + ".txt";
		Worksheet w = new Worksheet(fileName);
		w.writeToFile();
	}
}

