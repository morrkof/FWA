package edu.school21.cinema.models;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Session {

    private Long id;
    private long userId;
    private LocalDate date;
    private LocalTime time;
    private String ip;

    public Session() {
    }

    public Session(Long id, long userId, LocalDate date, LocalTime time, String ip) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.time = time;
        this.ip = ip;
    }

    public Session(long userId, LocalDate date, LocalTime time, String ip) {
        this.id = null;
        this.userId = userId;
        this.date = date;
        this.time = time;
        this.ip = ip;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id) && Objects.equals(userId, session.userId) && Objects.equals(date, session.date) && Objects.equals(time, session.time) && Objects.equals(ip, session.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, date, time, ip);
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", userId=" + userId +
                ", date=" + date +
                ", time=" + time +
                ", ip='" + ip + '\'' +
                '}';
    }
}
