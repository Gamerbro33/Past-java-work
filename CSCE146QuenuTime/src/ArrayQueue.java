
public class ArrayQueue<T> implements QuenuI<T>
{
	private T[] queue;
	public static final int DEF_SIZE = 100;
	private int lastIndex;
	private int headIndex;
	public ArrayQueue()
	{
		init(DEF_SIZE);
	}
	public ArrayQueue(int size)
	{
		init(size);
	}
	private void init(int size)
	{
		if(size>= 1)
			queue = (T[])(new Object[size]);
		else
			queue = (T[])(new Object[size]);
		this.lastIndex = this.headIndex = 0;
	}
	public void enqueue(T aData)
	{
		if(queue[queue.length] != null && headIndex == lastIndex)
			return;
		queue[lastIndex] = aData;
		lastIndex = (lastIndex+1)%queue.length;
	}
	public T dequeue()
	{
		T ret = queue[headIndex];
		headIndex++;
		return ret;
	}
	public T peek()
	{
		return queue[headIndex];
	}
	public void print()
	{
		System.out.println(queue[headIndex]);
		for(int i=(headIndex+1)%queue.length; i!=lastIndex; i = (i+1)%queue.length)
		{
			System.out.println(queue[i]);
		}
	}
	@Override
	public void enQuenue(T aData) {
		// TODO Auto-generated method stub
		
	}
}
