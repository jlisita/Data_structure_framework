import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;



public abstract class ArrayStruct extends Structure {

	protected int []array;
	protected int N;

	//create empty structure
	public ArrayStruct()
    {
		this.array=new int[100];
		this.N=0;
	}

	//accessors
	public int[] getArray() {
		return array;
	}

	public void setArray(int[] array) {
		this.array = array;
	}

	public int getN() {
		return N;
	}

	public void setN(int n) {
		N = n;
	}

	// reset instance variables
	public void reInit()
	{
		this.array=new int[100];
		this.N=0;
	}

	// return true if struct is empty
	public boolean isEmpty()
	{
		return N==0;
	}

	// remove the first element with the value i
	public boolean remove(int i)
	{
		for(int j=0;j<N;j++)
		{
			if(array[j]==i)
			{
				for(int k=j;k<N;k++)
					array[k]=array[k+1];
				N--;
				return true;
			}
		}
		return false;
	}

	// remove all element with the value i
	public void removeAll(int i)
		{
			while(contains(i)==true)
				remove(i);
		}

	// return true if the struct contains an element with the value i
	public boolean contains(int i)
	{
		for (int j=0;j<N;j++)
			if(array[j]==i)
				return true;
		return false;
	}

    public Iterator<Integer> iterator() {

		return new myIterator();
	}

	public class myIterator implements Iterator<Integer>
	{
		private int pos=-1;

		public boolean hasNext() {

			return pos<N-1;
		}

		public Integer next() {

			if(pos<N)
				{
				   pos++;
				   return array[pos];
				}
			else{
				throw new NoSuchElementException();
			}
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

	public Iterator<Integer> randomIterator()
	{
		return new RandomIterator();
	}
	public class RandomIterator implements Iterator<Integer>
	{
		Random rd=new Random();
		int i=0;
		int length=N;
		int[]used;
		public RandomIterator()
		{
			used=new int[length];
			for(int j=0;j<length;j++)
				used[j]=j;
		}

		public boolean hasNext() {
			return length>0;
		}

		public Integer next() {
			int k=rd.nextInt(length);
			i=array[used[k]];
			this.remove(k);
			return i;
		}

		public void remove(int k) {
			for(int i=k;i<length-1;i++)
				used[i]=used[i+1];
			length--;

		}

		public void remove() {
			}
	}

	// copy elements of the structure in other
	public void copy(Structure other)
	{
	 	other.reInit();
	 	Iterator it=this.iterator();
	 	while(it.hasNext())
	 		other.add((Integer) it.next());
	}
}
