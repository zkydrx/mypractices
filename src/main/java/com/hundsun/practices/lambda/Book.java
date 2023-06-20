package com.hundsun.practices.lambda;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.hundsun.practices.lambda
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/6/2 19:46
 * @UpdateUser: zky
 * @UpdateDate: 2021/6/2 19:46
 * @UpdateRemark: The modified content
 * @DATE: 2021-06-02 19:46
 * @SINCE:
 * @Version: 1.0
 *           <p>
 *           Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	private Integer releaseYear;
	private String name;
}
