package com.mlog.user.client.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserRepresentation {
    private String firstName;
    private String lastName;
    private String email;
}

