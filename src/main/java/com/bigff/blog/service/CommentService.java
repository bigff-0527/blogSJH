package com.bigff.blog.service;

import com.bigff.blog.po.Comment;

import java.util.List;

public interface CommentService {

        List<Comment> listCommentByBlogId(Long id);

        Comment saveComment(Comment comment);
}
