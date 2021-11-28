package br.com.jonathanferreira.spring.data.service;

import br.com.jonathanferreira.spring.data.orm.Job;
import br.com.jonathanferreira.spring.data.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Scanner;

@Service
public class CrudJobService {
    private Boolean system = true;
    private final JobRepository jobRepository;

    public CrudJobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void init(Scanner scanner) {
        while (system) {
            System.out.println("What job action you want to execute?");
            System.out.println("0 - Leave");
            System.out.println("1 - Save");
            System.out.println("2 - Update");
            System.out.println("3 - List all jobs");

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    save(scanner);
                    break;
                case 2:
                    update(scanner);
                    break;
                case 3:
                    list();
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void save(Scanner scanner) {
        System.out.println("Job description");
        String description = scanner.next();
        Job job = new Job(description);
        jobRepository.save(job);
        System.out.println("Job saved");
    }

    private void update(Scanner scanner) {
        System.out.println("What is the job ID?");
        Integer id = scanner.nextInt();
        System.out.println("What is the new job description?");
        String newDescription = scanner.next();

        Job job = new Job(newDescription);
        job.setId(id);
        jobRepository.save(job);
        System.out.println("Job updated");
    }

    private void list() {
        Iterable<Job> jobs = jobRepository.findAll();
        jobs.forEach(System.out::println);
    }
}
