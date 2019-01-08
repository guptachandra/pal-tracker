package io.pivotal.pal.tracker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TimeEntryController {

    TimeEntryRepository timeEntryRepository;

    public TimeEntryController(TimeEntryRepository timeEntryRepository) {
        this.timeEntryRepository = timeEntryRepository;
    }

    @PostMapping("/time-entries")
    public ResponseEntity<TimeEntry> create(@RequestBody TimeEntry timeEntryToCreate) {

        return new ResponseEntity<TimeEntry>( timeEntryRepository.create(timeEntryToCreate), HttpStatus.CREATED);
    }

    @GetMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> read(@PathVariable("id") long timeEntryId) {
        TimeEntry timeEntry = timeEntryRepository.find(timeEntryId);
        if(timeEntry == null) {
            return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<TimeEntry>(timeEntry , HttpStatus.OK);

    }

    @GetMapping("/time-entries")
    public ResponseEntity<List<TimeEntry>> list() {

        return new ResponseEntity<List<TimeEntry>>(timeEntryRepository.list() , HttpStatus.OK);

    }

    @PutMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> update(@PathVariable("id") long timeEntryId, @RequestBody TimeEntry timeEntry) {

        timeEntry = timeEntryRepository.update(timeEntryId, timeEntry) ;

        if(timeEntry == null) {
            return new ResponseEntity<TimeEntry>(HttpStatus.NOT_FOUND);

        }
        return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.OK);

    }

    @DeleteMapping("/time-entries/{id}")
    public ResponseEntity<TimeEntry> delete(@PathVariable("id") long timeEntryId) {
        TimeEntry timeEntry = timeEntryRepository.delete(timeEntryId);
        if(timeEntry == null) {
            return new ResponseEntity<TimeEntry>(HttpStatus.NO_CONTENT);

        }
        return new ResponseEntity<TimeEntry>(timeEntry, HttpStatus.NO_CONTENT);
    }
}
