package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.TagsDto;
import com.example.MyBookShopApp.entity.TagsEntity;
import com.example.MyBookShopApp.repositories.TagsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagsRepository tagsRepository;

    public List<TagsDto> getAllTags() {
        final List<TagsEntity> tagsEntity = tagsRepository.findAll();
        return toDtoList(tagsEntity);
    }

    //todo это маппер написанный руками, но best practice  - это mapstruct
    //todo мы получаем из базы сущность, а их потом дто передаем дальше - так нужно и так правильно
    List<TagsDto> toDtoList(List<TagsEntity> tagsEntity) {
        final List<TagsDto> tagsDto = new ArrayList<>(tagsEntity.size());
        for (TagsEntity tags : tagsEntity) {
            tagsDto.add(toDto(tags));
        }
        return tagsDto;
    }

    public TagsDto toDto(TagsEntity tagsEntity) {
        TagsDto tagsDto = new TagsDto();
        tagsDto.setName(tagsEntity.getName());
        tagsDto.setCountBooks(tagsEntity.getId());
        return tagsDto;
    }
}
