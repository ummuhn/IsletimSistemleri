package OperatingSystem;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {

		DispatchList dl = new DispatchList();
		Process process = new Process(dl);
		process.process();
	}
}
