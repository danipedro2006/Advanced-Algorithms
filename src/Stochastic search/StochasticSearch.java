package diverse;

import java.util.concurrent.ThreadLocalRandom;

public class StochasticSearch {
	
	private static final double START_DOMAIN=-1;
	private static final double END_DOMAIN=2;
	
	private double function(double x) {
		return ((Math.pow(x, 2)-1)*((x-2)*Math.pow(x, 3)));
	}
	
	public void search() {
		double startPos=START_DOMAIN;
		double maxY=function(startPos);
		double maxX=START_DOMAIN;
		
		for(int i=0;i<10;i++) {
			double random=ThreadLocalRandom.current().nextDouble(START_DOMAIN, END_DOMAIN);
			if(function(random)>maxY) {
				maxY=function(random);
				maxX=random;
			}
		}
		System.out.println("Maximum value of f(x) is: "+maxX+", "+maxY);
	}
	public static void main(String[] args) {
		StochasticSearch s=new StochasticSearch();
		s.search();
		
		 
	}

}
