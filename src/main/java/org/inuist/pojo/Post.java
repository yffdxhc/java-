package org.inuist.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 18369
 * @date 2024/7/30 下午1:37
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    private Integer pid;
    private String ptitle;
    private String psummary;
    private String pcontent;
    private Integer uid;
    private Date pdate;
    private boolean pstatus;
}
