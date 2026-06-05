package org.heartmatch.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProfileDTO {
    private Long id;
    private Long userId;
    private String firstName;
    private String lastName;
    private Integer age;
    private String gender;
    private String bio;
    private String location;
    private String profileImageUrl;
    private String interests;
    private Boolean verified;
}