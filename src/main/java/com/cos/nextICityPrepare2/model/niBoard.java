package com.cos.nextICityPrepare2.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="niBoard")
@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
		name="NIBOARD_SEQUENCE_GENERATOR_NI2_NIBOARD"
		,sequenceName = "NIBOARD_SEQ_NI_NIBOARD"
		,initialValue = 1
		,allocationSize = 1
		)
public class niBoard {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "NIBOARD_SEQUENCE_GENERATOR_NI2_NIBOARD")
	private int id;
	
	@Column(nullable=false,length=1000)
	private String title;
	
	@Lob
	private String content;
	
	private int count;
	
	@CreationTimestamp
	private Timestamp createTime;
	
	@JoinColumn(name="niUsers2")
	@OrderBy("id desc")
	@ManyToOne(fetch=FetchType.EAGER)
	private niUsers username;
	
	@OneToMany(mappedBy = "niBoard",fetch=FetchType.EAGER,cascade=CascadeType.REMOVE)
	@JsonIgnoreProperties({"niBoard"})
	private List<niReply> niReply;
}
