//package com.example.processor;
//
//import com.example.doman.Vote;
//import com.squareup.okhttp.OkHttpClient;
//import com.squareup.okhttp.Request;
//import com.squareup.okhttp.Response;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.boot.json.JsonParserFactory;
//
//import java.io.IOException;
//import java.util.Map;
//
///**
// * Created by lazygod on 2016/8/7.
// */
//public class VoteProcessor implements ItemProcessor<Vote, Vote> {
//
//    private static final Logger log = LoggerFactory.getLogger(VoteProcessor.class);
//
//    public static final String IP_BASE = "http://ip.taobao.com/service/getIpInfo.php?ip=";
//
//    private static final OkHttpClient client = new OkHttpClient();
//
//    @Override
//    public Vote process(final Vote vote) throws Exception {
//        vote.setZid(1271);
//        vote.setName("孙艺阳");
//        //String ipCity = getIpCity(vote.getIp());
//        log.debug("ip={} City {}",vote.getIp());
//        return vote;
//    }
//
//
//
//    private  String getIpCity(String ip) {
//        Request request = new Request.Builder()
//                .url(IP_BASE + ip)
//                .build();
//
//        Response response = null;
//        try {
//            response = client.newCall(request).execute();
//            String jsonStr = response.body().string();
//            String address = getCityName(jsonStr);
//            return address;
//        } catch (IOException e) {
//            log.error("解析Ip地址出错!! ip={}",ip,e);
//        }
//
//        return "";
//    }
//
//    private  String getCityName(String jsonStr) {
//        Map<String, Object> jsonMap = JsonParserFactory.getJsonParser().parseMap(jsonStr);
//        Integer code = (Integer) jsonMap.get("code");
//        StringBuilder sb = new StringBuilder();
//        if (code==0) {
//            Map<String,String> data = (Map<String,String>)jsonMap.get("data");
//            sb.append(data.get("region"));
//            sb.append(" ");
//            sb.append(data.get("city"));
//            sb.append(" ");
//            sb.append(data.get("isp"));
//        }
//        return sb.toString();
//    }
//
//
//}
