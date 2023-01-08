package OperatingSystem;

import java.util.LinkedList;

public class Queue {

	private LinkedList<Item> queue = new LinkedList<Item>();

	public void addQueue(Item item) {
		queue.addLast(item);
		
	}

	public Item exitQueue() {
		return queue.remove();
	}
	
	public Item exitQueue(int id) {
		return queue.remove(id);
	}

	public Item Get(int index)
	{
		return queue.get(index);
	}
	
	public boolean isEmptyQueue() {
		return queue.isEmpty();
	}
	
	public int queueSize()
	{
		return queue.size();
	}

}
