package some.package;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.util.Log;

public class PhoneNumberTextWatcher implements TextWatcher {

    private int removeBackLenth = 0;
    private int removeBackStart = 0;
    private boolean deleting;
    private String lastText = "";

    @Override
    public void afterTextChanged(Editable text) {

        //text should start with "8 ("
        if (text.length() < 3) {
            text.replace(0, text.length(), "8 (");
        }

        if (!deleting) {
            if (text.length() == 6) {
                text.append(") ");
            }

            if (text.length() == 11 || text.length() == 14) {
                text.append(' ');
            }

            if (text.length() > 17) {
                text.delete(17, text.length());
            }
        } else {
            if (removeBackLenth > 0) {
                text.delete(removeBackStart, removeBackStart + removeBackLenth);
            }
        }

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        deleting = s.length() < lastText.length();
        removeBackLenth = 0;
        removeBackStart = 0;

        if (deleting) {
            if (lastText.endsWith(") ")) {
                removeBackLenth = 2;
                removeBackStart = lastText.length() - 3;
            } else {
                if (lastText.endsWith(" ")) {
                    removeBackLenth = 1;
                    removeBackStart =  lastText.length() - 2;
                }
            }
        }

        lastText = s.toString();
    }
}
