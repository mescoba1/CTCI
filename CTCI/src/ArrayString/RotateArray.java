package ArrayString;

public class RotateArray {

	public static void main(String[] args) {
		/*
		 * 1 2 3 7 4 1 4 5 6 -> 8 5 3 7 8 9 9 6 4
		 */
		int[][] arr = genArray(6);
		printArray(arr);
		System.out.println();
		rotate(arr);
		printArray(arr);
	}

	public static void rotate(int[][] a) {
		int lastCell = a.length - 1;
		for (int shell = 0; shell < a.length / 2; shell++) {
			for (int offSet = shell; offSet < lastCell; offSet++) {
				/*
				 * a[shell][offSet]; Top Left a[offSet][(a.length-1)-shell]; Top
				 * Right a[(a.length-1)-offSet][shell]; Bottom Left
				 * a[(a.length-1)-shell][(a.length-1) - offSet]; Bottom Right
				 */
				int temp = a[shell][offSet]; // save TL
				a[shell][offSet] = a[(a.length - 1) - offSet][shell]; // BL to
																		// TL
				a[(a.length - 1) - offSet][shell] = a[(a.length - 1) - shell][(a.length - 1) - offSet]; // BR
				// to
				// BL
				a[(a.length - 1) - shell][(a.length - 1) - offSet] = a[offSet][(a.length - 1) - shell]; // TR
				// to
				// BR
				a[offSet][(a.length - 1) - shell] = temp; // temp to TR
			}
			lastCell -= 1;
		}
	}

	public static int[][] genArray(int d) {
		int count = 1;
		int[][] arr = new int[d][d];
		for (int i = 0; i < d; i++) {
			for (int j = 0; j < d; j++) {
				arr[i][j] = count++;
			}
		}
		return arr;
	}

	public static void printArray(int[][] arr) {
		for (int[] row : arr) {
			for (int elem : row) {
				System.out.print(elem + "\t");
			}
			System.out.println();
		}
	}
}
