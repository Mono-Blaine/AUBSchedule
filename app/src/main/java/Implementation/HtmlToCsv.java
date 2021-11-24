package Implementation;
import android.content.Context;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class HtmlToCsv {
	Context context;

	public HtmlToCsv(Context context) {
		this.context = context;
	}
	
	/**
	 * <b>requires:</b> valid file names (ending with .txt) <p>
	 * <b>effects:</b> translates the html into valid CSV format in the <i>csvFile</i>
	 * @param htmlFile file name of the file containing html code
	 * @param csvFile file name of the file where the html will be parsed into csv
	 */
	public void htmlToCsv(String htmlFile, String csvFile) {
		try {
			FileOutputStream fileout= context.openFileOutput(csvFile, Context.MODE_PRIVATE);
			OutputStreamWriter writer = new OutputStreamWriter(fileout);

			FileInputStream inStream = context.openFileInput(htmlFile);
			String html = "";

			if ( inStream != null ) {
				InputStreamReader inStreamReader = new InputStreamReader(inStream);
				BufferedReader buffReader = new BufferedReader(inStreamReader);

				String receiveString;
				StringBuilder stringBuilder = new StringBuilder();

				while ( (receiveString = buffReader.readLine()) != null )
					stringBuilder.append("\n").append(receiveString).append("\n");

				inStream.close();
				inStreamReader.close();
				buffReader.close();
				html = stringBuilder.toString();
			}

			if (html.compareTo("") == 0)
				throw new Exception();

			// removes everything before the first "Fall"
			String fall = html.substring(html.indexOf("Fall"));
			fall = fall.substring(0, fall.indexOf("</TABLE>")).trim();
			String[] rows = fall.split("</TD>");

			int i = 0;
			while (i < rows.length) {
				// removes "<TD>", "</TR>", whitespaces, and new lines
				rows[i] = rows[i].replace("<TD>", "");
				rows[i] = rows[i].replace("</TR>", "");
				rows[i] = rows[i].trim();

				// writing "N/A" for empty values
				if (rows[i].compareTo("") == 0 || rows[i].compareTo(".") == 0) {
					writer.write("N/A,");
					i++;
					continue;
				}

				// a new line for a new course
				if (rows[i].length() > 4 && rows[i].substring(0, 4).compareTo("Fall") == 0)
					writer.write("\n");

				// when the spring section is reached (stops writing)
				if (rows[i].length() > 6 && rows[i].substring(0, 6).compareTo("Spring") == 0)
					writer.write("\n");

				// writes the values to the file
				writer.write(rows[i]);
				writer.write(",");
				i++;
			}
			writer.close();
		}
		catch (Exception e) {
			System.out.println("Unable to convert");
			e.printStackTrace();
		}
	}
}
