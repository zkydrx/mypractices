package com.zhihei.jdk8.methodreference;

/**
 * @author ZKY
 * @createTime 2019/7/6 13:21
 * @description
 */

public class StudentComparator {

	/**
	 * 根据分数比较
	 *
	 * @param student1
	 * @param student2
	 * @return
	 */
	public int comparatorStudentByScore(Student student1, Student student2) {
		return student1.getScore() - student2.getScore();
	}

	/**
	 * 根据名称比较
	 *
	 * @param student1
	 * @param student2
	 * @return
	 */
	public int comparatorStudentByName(Student student1, Student student2) {
		return student1.getName().compareToIgnoreCase(student2.getName());
	}
}
