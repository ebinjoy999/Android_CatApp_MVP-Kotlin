package workmeter.orange.ebin.com.dogapp.screens.login.model

/**
 * Created by ebinjoy999 on 03/06/19.
 */
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Workmeter {

    @SerializedName("emp_key")
    @Expose
    var empKey: String? = null

    @SerializedName("emp_name")
    @Expose
    var empName: String? = null

    @SerializedName("work_hour")
    @Expose
    var workHour: String? = null

    @SerializedName("work_minute")
    @Expose
    var workMinute: String? = null

    @SerializedName("week_hour")
    @Expose
    var weekHour: String? = null


    @SerializedName("week_minute")
    @Expose
    var weekMinute: String? = null


    @SerializedName("w1")
    @Expose
    var w1: String? = null


    @SerializedName("w2")
    @Expose
    var w2: String? = null


    @SerializedName("w3")
    @Expose
    var w3: String? = null


    @SerializedName("w4")
    @Expose
    var w4: String? = null


    @SerializedName("cl")
    @Expose
    var cl: String? = null


    @SerializedName("el")
    @Expose
    var el: String? = null


    @SerializedName("ml")
    @Expose
    var ml: String? = null


    @SerializedName("mgr_pending")
    @Expose
    var mgrPending: String? = null



    @SerializedName("you_pending")
    @Expose
    var youPending: String? = null


    @SerializedName("updated_at")
    @Expose
    var updatedAt: String? = null



    @SerializedName("leave_status")
    @Expose
    var leaveStatus: String? = null




    constructor(empKey: String?, empName: String?, workHour: String?, workMinute: String?, weekHour: String?, weekMinute: String?, w1: String?, w2: String?, w3: String?, w4: String?, cl: String?, el: String?, ml: String?, mgrPending: String?, youPending: String?, updatedAt: String?, leaveStatus: String?) {
        this.empKey = empKey
        this.empName = empName
        this.workHour = workHour
        this.workMinute = workMinute
        this.weekHour = weekHour
        this.weekMinute = weekMinute
        this.w1 = w1
        this.w2 = w2
        this.w3 = w3
        this.w4 = w4
        this.cl = cl
        this.el = el
        this.ml = ml
        this.mgrPending = mgrPending
        this.youPending = youPending
        this.updatedAt = updatedAt
        this.leaveStatus = leaveStatus
    }
}