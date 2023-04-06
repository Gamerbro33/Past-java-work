
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object o = new Object();
		
		LinkedBST<Integer> bst = new LinkedBST<Integer>();
		//int[] a = {8,2,12,1,4,10,16};
		int[] a = {500, 2000, 1500, 250, 350, 150, 2500};
		for(int i : a)
			bst.add(i);
		
		bst.printPreorder();
		System.out.println();
		bst.printInorder();
		
		LinkedBST<SomeObject> oBst = new LinkedBST<SomeObject>();
		bst.remove(8);
		bst.printPreorder();
	}

}
