package com.design.atgg.own.composite;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: mypractices
 * @Package: com.design.atgg.own.composite
 * @Description: note
 * @Author: zky
 * @CreateDate: 2021/5/23 2:39
 * @UpdateUser: zky
 * @UpdateDate: 2021/5/23 2:39
 * @UpdateRemark: The modified content
 * @DATE: 2021-05-23 02:39
 * @SINCE:
 * @Version: 1.0
 * <p>
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public class Client
{
    public static void main(String[] args)
    {
        Organization country = new Country("中国", "中国威武");
        Organization alibaba = new Company("阿里巴巴", "电商帝国");
        Organization tencent = new Company("腾讯", "社交帝国");
        Organization byteDance = new Company("字节跳动", "短视频帝国");
        country.add(alibaba);
        country.add(tencent);
        country.add(byteDance);
        Organization aliTechnologyDepartMent = new Department("技术部", "底部支撑");
        Organization aliSalesDepartMent = new Department("运营部", "牛");
        Organization tencentCommerceDepartment = new Department("商务部", "南山必胜客");
        Organization byteDanceShortVideoBusinessDepartment = new Department("短视频业务", "支柱业务");
        alibaba.add(aliSalesDepartMent);
        alibaba.add(aliTechnologyDepartMent);
        tencent.add(tencentCommerceDepartment);
        byteDance.add(byteDanceShortVideoBusinessDepartment);

        country.print();
    }
}
