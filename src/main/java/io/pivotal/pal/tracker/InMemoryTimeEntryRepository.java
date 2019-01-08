package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryTimeEntryRepository  implements  TimeEntryRepository {

    private long sequence = 1l;

    private Map<Long, TimeEntry> db = new HashMap<>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        if(timeEntry !=  null ) { //TODO add checks for id
            timeEntry.setId(sequence);
            sequence = sequence + 1;
            db.put(timeEntry.getId(), timeEntry);
        }
        return timeEntry;
    }

    @Override
    public TimeEntry find(long id) {
        return db.get(id);
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<>(db.values());
    }

    @Override
    public TimeEntry update(long id, TimeEntry timeEntry) {
        timeEntry.setId(id);
        db.put(timeEntry.getId(), timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry delete(long id) {
        TimeEntry timeEntry = db.get(id);
        db.remove(id);
        return timeEntry;

    }
}
