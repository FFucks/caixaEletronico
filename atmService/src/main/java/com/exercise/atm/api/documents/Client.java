package com.exercise.atm.api.documents;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Client {
	
	@Id
	private String id;
	
	@NotNull(message = "Name cannot be null")
	@NotEmpty(message = "Name cannot be empty")
	private String name;
	
	@NotNull(message = "Name cannot be null")
	@NotEmpty(message = "Name cannot be empty")
	private String account;
	
	@NotNull(message = "limit cannot be null")
	private int limit;
	
	private int cash;
	
	private BankNotes bankNotes;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public BankNotes getBankNotes() {
		return bankNotes;
	}

	public void setBankNotes(BankNotes bankNotes) {
		this.bankNotes = bankNotes;
	}

	public int getCash() {
		return cash;
	}

	public void setCash(int cash) {
		this.cash = cash;
	}
	

}
