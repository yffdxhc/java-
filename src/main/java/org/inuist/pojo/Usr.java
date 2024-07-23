package org.inuist.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 18369
 * @date 2024/7/23 下午7:31
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usr {
    private Long uid;
    private String uname;
    private String upassword;
    private Boolean ustatus;
}
