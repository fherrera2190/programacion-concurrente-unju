package punto2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Queue;

public class ClaseMetodos {

	DateTimeFormatter formatter;

	private Queue<String> list = new LinkedList<String>();

	public ClaseMetodos() {
		this.formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");
	}

	public void task1() {

		LocalTime currentTime = LocalTime.now();
		String formattedTime = currentTime.format(formatter);
		addToList(formattedTime);
		System.out.println(this.list);
	}

	public void task2() {

		String formattedTime = removeFromList();
		if (formattedTime != null) {

			LocalTime time = LocalTime.parse(formattedTime, formatter);

			long milliseconds = ChronoUnit.MILLIS.between(LocalTime.MIN, time);

			if (checkPrimo(milliseconds)) {
				System.out.println("Se agrego un nro primo: " + milliseconds);
				writeResult("D:/Primos.txt", milliseconds + "\n");
			} else {
				System.out.println("Se agrego un nro no-primo: " + milliseconds);
				writeResult("D:/NoPrimos.txt", milliseconds + "\n");
			}
		}

	}

	private synchronized void addToList(String value) {
		list.add(value);
	}

	private synchronized String removeFromList() {
		return list.poll();
	}

	private boolean checkPrimo(long milliseconds) {
		if (milliseconds <= 1) {
			return false;
		}

		for (int i = 2; i * i <= milliseconds; i++) {
			if (milliseconds % i == 0) {
				return false;
			}
		}

		return true;
	}

	private void writeResult(String path, String text) {

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {

			writer.write(text);

		} catch (IOException e) {

			System.out.println("Error" + e.getMessage());
		}
	}
}
