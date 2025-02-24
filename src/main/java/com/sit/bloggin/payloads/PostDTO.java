package com.sit.bloggin.payloads;

import com.sit.bloggin.entities.Category;
import com.sit.bloggin.entities.Comment;
import com.sit.bloggin.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class PostDTO {
    private Integer postId;
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private CategoryDTO category;
    private UserDto user;
    private List<CommentDTO> comments = new ArrayList<>();

}
