public class MaxSubArray {
	public static void main(String args[] ){
		program();
	}
	public static void program(){
		Scanner in = new Scanner(System.in);
		int n =in.nextInt();
		for(int i = 0; i < n; i++){
			ArrayList<Integer> numList = new ArrayList<Integer>();
			int len = in.nextInt();
			for (int j = 0; j < len; j++){
				int num = in.nextInt();
				numList.add(num);
			}
			getSums(numList.toArray(new Integer [numList.size()]));
		}
	}
	public static void getSums(Integer [] numList){
		
		Integer Max = Integer.MIN_VALUE;
		for(int i = 0; i < numList.length; i++){
			if (numList[i]>Max){
				Max = numList[i];
			}
		}
		
		Integer sum1 = getSumContig(numList);
		Integer sum2 = getSumNonContig(numList);
		
		if(sum2 == 0){
			sum2 = Math.min(Max, sum2);
		}
		
		System.out.println(sum1+ " "+ sum2);
	}
	public static Integer getSumContig(Integer [] numList){
		Integer [] sumMatrix = new Integer [numList.length] ;
		Integer maxSum = Integer.MIN_VALUE;
		for(int i=0; i < numList.length; i++){
			Integer curSum;
			if(i != 0){
				curSum = Math.max(sumMatrix[i-1] + numList[i], numList[i]);
			}else{
				curSum = numList[i];
			}
			sumMatrix[i] = curSum;
			if(curSum > maxSum){
				maxSum = curSum;
			}
		}
		return maxSum; 
	}
	public static Integer getSumNonContig(Integer [] numList){
		Integer total = 0;
		for(int i = 0; i < numList.length; i++){
			if (numList[i]>0){
				total += numList[i];
			}
		}
		return total; 
	}
	
}