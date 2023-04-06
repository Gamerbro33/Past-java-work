
public class TacosDB 
{
	private Taco[] tacos;
	
	public static final int TACOS_SIZE = 10;
	
	public TacosDB()
	{
		tacos = new Taco[TACOS_SIZE];
		
	}
	
	//parameterized constructor
	public TacosDB(int size)
	{
		if(size >0)
		{
			tacos = new Taco[size];
		}
	}
	
	public Taco[] getTacos()
	{
		return this.tacos;
	}
	
	public void addTaco(String xName, double xPrice)
	{
		for(int i=0; i<tacos.length; i++)
		{
			if(tacos[i] == null)
			{
				tacos[i] = new Taco(xName, xPrice);
				break;
				
			}
			else if((i+1 == tacos.length))
			{
				System.out.println("Cannot add tacos, array is full!");
			}
					
		}
	}
	
	public void removeTaco(Taco t)
	{
		for(int i = 0; i < tacos.length; i++)
		{
			if(tacos[i] != null && tacos[i].equals(t))
			{
				tacos[i] = null;
				break;
			}
			else if((i+i) == tacos.length)
			{
				System.out.println("Cannot find taco!");
			}
		}
	}
	
	public boolean equals(TacosDB tdb)
	{
		for(int i = 0; i<tacos.length; i++)
		{
			if((tacos[i] == null && tdb.getTacos()[i] != null) || (tacos[i].equals(tdb.getTacos()[i])) == false)
			{
				return false;
			}
			else
			{
				return true;
			}
		}
		return true;
	}
	
	public String toString()
	{
		String result = "";
		
		for(int i = 0; i < tacos.length; i++)
		{
			if(tacos[i] != null)
			{
				result += tacos[i].toString();
				
			}
		}
		return result;
	}
}
