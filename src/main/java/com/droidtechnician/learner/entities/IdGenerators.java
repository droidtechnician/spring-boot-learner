package com.droidtechnician.learner.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "id_gen")
public class IdGenerators {

	@Id
	@Column(name = "gen_name")
	private String genName;

	@Column(name = "gen_val")
	private Long gen_value;

	public IdGenerators(String genName, Long gen_value) {
		this.genName = genName;
		this.gen_value = gen_value;
	}

	public String getGenName() {
		return genName;
	}

	public void setGenName(String genName) {
		this.genName = genName;
	}

	public Long getGen_value() {
		return gen_value;
	}

	public void setGen_value(Long gen_value) {
		this.gen_value = gen_value;
	}

}
