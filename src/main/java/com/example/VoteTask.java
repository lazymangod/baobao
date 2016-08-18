package com.example;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by lazygod on 2016/8/14 ${Time}.
 */
public class VoteTask implements Runnable {

    private static final Logger log = LoggerFactory.getLogger(VoteTask.class);

    private static final String URLBASE = "http://pa10oo1059.mychewang.cn/plugin.php?id=hejin_toupiao&model=ticket&zid=2153&formhash=7c831cd3&_=1471126764627";

    public static final String BEFORE ="lQEv_2132_saltkey=aXvHEdkw; lQEv_2132_lastvisit=1471002769; hjbox_openid=";


    public static final String AFTER = "; lQEv_2132_sid=owvuv4; lQEv_2132_lastact=1471126757%09plugin.php%09";

    private String openId;

    public VoteTask(String openId) {
        this.openId = openId;
    }

    @Override
    public void run() {
        try {

            String cookies = BEFORE + openId + AFTER;

            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(URLBASE)
                    .addHeader("Host", "pa10oo1059.mychewang.cn")
                    .addHeader("Connection", "keep-alive")
                    .addHeader("X-Requested-With", "XMLHttpRequest")
                    .addHeader("User-Agent", " Mozilla/5.0 (Linux; Android 5.1.1; MX4 Pro Build/LMY48W) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/37.0.0.0 Mobile MQQBrowser/6.2 TBS/036555 Safari/537.36 MicroMessenger/6.3.23.840 NetType/WIFI Language/zh_CN")
                    .addHeader("Referer", " http://pa10oo1059.mychewang.cn/plugin.php?id=hejin_toupiao&model=detail&zid=2153")
                    .addHeader("Accept-Language", "zh-CN,en-US;q=0.8")
                    .addHeader("Cookie", cookies)
                    .build();
            Response response = client.newCall(request).execute();
            log.debug("{} 提交请求 ", Thread.currentThread().getName());


            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                String string = body.string();
                System.out.println("string = " + string);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            log.error("{} 投票出错 zid={} ", Thread.currentThread().getName());

        }
    }
}
