package com.luis.simplerestapi.service;

import com.luis.simplerestapi.model.ImageData;
import com.luis.simplerestapi.repository.ImageDataRepository;
import com.luis.simplerestapi.utils.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageDataServiceImpl implements ImageDataService {

    @Autowired
    private ImageDataRepository repository;

    @Override
    public String uploadImage(MultipartFile file) throws IOException {

        ImageData imageData = repository.save(
                ImageData.builder()
                        .name(file.getName())
                        .format(file.getContentType())
                        .fileData(ImageUtils.compressImage(file.getBytes()))
                        .build());
        return ("Image was successfully stored in the database: " + file.getOriginalFilename());
    }

    @Override
    public byte[] dowloadImage(Long id) {
        Optional<ImageData> databaseImageData = repository.findById(id);
        byte[] images = ImageUtils.decompressImage(databaseImageData.get().getFileData());
        return images;
    }


}
