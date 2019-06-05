package workmeter.orange.ebin.com.dogapp.utils

import android.widget.EditText

/**
 * Created by ebinjoy999 on 03/06/19.
 */
class FieldValidator{

    companion object {
        fun isValidFieldEntry(editText: EditText) :Boolean{
            return editText!=null && editText.text.count()>0
        }
    }
}