package Sam.Ab.Application;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import Implementation.CsvToDb;
import Implementation.Downloader;
import Implementation.HtmlToCsv;

public class UpdateFiles {
    private static final String[] links = new String[] {
            "https://www-banner.aub.edu.lb/catalog/schd_A.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_B.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_C.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_D.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_E.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_F.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_G.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_H.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_I.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_J.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_K.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_L.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_M.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_N.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_O.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_P.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_Q.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_R.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_S.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_T.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_U.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_V.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_W.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_X.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_Y.htm",
            "https://www-banner.aub.edu.lb/catalog/schd_Z.htm"
    };

    Downloader downloader;
    HtmlToCsv toCsv;

    public void buttonUpdateFiles(View view, Context context) {
        downloader = new Downloader(context);
        toCsv = new HtmlToCsv(context);

        for (int i = 0; i < 1; i++) {
            String htmlFile = (char) (i + 65) + ".txt";
            String csvFile = (char) (i + 65) + "csv.txt";

            downloader.downloadHtmlToFile(links[i], htmlFile);
            toCsv.htmlToCsv(htmlFile, csvFile);
        }

        Toast.makeText(context, "Files downloaded", Toast.LENGTH_LONG).show();
    }
}
