package br.com.jonathanferreira.spring.data;

import br.com.jonathanferreira.spring.data.service.CrudJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DataApplication implements CommandLineRunner {

    private boolean system = true;

    @Autowired
    private CrudJobService jobService;

    public static void main(String[] args) {
        SpringApplication.run(DataApplication.class, args);
    }

    @Override
    public void run(String... args) {
        Scanner sc = new Scanner(System.in);
        while (system) {
            System.out.println("What action do you want to execute?");
            System.out.println("0 - Leave");
            System.out.println("1 - Jobs");

            int action = sc.nextInt();
            if (action == 1) {
                jobService.init(sc);
            } else {
                system = false;
            }
        }

    }
}
