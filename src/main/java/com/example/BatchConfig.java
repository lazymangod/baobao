package com.example;

import com.example.doman.Vote;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.MultiResourceItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import java.io.IOException;

//import com.example.listener.JobCompletionNotificationListener;
//import com.example.processor.VoteProcessor;



public class BatchConfig {

    public final JobBuilderFactory jobBuilderFactory;

    public final StepBuilderFactory stepBuilderFactory;

    public final DataSource dataSource;

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    public BatchConfig(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, DataSource dataSource) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.dataSource = dataSource;
    }

    /**
     * 读入数据
     *
     * @return
     */
    @Bean
    public MultiResourceItemReader multiResourceItemReader() {
        MultiResourceItemReader reader = new MultiResourceItemReader();
        try {
            reader.setResources(new PathMatchingResourcePatternResolver().getResources("file:D:/baobao/*.csv"));
        } catch (IOException e) {
            System.err.println("A error in Reading File");
        }
        reader.setDelegate(reader());
        return reader;
    }


    @Bean
    public FlatFileItemReader<Vote> reader() {
        FlatFileItemReader<Vote> reader = new FlatFileItemReader<Vote>();
        reader.setResource(new ClassPathResource("孙艺阳 1271.csv"));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<Vote>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[]{"userid", "openid", "ip", "time"});
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<Vote>() {{
                setTargetType(Vote.class);
            }});
        }});
        return reader;
    }

    /**
     * 定义处理器
     *
     * @return
     */
//    @Bean
//    public VoteProcessor processor() {
//        return new VoteProcessor();
//    }


    @Bean
    public JdbcBatchItemWriter<Vote> writer() {
        JdbcBatchItemWriter<Vote> writer = new JdbcBatchItemWriter<Vote>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<Vote>());
        writer.setSql("insert into hjtp_zuopins(zid,name,userid,openid,ip,time) values (:zid,:name,:userId, :openId, :ip,:time)");
        writer.setDataSource(dataSource);
        return writer;
    }


    @Bean

    public Job importUserJob() {
        return jobBuilderFactory.get("importVoteJob")
                .incrementer(new RunIdIncrementer())
//                .listener(listener())
                .flow(step1())
                .end()
                .build();
    }


    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Vote, Vote>chunk(300)
                .reader(multiResourceItemReader())
                //.processor(processor())
                .writer(writer())
                .build();
    }

//
//    @Bean
//    public JobExecutionListener listener() {
//        return new JobCompletionNotificationListener(new JdbcTemplate(dataSource));
//    }

    @Bean
    public ApplicationListener contextlistener() {
        return applicationEvent -> {
            if (applicationEvent instanceof ContextClosedEvent) {
                System.out.println("Closing!!!");
            } else if (applicationEvent instanceof ContextStartedEvent) {
                System.out.println("Starting!!!");
            } else if (applicationEvent instanceof ContextStoppedEvent) {
                System.out.println("Stopping!!");
            } else if (applicationEvent instanceof ContextRefreshedEvent) {
                System.out.println("Refreshing");
            }
        };
    }

}
