package com.rin.chat.dto;

import com.rin.chat.constant.MessageType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatMessage {
    String content;
    String sender;
    MessageType type;
}
