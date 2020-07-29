package com.sakinramazan.userservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailSentWithAttachmentRequest extends EmailSentRequest {
    private String attachmentName;
    @NotEmpty(message = "Attachment path can not be empty")
    private String attachmentPath;
}
