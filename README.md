Android Phone Number Formatter
==============================

Format Android EditText content when it changed.

In this case x xxx xxx xx xx

for othe formats see source and comments

USAGE:

```java
...
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.telephony.PhoneNumberUtils;
...
```


```java
...
TextView phoneField = (TextView)findViewById(R.id.phoneField);
if (phoneField != null) {
phoneField.setText(phone);
phoneField.addTextChangedListener(new PhoneNumberTextWatcher());
phoneField.setFilters(new InputFilter[] { new PhoneNumberFilter(), new InputFilter.LengthFilter(15) });
}
...
```

