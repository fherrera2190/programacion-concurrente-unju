package punto4;

import java.io.File;
import java.util.LinkedList;

public class TaskCheckFolder {

	LinkedList<String> list = new LinkedList<>();
	
	public TaskCheckFolder() {
		File[] listOfFiles = this.readFiles();

		for (File file : listOfFiles) {
			this.list.offer(file.getName());
		}

	}
	public void showList() {
		System.out.println(this.list);
	}

	public File[] readFiles() {
		File folder = new File("D:/test");
		return folder.listFiles();
	}

	public void checkFolder() {
		File[] listOfFiles = this.readFiles();

		if (list.size() < listOfFiles.length) {
			for (File file : listOfFiles) {
				if (!list.contains(file.getName())) {
					System.out.println("Nuevo archivo " + file.getName() + ", con tamaño " + file.length());
					this.list.add(file.getName());
				}
			}
			this.showList();
		}
	}
}
