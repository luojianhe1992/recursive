import java.util.ArrayList;
public class GetPossibleArray {
	public static void main(String [] args){
		ArrayList<int[]> result1 = new ArrayList<int[]>();
		int[] array1 = new int [3];
		
		getPossibleArray(result1, array1, 0);
		
		for(int []temp:result1){
			for(int i=0;i<temp.length;i++){
				System.out.print(temp[i]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("size1 = "+result1.size());
		
		System.out.println("*****************");
		
		ArrayList<int[]> result2 = new ArrayList<int[]>();
		int [] array2 = new int [5];
		
		getPossibleArray2(result2, array2, 0);
		
		System.out.println("size2 = "+result2.size());
		
		for(int []temp:result2){
			for(int i=0;i<temp.length;i++){
				System.out.print(temp[i]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("*****************");
		
		int [][] result3 = new int [8][3];
		int[] array3 = new int[3];
		
		getPossibleArray3(result3, array3, 0);
		
		for(int [] temp:result3){
			for(int i=0;i<temp.length;i++){
				System.out.print(temp[i]+"\t");
			}
			System.out.println();
		}
		
		System.out.println("*****************");
		
		System.out.println(resultIndex);
		
		
		
	}
	
	//method 1
	public static void getPossibleArray(ArrayList<int []> result, int [] array, int index){
		
		final int [] possibleValue = new int[]{1,2,3};
		
		//遍历所有可能性
		for(int pv:possibleValue){
			int [] clone = array.clone();
			clone[index] = pv;
			
			if(index == array.length - 1){
				result.add(clone);
			}
			else{
				getPossibleArray(result, clone, index+1);
			}
			
		}
	}
	
	public static void getPossibleArray2(ArrayList<int[]> result, int []array,int index){
		
		int [] clone1 = array.clone();
		clone1[index] = 1;
		
		int [] clone2 = array.clone();
		clone2[index] = 2;
		
		int [] clone3 = array.clone();
		clone3[index] = 3;
		
		//终止条件
		if(index == array.length - 1){
			result.add(clone1);
			result.add(clone2);
			result.add(clone3);
		}
		else{
			getPossibleArray2(result, clone1, index + 1);
			getPossibleArray2(result, clone2, index + 1);
			getPossibleArray2(result, clone3, index + 1);
		}
	}
	
	public static int resultIndex = 0;
	
	public static void getPossibleArray3(int [][] result,int [] array, int index){
		
		//possible value set
		final int [] possibleValue = new int[]{-1,1};
		
		//遍历每一个框框的每一个可能性
		for(int pv:possibleValue){
			
			//using clone()
			int [] clone = array.clone();
			clone[index] = pv;
			
			//终止条件
			if(index == array.length - 1){
				/*
				for(int i=0;i<result[0].length;i++){
					result[resultIndex][i] = clone[i];
				}
				*/
				
				//
				result[resultIndex] = clone;
				resultIndex++;
			}else{
				//recursive
				getPossibleArray3(result, clone, index + 1);
			}
		}
		
		
	}
}
