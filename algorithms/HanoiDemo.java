import java.util.Scanner;

public class HanoiDemo {
	
	public static void main(String[] args) {
		
		System.out.println("TOWERS OF HANOI");
		System.out.println("===============");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number of Disks : ");
		int n = scanner.nextInt();
		scanner.close();
		
		HanoiDemo hanoiDemo = new HanoiDemo();
		hanoiDemo.hanoi(n);

	}
	
	public void hanoi(int n) {
		
		int[][][] array = new int[n][][];	//create 3D array with n elements
											//each for 1,2,3,...,n number of disks	
		for (int i = 0; i < n; i++) {
			array[i] = new int[(int) (Math.pow(2, i+1)-1)][2];	//create 2D sub arrays with (2^n)-1 elements to hold 
		}														//start and end positions of each step
		
		for (int i = 0; i < n; i++) {
			
			for (int j = 0; j < (int) (Math.pow(2, i)-1); j++) {	//move n−1 discs from P1 to P2
				switch (array[i-1][j][0]) {
					case 1 :
						array[i][j][0] = 1;
						break;
					case 2 :
						array[i][j][0] = 3;
						break;
					case 3 :
						array[i][j][0] = 2;
						break;
				}
				switch (array[i-1][j][1]) {
					case 1 :
						array[i][j][1] = 1;
						break;
					case 2 :
						array[i][j][1] = 3;
						break;
					case 3 :
						array[i][j][1] = 2;
						break;
				}
			}
			
			array[i][(int) (Math.pow(2, i)-1)][0] = 1;	//move disc n from P1 to P3
			array[i][(int) (Math.pow(2, i)-1)][1] = 3;
			
			for(int j = (int) (Math.pow(2, i)),k = 0; j < (int) (Math.pow(2, i+1)-1); j++,k++) {	//move n−1 discs from P2 to P3
				switch (array[i-1][k][0]) {
					case 1 :
						array[i][j][0] = 2;
						break;
					case 2 :
						array[i][j][0] = 1;
						break;
					case 3 :
						array[i][j][0] = 3;
						break;
				}
				switch (array[i-1][k][1]) {
					case 1 :
						array[i][j][1] = 2;
						break;
					case 2 :
						array[i][j][1] = 1;
						break;
					case 3 :
						array[i][j][1] = 3;
						break;
				}
			}
			 
		}
		
		System.out.println("Number of Steps : "+array[n-1].length);	//display number of steps for n disks
		
		for (int[] i : array[n-1]) {	//display steps for n disks
			System.out.println("P"+i[0]+" --> "+"P"+i[1]);
		}
		
		
		
	}

}
