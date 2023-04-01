package com.cos.nextICityPrepare2.model;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="niReply")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(
		name="NIREPLY_SEQUENCE_GENERATOR_NI2_NIREPLY"
		,sequenceName = "NIREPLY_SEQ_NI2_NIREPLY"
		,initialValue = 1
		,allocationSize = 1
		)
public class niReply {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="NIREPLY_SEQUENCE_GENERATOR_NI2_NIREPLY")
	private int id;
	
	@Column(nullable=false, length=200)
	private String content;
	
	@JoinColumn(name="niBoard")
	@ManyToOne
	private niBoard niBoard;
	
	@ManyToOne
	@JoinColumn(name="niUsers2")
	private niUsers username;
	
	@CreationTimestamp
	private Timestamp createTime;
}
