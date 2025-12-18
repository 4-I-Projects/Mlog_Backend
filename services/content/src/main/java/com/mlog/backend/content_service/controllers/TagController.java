package com.mlog.backend.content_service.controllers;

import com.mlog.backend.content_service.dtos.responses.TagResponse;
import com.mlog.backend.content_service.entities.Tag;
import com.mlog.backend.content_service.services.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tags")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping
    public ResponseEntity<List<TagResponse>> getAllTags() {
        List<TagResponse> tags = tagService.getAllTags().stream().map(tag -> TagResponse.builder()
                .id(tag.getId())
                .name(tag.getName())
                .description(tag.getDescription())
                .createdAt(tag.getCreatedAt())
                .updatedAt(tag.getUpdatedAt())
                .createdBy(tag.getCreatedBy())
                .updatedBy(tag.getUpdatedBy())
                .build()).collect(Collectors.toList());
        return ResponseEntity.ok(tags);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagResponse> getTagById(@PathVariable Long id) {
        return tagService.getTagById(id).map(tag -> ResponseEntity.ok(TagResponse.builder()
                .id(tag.getId())
                .name(tag.getName())
                .description(tag.getDescription())
                .createdAt(tag.getCreatedAt())
                .updatedAt(tag.getUpdatedAt())
                .createdBy(tag.getCreatedBy())
                .updatedBy(tag.getUpdatedBy())
                .build())).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<TagResponse> createTag(@RequestBody Tag tag) {
        Tag createdTag = tagService.createTag(tag);
        TagResponse response = TagResponse.builder()
                .id(createdTag.getId())
                .name(createdTag.getName())
                .description(createdTag.getDescription())
                .createdAt(createdTag.getCreatedAt())
                .updatedAt(createdTag.getUpdatedAt())
                .createdBy(createdTag.getCreatedBy())
                .updatedBy(createdTag.getUpdatedBy())
                .build();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagResponse> updateTag(@PathVariable Long id, @RequestBody Tag tag) {
        try {
            Tag updatedTag = tagService.updateTag(id, tag);
            TagResponse response = TagResponse.builder()
                    .id(updatedTag.getId())
                    .name(updatedTag.getName())
                    .description(updatedTag.getDescription())
                    .createdAt(updatedTag.getCreatedAt())
                    .updatedAt(updatedTag.getUpdatedAt())
                    .createdBy(updatedTag.getCreatedBy())
                    .updatedBy(updatedTag.getUpdatedBy())
                    .build();
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }
}
