package com.example.voting_sys2.entity;


import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="polls")
public class Poll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="question")
	private String question;
	
	@OneToMany(mappedBy = "poll", cascade = CascadeType.ALL)
	private List<Option> optionList = new ArrayList<>();


	
	public Poll() {
		super();
	}
	
	

	public Poll(int id, String question, List<Option> optionList) {
		super();
		this.id = id;
		this.question = question;
		this.optionList =optionList;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<Option> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<Option> optionList) {
		this.optionList = optionList;
	}
	
	
	
}
