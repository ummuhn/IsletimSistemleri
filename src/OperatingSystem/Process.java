package OperatingSystem;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Process {

	public static DispatchList dl = null;

	public Process(DispatchList dl) 
	{
		Process.dl = dl;
	}

	public void process() throws IOException {

		List<String> allLines = Files.readAllLines(Paths.get("./giris.txt"));
		int idSayac = 0;

		for (int i = 0; i < allLines.size(); i++) { 

			String line = allLines.get(i);

			Item item = new Item();

			int sayac = -1;

			String data = "";

			for (int j = 0; j < line.length(); j++) {
				char ch = line.charAt(j);

				if (ch == ' ')
					continue;

				else if (j == line.length() - 1) {
					data += ch;
					item.burstTime = Integer.parseInt(data);

				} else if (ch != ',') {
					data += ch;

				} else {

					sayac++;
					switch (sayac) {
					case 0:
						item.varis = Integer.parseInt(data);
						break;
					case 1:
						item.oncelik = Integer.parseInt(data);
						break;
					}

					data = ""; 
				}
			}
			
			item.id = idSayac;
			
			idSayac++;
			
			item.askiyaAlinma = item.varis; 
			
			
			dl.AddList(item);
		}
		dl.General_Dispatcher();
	}
}