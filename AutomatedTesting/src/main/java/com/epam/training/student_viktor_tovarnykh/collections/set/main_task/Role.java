package com.epam.training.student_viktor_tovarnykh.collections.set.main_task;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Set;

public class Role {

	private Level level;

	private Position position;

	private Set<Skill> skills;

	public Role(Position position, Level level, Skill... skills) {
		this.position = position;
		this.level = level;
		this.skills = EnumSet.copyOf(Arrays.asList(skills));
	}

	public Set<Skill> getSkills() {
		return skills;
	}

	public Level getLevel() {
		return level;
	}

	public Position getPosition() {
		return position;
	}
	
}
