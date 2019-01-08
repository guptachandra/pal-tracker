package io.pivotal.pal.tracker;

import java.time.LocalDate;

public class TimeEntry {

    private  long projectId;
    private  long userId;
    private  LocalDate date;
    private  int hours;
    private  long id;

    public TimeEntry(long projectId, long userId, LocalDate date, int hours) {

        this.projectId = projectId;
        this.userId = userId;
        this.date = date;
        this.hours = hours;
    }

    public TimeEntry(long id, long projectId, long userId, LocalDate date, int hours) {

        this( projectId,  userId, date,  hours);
        this.id = id;

    }

    public TimeEntry() {

    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {

        this.id = id;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getUserId() {
        return userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TimeEntry timeEntry = (TimeEntry) o;

        if (projectId != timeEntry.projectId) return false;
        if (userId != timeEntry.userId) return false;
        if (hours != timeEntry.hours) return false;
        if (id != timeEntry.id) return false;
        return date.equals(timeEntry.date);
    }

    @Override
    public int hashCode() {
        int result = (int) (projectId ^ (projectId >>> 32));
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + date.hashCode();
        result = 31 * result + hours;
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }
}
