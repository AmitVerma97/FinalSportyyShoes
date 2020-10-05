package com.api.sportyyshoes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.annotation.PostConstruct;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	@Id
	//@GeneratedValue
	private int id;
	private String name;
	private String date;
	@OneToMany(targetEntity = Shoe.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="cusProForeignKey",referencedColumnName = "id")
	List<Shoe> shoes;
	
	
	//////////////////
	
	

}