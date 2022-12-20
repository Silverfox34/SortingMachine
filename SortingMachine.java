package main;

import java.util.ArrayList;
import java.util.List;

public class SortingMachine {

	public static void main(String[] args) {
		
		
		
		
		
		
		/*
		int array_size = (int)Math.round(Math.pow(2,17));
		SortingMachine machine = new SortingMachine();		
		List<Integer> list = new ArrayList<>(array_size);
		int[] array = new int[array_size];
			
		for(int i=0; i<array_size; i++) {
			list.add((int)Math.round(Math.random()*100));
			array[i] = (int)Math.round(Math.random()*100);
		}
		
		long startTime = System.currentTimeMillis();
		List<Integer> sortedlist = machine.BubbleSort(list);
		long endTime = System.currentTimeMillis();
		long millis = endTime-startTime;
		System.out.println(millis);
		
		startTime = System.currentTimeMillis();
		int[] sorted_array = machine.BubbleSort(array);
		endTime = System.currentTimeMillis();
		millis = endTime-startTime;
		System.out.println(millis);
		*/
	}
	
	protected void printList(List<Integer> inputList) {
	
		try {
			for(int element : inputList) {
				System.out.print(String.valueOf(element)+" ");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

	protected List<Integer> BubbleSort(List<Integer> inputList) {
		try {
			int length = inputList.size();
			int temp;
			boolean changed = true;
			while (true){
				
				if(changed == true) {
					changed = false;
				}else if(changed == false) {
					break;
				}
				
				for(int i=0; i<length-1; i++) {
					if(inputList.get(i)<=inputList.get(i+1)) {
						//very good !
					}else if(inputList.get(i)>inputList.get(i+1)) {
						temp = inputList.get(i);
						inputList.set(i, inputList.get(i+1));
						inputList.set(i+1, temp);
						changed = true;
					}
				}	
				
			}
			
			return inputList;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}

		

	}

	protected int[] BubbleSort(int[] inputArray) {
		
		try {
			int length = inputArray.length;
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
}
