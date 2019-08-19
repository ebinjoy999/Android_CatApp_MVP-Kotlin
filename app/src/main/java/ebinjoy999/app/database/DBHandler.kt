package ebinjoy999.app.database

import android.database.sqlite.SQLiteDatabase
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import ebinjoy999.app.screens.home.model.CatBreed


/**
 * Created by ebinjoy999 on 04/06/19.
 */
class DBHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    val getItems: List<CatBreed>
        get() {
            val entriesCatBreed = ArrayList<CatBreed>()
            val selectQuery = "SELECT  * FROM $TABLE_ITEM_ENTRIES"

            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)
            if (cursor.moveToFirst()) {
//                do {
//                    val entry = CatBreed(
//                            cursor.getString(0),
//                            cursor.getString(1),
//                            cursor.getString(2),
//                            cursor.getString(3),
//                            cursor.getString(4),
//                            cursor.getString(5),
//                            cursor.getString(6),
//                            cursor.getString(7),
//                            cursor.getString(8),
//                            cursor.getString(9),
//                            cursor.getString(10),
//                            cursor.getString(11),
//                            cursor.getString(12),
//                            cursor.getString(13),
//                            cursor.getString(14),
//                            cursor.getString(15),
//                            cursor.getString(16))

//                    entriesCatBreed.add(entry)

//                } while (cursor.moveToNext())
            }
            return entriesCatBreed
        }


    // Getting students count
    // return count
    val studentsCount: Int
        get() {
            val countQuery = "SELECT  * FROM $TABLE_ITEM_ENTRIES"
            val db = this.readableDatabase
            val cursor = db.rawQuery(countQuery, null)
            cursor.close()
            return cursor.count
        }

    //This method will be called every-time the file is called.
    override fun onCreate(db: SQLiteDatabase) {
        //Query to create table
        val CREATE_STUDENTS_TABLE = ("CREATE TABLE IF NOT EXISTS "
                + TABLE_ITEM_ENTRIES + "("
                + KEY_emp_key + " TEXT, "
                + KEY_emp_name + " TEXT, "
                + KEY_work_hour + " TEXT,"
                + KEY_work_minute + " TEXT,"
                + KEY_week_hour + " TEXT,"
                + KEY_week_minute_ + " TEXT,"
                + KEY_w1 + " TEXT,"
                + KEY_w2 + " TEXT,"
                + KEY_w3 + " TEXT,"
                + KEY_w4 + " TEXT,"
                + KEY_cl + " TEXT,"
                + KEY_el + " TEXT,"
                + KEY_ml + " TEXT,"
                + KEY_mgr_pending + " TEXT,"
                + KEY_you_pending + " TEXT,"
                + KEY_updated_at + " TEXT  PRIMARY KEY,"
                + KEY_leave_status + " TEXT"
                + ")")

        //Create table query executed in sqlite
        db.execSQL(CREATE_STUDENTS_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        //This method will be called only if there is change in DATABASE_VERSION.

        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS $TABLE_ITEM_ENTRIES")

        // Create tables again
        onCreate(db)
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    fun addCatBreedEntry(CatBreed: CatBreed) {
        val db = this.writableDatabase

        //Content values use KEY-VALUE pair concept
        val values = ContentValues()
//        values.put(KEY_emp_key, CatBreed.empKey)
//        values.put(KEY_emp_name, CatBreed.empName)
//        values.put(KEY_work_hour, CatBreed.workHour)
//        values.put(KEY_work_minute, CatBreed.workMinute)
//        values.put(KEY_week_hour, CatBreed.weekHour)
//        values.put(KEY_week_minute_, CatBreed.weekMinute)
//        values.put(KEY_w1, CatBreed.w1)
//        values.put(KEY_w2, CatBreed.w2)
//        values.put(KEY_w3, CatBreed.w3)
//        values.put(KEY_w4, CatBreed.w4)
//        values.put(KEY_cl, CatBreed.cl)
//        values.put(KEY_el, CatBreed.el)
//        values.put(KEY_ml, CatBreed.ml)
//        values.put(KEY_mgr_pending, CatBreed.mgrPending)
//        values.put(KEY_you_pending, CatBreed.youPending)
//        values.put(KEY_updated_at, CatBreed.updatedAt)
//        values.put(KEY_leave_status, CatBreed.leaveStatus)
        db.insert(TABLE_ITEM_ENTRIES, null, values)
        db.close()
    }

    // Getting single student details through ID
    fun getLastEntry(): CatBreed {

        val db = this.readableDatabase


        //You can browse to the query method to know more about the arguments.
        val cursor = db.query(TABLE_ITEM_ENTRIES,
                arrayOf(KEY_emp_key,
                         KEY_emp_name,
                         KEY_work_hour,
                         KEY_work_minute,
                         KEY_week_hour,
                         KEY_week_minute_,
                         KEY_w1,
                         KEY_w2,
                         KEY_w3,
                         KEY_w4,
                         KEY_cl,
                         KEY_el,
                         KEY_ml,
                         KEY_mgr_pending ,
                         KEY_you_pending,
                         KEY_updated_at,
                         KEY_leave_status ),
                null,
                null, null, null, null, null)

        cursor?.moveToLast()

//Return Student
        return CatBreed(
//                cursor.getString(0),
//                cursor.getString(1),
//                cursor.getString(2),
//                cursor.getString(3),
//                cursor.getString(4),
//                cursor.getString(5),
//                cursor.getString(6),
//                cursor.getString(7),
//                cursor.getString(8),
//                cursor.getString(9),
//                cursor.getString(10),
//                cursor.getString(11),
//                cursor.getString(12),
//                cursor.getString(13),
//                cursor.getString(14),
//                cursor.getString(15),
//                cursor.getString(16)
 )
    }

    // Updating single student
    fun asa(CatBreed: CatBreed) {
//        val db = this.writableDatabase
//
//        val values = ContentValues()
//        values.put(KEY_STUDENT_NAME, student.getStudentName())
//        values.put(KEY_STUDENT_EMAIL, student.getStudentEmail())
//
//        // updating student row
//        return db.update(TABLE_ITEM_ENTRIES,
//                values,
//                "$KEY_STUDENT_ID = ?",
//                arrayOf(String.valueOf(student.getStudentID())))
    }

    // Deleting single student
    fun deleteStudent(CatBreed: CatBreed) {

//        val db = this.writableDatabase
//        db.delete(TABLE_ITEM_ENTRIES, "$KEY_STUDENT_ID = ?",
//                arrayOf(String.valueOf(student.getStudentID())))
//        db.close()
    }

    companion object {
        //Database version.
        //Note: Increase the database version every-time you make changes to your table structure.
        private val DATABASE_VERSION = 1

        //Database Name
        private val DATABASE_NAME = "Items"

        //You will declare all your table names here.
        private val TABLE_ITEM_ENTRIES = "itementries";

        //var a :String = CatBreed::class.java.declaredFields.forEach { a in String: Field -> a.name }

        // Students Table Columns names
        private val KEY_emp_key = "emp_key"
        private val KEY_emp_name = "emp_name"
        private val KEY_work_hour = "work_hour"
        private val KEY_work_minute = "work_minute"
        private val KEY_week_hour = "week_hour"
        private val KEY_week_minute_ = "week_minute"
        private val KEY_w1 = "w1"
        private val KEY_w2 = "w2"
        private val KEY_w3 = "w3"
        private val KEY_w4 = "w4"
        private val KEY_cl = "cl"
        private val KEY_el = "el"
        private val KEY_ml = "ml"
        private val KEY_mgr_pending = "mgr_pending"
        private val KEY_you_pending = "you_pending"
        private val KEY_updated_at = "updated_at"
        private val KEY_leave_status = "leave_status"

    }

}
