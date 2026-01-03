import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		try {
			File f = new File("imdb_tvshows.csv");
			Scanner sc = new Scanner(f, "UTF-8");
			int lineCount = Integer.parseInt(sc.nextLine());
			Show[] shows = new Show[lineCount];

			int idx = 0;
			while (sc.hasNextLine()) {
				String[] parts = sc.nextLine().trim().split("=");
				if (parts.length != 8) {
					System.out.println("bad line" + parts.length + idx + Arrays.toString(parts));
					continue;
				}
				shows[idx] = new Show(parts);
				idx++;
			}
			sc.close();
			sortShowsByYear(shows);
			System.out.print(Arrays.toString(shows));

		}
		catch (FileNotFoundException e) {
			System.out.println("File not Found");
		}
	}

	public static Show findShowByTitle(Show[] shows, String title) {
		for (int i = 0; i < shows.length; i++) {
			if (title.equals(shows[i].getTitle())) return shows[i];
		}
		return null;
	}
	public static Show[] findShowsByGenre(Show[] shows, String genre) {
		int showCounter = 0;
		for (int i = 0; i < shows.length; i++) {
			if (shows[i].hasGenre(genre)) showCounter++;
		}
		Show[] result = new Show[showCounter];
		int idx = 0;
		for (int i = 0; i < shows.length; i++) {
			if (shows[i].hasGenre(genre)) {
				result[idx] = shows[i];
				idx++;
			}
		}
		return result;
	}
	public static Show[] findShowsByActor(Show[] shows, String actor) {
		int ct = 0;
		for (int i = 0; i < shows.length; i++) {
			if (shows[i].hasActor(actor)) ct++;
		}
		Show[] result = new Show[ct];
		int idx = 0;
		for (int i = 0; i < shows.length; i++) {
			if (shows[i].hasActor(actor)) {
				result[idx] = shows[i];
				idx++;
			}
		}
		return result;
	}
	public static Show[] findShowsByRelease(Show[] shows, int year) {
		int ct = 0;
		for (int i = 0; i < shows.length; i++) {
			if (shows[i].released(year)) ct++;
		}
		Show[] result = new Show[ct];
		int idx = 0;
		for (int i = 0; i < shows.length; i++) {
			if (shows[i].released(year)) {
				result[idx] = shows[i];
				idx++;
			}
		}
		return result;
	}
	public static void sortShowsByTitle(Show[] shows) {
		for (int i = 1; i < shows.length; i++) {
			Show key = shows[i];
			int j = i - 1;
			while (j >= 0 && shows[j].getTitle().compareTo(key.getTitle()) > 0) {
				shows[j + 1] = shows[j];
				j--;
			}
			shows[j + 1] = key;
		}
	}
	public static void sortShowsByRating(Show[] shows) {
		for (int i = 1; i < shows.length; i++) {
			Show key = shows[i];
			int j = i - 1;
			while (j >= 0 && shows[j].getRating() < key.getRating()) {
				shows[j + 1] = shows[j];
				j--;
			}
			shows[j + 1] = key;
		}
	}
	public static void sortShowsByYear(Show[] shows) {
		for (int i = 1; i < shows.length; i++) {
			Show key = shows[i];
			int j = i - 1;
			while (j >= 0 && shows[j].getYears()[0] > key.getYears()[0]) {
				shows[j + 1] = shows[j];
				j--;
			}
			shows[j + 1] = key;
		}
	}
}