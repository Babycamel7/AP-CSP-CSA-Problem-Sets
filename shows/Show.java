import java.util.Arrays;

public class Show {
	private String title;
	private String about;
	private int episodeDuration;
	private String[] genres;
	private String[] actors;
	private double rating;
	private int votes;
	private int[] years;

	public Show(String[] fields) {
		this.title = fields[0];
		this.about = fields[1];
		this.episodeDuration = safeParseInt(fields[2]);

		this.genres = fields[3].split(",");
		for (int i = 0; i < genres.length; i++) {
			genres[i] = genres[i].trim();
		}
		this.actors = fields[4].split(",");
		for (int i = 0; i < actors.length; i++) {
			actors[i] = actors[i].trim();
		}
		this.rating = Double.parseDouble(fields[5]);
		this.votes = safeParseInt(fields[6]);

		String[] partYears = fields[7].split("-");
		if (partYears.length == 1) {
			this.years = new int[]{safeParseInt(partYears[0])};
		}
		else if (partYears[1].isEmpty()) {
			this.years = new int[]{safeParseInt(partYears[0])};
		}
		else {
			this.years = new int[]{safeParseInt(partYears[0]), safeParseInt(partYears[1])};
		}
	}
	private int safeParseInt(String s) {
		try {
			return Integer.parseInt(s.trim());
		}
		catch (NumberFormatException e) {
			return 0;
		}
	}
	public String toString() {
		return "<" + title + ", " + about + ", " + episodeDuration + " mins, " + 
		Arrays.toString(genres) + ", " + Arrays.toString(actors) + ", " + rating + ", " +
		votes + ", " + Arrays.toString(years) + ">";
	}
	public String getTitle() {
		return title;
	}
	public String[] getGenres() {
		return genres;
	}
	public String[] getActors() {
		return actors;
	} 
	public int[] getYears() {
		return years;
	}
	public double getRating() {
		return rating;
	}
	public boolean hasGenre(String genre) {
		for (int i = 0; i < genres.length; i++) {
			if (genre.equals(genres[i])) return true;
		}
		return false;
	}
	public boolean hasActor(String actor) {
		for (int i = 0; i < actors.length; i++) {
			if (actor.equals(actors[i])) return true;
		}
		return false;
	}
	public boolean released(int releaseYear) {
		if (years[0] == releaseYear) return true;
		else return false;
	}
}