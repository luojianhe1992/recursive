import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ConceptSpace {
	public static void main(String[] args) {

		int features = 3;

		ArrayList<int[]> inputSpace = new ArrayList<int[]>();
		int[] array = new int[features];
		getPossibleInputSpace(inputSpace, array, 0);

		for (int[] temp : inputSpace) {
			for (int i = 0; i < temp.length; i++) {
				System.out.print(temp[i] + "\t");
			}
			System.out.println();
		}
		System.out.println(inputSpace.size());

		// transform the input space to the array
		int[][] inputSpaceArray = new int[inputSpace.size()][features + 1];

		// initialize the inputSpaceArray
		for (int i = 0; i < inputSpace.size(); i++) {
			for (int j = 0; j < features; j++) {
				inputSpaceArray[i][j] = inputSpace.get(i)[j];
			}
		}

		System.out.println("*******************");

		ArrayList<int[][]> result = new ArrayList<int[][]>();

		getPossibleConceptSpace(result, inputSpaceArray, 0);

		System.out.println(result.get(0)[0][3] + "))))))))");
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");

		for (int[][] temp : result) {
			for (int i = 0; i < temp.length; i++) {
				for (int j = 0; j < temp[i].length; j++) {
					System.out.print(temp[i][j] + "\t");
				}
				System.out.println();
			}

			System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&");
		}

		System.out.println("size = " + result.size());

	}

	public static void getPossibleInputSpace(ArrayList<int[]> result,
			int[] array, int index) {
		final int[] possibleValue = new int[] { -1, 1 };

		for (int pv : possibleValue) {
			int[] clone = array.clone();
			clone[index] = pv;

			if (index == array.length - 1) {
				result.add(clone);
			} else {
				getPossibleInputSpace(result, clone, index + 1);
			}

		}
	}

	public static int resultIndex = 3;

	public static void getPossibleConceptSpace(ArrayList<int[][]> result,
			int[][] inputSpce, int rowIndex) {
		final int[] possibleValue = new int[] { -1, 1 };

		for (int pv : possibleValue) {

			//调用自己的clone函数cloneArray()
			int [][] clone = cloneArray(inputSpce);
			
			clone[rowIndex][resultIndex] = pv;

			if (rowIndex == inputSpce.length - 1) {
				result.add(clone);
			} else {
				getPossibleConceptSpace(result, clone, rowIndex + 1);
			}
		}
	}
	
	public static int [][] cloneArray(int [][] origin){
		int [][] clone = new int[origin.length][origin[0].length];
		
		for(int i=0;i<clone.length;i++){
			for(int j=0;j<clone[0].length;j++){
				clone[i][j] = origin[i][j];
			}
		}
		
		return clone;
		
	}

}
