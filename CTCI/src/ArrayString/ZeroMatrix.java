package ArrayString;

public class ZeroMatrix {

	public static void main(String[] args) {
		int[][] arr = {{1,0,1,1,0},{0,1,1,1,0},{1,1,1,1,1},{1,0,1,1,1},{1,1,1,1,1}};
		zeroMatrix(arr);
		printArray(arr);

	}
	
	public static void zeroMatrix(int[][] matrix){
		boolean rowZero = false, colZero = false;
		
		//check if the first row/ col has zeros
		for(int c = 0; c < matrix.length; c++){
			if(matrix[0][c] == 0){
				rowZero = true;
				break;
			}
		}
		for(int r = 0; r < matrix.length; r++){
			if(matrix[r][0] == 0){
				colZero = true;
				break;
			}
		}
		
		//check the rest of the array
		for(int i = 1; i < matrix.length; i++){
			for(int j = 1; j < matrix[i].length; j++){
				if(matrix[i][j] == 0){
					//set the first row and col of that cell to zero
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		//nullify rows
		for(int r = 1; r < matrix.length; r++){
			if(matrix[r][0] == 0){
				nullifyRow(matrix, r);
			}
		}
		//nullify col
		for(int c = 1; c < matrix.length; c++){
			if(matrix[0][c] == 0){
				nullifyCol(matrix, c);
			}
		}
		if(rowZero){
			nullifyRow(matrix, 0);
		}
		if(colZero){
			nullifyCol(matrix, 0);
		}
	}
	
	public static void nullifyRow(int[][] arr, int row){
		for(int i = 0; i < arr[0].length; i++){
			arr[row][i] = 0;
		}
	}
	public static void nullifyCol(int[][] arr, int col){
		for(int i = 0; i < arr.length; i++){
			arr[i][col] = 0;
		}
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
