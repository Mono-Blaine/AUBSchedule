package Implementation;
import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Sam.Ab.Application.MainActivity;

public class CsvToDb {
	private final Context context;

	public CsvToDb(Context context) {
		this.context = context;
	}

	/**
	 * <b>requires:</b> a valid file name (ending with .txt) <p>
	 * <b>effects:</b> a list of all Courses from the given file 
	 * @param courses a list that will be filled with all courses from the given csv
	 * @param csvFile a file name of the file containing csv data for <i>courses</i>
	 */
	public void csvToDb(List<Course> courses, String csvFile) {
		try {
			FileInputStream inStream = context.openFileInput(csvFile);
			InputStreamReader inputReader = new InputStreamReader(inStream);
			BufferedReader buffReader = new BufferedReader(inputReader);

			String temp;
			while ( (temp = buffReader.readLine()) != null) {
				if (temp.compareTo("") == 0)
					continue;

				// if the line isn't empty, puts its values into an array
				String[] courseData = temp.split(",");

				// so that it has enough elements for a course to be created
				if (courseData.length < 34)
					continue;

				courses.add(new Course(courseData));
			}

			inStream.close();
			inputReader.close();
			buffReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
