package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.relational.core.mapping.Column;

import javax.validation.constraints.NotEmpty;

public class CatCard {
	//@JsonProperty(value = "id")
	//@Column(value = "id")
	public Long catCardId;
	@NotEmpty
	@JsonProperty(value = "fact")
	public String catFact;
	@NotEmpty
	public String imgUrl;
	@NotEmpty
	public String caption;

	public Long getCatCardId() {
		return catCardId;
	}
	public void setCatCardId(Long catCardId) {
		this.catCardId = catCardId;
	}
	
	public String getCatFact() {
		return catFact;
	}
	public void setCatFact(String catFact) {
		this.catFact = catFact;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getCaption() {
		return caption;
	}
	public void setCaption(String caption) {
		this.caption = caption;
	}
	
}
