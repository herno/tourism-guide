package touristGuide.pckg;

public class Historic_Places {

	// private variables
	int _place_id;
	String _place_name;
	int _governate_id;

	// Empty constructor
	public Historic_Places() {

	}

	// constructor
	public Historic_Places(int id, String name, int governate_id) {
		this._place_id = id;
		this._place_name = name;
		this._governate_id =governate_id;
	}

	// constructor
	public Historic_Places(String name, int governate_id) {
		this._place_name = name;
		this._governate_id = governate_id;
	}

	// getting ID
	public int getID() {
		return this._place_id;
	}

	// setting id
	public void setID(int id) {
		this._place_id = id;
	}

	// getting name
	public String getName() {
		return this._place_name;
	}

	// setting name
	public void setName(String name) {
		this._place_name = name;
	}

	// getting phone number
	public int getGovernateID() {
		return this._governate_id;
	}

	// setting phone number
	public void setGovernateID(int governate_id) {
		this._governate_id = governate_id;
	}
}