
public class ShapesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//polymorphism - OOP Principle
		ShapeBasics[] shapes = new ShapeBasics[3];
		
		shapes[0] = new Rectangle(0, 5, 15);
		shapes[1] = new HTriangle(2, 7);
		shapes[2] = new HTriangle(10, 19);
		
		for(int i = 0; i < shapes.length; i++)
		{
			shapes[i].drawAt(i);
		}
		
		
	//	Rectangle r = new Rectangle(2, 3, 15);
		
	}

}
