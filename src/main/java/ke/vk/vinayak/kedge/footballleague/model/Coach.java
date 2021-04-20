package ke.vk.vinayak.kedge.footballleague.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Coach {

	@JsonProperty("coach_name")
	private String name;
	@JsonProperty("coach_country")
	private String country;
	@JsonProperty("coach_age")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
