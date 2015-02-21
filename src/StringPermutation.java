import java.util.ArrayList;
public class StringPermutation {
	
	static int sumLength = 0;
	
	public static void main(String [] args){
		ArrayList<char[]> result = new ArrayList<char[]>();
		char[] chars = new char[]{'a','b'};
		int [] count = new int[]{1,3};
		getSumLength(count);
		System.out.println("sumLength = "+sumLength);
		char [] way = new char[sumLength];
		stringPermutation(result, chars, count, 0, way);
		for(char[]temp:result){
			for(int i=0;i<temp.length;i++){
				System.out.print(temp[i]+"\t");
			}
			System.out.println();
		}
		System.out.println("size = "+result.size());
		System.out.println("****************");
		
		ArrayList<char[]> result2 = new ArrayList<char[]>();
		char[] chars2 = new char[]{'c','d'};
		int [] count2 = new int[]{2,2};
		int arraySum = returnArraySum(count2);
		char [] way2 = new char [arraySum];
		stringPermutation2(result2, chars2, count2, 0, way2);
		
		for(char[] temp:result2){
			for(char tempChar:temp){
				System.out.print(tempChar+"\t");
			}
			System.out.println();
		}
		
		System.out.println("size = "+result2.size());
		
	}
	
	public static void stringPermutation(ArrayList<char[]> result, char[]chars, int []count, int index, char[] way){
		
		//遍历each框框的每一种可能性
		for(int i=0;i<chars.length;i++){
			if(count[i] == 0){
				continue;
			}
			
			//利用复制clone
			int[] cloneCount = count.clone();
			char[] cloneWay = way.clone();
			
			cloneCount[i]--;
			cloneWay[index] = chars[i];
			
			//终止条件
			if(index == sumLength - 1){
				result.add(cloneWay);
			}
			else{
				stringPermutation(result, chars, cloneCount, index+1, cloneWay);
			}
			
		}
	}
	
	public static void getSumLength(int [] count){
		sumLength = 0;
		for(int temp:count){
			sumLength += temp;
		}
	}
	
	public static void stringPermutation2(ArrayList<char[]> result, char[] chars, int[] count, int index, char[] way){
		
		boolean stopped = true;
		
		for(int i=0;i<chars.length;i++){
			
			//the character in i position is empty
			if(count[i] == 0){
				continue;
			}
			
			//using clone()
			int [] cloneCount = count.clone();
			char [] cloneWay = way.clone();
			
			cloneCount[i]--;
			cloneWay[index] = chars[i];
			
			stringPermutation2(result, chars, cloneCount, index + 1, cloneWay);
			
			stopped = false;
		}
		
		if(stopped){
			result.add(way);
		}
		
	}
	
	public static int returnArraySum(int [] array){
		int sum = 0;
		for(int i=0;i<array.length;i++){
			sum = sum + array[i];
		}
		return sum;
	}
	
}
