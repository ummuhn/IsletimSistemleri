package OperatingSystem;

import OperatingSystem.DispatchList;
import OperatingSystem.Item;
import OperatingSystem.Queue;
import OperatingSystem.Process;

public class UserQueue {
	Queue queue = new Queue();

	void UJ_add(Item item) {
		queue.addQueue(item);
	}
	
	void UJ_Dispatch()
	{
		DispatchList dl = Process.dl;
		
		while(!queue.isEmptyQueue())
		{
			if (queue.Get(0).oncelik == 1) {
				dl.fpl.FPL_add(queue.exitQueue());
			} else if (queue.Get(0).oncelik == 2) {
				dl.spl.SPL_add(queue.exitQueue());
			} else {
				dl.rr.RR_add(queue.exitQueue());
			}
		}
		
	}
}
