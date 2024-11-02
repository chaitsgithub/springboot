package dev.chaitanya.runnerz.run.repository;

import dev.chaitanya.runnerz.run.Location;
import dev.chaitanya.runnerz.run.Run;
import jakarta.annotation.PostConstruct;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryRunRepository implements IRunRepository {
    private List<Run> runs = new ArrayList<>();

    @PostConstruct
    private void init() {
        runs.add(new Run(1, "Day#1 IM Morning Run", LocalDateTime.now(), LocalDateTime.now().plusMinutes(30), 10, Location.INDOOR));
        runs.add(new Run(2, "Day#1 IM Evening Run", LocalDateTime.now(), LocalDateTime.now().plusMinutes(45), 15, Location.INDOOR));
        runs.add(new Run(3, "Day#2 IM Morning Run", LocalDateTime.now(), LocalDateTime.now().plusMinutes(45), 17, Location.INDOOR));
        runs.add(new Run(4, "Day#2 IM Evening Run", LocalDateTime.now(), LocalDateTime.now().plusMinutes(60), 20, Location.INDOOR));
    }

    @Override
    public List<Run> findAllRuns() {
        return runs;
    }

    @Override
    public Optional<Run> findRunById(Integer id) {
        return runs.stream()
                .filter(run -> run.id() == id)
                .findFirst();
    }

    @Override
    public void create(Run run) {
        runs.add(run);
    }

    @Override
    public void update(Run run, Integer id) {
        Optional<Run> existingRun = findRunById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    @Override
    public void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }
}
