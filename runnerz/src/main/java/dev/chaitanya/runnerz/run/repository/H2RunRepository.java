package dev.chaitanya.runnerz.run.repository;

import dev.chaitanya.runnerz.run.Run;

import java.util.List;
import java.util.Optional;

public class H2RunRepository implements IRunRepository {
    @Override
    public List<Run> findAllRuns() {
        return null;
    }

    @Override
    public Optional<Run> findRunById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void create(Run run) {

    }

    @Override
    public void update(Run run, Integer id) {

    }

    @Override
    public void delete(Integer id) {

    }
}
