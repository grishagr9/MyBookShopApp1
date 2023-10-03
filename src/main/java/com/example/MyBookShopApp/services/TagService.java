package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.TagsDto;
import com.example.MyBookShopApp.repositories.TagsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagsRepository tagsRepository;


    public List<TagsDto> getAllTags() {
        return tagsRepository.findAll();
    }

}
