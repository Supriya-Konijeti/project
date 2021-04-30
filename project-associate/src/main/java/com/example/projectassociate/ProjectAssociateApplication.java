package com.example.projectassociate;

import com.example.projectassociate.model.Associate;
import com.example.projectassociate.model.Skill;
import com.example.projectassociate.repo.AssociateRepo;
import com.example.projectassociate.repo.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;


@SpringBootApplication
@EnableEurekaClient
public class ProjectAssociateApplication implements CommandLineRunner {
    private AssociateRepo associateRepo;
    private SkillRepository skillRepository;
@Autowired
    public ProjectAssociateApplication(AssociateRepo associateRepo, SkillRepository skillRepository) {
        this.associateRepo = associateRepo;
        this.skillRepository = skillRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(ProjectAssociateApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Skill javascript = new Skill(1, "Javascript");
        Skill java = new Skill(2, "Java");
        Skill cpp = new Skill(3, "C++");
        Skill python = new Skill(4, "Python");

        skillRepository.save(javascript);
        skillRepository.save(java);
        skillRepository.save(cpp);
        skillRepository.save(python);


        associateRepo.save(new Associate(1,"Supriya","supriya@email.com", "9876543210", Arrays.asList(new Skill[]{java, python})));
        associateRepo.save(new Associate(2,"John","john@email.com", "1234567890", Arrays.asList(new Skill[]{cpp, python})));
        associateRepo.save(new Associate(3,"Marry","public@email.com", "9753186420", Arrays.asList(new Skill[]{java, javascript})));
        associateRepo.save(new Associate(4,"Sachin","sachin@email.com", "9425159540", Arrays.asList(new Skill[]{cpp, javascript, java})));
    }
}
