import java.util.Scanner;

public class KaratsubaDemo {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("KARATSUBA MULTIPLICATION");
		System.out.println("========================");
		System.out.print("Enter number 1 : ");
		int[] num1 = makeArray(sc.next());
		System.out.print("Enter number 2 : ");
		int[] num2 = makeArray(sc.next());
		sc.close();
		System.out.println("Result = " + makeString(karatsubaMultiply(num1,num2)));
	}
	
	private static int[] makeArray(String num) { //converts a string into an integer array
		int[] array = new int[num.length()];
		for(int i = 0; i < array.length; i++) {
			array[i] = new Integer(num.substring(i, i+1)); 
		}
		return array;
	}
	
	private static String makeString(int[] array) { //converts an integer array to a string
		String num = "";
		for(int i = 0; i < array.length; i++) {
			num = num + array[i];
		}
		return num;
	}

	public static int[] karatsubaMultiply(int[] x, int[] y) {
		int max = Math.max(x.length, y.length);
		
		if(max == 1){
			int temp = x[0]*y[0];
			if(temp < 10) {
				return new int[]{temp};
			}
			return new int[]{temp/10, temp-(temp/10)*10};
		}
		
		int[] x1 = fixArray(x, max);
		int[] y1 = fixArray(y, max);
		
		int[] a = subArray(x1, 1, x1.length/2);
		int[] b = subArray(x1, x1.length/2 + 1, x1.length);
		int[] c = subArray(y1, 1, x1.length/2);
		int[] d = subArray(y1, x1.length/2 + 1, x1.length);
		
		int[] mul1 = karatsubaMultiply(a, c);
		int[] mul2 = karatsubaMultiply(b, d);
		int[] mul3 = karatsubaMultiply(add(a, b), add(c, d));
		
		int[] part1 = shiftDigits(mul1, x1.length);
		int[] part2 = shiftDigits(subtract(subtract(mul3, mul1), mul2), x1.length/2);
		return add(part1, add(part2, mul2));
	}
	
	private static int[] fixArray(int[] array, int max) {
		int length = 0;
		if(max%2 == 1) {
			length = max + 1;
		}
		else {
			length = max;
		}
		int[] array1 = new int[length];
		for(int i = length-1, j = array.length-1; i >= 0; i--,j--) {
			array1[i] = array[j];
			if(j == 0) {
				break;
			}
		}
		return array1;
	}
	
	private static int[] subArray(int[] array, int start, int finish) {
		int[] array1 = new int[finish - start + 1];
		for(int i = 0; i < array1.length; i++) {
			array1[i] = array[start-1];
			start++;
		}
		return array1;
	}
	
	private static int[] add(int[] a1, int[] a2) {
		int temp = 0;
		boolean carried = false;
		int max = Math.max(a1.length, a2.length);
		int[] array1 = fixArray(a1, max);
		int[] array2 = fixArray(a2, max);
		int[] result = new int[array1.length + 1];
		for(int i = result.length-1, j = array1.length-1; i >= 0; i--, j--) {
			if(carried) {
				if(j >= 0) {
					temp = array1[j] + array2[j] + 1;
				}
				else {
					temp = 1;
				}
			}
			else {
				if(j >= 0) {
					temp = array1[j] + array2[j];
				}
				else {
					temp = 0;
				}
			}
			result[i] = temp % 10;
			if(temp/10 == 0) {
				carried = false;
			}
			else {
				carried = true;
			}
		}
		return compact(result);
	}

	private static int[] subtract(int[] a1, int[] a2) {
		boolean borrowed = false;
		int max = Math.max(a1.length, a2.length);
		int[] array1 = fixArray(a1, max);
		int[] array2 = fixArray(a2, max);
		int[] result = new int[array1.length];
		for(int i = array1.length-1; i >= 0; i--) {
			if(borrowed) {
				if(array1[i]-1 >= array2[i]) {
					result[i] = array1[i]-1 - array2[i];
					borrowed = false;
				}
				else {
					result[i] = array1[i]-1 + 10 - array2[i];
					borrowed = true;
				}
			}
			else {
				if(array1[i] >= array2[i]) {
					result[i] = array1[i] - array2[i];
					borrowed = false;
				}
				else {
					result[i] = array1[i] + 10 - array2[i];
					borrowed = true;
				}
			}
		}
		return compact(result);
	}

	private static int[] shiftDigits(int[] array, int length) {
		int[] array1 = new int[array.length + length];
		for(int i = 0; i < array.length; i++) {
			array1[i] = array[i];
		}
		return array1;
	}
	
	private static int[] compact(int[] array) { //removes leading 0 valued elements in an array
		int i = 0;
		while(array[i] == 0 && i < array.length-1) {
			i++;
		}
		return subArray(array, i+1, array.length);
	}

}
