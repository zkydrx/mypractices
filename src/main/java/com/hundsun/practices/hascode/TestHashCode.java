package com.hundsun.practices.hascode;

import cn.hutool.crypto.digest.MD5;

public class TestHashCode {
	public static void main(String[] args) {
		System.out.println("1111".hashCode());
		System.out.println(
				"0e306561559aa787d00bc6f70bbdfe3404cf03659e704f8534c00ffb659c4c8740cc942feb2da115a3f4155cbb8607497386656d7d1f34a42059d78f5a8dd1ef"
						.hashCode());
		System.out.println(
				"0e306561559aa787d00bc6f70bbdfe3404cf03659e744f8534c00ffb659c4c8740cc942feb2da115a3f415dcbb8607497386656d7d1f34a42059d78f5a8dd1ef"
						.hashCode());
		MD5 md5 = new MD5();
		System.out.println(md5.digest(
				"0e306561559aa787d00bc6f70bbdfe3404cf03659e704f8534c00ffb659c4c8740cc942feb2da115a3f4155cbb8607497386656d7d1f34a42059d78f5a8dd1ef")
				.toString());
		System.out.println(md5.digest(
				"0e306561559aa787d00bc6f70bbdfe3404cf03659e744f8534c00ffb659c4c8740cc942feb2da115a3f415dcbb8607497386656d7d1f34a42059d78f5a8dd1ef")
				.toString());
	}
}
