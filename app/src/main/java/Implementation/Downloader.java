package Implementation;
import android.content.Context;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class Downloader {
	private final Context context;

	public Downloader(Context context) {
		this.context = context;
	}

	/**
	 * <b>requires:</b> a valid url and and a valid file name (ending with .txt) <p>
	 * <b>effects:</b> the html code in the given file
	 * @param url of the website to be downloaded
	 * @param file name of the file where the downloaded html will be written
	 */
	public void downloadHtmlToFile(String url, String file) {
		Thread thread = new Thread(() -> {
			try {
				URL urlR = new URL(url);
				InputStream inStream = urlR.openStream();

				DataInputStream dis = new DataInputStream(new BufferedInputStream(inStream));
				String line;
				StringBuilder htmlBuilder = new StringBuilder();

				while ((line = dis.readLine()) != null)
					htmlBuilder.append(line);

				String html = htmlBuilder.toString();
				FileOutputStream outputStream = context.openFileOutput(file, Context.MODE_PRIVATE);
				outputStream.write(html.getBytes());
				outputStream.close();
			}
			catch (Exception e) {
				System.out.println("Unable to download");
				e.printStackTrace();
			}
		});
		thread.start();
	}
}
