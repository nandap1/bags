public class LinkedBag <T> implements BagInterface<T> 

{
	private Node firstNode; // Reference to first node of chain
	private int numberOfEntries;

	//default constructor
	public LinkedBag()
	{
		firstNode = null;
		numberOfEntries = 0;
	} 
	// end default constructor

	// Implement the unimplemented methods 
	// Locates a given entry within this bag.
	// Returns a reference to the node containing the entry, if located,
	// or null otherwise.
	private Node getReferenceTo(T anEntry)
	{
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while

		return currentNode;
	} // end getReferenceTo



	private class Node
	{
		private T data; //Entry in bag
		private Node next; //Link to next Node
		public Node(T dataPortion)
		{
			this(dataPortion, null);
		}

		public Node(T dataPortion,
				Node nextNode)
		{
			data = dataPortion;
			next = nextNode;
		}
	}

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return numberOfEntries;
	}

	@Override
	public boolean isEmpty() 
	{
		return numberOfEntries == 0;
	}

	@Override
	public boolean add(T newEntry) {
		Node newNode = new Node(newEntry);
		newNode.next = firstNode;
		firstNode = newNode;
		numberOfEntries++;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T remove() {
		T result = null;
		if (firstNode != null)
		{
			result = firstNode.data;
			firstNode = firstNode.next;
			numberOfEntries--;
		}
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		}
		// TODO Auto-generated method stub
		return found;
	}

	@Override
	public void clear() {
		while (!isEmpty())
		{
			remove();
		}
		// TODO Auto-generated method stub

	}



	@Override
	public int getFrequencyOf(T anEntry) {
		int frequency = 0;
		int loopCounter = 0;
		Node currentNode = firstNode;
		while ((loopCounter < numberOfEntries) && currentNode != null)
{
	if (anEntry.equals(currentNode.data))
		frequency++;
	loopCounter++;
	currentNode = currentNode.next;
}
// TODO Auto-generated method stub
return frequency;
	}



	@Override
	public boolean contains(T anEntry) {
		boolean found = false;
		Node currentNode = firstNode;
		while (!found && (currentNode != null))
		{
			if (anEntry.equals(currentNode.data))
				found = true;
			else 
				currentNode = currentNode.next;
		}
		// TODO Auto-generated method stub
		return found;
	}

	@Override
	public T[] toArray() {
		@SuppressWarnings("unchecked")
		T[] result = (T[])new Object[numberOfEntries];

		int index = 0;
		Node currentNode = firstNode;
		while ((index < numberOfEntries) && (currentNode != null))
		{
			result[index] = currentNode.data;
			index++;
			currentNode = currentNode.next;
		}
		// TODO Auto-generated method stub
		return result;
	}// end Node
}

