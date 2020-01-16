package only.request.utils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class URLUtil {

    public static String getURLResult(URL url) {
        if (url == null)
            throw new RuntimeException("URL é null");

        String html = null;
        StringBuilder sB = new StringBuilder();
        try (BufferedReader bR = new BufferedReader(new InputStreamReader(url.openStream()))) {
            while ((html = bR.readLine()) != null)
                sB.append(html);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return sB.toString();
    }

    public static String download(String url) throws IOException {
        try {
            return download(new URL(url));
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static String download(URL url) throws IOException {
        ByteArrayOutputStream baixado = new ByteArrayOutputStream(20480);
        try (InputStream is = url.openStream()) {
            int t;
            while ((t = is.read()) != -1) {
                baixado.write(t);
            }
            return baixado.toString();
        }
    }

}
