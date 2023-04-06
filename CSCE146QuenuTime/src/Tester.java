
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuenuI<Integer> qI;
		//qI = new QuenueI<Interger>;
		qI =new ArrayQueue<Integer>();
		for(int i=0;i<5;i++)
			qI.enQuenue(i);
		qI.print();
		System.out.println();
		for(int i=0; i<5;i++)
			System.out.println(qI.dequeue());
		
	}

}
