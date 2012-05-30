package touristGuide.pckg;

public class Governates {

	// private variables
	int _governate_id;
	String _governate_name;

	// Empty constructor
	public Governates() {

	}

	// constructor
	public Governates(int id, String name) {
		this._governate_id = id;
		this._governate_name = name;

	}

	// constructor
	public Governates(String name) {
		this._governate_name = name;

	}

	// getting ID
	public int getID() {
		return this._governate_id;
	}

	// setting id
	public void setID(int id) {
		this._governate_id = id;
	}

	// getting name
	public String getName() {
		return this._governate_name;
	}

	// setting name
	public void setName(String name) {
		this._governate_name = name;
	}

}