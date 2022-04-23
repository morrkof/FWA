package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Image;
import edu.school21.cinema.models.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ImageRepositoryImpl implements ImageRepository {

    private final JdbcTemplate jdbcTemplate;

    public ImageRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    private final RowMapper<Image> imageRowMapper = (resultSet, rowNum) -> {
        return new Image(resultSet.getLong("id"),
                resultSet.getLong("userid"),
                resultSet.getString("original_name"),
                resultSet.getString("unique_name"),
                resultSet.getString("filepath"),
                resultSet.getLong("filesize"),
                resultSet.getString("mimetype"));
    };

    @Override
    public Optional<Image> findById(Long id) {
        try {
            Image image = jdbcTemplate.queryForObject("SELECT * FROM image WHERE id = ?", imageRowMapper, id);
            return Optional.ofNullable(image);
        } catch (DataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<Image> findAll() {
        return jdbcTemplate.query("SELECT * FROM image", imageRowMapper);
    }

    @Override
    public void save(Image image) {
        jdbcTemplate.update("INSERT INTO image (userid, original_name, unique_name, filepath, filesize, mimetype) VALUES (?, ?, ?, ?, ?, ?)",
                image.getUserId(), image.getOriginalName(), image.getUniqueName(), image.getFilepath(), image.getSize(), image.getMimetype());
    }

    @Override
    public int saveAndReturn(Image image) {
        return jdbcTemplate.update("INSERT INTO image (userid, original_name, unique_name, filepath, filesize, mimetype) VALUES (?, ?, ?, ?, ?, ?) RETURNING id",
                image.getUserId(), image.getOriginalName(), image.getUniqueName(), image.getFilepath(), image.getSize(), image.getMimetype());
    }

    @Override
    public void update(Image image) {
        jdbcTemplate.update("UPDATE image SET userid = ?, original_name = ?, unique_name = ?, filepath = ?, filesize = ?, mimetype = ? WHERE id = ?",
                image.getUserId(), image.getOriginalName(), image.getUniqueName(), image.getFilepath(), image.getSize(), image.getMimetype(), image.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM image WHERE id = ?", id);

    }

    @Override
    public List<Image> findAllByUserid(long userid) {
        return jdbcTemplate.query("SELECT * FROM image WHERE userid = ? ORDER BY id DESC", imageRowMapper, userid);
    }
}
