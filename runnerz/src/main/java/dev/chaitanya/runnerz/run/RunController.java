package dev.chaitanya.runnerz.run;

import dev.chaitanya.runnerz.run.repository.IRunRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    private final IRunRepository runRepository;

    @Autowired
    public RunController(IRunRepository iRunRepository) {
        this.runRepository = iRunRepository;
    }

    @GetMapping("")
    List<Run> findAll() {
        return runRepository.findAllRuns();
    }

    @GetMapping("/{id}")
    Run findRunById(@PathVariable Integer id) {
        Optional<Run> run = runRepository.findRunById(id);
        if (run.isEmpty()) {
            throw new RunNotFoundException();
        }
        return run.get();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void createRun(@Valid @RequestBody Run run) {
        runRepository.create(run);
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{id}")
    void updateRun(@Valid @RequestBody Run run, @PathVariable Integer id) {
        runRepository.update(run, id);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    void deleteRun(@PathVariable Integer id) {
        runRepository.delete(id);
    }
}
