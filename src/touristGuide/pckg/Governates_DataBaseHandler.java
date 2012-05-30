package touristGuide.pckg;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Governates_DataBaseHandler extends SQLiteOpenHelper {

	// All Static variables
	// Database Version
	private static final int DATABASE_VERSION = 1;

	// Database Name
	private static final String DATABASE_NAME = "touristGuide";

	// Contacts table name
	private static final String TABLE_GOVERNATES = "governates";

	// Contacts Table Columns names
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";

	public Governates_DataBaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	// Creating Tables
	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_GOVERNATES_TABLE = "CREATE TABLE " + TABLE_GOVERNATES + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT," + ")";
		db.execSQL(CREATE_GOVERNATES_TABLE);
	}

	// Upgrading database
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// Drop older table if existed
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_GOVERNATES);

		// Create tables again
		onCreate(db);
	}

	/**
	 * All CRUD(Create, Read, Update, Delete) Operations
	 */
	// Adding new governate
	void addGovernate(Governates governate) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, governate.getName()); // Contact Name

		// Inserting Row
		db.insert(TABLE_GOVERNATES, null, values);
		db.close(); // Closing database connection
	}

	// Getting single governate
	Governates getGovernate(int id) {
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor cursor = db.query(TABLE_GOVERNATES, new String[] { KEY_ID,
				KEY_NAME }, KEY_ID + "=?", new String[] { String.valueOf(id) },
				null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();

		Governates governate = new Governates(Integer.parseInt(cursor
				.getString(0)), cursor.getString(1));
		// return contact
		return governate;
	}

	// Getting All Governates
	public List<Governates> getAllGovernates() {
		List<Governates> GovernateList = new ArrayList<Governates>();
		// Select All Query
		String selectQuery = "SELECT  * FROM " + TABLE_GOVERNATES;

		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);

		// looping through all rows and adding to list
		if (cursor.moveToFirst()) {
			do {
				Governates governate = new Governates();
				governate.setID(Integer.parseInt(cursor.getString(0)));
				governate.setName(cursor.getString(1));
				// Adding contact to list
				GovernateList.add(governate);
			} while (cursor.moveToNext());
		}

		// return contact list
		return GovernateList;
	}

	// Updating single contact
	public int updateGovernate(Governates governate) {
		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(KEY_NAME, governate.getName());

		// updating row
		return db.update(TABLE_GOVERNATES, values, KEY_ID + " = ?",
				new String[] { String.valueOf(governate.getID()) });
	}

	// Deleting single contact
	public void deleteContact(Governates governate) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_GOVERNATES, KEY_ID + " = ?",
				new String[] { String.valueOf(governate.getID()) });
		db.close();
	}

	// Getting contacts Count
	public int getContactsCount() {
		String countQuery = "SELECT  * FROM " + TABLE_GOVERNATES;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();

		// return count
		return cursor.getCount();
	}
}
