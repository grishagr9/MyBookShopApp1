package com.example.MyBookShopApp.services;

import com.example.MyBookShopApp.dto.TagsDto;
import com.example.MyBookShopApp.entity.Book;
import com.example.MyBookShopApp.entity.TagsEntity;
import com.example.MyBookShopApp.entity.book.links.Book2TagEntity;
import com.example.MyBookShopApp.repositories.Book2TagRepository;
import com.example.MyBookShopApp.repositories.BookRepository;
import com.example.MyBookShopApp.repositories.TagsRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class TagService {

    private final TagsRepository tagsRepository;
    private final Book2TagRepository book2TagRepository;
    private final BookRepository bookRepository;

    public List<TagsDto> getAllTags() {
        final List<TagsEntity> tagsEntity = tagsRepository.findAll();
        return toDtoList(tagsEntity);
    }

    public List<Book> getBooksFromTag(String nameTag){
        List<Book> list = new ArrayList<>();
        TagsEntity tagsEntity = tagsRepository.getTagsEntitiesByName(nameTag);
        if(tagsEntity==null){
            return list;
        }
        //Logger.getLogger(TagService.class.getSimpleName()).info(tagsEntity.getName());
        List<Book2TagEntity> booksId = book2TagRepository.getBook2TagEntitiesByTagId(tagsEntity.getId());
        //Logger.getLogger(TagService.class.getSimpleName()).info(tagsEntity.getName() + " " + booksId.size());
        for (int i = 0; i <booksId.size(); i++) {
            list.add(bookRepository.findBookById(booksId.get(i).getBookId()));
        }
        return list;
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
        if(tagsEntity!=null) {
            TagsDto tagsDto = new TagsDto();
            tagsDto.setName(tagsEntity.getName());
            tagsDto.setCountBooks(tagsEntity.getId());
            Integer countBooks = book2TagRepository.countBook2TagEntitiesByTagId(tagsEntity.getId());
            tagsDto.setCountBooks(countBooks);
            tagsDto.setTagClass(getClassOfTag(countBooks));

            Logger.getLogger(TagService.class.getSimpleName()).info(
                    "name: " + tagsEntity.getName() + " count: " + countBooks.toString());
            return tagsDto;
        }
        return new TagsDto();
    }

    private String getClassOfTag(Integer count){
        if(count <= 40){
            return "Tag_xs";
        }
        if(count <= 46){
            return "Tag_sm";
        }
        if(count <= 54){
            return "Tag_md";
        }
        return "Tag_lg";
    }


}
