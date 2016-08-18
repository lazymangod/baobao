package com.example;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lazygod on 2016/8/7.
 */
public class DownloadTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(DownloadTask.class);

    private static final String URLBASE = "http://pa10oo380.mychewang.cn/plugin.php?id=hejin_toupiao&model=dcexcel&zid=";

    private static final String DIR = "D:\\baobao\\";

    public static final int cache = 1 * 1024;

    private static final String DELIMITER = "_";


    private String zid;

    public DownloadTask(String zid) {
        this.zid = zid;
    }

    @Override
    public void run() {

       try{
           OkHttpClient client = new OkHttpClient();
           Request request = new Request.Builder().url(URLBASE+zid).build();
           Response response = client.newCall(request).execute();
           log.debug("{} 提交请求 ",Thread.currentThread().getName());
           if (response.isSuccessful()) {
               saveFile(response);
           }
       } catch (IOException e) {
          log.error("{} 下载出错 zid={} ",Thread.currentThread().getName(),zid);

       }
    }

    private static String extractName(String resp) {
        int i = resp.indexOf("=");
        String name = resp.substring(i+1);
        return name;
    }

    public String saveFile(Response response) throws IOException {

        String resp = response.headers().get("Content-Disposition");
        String name = extractName(resp);
        log.debug("{} file name {}.",Thread.currentThread().getName(),name);

        if (name.indexOf("/") != -1) {
            name = name.replace("/", "-");
        }

        File file = new File(DIR + zid + DELIMITER + name);

        if (file.exists()) {
            file.delete();
        }

        InputStream is = null;
        byte[] buf = new byte[cache];
        int len = 0;
        FileOutputStream fos = null;
        try {

            is = response.body().byteStream();
            final long total = response.body().contentLength();
            long sum = 0;

            fos = new FileOutputStream(file);
            while ((len = is.read(buf)) != -1) {
                sum += len;
                fos.write(buf, 0, len);
            }
            fos.flush();

            return file.getAbsolutePath();

        } finally {
            try {
                if (is != null) { is.close(); }
            } catch (IOException e) {
            }
            try {
                if (fos != null) { fos.close(); }
            } catch (IOException e) {
                log.error("e",e);
            }
        }
    }

}
