//challenge: implement an algorithm that, given some amount of money (in US dollars),
//will find the smallest number of coins with which change can be made,
//using a dynamic programming approach.

public class ChangeMaker {	
	public static void main(String[] args) {
		
		int c = -1;
		try {
			c = Integer.valueOf(args[0]) % 100;
		} catch (Exception e) {
			System.out.println("usage: java ChangeMaker <integer>");
			System.exit(1);
		}
		
		int coins[] = {1, 5, 10, 25};		//US coins
		int initSolution[] = {1,2,3,4,1,2,3,4,5,1,2,3,4,5,2,3,4,5,6,2,3,4,5,6,1};	//initial values
		int numCoins[] = new int[100];		//100 is maximum number of solutions
		
		//populate initial values
		for(int i = 0; i < initSolution.length; i++) {
			numCoins[i] = initSolution[i];
		}
		//traverse from end of initial values
		for(int i = initSolution.length; i < numCoins.length; i++) {
			int min = 100;
			//take min(solution[i-coinDenom1], solution[i-coinDenom2], etc...)
			for(int co : coins) {
				if(numCoins[i-co] < min) {
					min = numCoins[i-co] + 1;
				}
			}
			numCoins[i] = min;
		}
		System.out.println(numCoins[c-1]);
	}
}

/*
Note: this is an example of dynamic programming that happens to not be efficient at all.
The advantage of DP comes from precalculating and caching solutions that can be used many times.
This form of the solution recalculates our solution set every time it is used.
In an actual use case, ChangeMaker would not have a main function. Instead, it might have an initializer
which accepts coin denominations, and an array of solutions up to the largest coin denomination.
It would then populate an array which is referenced for every solution requested by a getter method. 
TODO: revisit this example in the future and implement.
*/