package edu.school21.cinema.repositories;

import java.util.List;
import java.util.Optional;

public class ImageRepositoryImpl implements ImageRepository{
    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public void save(Object entity) {

    }

    @Override
    public void update(Object entity) {

    }

    @Override
    public void delete(Long id) {

    }
}
