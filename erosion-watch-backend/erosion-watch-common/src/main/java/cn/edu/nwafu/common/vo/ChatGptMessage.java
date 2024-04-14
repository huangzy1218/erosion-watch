package cn.edu.nwafu.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Huang Z.Y.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatGptMessage {
    String role;
    String content;
}
    