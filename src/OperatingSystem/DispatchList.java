package OperatingSystem;

import java.util.LinkedList;
import java.util.Random;

public class DispatchList {
	LinkedList<Item> dispatchList;

	UserQueue uq = new UserQueue();

	RealTimeQueue rtq = new RealTimeQueue();
	FirstPriList fpl = new FirstPriList();
	SecondPriList spl = fpl.spl;
	RoundRobinList rr = spl.rr;

	int damn_timer = 0;

	

	public void General_Dispatcher() {
		int size = dispatchList.size();

		int used_items_count = 0;

		while (used_items_count != size || !fpl.FPL_isEmpty() || !spl.SPL_isEmpty() || !rr.RR_isEmpty()) { // tüm
																											// boşaldığında
																											// duracak
			for (int i = 0; i < size; i++) {
				if (dispatchList.size() == 0)
					break;

				if (dispatchList.get(0).varis > damn_timer) {
					break;
				} else if (dispatchList.get(0).oncelik == 0) {
					rtq.FCFS_add(dispatchList.remove());
					used_items_count++;
				} else {
					if (dispatchList.get(0).oncelik != 0) {
						uq.UJ_add(dispatchList.remove());
						used_items_count++;
					}
				}
			}

			if (!(uq.queue.isEmptyQueue()))
				uq.UJ_Dispatch();

			Executer(); 
		}
	}


	public void AddList(Item item) {
		dispatchList.add(item);
	}
	
	void Executer() {
		if (!(rtq.FCFS_isEmpty())) { 
			int rtq_ExecTime = rtq.FCFS_execute(damn_timer);
			damn_timer += rtq_ExecTime;
		} else if (!(fpl.FPL_isEmpty())) {
			int fpl_ExecTime = fpl.FPL_execute(damn_timer);
			damn_timer += fpl_ExecTime;
		} else if (!(spl.SPL_isEmpty())) {
			int spl_ExecTime = spl.SPL_execute(damn_timer);
			damn_timer += spl_ExecTime;
		} else if (!(rr.RR_isEmpty())) {
			int rr_ExecTime = rr.RR_execute(damn_timer);
			damn_timer += rr_ExecTime;
		} else
			damn_timer++;
	}
	public DispatchList() {
		dispatchList = new LinkedList<Item>();
	}

	public void TimeOut_Scanner(int gecenZaman) { 

		String text = "";

		for (int i = 0; i < rtq.queue.queueSize(); i++) {
			Item item = rtq.queue.Get(i);

			if (gecenZaman - item.askiyaAlinma >= 20)
			{
				Random rng = new Random();

				int r = rng.nextInt(256);
				int g = rng.nextInt(256);
				int b = rng.nextInt(256);

				text = String.format(
						"\033[38;2;%d;%d;%dm%d sn proses zamanasimi      (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
						r, g, b, gecenZaman, item.id, item.oncelik, item.burstTime);

				System.out.println(text);

				rtq.queue.exitQueue(i);
				i--; 
			}
		}
		
		for (int i = 0; i < fpl.queue.queueSize(); i++) {
			Item item = fpl.queue.Get(i);
			if (gecenZaman - item.askiyaAlinma >= 20)
			{
				Random rng = new Random();
				
				int r = rng.nextInt(256);
				int g = rng.nextInt(256);
				int b = rng.nextInt(256);

				text = String.format(
						"\033[38;2;%d;%d;%dm%d sn proses zamanasimi      (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
						r, g, b, gecenZaman, item.id, item.oncelik, item.burstTime);

				System.out.println(text);

				fpl.queue.exitQueue(i);
				i--;
			}
		}
		
		for (int i = 0; i < spl.queue.queueSize(); i++) {
			Item item = spl.queue.Get(i);
			if (gecenZaman - item.askiyaAlinma >= 20)
			{
				Random rng = new Random();

				int r = rng.nextInt(256);
				int g = rng.nextInt(256);
				int b = rng.nextInt(256);

				text = String.format(
						"\033[38;2;%d;%d;%dm%d sn proses zamanasimi      (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
						r, g, b, gecenZaman, item.id, item.oncelik, item.burstTime);

				System.out.println(text);

				spl.queue.exitQueue(i);
				i--;
			}
		}
		for (int i = 0; i < rr.queue.queueSize(); i++) {
			Item item = rr.queue.Get(i);
			if (gecenZaman - item.askiyaAlinma >= 20)
			{
				Random rng = new Random();

				int r = rng.nextInt(256);
				int g = rng.nextInt(256);
				int b = rng.nextInt(256);

				text = String.format(
						"\033[38;2;%d;%d;%dm%d sn proses zamanasimi      (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
						r, g, b, gecenZaman, item.id, item.oncelik, item.burstTime);

				System.out.println(text);

				rr.queue.exitQueue(i);
				i--;
			}
		}

	}
}
