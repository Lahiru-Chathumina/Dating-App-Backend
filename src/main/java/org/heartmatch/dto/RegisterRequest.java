
package org.heartmatch.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.heartmatch.entity.User;

import java.util.List;

/**
 * DTO used for user registration.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {

    @NotBlank(message = "First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters")
    private String password;

    private Integer age;

    private String gender;

    private String location;

    @Size(max = 1000, message = "Bio is too long")
    private String bio;

    private List<String> interests;

    private List<String> photos;

    private String lookingFor;

    /**
     * Convert this DTO to the JPA User entity.
     * Note: hashing the password should be done before saving the User.
     */
    public User toUserEntity() {
        User user = new User();
        user.setName((firstName == null ? "" : firstName) + (lastName == null ? "" : " " + lastName));
        user.setEmail(this.email);
        user.setPassword(this.password); // IMPORTANT: hash before saving
        if (this.age != null) user.setAge(this.age);
        user.setGender(this.gender);
        user.setLocation(this.location);
        user.setBio(this.bio);
        user.setInterests(this.interests);
        user.setPhotos(this.photos);
        user.setLookingFor(this.lookingFor);
        return user;
    }
}

