package com.sakinramazan.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailSentRequest {
    @NotEmpty(message = "Mail user can not be empty")
    private String mailUser;
    @NotEmpty(message = "Mail subject can not be empty")
    private String emailHeadline;
    private String mailDetails;

}
