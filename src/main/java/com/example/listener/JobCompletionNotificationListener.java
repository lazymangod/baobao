//package com.example.listener;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.batch.core.BatchStatus;
//import org.springframework.batch.core.JobExecution;
//import org.springframework.batch.core.listener.JobExecutionListenerSupport;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.RowMapper;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
///**
// * Created by lazygod on 2016/8/7.
// */
//public class JobCompletionNotificationListener extends JobExecutionListenerSupport {
//
//    private static final Logger log = LoggerFactory.getLogger(JobCompletionNotificationListener.class);
//
//    private final JdbcTemplate jdbcTemplate;
//
//
//    @Autowired
//    public JobCompletionNotificationListener(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public void afterJob(JobExecution jobExecution) {
//        if (jobExecution.getStatus()== BatchStatus.COMPLETED) {
//            log.debug("!!! JOB FINISHED! Time to verify the results");
//
//            List<Integer> count = jdbcTemplate.query("select count(*) from hjtp_zuopins", new RowMapper<Integer>() {
//                @Override
//                public Integer mapRow(ResultSet rs, int rowNum) throws SQLException {
//                    return rs.getInt(1);
//                }
//            });
//
//            log.debug("count = {}",count);
//        }
//        super.afterJob(jobExecution);
//    }
//}
