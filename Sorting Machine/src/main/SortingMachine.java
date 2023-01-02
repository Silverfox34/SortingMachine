package main;


import java.util.ArrayList;
import java.util.List;

public class SortingMachine {

	public static void main(String[] args) {
		
		
		//Prework, creating array etc.
		/*
		int k = (int)Math.pow(2, 5);
		int[] array = new int[k];
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<k; i++) {
			array[i] = (int)(Math.random()*10000);
			list.add((int)(Math.random()*100));
		}*/
		
		//FOR ARRAYS
		//SortingMachine machine = new SortingMachine();
		//machine.Sort(array);
		
		
		
		//FOR LISTS
		/*
		List<Integer> sorted_list;
		
		SortingMachine machine = new SortingMachine();
		
		
		sorted_list = machine.Sort(list);
		
		machine.printList(sorted_list);
		System.out.println("Finished");
		*/
	}

	
	
	
	public void Sort(int[] array) {
		
		//TreeSort is NOT implemented here !
		//You can do this by changing the code by looking at the tree-class
		//to create an instance of a tree
		//
		//Here is an example on how to use it:
		/*
		 * 
		Tree tree = new Tree(a);
		int[] my_sorted_array = tree.sortArrayByTree(tree);
	
		machine.printArray(my_sorted_array);
		 * 
		 */
		
		//Of course you have to comment the other sorting 
		//algorithms below out
		//If you just want to see that TreeSort works, use this:
		//Tree my_tree = new Tree();
		//Tree.TestMe();
		
		
		try {
			this.QuickSort(array, 0, array.length-1);
		}catch(Error e) {
			this.BubbleSort(array);
		}
		
	}

	
	
	
	
	public List<Integer> Sort(List<Integer> inputList) {
		

		try {
			return this.QuickSort(inputList);
		}catch(Error e) {
			return this.BubbleSort(inputList);
		}
		
		
	}

	public void printArray(int array[]) {
		try {
			for(int i=0; i<array.length; i++) {
				System.out.print(String.valueOf(array[i])+" ");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("\n");
	}

	public void printList(List<Integer> inputList) {

		try {
			for(int element : inputList) {
				System.out.print(String.valueOf(element)+" ");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	private List<Integer> QuickSort(List<Integer> inputList){
		int[] array = new int[inputList.size()];
		List<Integer> sorted_list = new ArrayList<Integer>();
		for(int i=0; i<inputList.size(); i++) {
			array[i] = inputList.get(i);
		}
		QuickSort(array, 0, inputList.size()-1);
		for(int i=0; i<inputList.size(); i++) {
			sorted_list.add(array[i]);
		}
		
		return sorted_list;
	}

    private void QuickSort(int[] a, int si, int ei){

    //base case
    if(ei<=si || si>=ei){}

    else{ 
        int pivot = a[si]; 
        int i = si+1; int tmp; 

        //partition array 
        for(int j = si+1; j<= ei; j++){
            if(pivot > a[j]){
                tmp = a[j]; 
                a[j] = a[i]; 
                a[i] = tmp; 

                i++; 
            }
        }

        //put pivot in right position
        a[si] = a[i-1]; 
        a[i-1] = pivot; 

        //call QuickSort on right and left sides of pivot
        QuickSort(a, si, i-2); 
        QuickSort(a, i, ei); 
    }
}
	
	

	private List<Integer> BubbleSort(List<Integer> inputList) {
		int[] array = new int[inputList.size()];
		List<Integer> sorted_list = new ArrayList<>();
		int index = 0;
		for(int element: inputList) {
			array[index] = element;
			index++;
		}

		array = this.BubbleSort(array);

		for(int i=0; i<array.length; i++) {
			sorted_list.add(array[i]);
		}


		return sorted_list;



	}

	private int[] BubbleSort(int[] inputArray) {

		try {
			int length = inputArray.length;

			if(length<=1) {
				return null;
			}



			int temp;
			boolean changed = true;
			while (true){

				if(changed == true) {
					changed = false;
				}else if(changed == false) {
					break;
				}

				for(int i=0; i<length-1; i++) {
					if(inputArray[i]<=inputArray[i+1]) {
						//very good !
					}else if(inputArray[i]>inputArray[i+1]) {
						temp = inputArray[i];
						inputArray[i] = inputArray[i+1];
						inputArray[i+1] = temp;
						changed = true;
					}
				}	

			}

			return inputArray;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}


	}
	
	
	

	public boolean checkIfSorted(int[] array) {
		for(int i=1; i<array.length; i++) {
			if(!(array[i-1] <= array[i])) {
				System.out.println("oops a mistake happened");
				return false;
			}
		}
		
		return true;
		
	}
	
}