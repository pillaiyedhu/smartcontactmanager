package com.scm.scm.helpers;

import com.scm.scm.constant.MessageType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Message {

    private String content;
    @Builder.Default
    private MessageType type =MessageType.blue;

}
