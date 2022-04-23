package edu.school21.cinema.services;

import edu.school21.cinema.models.Session;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.SessionRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public void saveSession(User user, String ip) {
        Session session = new Session();
        session.setUserId(user.getId());
        session.setDate(LocalDate.now());
        session.setTime(LocalTime.now());
        session.setIp(ip);
        sessionRepository.save(session);
    }

    public List<Session> getAllUserSession(User user) {
        return sessionRepository.findAllByUserid(user.getId());
    }
}
