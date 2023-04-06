
public class SomeObject implements Comparable<SomeObject>{
	public double someValue;
	
	public int compareTo(SomeObject o)
	{
		if(this.someValue > o.someValue)
			return 1;
		else if(this.someValue < o.someValue)
			return -1;
		else
			return 0;
		
	}
}
