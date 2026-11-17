package streamapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class DistinctCertifiedSkills {

    static class Trainer {
        String skill;
        boolean certified;

        Trainer(String skill, boolean certified) {
            this.skill = skill;
            this.certified = certified;
        }
    }

    public static void main(String[] args) {
        List<Trainer> trainers = Arrays.asList(
                new Trainer("Java", true),
                new Trainer("Spring Boot", true),
                new Trainer("Java", true),
                new Trainer("Kafka", false)

        );

        List<String> skills = trainers.stream().filter(n -> n.certified).map(n -> n.skill).distinct().toList();
        System.out.println(skills);
    }
}
