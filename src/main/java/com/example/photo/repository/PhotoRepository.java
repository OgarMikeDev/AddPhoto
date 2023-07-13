package com.example.photo.repository;

import com.example.photo.model.Photo;
import org.springframework.data.repository.CrudRepository;

@org.springframework.stereotype.Repository
public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
