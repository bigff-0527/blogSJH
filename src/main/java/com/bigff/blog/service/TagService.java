package com.bigff.blog.service;

import com.bigff.blog.po.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    Tag updateTag(Long id,Tag tag);

    void delectTag(Long id);

    Tag getTagByName (String name);

    List<Tag> listTag(String ids);

    List<Tag> listTagTop(Integer size);
//    String tagids(List<Tag> list);
}
