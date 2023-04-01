package com.cos.nextICityPrepare2.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="niUsers2")
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
		name = "NIUSERS_SEQ_GENERATOR_NI2_NIUSERS"
		, sequenceName = "NIUSERS_SEQ_NI2_NIUSERS"
		, initialValue = 1
		, allocationSize = 1
		)

public class niUsers {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="NIUSERS_SEQ_GENERATOR_NI2_NIUSERS")
	private int id;
	
	@Column(length=100,unique=true)
	private String username;

	@Column(length=100)
	private String name;
	
	@Column(length=100)
	private String password;
	
	private String Roles;

}
