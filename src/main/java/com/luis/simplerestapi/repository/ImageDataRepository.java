package com.luis.simplerestapi.repository;

import com.luis.simplerestapi.model.ImageData;
import org.hibernate.annotations.SecondaryRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


public interface ImageDataRepository extends JpaRepository<ImageData, Long> {

    Optional<ImageData> findByName(String name);
}
