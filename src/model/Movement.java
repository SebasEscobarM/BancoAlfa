package model;

import java.time.LocalDate;

public class Movement {
	
	private String type;
	private double mount;
	private String comment;
	private LocalDate date;
	
	public Movement(String type, double mount, String comment, LocalDate date) {
		this.type=type;
		this.mount=mount;
		this.comment=comment;
		this.date=date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getMount() {
		return mount;
	}

	public void setMount(double mount) {
		this.mount = mount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
