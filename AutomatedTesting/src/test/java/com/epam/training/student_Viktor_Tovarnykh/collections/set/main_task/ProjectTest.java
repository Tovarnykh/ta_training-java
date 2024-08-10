package com.epam.training.student_Viktor_Tovarnykh.collections.set.main_task;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.epam.training.student_viktor_tovarnykh.collections.set.main_task.Project;
import com.epam.training.student_viktor_tovarnykh.collections.set.main_task.Skill;
import com.epam.training.student_viktor_tovarnykh.collections.set.main_task.Level;
import com.epam.training.student_viktor_tovarnykh.collections.set.main_task.Position;
import com.epam.training.student_viktor_tovarnykh.collections.set.main_task.Role;
import com.epam.training.student_viktor_tovarnykh.collections.set.main_task.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author D. Kolesnikov
 */
class ProjectTest {
	
	@Test
	void test1() {
		Project project = new Project(new Role(Position.DEVELOPER, Level.A1, Skill.JAVA, Skill.DATABASE),
				new Role(Position.KEY_DEVELOPER, Level.A2, Skill.JAVA, Skill.DATABASE, Skill.SPRING),
				new Role(Position.TESTER, Level.A3, Skill.TESTING_TOOLS, Skill.AWS), new Role(Position.TESTER, Level.A3, Skill.AWS));

		Set<Member> team = new HashSet<>(Arrays.asList(new Member("Name1", Level.A1, Skill.JAVA, Skill.DATABASE),
				new Member("Name2", Level.A2, Skill.JAVA, Skill.DATABASE, Skill.SPRING),
				new Member("Name3", Level.A3, Skill.TESTING_TOOLS, Skill.AWS), new Member("Name4", Level.A3, Skill.TESTING_TOOLS)));

		int expected = 87;
		int actual = project.getConformity(team);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void test2() {
		Project project = new Project(new Role(Position.DEVELOPER, Level.A1, Skill.JAVA, Skill.DATABASE),
				new Role(Position.TESTER, Level.A3, Skill.TESTING_TOOLS, Skill.AWS), new Role(Position.TESTER, Level.A3, Skill.AWS));

		Set<Member> team = new HashSet<>(Arrays.asList(new Member("Name1", Level.A1, Skill.JAVA, Skill.DATABASE),
				new Member("Name2", Level.A2, Skill.JAVA, Skill.DATABASE, Skill.SPRING),
				new Member("Name3", Level.A3, Skill.TESTING_TOOLS, Skill.AWS)));

		int expected = 80;
		int actual = project.getConformity(team);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void test3() {
		Project project = new Project(new Role(Position.DEVELOPER, Level.A1, Skill.JAVA),
				new Role(Position.KEY_DEVELOPER, Level.A2, Skill.JAVA), new Role(Position.TESTER, Level.A3, Skill.TESTING_TOOLS),
				new Role(Position.TESTER, Level.A3, Skill.AWS));

		Set<Member> team = new HashSet<>(Arrays.asList(new Member("Name1", Level.A1, Skill.JAVA, Skill.DATABASE),
				new Member("Name2", Level.A2, Skill.JAVA, Skill.DATABASE), new Member("Name4", Level.A3, Skill.TESTING_TOOLS)));

		int expected = 75;
		int actual = project.getConformity(team);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void test4() {
		Project project = new Project(new Role(Position.DEVELOPER, Level.A1, Skill.JAVA));

		Set<Member> team = new HashSet<>(Arrays.asList(new Member("Name1", Level.A1, Skill.JAVA, Skill.JAVA)));

		int expected = 100;
		int actual = project.getConformity(team);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void test5() {
		Project project = new Project(new Role(Position.DEVELOPER, Level.A1, Skill.JAVA));

		Set<Member> team = new HashSet<>();

		int expected = 0;
		int actual = project.getConformity(team);
		Assertions.assertEquals(expected, actual);
	}

	@Test
	void test6() {
		Project project = new Project(new Role(Position.DEVELOPER, Level.A1, Skill.JAVA, Skill.DATABASE),
				new Role(Position.TESTER, Level.A3, Skill.TESTING_TOOLS, Skill.AWS), new Role(Position.TESTER, Level.A3, Skill.AWS));

		Set<Member> team = new HashSet<>(Arrays.asList(new Member("Name1", Level.A1, Skill.JAVA, Skill.DATABASE),
				new Member("Name4", Level.A3, Skill.TESTING_TOOLS)));

		int expected = 60;
		int actual = project.getConformity(team);
		Assertions.assertEquals(expected, actual);
	}
}
