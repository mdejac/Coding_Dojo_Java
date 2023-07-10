package com.michaeld.projectmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.michaeld.projectmanager.models.User;
import com.michaeld.projectmanager.validators.LoginUser;

@SpringBootApplication
public class ProjectManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectManagerApplication.class, args);
	}
}
