public class ArrayList<E> implements List<E>
{
	/* Here would be all the stuff that the list implements anyway, like */
	private int size = 0;
	//or
	private E[] data;

	//This is the alternateIterator
	private class AlternateIterator implements Iterator<E>
	{
		private int index = 0; //index of the next element to report
					//this number will only be "even"-ly assigned within the Iterator
		private boolean removable = false;
		
		public boolean hasNext() { return index < size; }
		
		public E next() throws NoSuchElementException
		{
			if(index >= size) throw new NoSuchElementException("No");
			
			index += 2; //make it ready for the next call
			removeable = true;
			return data[index-2]; //but return the previous element
				//this way we dont have to create a local variable
		}
		
		public void remove() throws IllegalStateException
		{
			if(!removable) throw new IllegalStateException("no");
			
			/* The Exercise-Description was not clear enough to me:
			*  when removing an item, do we still want to return elements having an even index
			*  or would we want to iterate over the even elements, the way they have been positioned
			*  when creating the iterator
			*
			*  so basically, decide, whether you keep iterating on even positions, or on the odd positions
			*/
			
			index -= 2;
			this.base.remove(index) //we remove the most recently returned element from the list
										//this = iterator, base = list
										
			//but now you gotta decide: do we still want to return the elements with even index
			//whereas the elements with index > this.index are shifted by one cell, making all odd positions
			//even now.
			//or do we want to keep calling the elements, which had a even number before the remove
			
			//comment this out, if you want to return odd elements
			index++;
			removable = false;
		}
		
		//The same way it works for all the other methods:
		/*
		* before, returns index-2
		* after, returns index +2
		* size, returns number of elements in list /2 (down-runden)
		*
		* Update-Methods imo will not work, without screwing up the whole positional-system. Elements
		* have to be repositioned by a specific order, in which the user has no clue what modifications are actually done.
		*/
	}
}