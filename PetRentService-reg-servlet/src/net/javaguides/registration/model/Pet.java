package net.javaguides.registration.model;

public class Pet {
	private String Name;
	private String petType;
	private String backStory;
	private boolean isAvailable;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPetType() {
		return petType;
	}
	public void setPetType(String petType) {
		this.petType = petType;
	}
	public String getBackStory() {
		return backStory;
	}
	public void setBackStory(String backStory) {
		this.backStory = backStory;
	}
	public boolean isAvailable() {
		return isAvailable;
	}
	public void isAvaialble(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
