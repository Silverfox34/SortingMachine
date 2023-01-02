package main;







public class Tree {

	

	

	static Node ROOT;

	Node current;

	Node parent;

	static int size = 0;

	static int index;

	static int[] array;

	

	
	
	
	public static void TestMe() {
		int size = (int)Math.pow(2,5);
		int[] a = new int[size];
		for(int i=0; i<size; i++) {
			a[i] = (int)(Math.random()*1000);
		}

		SortingMachine machine = new SortingMachine();
		machine.printArray(a);

		Tree tree = new Tree(a);
		int[] my_sorted_array = tree.sortArrayByTree(tree);
	
		machine.printArray(my_sorted_array);
	}

	

	public int[] sortArrayByTree(Tree tree) {

		Tree.array = new int[size];

		Tree.index = size-1;

		tree = SetMinimumRoot(Tree.ROOT, tree);
		
		Tree.searchAndSort(Tree.ROOT, "root");

		return Tree.array;

	}

	

	private Tree SetMinimumRoot(Node current, Tree tree) {

		

		if(current.left_child != null) {

			SetMinimumRoot(current.left_child, tree);

		}else if(current.left_child == null) {

			if(current.right_child == null) {

				addRecursive(Tree.ROOT, Tree.ROOT.value);

				Tree.ROOT.value = current.value;

				current.parent.left_child = null;

				current = null;

	

				

				//.out.println("Root: "+ Integer.toString(Tree.ROOT.value));

			}else if(current.right_child != null) {
				
				if(Tree.ROOT.value != current.value) {
					addRecursive(Tree.ROOT, Tree.ROOT.value);

					Tree.ROOT.value = current.value;

					
					current.parent.left_child = current.right_child;
					
					current.right_child.parent = current.parent;


					current = null;
				}



				//System.out.println("Root: "+ Integer.toString(Tree.ROOT.value));

			}

		}

		

		//System.out.println("ROOT: "+Integer.toString(Tree.ROOT.value));

		

		return tree;

	}



	//String childStatus

	public static void searchAndSort(Node current, String childStatus) {

		

		if(index<0) return;
		if(Tree.ROOT == null) {
			System.out.println("null");
			return;
		}

		if (current.right_child != null) {

			searchAndSort(current.right_child, "right");

			
		//LEAF
		}else if(current.right_child == null && current.left_child == null) {
			
			if(childStatus.equals("right")) {

				
				array[index] = current.value;
				index--;

				current.parent.right_child = null;
				current = null;

				searchAndSort(Tree.ROOT, "root");

			}else if(childStatus.equals("root")) {

				
				array[index] = current.value;
				index--;

				Tree.ROOT = null;

				searchAndSort(Tree.ROOT, "root");

			}else if(childStatus.equals("left")) {

				
				array[index] = current.value;
				index--;
				
				current.parent.left_child = null;
				current = null;

				searchAndSort(Tree.ROOT, "root");

			}

		//There are still left children
		}else if(current.right_child == null && current.left_child != null) {

			if(childStatus == "right") {

						
				array[index] = current.value;
				index--;
				
				current.left_child.parent = current.parent;
				current.parent.right_child = current.left_child;
				current = null;
				
				searchAndSort(Tree.ROOT, "root");
				

			}else if(childStatus.equals("root")) {

				searchAndSort(current.left_child, "left");

			}else if(childStatus.equals("left")) {

				array[index] = current.value;
				index--;
												
				Node temp_left_child = current.left_child;
				current.left_child.parent = current.parent;
				current.parent.left_child = temp_left_child;
				current = null;
	
				searchAndSort(Tree.ROOT, "root");

			}
		}
	}

	
	
	
	
	public Tree() {
		
	}
	
	
	
	

	public Tree(int[] array) {

		Tree.ROOT = new Node(array[0]);

		size++;

		for(int i=1; i<array.length; i++) {

			addRecursive(Tree.ROOT, array[i]);

		}

	}

	

	private Node addRecursive(Node current, int value) {

		if(current != null) {

			if(value < current.value) {

				//System.out.print("left ");

				

				if(current.left_child != null) {

					current.left_child = addRecursive(current.left_child, value);

					current.left_child.parent = current;

				}else if(current.left_child == null) {

					current.left_child = addRecursive(current.left_child, value);

					current.left_child.parent = current;

				}

				

		

			}else if(value >= current.value) {

				//System.out.print("right ");

				

				if(current.right_child != null) {

					current.right_child = addRecursive(current.right_child, value);

					current.right_child.parent = current;

				}else if(current.right_child == null) {

					current.right_child = addRecursive(current.right_child, value);

					current.right_child.parent = current;

				}

				



			}

		}else if(current == null) {

			size++;

			//System.out.println("added: "+Integer.toString(value));

			return new Node(value);

		}

		

		return current;

	}

}