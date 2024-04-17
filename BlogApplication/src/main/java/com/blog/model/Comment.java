package com.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentId;

    @NotBlank(message = "comment should not be blank")
    @NotEmpty
    private String contend;
    private LocalDate timeStamp;
    @ManyToOne
    private Post post;

    @ManyToOne
    @JoinColumn(name = "userId")
    @JsonIgnore
    private User User;

}
