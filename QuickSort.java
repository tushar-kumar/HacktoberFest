package recursion;

public class QuickSort {
	
	public static void quickSort(int[] input, int sI, int eI) {
		
		if(sI >= eI) {
			return;
		}
		
		int pivotPos = partition(input, sI, eI);
		quickSort(input, sI, pivotPos - 1);
		quickSort(input, pivotPos+1, eI);
	}
	
	private static int partition(int[] input, int sI, int eI) {
		
		int pivot = input[sI];
		int count = 0;
		
		int i = sI;
		int j = eI;
		
		for(int index = sI; index <= eI; index++) {
			if(input[index] < pivot) {
				count++;
			}
		}
		
		int pivotPos = sI + count;
		int temp = input[sI + count];
		input[sI + count] = input[sI];
		input[sI] = temp;
		
		while(i < pivotPos && j > pivotPos) {
			if(input[i] <= pivot) {
				i++;
			}else if( input[j] > pivot) {
				j--;
			}else {
				int temp1 = input[i];
				input[i] = input[j];
				input[j] = temp1;
				i++;
				j--;
			}
		}
		return pivotPos;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {6,2,20,8,15,3,4};
		quickSort(arr,0,arr.length-1);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+" ");
		}

	}

}
