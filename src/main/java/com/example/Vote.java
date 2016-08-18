package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by lazygod on 2016/8/14 ${Time}.
 */
public class Vote {

    private static final Logger log = LoggerFactory.getLogger(Vote.class);

    private static final String URLBASE = "http://pa10oo1059.mychewang.cn/plugin.php?id=hejin_toupiao&model=ticket&zid=2153&formhash=7c831cd3&_=1471126764627";




    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        String openId = "ofMpPwWQSqJFVAYzz-C8hKqmLaxI";
        VoteTask voteTask = new VoteTask(openId);

        Future<?> submit = executorService.submit(voteTask);





    }
}
