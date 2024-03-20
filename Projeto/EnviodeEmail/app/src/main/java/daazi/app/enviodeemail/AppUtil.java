package daazi.app.enviodeemail;

import android.text.TextUtils;
import android.widget.EditText;

public class AppUtil {

    public static void setVazioEdit(EditText... obj){
        for (EditText T: obj) {
            T.setText(null);
        }
    }

    public static boolean getVazioEdit(EditText... obj){
        for (EditText T: obj) {
            if(TextUtils.isEmpty(T.getText())){
                return false;
            }
        }
        return true;
    }

    public static void voErroEdit(String s,EditText... edit){
        for (EditText T: edit) {
            if(TextUtils.isEmpty(T.getText())){
                T.setError(s);
            }
        }
    }

}
