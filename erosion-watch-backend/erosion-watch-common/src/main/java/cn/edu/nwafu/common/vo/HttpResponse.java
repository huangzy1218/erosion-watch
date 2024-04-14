package cn.edu.nwafu.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Huang Z.Y.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HttpResponse {
    private String result;
    private boolean needClearHistory;
    private long created;
    private UsageInfo usage;
    private boolean isTruncated;
    private String id;
    private String object;

    public class UsageInfo {
        private int completionTokens;
        private int promptTokens;
        private int totalTokens;
    }
}
    