
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MultiSet extends ArrayStruct {


	// add element
	public void add(int i)
	{
		this.array[N]=i;
		N++;
	}

	//add to the structure elements of other
	public void union(Structure other)
	{
		for(int i=0;i<((MultiSet) other).getN();i++)
			this.add(((MultiSet) other).getArray()[i]);
	}

    //remove from the structure elements not contained in other
	public void inter(Structure other)
	{
 		MultiSet temp=new MultiSet();
		for(int i=0;i<((MultiSet) other).getN();i++)
		   temp.add(((MultiSet) other).getArray()[i]);
		Iterator it=this.iterator();
		while (it.hasNext()){
			int i=(Integer) it.next();
			if(temp.contains(i)==false)
			{
				this.remove(i);
			}
			else
			{
				temp.remove(i);
			}
		}
	}

	//return s1 union s2
	public Structure union(Structure s1,Structure s2)
	{
		MultiSet s3=new MultiSet();
		for (int i=0;i<((MultiSet) s1).getN();i++)
			s3.add(((MultiSet) s1).getArray()[i]);
		for(int i=0;i<((MultiSet) s2).getN();i++)
			s3.add(((MultiSet) s2).getArray()[i]);
		return s3;
	}

	//return s1 inter s2
	public Structure inter(Structure s1 ,Structure s2)
	{
		MultiSet s3=new MultiSet();
		MultiSet temp=new MultiSet();
		for(int i=0;i<((MultiSet) s2).getN();i++)
			temp.add(((MultiSet) s2).getArray()[i]);
		for(int i=0;i<temp.N;i++)
			if(temp.contains(((MultiSet) s1).getArray()[i])==true)
			{
				s3.add(((MultiSet) s1).getArray()[i]);
				temp.remove(temp.array[i]);
			}
		return s3;
	}

	// remove all duplicates
	public Set toSet()
	{
		Set e=new Set();
		Iterator it=this.iterator();
		int i=0;
		while(it.hasNext())
		{
			i=((Integer) it.next());
			if(e.contains(i)==false){
				e.add(i);
			}
		}
		return e;

	}

	public String toString()
	{
		Iterator it=this.randomIterator();
		String str=new String();
		str+="MultiSet: ";
		while(it.hasNext()){
			str+=it.next()+",";
		}
		return str;
	}
}
