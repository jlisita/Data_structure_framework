import java.util.Iterator;


public class Set extends ArrayStruct{

	// add an element in the list if it doesn't already exist
	public void add(int i)
	{
		if(contains(i)==false)
		{
			this.array[N]=i;
			N++;
		}
		else
			System.out.println( i+ " already exist int the list");
	}

	//add to the structure elements of other
	public void union(Structure other)
	{
		for(int i=0;i<((Set) other).getN();i++)
			this.add(((Set) other).getArray()[i]);
	}

	// remove from the structure the elements not contained in other
	public void inter(Structure other)
	{
		Iterator it=this.iterator();
		while (it.hasNext())
		{
			int i=(Integer) it.next();
			if(other.contains(i)==false)
				this.remove(i);
		}
	}

  	//return the union of e1 and e2
	public Structure union(Structure e1,Structure e2)
	  {
		Set e3=new Set();
		for (int i=0;i<((ArrayStruct) e1).getN();i++)
			e3.add(((ArrayStruct) e1).getArray()[i]);
		for(int i=0;i<((ArrayStruct) e2).getN();i++)
			e3.add(((ArrayStruct) e2).getArray()[i]);
		return e3;
	 }

	//return the union of e1 and e2
	public Structure inter(Structure e1,Structure e2)
	{
		Set e3=new Set();
		for(int i=0;i<((Set) e1).getN();i++)
			if(e2.contains(((Set) e1).getArray()[i]))
				e3.add(((Set) e1).getArray()[i]);
		return e3;
	}

	public MultiSet toMultiSet()
	{
		MultiSet m=new MultiSet();
		Iterator it = this.iterator();
		while(it.hasNext())
		{
			m.add((Integer)it.next());
		}
		return m;
	}

	public String toString()
	{
		Iterator it=this.randomIterator();
		String str=new String();
		str+="Set: ";
		while(it.hasNext())
		{
			str+=it.next()+",";
		}
		return str;
	}
}

