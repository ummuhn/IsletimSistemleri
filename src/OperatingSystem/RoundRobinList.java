package OperatingSystem;

import java.util.Random;

public class RoundRobinList {
	Queue queue = new Queue();
	int sayac = 0;

	void RR_add(Item item) {
		queue.addQueue(item);

	}

	boolean RR_isEmpty() {
		return queue.isEmptyQueue();
	}

	Item cikanEleman = null;

	int RR_execute(int zaman) {

		Random rng = new Random();

		int r = rng.nextInt(256);
		int g = rng.nextInt(256);
		int b = rng.nextInt(256);

		DispatchList dl = Process.dl;

		String text = "";

		int timer = 0; 
		Item item = queue.Get(sayac);

		text = String.format(
				"\033[38;2;%d;%d;%dm%2d sn proses basladi         (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m", r,
				g, b, (zaman + timer), item.id, item.oncelik, item.burstTime);

		System.out.println(text);

		timer++;
		item.burstTime--;

		item.askiyaAlinma = zaman + timer; 
		if (item.burstTime == 0) {
			text = String.format(
					"\033[38;2;%d;%d;%dm%2d sn proses sonlandi        (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
					r, g, b, (zaman + timer), item.id, item.oncelik, item.burstTime);

			System.out.println(text);

			queue.exitQueue(sayac);

			if (sayac == queue.queueSize()) 
				sayac = 0;					
				
		} else { 
			text = String.format(
					"\033[38;2;%d;%d;%dm%2d sn proses askida          (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
					r, g, b, (zaman + timer), item.id, item.oncelik, item.burstTime);

			System.out.println(text);

			dl.TimeOut_Scanner(zaman + timer);

			sayac = (sayac + 1) % queue.queueSize(); 

		}
		return timer;
	}
}
