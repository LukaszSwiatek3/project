package com.wevibe.project.tags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    @Autowired
    TagRepository tagRepository;

    @GetMapping("")
    public List<Tag> getAll() {
        return tagRepository.getAll();
    }

    @GetMapping("/event/{id}")
    public List<Tag> getAllForEvent(@PathVariable("id") Long id) {
        return tagRepository.getAllForEvent(id);
    }


    @GetMapping("/{id}")
    public Tag getTagById(@PathVariable("id") Long id) {
        return tagRepository.getTagById(id);
    }


    @PostMapping("")
    public int add(@RequestBody List<Tag> tags) {
        return tagRepository.save(tags);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody Tag updatedTag) {
        Tag tag = tagRepository.getTagById(id);

        if (tag != null) {
            tag.setNameTag(updatedTag.getNameTag());
            tag.setComment(updatedTag.getComment());

            tagRepository.update(tag);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") Long id, @RequestBody Tag updatedTag) {
        Tag tag = tagRepository.getTagById(id);

        if (tag != null) {
            if (updatedTag.getNameTag() != null) tag.setNameTag(updatedTag.getNameTag());
            if (updatedTag.getComment() != null) tag.setComment(updatedTag.getComment());

            tagRepository.update(tag);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id) {
        return tagRepository.delete(id);
    }

}
