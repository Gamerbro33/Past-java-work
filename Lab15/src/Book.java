//RJ Allen
public class Book 
{
	//instance variable
	private String title;
	private String author;
	private String publisher;
	private int numCopiesSold;
	private int yearOfRelease;
	
	public Book()
	{
		this.title = "Title unknown";
		this.author = "unknown";
		this.publisher = "unknown";
		this.numCopiesSold = 0;
		this.yearOfRelease = 2021;
	}
	
	//getters/Accessors
	public String getTitle()
	{
		return this.title;
	}
	
	public String getAuthor()
	{
		return this.author;
	}
	
	public String getPublisher()
	{
		return this.publisher;
	}
	
	public int getCopies()
	{
		return this.numCopiesSold;
	}
	
	public int getYear()
	{
		return this.yearOfRelease;
	}
	
	//setters/mutators
	public void setTitle(String xTitle)
	{
		this.title = xTitle;
	}
	public void setAuthor(String xAuthor)
	{
		this.author = xAuthor;
	}
	public void setPublisher(String xPublish)
	{
		this.publisher = xPublish;
	}
	public void setCopies(int xCopies)
	{
		//if the value is negative
		if(xCopies >= 0)
		{
			this.numCopiesSold = xCopies;
		}
		else
		{
			System.out.println("Invalid input of copies setting to default value");
			this.numCopiesSold = 0;
		}
	}
	public void setYear(int xYear)
	{
		//if user input years that are not between 1950-2021
		if(xYear >=1950 || xYear <=2021)
		{
			this.yearOfRelease = xYear;
		}
		else
		{
			System.out.println("Invalid input of release year setting to default value");
			this.yearOfRelease = 2021;
		}
	}
	public String toString()
	{
		return "Book Title:"+this.title
				+"\nAuthor:"+this.author
				+"\nPublisher:"+this.publisher
				+"\nNumber of Copies"+this.numCopiesSold
				+"\nYear of Release"+this.yearOfRelease;
	}
	
	public boolean equals(Book b)
	{
		return /*b != null*/ this.title.equalsIgnoreCase(b.getTitle()) 
				&& this.author.equalsIgnoreCase(b.getAuthor())
				&& this.publisher.equalsIgnoreCase(b.getPublisher())
				&& this.numCopiesSold == b.getCopies()
				&& this.yearOfRelease == b.getYear();
	}
}
