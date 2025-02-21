package com.sit.bloggin.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
    private int id;

    @NotEmpty
    @Size(min = 4, message = "Name must be minimum 4 Characters long")
    private String name;

    @NotEmpty
    @Email(message = "Email address is not valid!")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "Password must be min 3 chars and max 10 chars")
    private String password;

    @NotEmpty
    private String about;
}
