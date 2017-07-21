package com.bridgeit.toDoApp.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

/**
 * This is simple POJO to represent ToDoTask entity in our application, we will be
 * dealing with ToDoTask entity to save, retrieve and delete data using Spring
 * Restful Web Services. We have annotated the class with Hibernate annotations
 * to make hibernate aware of the entity.
 * 
 * @version 1.8Jdk
 * @since 2017-03-23.
 * @author bridgeit Satyendra Singh.
 */
@Entity
@Table
public class ToDoTask  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GenericGenerator(name="any", strategy="increment")
	@GeneratedValue(generator="any")
	private int id;
	private String title;
	private String description;
	private Date date;
	private Date reminder;
	private boolean pinCard;
	private boolean archive;
	private Boolean isShare;
	private String cardColor;
	private int cardIndex;
	
	@ManyToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="user_Id")
	private User user;
	
	
	public ToDoTask() {	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getReminder() {
		return reminder;
	}

	public void setReminder(Date reminder) {
		this.reminder = reminder;
	}

	public String getCardColor() {
		return cardColor;
	}
	
	public void setCardColor(String cardColor) {
		this.cardColor = cardColor;
	}

	public boolean isPinCard() {
		return pinCard;
	}

	public void setPinCard(boolean pinCard) {
		this.pinCard = pinCard;
	}

	public boolean isArchive() {
		return archive;
	}

	public void setArchive(boolean archive) {
		this.archive = archive;
	}
	
	public int getCardIndex() {
		return cardIndex;
	}

	public void setCardIndex(int cardIndex) {
		this.cardIndex = cardIndex;
	}
	
	public Boolean getIsShare() {
		return isShare;
	}

	
	public void setIsShare(Boolean isShare) {
		this.isShare = isShare;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ToDoTask [id=" + id + ", title=" + title + ", description=" + description + ", date=" + date
				+ ", reminder=" + reminder + ", pinCard=" + pinCard + ", archive=" + archive + ", isShare=" + isShare
				+ ", cardColor=" + cardColor + ", cardIndex=" + cardIndex + ", user=" + user + "]";
	}
	

}
