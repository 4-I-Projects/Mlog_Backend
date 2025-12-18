package com.mlog.backend.content_service.services;

import com.mlog.backend.content_service.entities.Tag;
import com.mlog.backend.content_service.repositories.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    public Optional<Tag> getTagById(Long id) {
        return tagRepository.findById(id);
    }

    public Tag createTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public Tag updateTag(Long id, Tag updatedTag) {
        return tagRepository.findById(id).map(tag -> {
            tag.setName(updatedTag.getName());
            tag.setDescription(updatedTag.getDescription());
            return tagRepository.save(tag);
        }).orElseThrow(() -> new RuntimeException("Tag not found"));
    }

    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
