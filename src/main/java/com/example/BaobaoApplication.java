package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.apache.log4j.helpers.LogLog.error;

@SpringBootApplication
//@EnableBatchProcessing
public class BaobaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaobaoApplication.class, args);
	}
}

