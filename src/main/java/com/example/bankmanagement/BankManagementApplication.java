package com.example.bankmanagement;
import com.example.bankmanagement.enums.OperationType;
import com.example.bankmanagement.enums.StatusType;
import com.example.bankmanagement.model.*;
import com.example.bankmanagement.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.security.auth.callback.Callback;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@SpringBootApplication

public class BankManagementApplication implements CommandLineRunner {


	public static void main(String[] args) {
		SpringApplication.run(BankManagementApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {

	}

	@Bean
	public ModelMapper modelMapper(){
		return  new ModelMapper();
	}
}
