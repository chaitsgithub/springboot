package dev.chaitanya.runnerz.run.repository;

import dev.chaitanya.runnerz.run.Run;

import java.util.List;
import java.util.Optional;

public interface IRunRepository {
    List<Run> findAllRuns();

    Optional<Run> findRunById(Integer id);

    void create(Run run);

    void update(Run run, Integer id);

    void delete(Integer id);
}
