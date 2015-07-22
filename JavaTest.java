
import java.util.*;

public class JavaTest {

	public static void main(String [] asdfg){
		int [] a = {9,9};
		int [] b = {5,5, 5};
		int [] aa = {9,9,9};
		int [] c = incrementArrayInt(a);
		int [] d = incrementArrayInt(b);
		int [] e = addArrayInt(a,b);
		int [] f = addArrayInt(aa,b);
		int [] g = multiplyArrayInt(b,aa);
		printArray(f);
		printArray(g);
	}
	public static void printArray(int [] a){
		for (int i=a.length-1;i>=0;i-- ){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
	}
	public static void printMatrix(int [][]a){
		for(int i=0;i<a.length;i++){
			printArray(a[i]);
		}
	}
	public static int[] multiplyArrayInt(int[] arrayInt, int[] otherInt){
		int [][] multMatrix = new int[Math.min(arrayInt.length, otherInt.length)][arrayInt.length+otherInt.length];
		int [] small;
		int [] large;
		int [] result = new int[arrayInt.length+otherInt.length];
		if(arrayInt.length>otherInt.length){
			large = arrayInt;
			small = otherInt;
		}else{
			large = otherInt;
			small = arrayInt;
		}
		for (int i = 0; i<small.length; i++){
			for(int k = 0; k<large.length; k++){
				multMatrix[i][k+i] = multMatrix[i][k+i]+small[i]*large[k];
				if (multMatrix[i][k+i] >9){
					multMatrix[i][k+1+i] = multMatrix[i][k+i]/10;
					multMatrix[i][k+i] = multMatrix[i][k+i]%10;
				}
			}
		}
		for (int k = 0; k<small.length+large.length; k++){
			int sum = result[k];
			for(int i = 0; i<small.length; i++){
				sum = sum + multMatrix[i][k];
			}
			if(sum>9){
				result[k+1] =sum/10;
				result[k] = sum%10;
				continue;
			}
			result[k] = sum;
		}
		if(result[small.length+large.length-1]==0){
			return Arrays.copyOf(result, small.length+large.length-1);
		}
		return result;
	}
	public static int[] incrementArrayInt(int[] arrayInt){
		int [] newArrayInt = new int[arrayInt.length+1];
		System.arraycopy(arrayInt, 0, newArrayInt, 0, arrayInt.length);
	    for (int i=0; i< arrayInt.length+1; i++){
	    	newArrayInt[i] = newArrayInt[i]+1;
	    	if(newArrayInt[i]>9){
	    		newArrayInt[i] = newArrayInt[i] %10;
	    		continue;
	    	}
	    	break;
	    }
	    if(newArrayInt[arrayInt.length]==0){
	    	return Arrays.copyOf(newArrayInt, arrayInt.length);
	    }
	    return newArrayInt;
	}
	public static int[] addArrayInt(int[] arrayInt, int []otherInt){
		int [] newArrayInt = new int[Math.max(arrayInt.length, otherInt.length)+1];
		int [] newOtherInt = new int[Math.max(arrayInt.length, otherInt.length)+1];
		int carry = 0;
		System.arraycopy(arrayInt, 0, newArrayInt, 0, arrayInt.length);
		System.arraycopy(otherInt, 0, newOtherInt, 0, otherInt.length);
	    for (int i=0; i< Math.max(arrayInt.length, otherInt.length); i++){
	    	newArrayInt[i] = newArrayInt[i]+newOtherInt[i]+carry;
	    	if(newArrayInt[i]>9){
	    		newArrayInt[i] = newArrayInt[i] %10;
	    		carry = 1;
	    	}else{
	    		carry = 0;
	    	}
	    }
	    if(carry==0){
	    	return Arrays.copyOf(newArrayInt, Math.max(arrayInt.length, otherInt.length));
	    }else{
	    	newArrayInt[Math.max(arrayInt.length, otherInt.length)] = 1;
	    	return newArrayInt;
	    }
	    
	}
}
