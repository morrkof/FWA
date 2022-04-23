package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class SessionRepositoryImpl implements SessionRepository {

    private final JdbcTemplate jdbcTemplate;

    public SessionRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    private final RowMapper<Session> sessionRowMapper = (resultSet, rowNum) -> {
        return new Session(resultSet.getLong("id"),
                resultSet.getLong("userid"),
                resultSet.getDate("sessiondate").toLocalDate(),
                resultSet.getTime("sessiontime").toLocalTime(),
                resultSet.getString("ip"));
    };

    @Override
    public Optional<Session> findById(Long id) {
        try {
            Session session = jdbcTemplate.queryForObject("SELECT * FROM session WHERE id = ?", sessionRowMapper, id);
            return Optional.ofNullable(session);
        } catch (DataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Session> findAll() {
        return jdbcTemplate.query("SELECT * FROM session", sessionRowMapper);
    }

    @Override
    public void save(Session session) {
        jdbcTemplate.update("INSERT INTO session (userid, sessiondate, sessiontime, ip) VALUES (?, ?, ?, ?)",
                session.getUserId(), session.getDate(), session.getTime(), session.getIp());
    }

    @Override
    public void update(Session session) {
        jdbcTemplate.update("UPDATE session SET userid = ?, sessiondate = ?, sessiontime = ?, ip = ? WHERE id = ?",
                session.getUserId(), session.getDate(), session.getTime(), session.getIp(), session.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM session WHERE id = ?", id);
    }

    @Override
    public List<Session> findAllByUserid(long userid) {
        return jdbcTemplate.query("SELECT * FROM session WHERE userid = ? ORDER BY id DESC LIMIT 5", sessionRowMapper, userid);
    }
}
