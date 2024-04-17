package com.blog.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @NotBlank(message = "First name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "First name can only contain alphabets")
    private String firstName;
    @NotBlank(message = "First name cannot be blank")
    @Pattern(regexp = "^[a-zA-Z]*$", message = "Last name can only contain alphabets")
    private String lastName;
    @Size(min = 10, max = 10, message = "Mobile number should be 10 digit")
    private String mobileNumber;

    @Email
    private String email;
    @NotEmpty
    @NotBlank(message = "Address cannot be blank")
    private String address;
    @Size(min = 12, message = "Age should be minimum 12")
    private Integer age;
    @NotEmpty
    private String role;
    @Enumerated
    private Gender gender;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, max = 12, message = "Password must be between 6 and 12 characters")
    @Pattern(regexp =  "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[#$@!%&*?])[A-Za-z\\d#$@!%&*?]{5,15}$",message = "password must contain atleast 1 uppercase, 1 lowercase, 1 special character and 1 digit")
    private String password;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

}
