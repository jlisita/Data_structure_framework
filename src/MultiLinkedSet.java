
import java.util.Iterator;


public class MultiLinkedSet extends LinkedStruct {

	// add an element to the end of the list
	public void add(int i)
	{
		ElementList el=new ElementList(i);
		if(first==null){
			this.first=last=el;
			el.setNext(null);
		}
		else{
		last.setNext(el);
		last=el;
		}
	}

	// add to the structure the elements of other
	public void union(Structure other)
	{
		this.last.setNext(((MultiLinkedSet) other).getFirst());
		this.last=((MultiLinkedSet) other).getLast();
	}

	// remove from the structure elements not contained in other
	public void inter(Structure other)
	{
		if(this.isEmpty() || other.isEmpty())
			this.reInit();
		else
		{
			MultiLinkedSet temp=new MultiLinkedSet();
			Iterator it=((LinkedStruct) other).iterator();
			while(it.hasNext())
				temp.add( ((ElementList) it.next()).getValue());

			Iterator it2=this.iterator();
			while(it2.hasNext())
			{
				ElementList i=(ElementList) it2.next();
				if(temp.contains(i.getValue())==false)
					this.remove(i.getValue());
				else
					temp.remove(i.getValue());

			}
		}
	}

	// return S1 union S2
	public Structure union(Structure s1,Structure s2)
	{
		MultiLinkedSet s3=new MultiLinkedSet();
		Iterator it=((LinkedStruct) s1).iterator();
		while(it.hasNext())
			s3.add(((ElementList) it.next()).getValue());
		Iterator it2=((LinkedStruct) s2).iterator();
		while(it2.hasNext())
			s3.add(((ElementList) it2.next()).getValue());
		return s3;
	}

	// return S1 inter S2
	public Structure inter(Structure s1,Structure s2)
	{
		MultiLinkedSet s3=new MultiLinkedSet();
		if(s1.isEmpty() || s2.isEmpty())
			return s3;
		MultiLinkedSet temp=new MultiLinkedSet();
		Iterator it=((MultiLinkedSet) s2).iterator();
		while(it.hasNext())
			temp.add( ((ElementList) it.next()).getValue());

		Iterator it1=((MultiLinkedSet) s1).iterator();
		while(it1.hasNext())
			s3.add( ((ElementList) it1.next()).getValue());

		Iterator it2=s3.iterator();
		while(it2.hasNext())
		{
			ElementList i=(ElementList) it2.next();
			if(temp.contains(i.getValue())==false)
				s3.remove(i.getValue());
			else
			{
				temp.remove(i.getValue());
			}
		}
		return s3;
	}

	public String toString()
	{
		String str=new String();
		Iterator<ElementList> it=this.randomIterator();
		str+="MultiLinkedEns: ";
		while(it.hasNext())
			str+=it.next()+",";
		return str;
	}
}
