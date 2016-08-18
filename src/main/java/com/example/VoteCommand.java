package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class VoteCommand implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(VoteCommand.class);

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public VoteCommand(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void run(String... args) throws Exception {



        List<String> list = jdbcTemplate.queryForList("select DISTINCT openid from hjtp_zuopins",String.class);

        System.out.println("list = " + list.size());
        log.error(list.size()+"  ********************");

        List<String> already = loadOpenId();

        log.error(already.size()+"  ********************");
        boolean b = list.removeAll(already);

        log.error(list.size()+"  ********************");



        try ( PrintWriter w = new PrintWriter("openid.txt")){
            for(String line : list){
                w.println(line);
            }

        }




//		ExecutorService executorService = Executors.newSingleThreadExecutor();
//
//		for (int i = 0; i < 100; i++) {
//			int index=(int)(Math.random()*list.size());
//			System.out.println("***********************************************");
//			System.out.println("index = " + index);
//			System.out.println("***********************************************");
//
//			VoteTask voteTask = new VoteTask(list.get(index));
//
//			Future<?> submit = executorService.submit(voteTask);
//		}

    }


    private static List<String> loadOpenId() {
        ClassPathResource resource = new ClassPathResource("222.csv");

        List<String> openidList = new ArrayList<String>();


        try {
            String line;
            InputStream inputStream = resource.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            while ((line = bufferedReader.readLine()) != null) {
                openidList.add(line);
            }

        } catch (IOException e) {
            System.err.println("加载 222 OpenId出错");

        }finally {


        }

        return openidList;
    }
}