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

	private static Queue<String> list = new LinkedList<String>();

	public static void task1() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

		LocalTime currentTime = LocalTime.now();

		String formattedTime = currentTime.format(formatter);
		addToList(formattedTime);

	}

	public static void task2() {

		String formattedTime = removeFromList();
		if (formattedTime != null) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss:SSS");

			LocalTime time = LocalTime.parse(formattedTime, formatter);

			long milliseconds = ChronoUnit.MILLIS.between(LocalTime.MIN, time);
			System.out.println(milliseconds);
			if(checkPrimo(milliseconds)) {
				writeResult("D:/Primos.txt", milliseconds+"\n");
			}
			else {
				writeResult("D:/NoPrimos.txt", milliseconds+"\n");
			}
		}

	}

	private synchronized static void addToList(String value) {

		list.add(value);

	}

	private synchronized static String removeFromList() {

		return list.poll();

	}

	private static boolean checkPrimo(long milliseconds) {
		if (milliseconds <= 1) {
			return false;
		}

		for (int i = 2; i <= Math.sqrt(milliseconds); i++) {
			if (milliseconds % i == 0) {
				return false;
			}
		}

		return true;
	}
	
	private static void writeResult(String path, String text) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path,true ))) {

            writer.write(text);

        } catch (IOException e) {

            System.out.println("Error" + e.getMessage());
        }
    }
}
