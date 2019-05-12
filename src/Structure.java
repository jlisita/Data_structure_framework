import java.util.Iterator;


public abstract class Structure {


	public abstract void add(int i);

	public abstract boolean isEmpty();

	public abstract boolean remove(int i);

	public abstract void removeAll(int i);

	public abstract void reInit();

	public abstract Iterator iterator();

	public abstract void copy(Structure other);

	public abstract boolean contains(int i);

	public abstract void union(Structure other);

	public abstract void inter(Structure other);

	public abstract Structure  union (Structure e1,Structure e2);

	public abstract Structure inter(Structure e1,Structure e2);
}
