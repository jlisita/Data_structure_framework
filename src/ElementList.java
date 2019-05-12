
public class ElementList{

	// Element of a linked list

		private int value;           // value contained by the Element
		private ElementList next;   // reference of the next Element of the list

		public ElementList(int value)
		{
			this.value=value;
			this.next=null;
		}

		public String toString()
		{
			return this.value+"";
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public ElementList getNext() {
			return next;
		}

		public void setNext(ElementList next) {
			this.next = next;
		}

}
