package com.epam.training.student_Viktor_Tovarnykh.collections.set.main_task;

import java.util.EnumSet;

import com.epam.training.student_viktor_tovarnykh.collections.set.main_task.Level;
import com.epam.training.student_viktor_tovarnykh.collections.set.main_task.Member;
import com.epam.training.student_viktor_tovarnykh.collections.set.main_task.Skill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author D. Kolesnikov
 */
class MemberTest {

	//////////////////////////////////////////////////////////////////////////////

	private static boolean isAllTestsMustFailed;

	//////////////////////////////////////////////////////////////////////////////

	@Test
	void test1() {
		Member m = new Member("Name1", Level.A1, Skill.JAVA);
		Class<?> expected = EnumSet.class;
		Class<?> actual = m.getSkills().getClass().getSuperclass();
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void test2() {
		Member m = new Member("Name2", Level.A1, Skill.JAVA, Skill.DATABASE, Skill.SPRING);
		Class<?> expected = EnumSet.class;
		Class<?> actual = m.getSkills().getClass().getSuperclass();
		Assertions.assertEquals(expected, actual);
	}

}
