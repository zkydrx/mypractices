package com.hundsun.practices.parsestr;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetTableFromStr {
    public static String extractTableNames(String sql) {
        String tableName = "[]";

        // 1. 匹配带有${ownername}前缀的表名
        Pattern pattern1 = Pattern.compile("\\$\\{ownername}(\\w+)");
        Matcher matcher1 = pattern1.matcher(sql);
        if (matcher1.find()) {
            tableName = matcher1.group(1);
        }
        // 2. 匹配带有数据库名和"."前缀的表名，数据库名前面是一个空格，空格前面是from
        if (tableName.equals("[]")) {
            Pattern pattern2 = Pattern.compile("from\\s+(\\w+)\\.(\\w+)");
            Matcher matcher2 = pattern2.matcher(sql);
            if (matcher2.find()) {
                tableName = matcher2.group(2);
            }
        }
        // 3. 匹配表名前有空格且空格前面是${ownername}的情况
        if (tableName.equals("[]")) {
            Pattern pattern3 = Pattern.compile("\\$\\{ownername}\\s+(\\w+)");
            Matcher matcher3 = pattern3.matcher(sql);
            if (matcher3.find()) {
                tableName = matcher3.group(1);
            }
        }
        // 4. 匹配表名前有空格且空格前面是from的情况
        if (tableName.equals("[]")) {
            Pattern pattern4 = Pattern.compile("from\\s+(\\w+)");
            Matcher matcher4 = pattern4.matcher(sql);
            if (matcher4.find()) {
                tableName = matcher4.group(1);
            }
        }

        return tableName;
    }

    public static void main(String[] args) {
        String sql1 = "select distinct * from (select b.parentproduct,a.companycode, a.abbrchiname, a.chiname, b.jsid from ${ownername}lc_instiarchive a inner join ${ownername}bond_ibmember b on a.companycode = b.parentcompany and b.ifeffected = 1)";
        String sql2 = "select * from abc.execinfo";
        String sql3 = "select * from ${ownername} execinfo";
        String sql4 = "select * from  execinfo";
        String tableNames1 = extractTableNames(sql1);
        String tableNames2 = extractTableNames(sql2);
        String tableNames3 = extractTableNames(sql3);
        String tableNames4 = extractTableNames(sql4);

        System.out.println("Table Names in sql1: " + tableNames1);
        System.out.println("Table Names in sql2: " + tableNames2);
        System.out.println("Table Names in sql3: " + tableNames3);
        System.out.println("Table Names in sql4: " + tableNames4);
    }
}
