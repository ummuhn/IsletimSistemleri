package OperatingSystem;

import java.util.Random;

public class FCFSList {

	Queue kuyruk = new Queue();

	void FCFS_add(ProcessItem item) {
		kuyruk.addQueue(item);

	}

	boolean FCFS_isEmpty() {
		return kuyruk.isEmptyQueue();
	}

	int FCFS_execute(int zaman) {

		Random rng = new Random();
		
		int r = rng.nextInt(256);
		int g = rng.nextInt(256);
		int b = rng.nextInt(256);


		DispatchList dl = Process.dl;

		int timer = 0;
		String text = "";
		ProcessItem item = kuyruk.exitQueue();

		text = String.format(
				"\033[38;2;%d;%d;%dm%2d sn proses basladi         (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m", r,
				g, b, (zaman + timer), item.id, item.priority, item.burstTime);

		System.out.println(text);

		while (item.burstTime != 0) {
			item.burstTime--;
			timer++;

			item.suspend = zaman + timer;

			if (item.burstTime > 0) {
				text = String.format(
						"\033[38;2;%d;%d;%dm%2d sn proses yurutuluyor     (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
						r, g, b, (zaman + timer), item.id, item.priority, item.burstTime);

				System.out.println(text);
			} else
				text = String.format(
						"\033[38;2;%d;%d;%dm%2d sn proses sonlandi        (id: %2d   oncelik:%2d  kalan sure:%2d sn)\033[0m",
						r, g, b, (zaman + timer), item.id, item.priority, item.burstTime);

			System.out.println(text);

			dl.TimeOut_Scanner(zaman + timer);
		}

		return timer;
	}
}
