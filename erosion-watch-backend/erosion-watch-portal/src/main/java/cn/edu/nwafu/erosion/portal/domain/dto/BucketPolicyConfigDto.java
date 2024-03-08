package cn.edu.nwafu.erosion.portal.domain.dto;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author Huang Z.Y.
 */
@Data
@EqualsAndHashCode
@Builder
public class BucketPolicyConfigDto {
    private String version;
    private List<Statement> statement;

    @Data
    @EqualsAndHashCode
    @Builder
    public static class Statement {
        private String effect;
        private String principal;
        private String action;
        private String resource;
    }
}
    