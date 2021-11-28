package br.com.jonathanferreira.spring.data.service;

import br.com.jonathanferreira.spring.data.orm.Job;
import br.com.jonathanferreira.spring.data.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudEmployeeService {
    private Boolean system = true;
    private final JobRepository jobRepository;

    public CrudEmployeeService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void init(Scanner scanner) {
        while (system) {
            System.out.println("What job action you want to execute?");
            System.out.println("0 - Leave");
            System.out.println("1 - Save");
            System.out.println("2 - Update");
            System.out.println("3 - List all jobs");
            System.out.println("4 - Find by id");
            System.out.println("5 - Delete");

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
                case 4:
                    findOne(scanner);
                    break;
                case 5:
                    remove(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }

    private void save(Scanner scanner) {
        System.out.println("Job description");
        scanner.nextLine();
        String description = scanner.nextLine();
        Job job = new Job(description);
        jobRepository.save(job);
        System.out.println("Job saved");
    }

    private void update(Scanner scanner) {
        System.out.println("What is the job ID?");
        Integer id = scanner.nextInt();

        System.out.println("What is the new job description?");
        scanner.nextLine();
        String newDescription = scanner.nextLine();

        Job job = new Job(newDescription);
        job.setId(id);
        jobRepository.save(job);
        System.out.println("Job updated");
    }

    private void list() {
        Iterable<Job> jobs = jobRepository.findAll();
        jobs.forEach(System.out::println);
    }

    private void findOne(Scanner scanner) {
        System.out.println("What is the job ID?");
        Integer id = scanner.nextInt();
        Optional<Job> optional = jobRepository.findById(id);
        if(optional.isPresent()){
            Job job = optional.get();
            System.out.println(job);
        }else {
            System.out.printf("Id %d not found!%n", id);
        }
    }

    private void remove(Scanner scanner) {
        System.out.println("What is the job ID?");
        Integer id = scanner.nextInt();
        jobRepository.deleteById(id);
        System.out.println("Job was successfully deleted!");
    }
}
