import java.util.ArrayList;


public class Sort {
	
	void Swap(int i, int j, int array[]) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	void DisplayArray(int array[]) {
		System.out.print("array : ");
		for(int i=0; i<array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	void merge(int array[], int low, int high) {
		int arr[] = new int[high-low+1], mid = (low+high)/2;
		
		int i = low, j = mid+1, k = 0;
		
		//walk through both halves of the array
		while(i <= mid && j<=high) {
			if(array[i] > array[j])
				arr[k++] = array[j++];
			else
				arr[k++] = array[i++];
		}
		
		while(i<=mid)
			arr[k++] = array[i++];
		
		while(j<=high)
			arr[k++] = array[j++];
		
		for(i=0,j=low; i<arr.length; i++,j++)
			array[j] = arr[i];		
	}
	
	void MergeSort(int array[], int low, int high) {
		if(low >= high)
			return;
		int mid = (low+high)/2;
		MergeSort(array, low, mid);
		MergeSort(array, mid+1, high);
		merge(array, low, high);
		DisplayArray(array);
	}
	
	void BubbleSort(int array[]) {
		int i, j;
		
		for(i=0; i<array.length-1; i++) {
			for(j=i+1; j<array.length; j++ ) {
				if(array[i] > array[j])
					Swap(i, j, array);
			}
			DisplayArray(array);
		}
	}
	
	void InsertionSort(int array[]) {
		int i, j, current;
		
		for(i=0; i<array.length; i++) {
			current = array[i];		
			j=i-1;
			while(j>=0 && array[j] > current){
				array[j+1] = array[j];
				j--;
			}
			if(array[j+1] > current)
				array[j+1] = current;
			
			DisplayArray(array);
		}				
	}

	void SelectionSort(int array[]) {
		int i, j, min;
		
		for(i=0; i<array.length-1; i++) {
			//find minimum
			min = i;			
			for(j=i+1; j<array.length; j++ ) {
				if(array[min] > array[j])
					min = j;
			}
			if(min!=i)
				Swap(min, i, array);
			DisplayArray(array);
		}		
	}
	
	int Partition(int array[], int low, int high) {		
		int i, k=low, pivot = array[low];
		
		//put pivot at the end
		Swap(low, high, array); 
		
		for(i=low; i<high; i++)
			//put lower elements to the left 
			if(array[i] < pivot)
				Swap(k++, i, array);
		
		//get pivot to it's correct position
		Swap(k, high, array);
		return k;
	}
	
	void QuickSort(int array[], int low, int high) {
		
		if(low < high) {
			int m = Partition(array, low, high);
			QuickSort(array, low, m);
			QuickSort(array, m+1, high);
			DisplayArray(array);
		}		
	}
	
	int FindDigits(int number) {
		int digits = 0;
		while(number>0) {
			number /= 10;
			digits++;
		}
		return digits;
	}
	
	void RadixSort(int array[]) {
		int digits, i, j, k, ind, max = 0;
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();
		
		//find number of max digits
		for(i=0; i<array.length; i++) {
			digits = FindDigits(array[i]);
			max = max<digits? digits:max ;
		}
		digits = max;
		
		System.out.println("digits = "+digits);
		int div = 1;

		//initialize buckets
		for(i=0; i<10; i++) {
			ArrayList<Integer> bucket = new ArrayList<Integer>();
			buckets.add(bucket);
		}
		
		for(i=0; i<digits; i++) {
			//clear buckets for each pass 
			for(j=0; j<10; j++) {			
				buckets.get(j).clear();
			}

			//add elements to correct bucket
			for(j=0; j<array.length; j++) 
				buckets.get((array[j]/(div))%10).add(array[j]);
			
			//sort array
			ind = 0;
			for(j=0; j<buckets.size(); j++) {
				for(k=0; k<buckets.get(j).size(); k++)
					array[ind++] = buckets.get(j).get(k);
			}			
			div = div*10;
			DisplayArray(array);
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int arr[] = {101,45,7,2, 44, 8, 5, 11};		
		Sort sort = new Sort();
		sort.BubbleSort(arr);
		//sort.MergeSort(arr, 0, arr.length-1);
		//sort.InsertionSort(arr);
		//sort.SelectionSort(arr);
		//sort.QuickSort(arr, 0, arr.length-1);
		//sort.RadixSort(arr);
	}
}

