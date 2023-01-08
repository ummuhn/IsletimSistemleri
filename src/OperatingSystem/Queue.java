package OperatingSystem;

import java.util.LinkedList;

public class Queue {

	private LinkedList<ProcessItem> queue = new LinkedList<ProcessItem>();

	public void addQueue(ProcessItem item) {
		queue.addLast(item);
		
	}

	public ProcessItem exitQueue() {
		return queue.remove();
	}
	
	public ProcessItem exitQueue(int id) {
		return queue.remove(id);
	}

	public ProcessItem Get(int index)
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
