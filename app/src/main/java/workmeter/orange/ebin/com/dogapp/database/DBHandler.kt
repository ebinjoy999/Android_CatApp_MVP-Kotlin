package workmeter.orange.ebin.com.dogapp.database

import android.database.sqlite.SQLiteDatabase
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import workmeter.orange.ebin.com.dogapp.screens.login.model.Workmeter


/**
 * Created by ebinjoy999 on 04/06/19.
 */
class DBHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    val allStudents: List<Workmeter>
        get() {
            val entriesWorkmeter = ArrayList<Workmeter>()
            val selectQuery = "SELECT  * FROM $TABLE_WORKMETER_ENTRIES"

            val db = this.writableDatabase
            val cursor = db.rawQuery(selectQuery, null)
            if (cursor.moveToFirst()) {
                do {
                    val entry = Workmeter(
                            cursor.getString(0),
                            cursor.getString(1),
                            cursor.getString(2),
                            cursor.getString(3),
                            cursor.getString(4),
                            cursor.getString(5),
                            cursor.getString(6),
                            cursor.getString(7),
                            cursor.getString(8),
                            cursor.getString(9),
                            cursor.getString(10),
                            cursor.getString(11),
                            cursor.getString(12),
                            cursor.getString(13),
                            cursor.getString(14),
                            cursor.getString(15),
                            cursor.getString(16))

                    entriesWorkmeter.add(entry)
                } while (cursor.moveToNext())
            }
            return entriesWorkmeter
        }


    // Getting students count
    // return count
    val studentsCount: Int
        get() {
            val countQuery = "SELECT  * FROM $TABLE_WORKMETER_ENTRIES"
            val db = this.readableDatabase
            val cursor = db.rawQuery(countQuery, null)
            cursor.close()
            return cursor.count
        }

    //This method will be called every-time the file is called.
    override fun onCreate(db: SQLiteDatabase) {
        //Query to create table
        val CREATE_STUDENTS_TABLE = ("CREATE TABLE IF NOT EXISTS "
                + TABLE_WORKMETER_ENTRIES + "("
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
        db.execSQL("DROP TABLE IF EXISTS $TABLE_WORKMETER_ENTRIES")

        // Create tables again
        onCreate(db)
    }

    /**
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    fun addWorkMeterEntry(workmeter: Workmeter) {
        val db = this.writableDatabase

        //Content values use KEY-VALUE pair concept
        val values = ContentValues()
        values.put(KEY_emp_key, workmeter.empKey)
        values.put(KEY_emp_name, workmeter.empName)
        values.put(KEY_work_hour, workmeter.workHour)
        values.put(KEY_work_minute, workmeter.workMinute)
        values.put(KEY_week_hour, workmeter.weekHour)
        values.put(KEY_week_minute_, workmeter.weekMinute)
        values.put(KEY_w1, workmeter.w1)
        values.put(KEY_w2, workmeter.w2)
        values.put(KEY_w3, workmeter.w3)
        values.put(KEY_w4, workmeter.w4)
        values.put(KEY_cl, workmeter.cl)
        values.put(KEY_el, workmeter.el)
        values.put(KEY_ml, workmeter.ml)
        values.put(KEY_mgr_pending, workmeter.mgrPending)
        values.put(KEY_you_pending, workmeter.youPending)
        values.put(KEY_updated_at, workmeter.updatedAt)
        values.put(KEY_leave_status, workmeter.leaveStatus)
        db.insert(TABLE_WORKMETER_ENTRIES, null, values)
        db.close()
    }

    // Getting single student details through ID
    fun getLastEntry(): Workmeter {

        val db = this.readableDatabase


        //You can browse to the query method to know more about the arguments.
        val cursor = db.query(TABLE_WORKMETER_ENTRIES,
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
        return Workmeter(
                cursor.getString(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getString(9),
                cursor.getString(10),
                cursor.getString(11),
                cursor.getString(12),
                cursor.getString(13),
                cursor.getString(14),
                cursor.getString(15),
                cursor.getString(16))
    }

    // Updating single student
    fun asa(workmeter: Workmeter) {
//        val db = this.writableDatabase
//
//        val values = ContentValues()
//        values.put(KEY_STUDENT_NAME, student.getStudentName())
//        values.put(KEY_STUDENT_EMAIL, student.getStudentEmail())
//
//        // updating student row
//        return db.update(TABLE_WORKMETER_ENTRIES,
//                values,
//                "$KEY_STUDENT_ID = ?",
//                arrayOf(String.valueOf(student.getStudentID())))
    }

    // Deleting single student
    fun deleteStudent(workmeter: Workmeter) {

//        val db = this.writableDatabase
//        db.delete(TABLE_WORKMETER_ENTRIES, "$KEY_STUDENT_ID = ?",
//                arrayOf(String.valueOf(student.getStudentID())))
//        db.close()
    }

    companion object {
        //Database version.
        //Note: Increase the database version every-time you make changes to your table structure.
        private val DATABASE_VERSION = 1

        //Database Name
        private val DATABASE_NAME = "OrangeWorkMeter"

        //You will declare all your table names here.
        private val TABLE_WORKMETER_ENTRIES = "workmeterentries";

        //var a :String = Workmeter::class.java.declaredFields.forEach { a in String: Field -> a.name }

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
