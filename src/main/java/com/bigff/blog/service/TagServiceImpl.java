package com.bigff.blog.service;

import com.bigff.blog.NotFoundException;
import com.bigff.blog.dao.TagRepository;
import com.bigff.blog.po.Tag;
import groovyjarjarantlr.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Transactional
    @Override
    public Tag saveTag(Tag tag) {

        return tagRepository.save(tag);
    }

    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagRepository.findOne(id);
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {

        return tagRepository.findAll(pageable);
    }

    @Override
    public List<Tag> listTag() {
        return tagRepository.findAll();
    }

    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) {
        Tag t = tagRepository.findOne(id);
        if (t==null){
            throw new NotFoundException("不存在该类型");
        }
        BeanUtils.copyProperties(tag,t);
        return tagRepository.save(t);
    }

    @Transactional
    @Override
    public void delectTag(Long id) {
        tagRepository.delete(id);
    }

    @Override
    public Tag getTagByName(String name) {
        return tagRepository.findByName(name);
    }

    @Override
    public List<Tag> listTag(String ids) {
        return tagRepository.findAll(converToList(ids));
    }

    @Override
    public List<Tag> listTagTop(Integer size) {
        Sort sort = new Sort(Sort.Direction.DESC,"blogs.size");
        Pageable pageable = new PageRequest(0,size,sort);
        return tagRepository.findTop(pageable);
    }

//    @Override
//    public String tagids(List<Tag> list) {
//
//        String ids = "";
//        for (int i = 0 ;i<list.size();i++){
//            if (!"".equals(list.get(i).getId()) && list.get(i).getId()!=null && list.size()>1){
//                ids +=","+ list.get(i).getId();
//            }else{
//                ids += list.get(i).getId();
//            }
//        }
//        return ids;
//    }

    private  List<Long> converToList(String ids){

        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids!=null){
            String[] idarray = ids.split(",");
            for (int i = 0 ;i<idarray.length;i++){
                list.add(new Long(idarray[i]));
            }

        }
        return list;

    }
}
