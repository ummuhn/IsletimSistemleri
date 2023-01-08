package OperatingSystem;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		DispatchList dl = new DispatchList();

		Process p1 = new Process(dl);

		p1.process();
	}
}
