import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileOperations {

	public static Path productsPath = Paths.get("products.txt");
	public static File productsFile = productsPath.toFile();

	//write to file accepts class variables and writes to file using ',' as delimiter
	public static void writeToFile(int id, String name, String category, String description,
			double price, double postTax) {

		PrintWriter printWriter = null;

		try {
			printWriter = new PrintWriter(new FileOutputStream("products.txt",
					true));
			printWriter.write(id + "," + name + "," + category + "," + description + "," + price
					+ "," + postTax + "\n");
		} catch (IOException ioex) {
			ioex.printStackTrace();
		} finally {
			if (printWriter != null) {
				printWriter.flush();
				printWriter.close();
			}
		}

	}

	//getFile reads file and returns arrayList of string[] called product
	public static ArrayList<String[]> getFile() {
		ArrayList<String[]> products = new ArrayList<String[]>();

		try (BufferedReader in = new BufferedReader(
				new FileReader(productsFile))) {

			String line = in.readLine();
			
			while (line != null) {
				String[] display = line.split(",");
				products.add(display);
				line = in.readLine();
			}

		} catch (IOException e) {
			System.out.println(e);
		}

		return products;

	}
}
