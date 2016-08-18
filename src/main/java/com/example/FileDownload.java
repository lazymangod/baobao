package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lazygod on 2016/8/7.
 */
public class FileDownload {

    private static final Logger log = LoggerFactory.getLogger(FileDownload.class);

    /**
     * Accept-Language: zh-CN,zh;q=0.8,en;q=0.6,en-US;q=0.4
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5868; i++) {

            DownloadTask downloadTask = new DownloadTask("" + i);
            Future<?> submit = executor.submit(downloadTask);
        }

    }

}
