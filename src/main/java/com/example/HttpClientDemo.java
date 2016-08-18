package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by lazygod on 2016/8/7.
 */
public class HttpClientDemo {

    public static void main(String[] args) throws InterruptedException, IOException {

        Process p = Runtime.getRuntime().exec("ping baidu.com");

        p.waitFor();

        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

        String line = "";

        StringBuilder sb = new StringBuilder();

        while ((line = reader.readLine()) != null) {
            sb.append(line + "\n");
        }

        System.out.println("sb = " + sb.toString());
    }



}
