package touristGuide.pckg;

public class Stories {

	// private variables
	int story_id;
	String story_describtion;
	int historical_place_id;

	// Empty constructor
	public Stories() {

	}

	// constructor
	public Stories(int id, String name, int historical_places_id) {
		this.story_id = id;
		this.story_describtion = name;
		this.historical_place_id = historical_places_id;
	}

	// constructor
	public Stories(String name, int historical_places_id) {
		this.story_describtion = name;
		this.historical_place_id = historical_places_id;
	}

	// getting ID
	public int getID() {
		return this.story_id;
	}

	// setting id
	public void setID(int id) {
		this.story_id = id;
	}

	// getting name
	public String getName() {
		return this.story_describtion;
	}

	// setting name
	public void setName(String name) {
		this.story_describtion = name;
	}

	// getting phone number
	public int getHistoricalPlace() {
		return this.historical_place_id;
	}

	// setting phone number
	public void setPhoneNumber(int historical_place_id) {
		this.historical_place_id = historical_place_id;
	}
}