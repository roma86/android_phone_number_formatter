Android Phone Number Formatter
==============================

Format Android EditText content when it changed.

In case of PhoneNumberTextWatcher format is n nnn nnn nn nn

In case of PhoneNumberTextWatcher2 format is 8 (nnn) nnn nn nn

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
phoneField.addTextChangedListener(new PhoneNumberTextWatcher());
phoneField.setFilters(new InputFilter[] { new PhoneNumberFilter(), new InputFilter.LengthFilter(15) });
...
```

**PhoneNumberTextWatcher2 with PhoneNumberFilter2**

This variation include required prefix **8 (** and check max lenth inside TextWatcher, so InputFilter.LengthFilter is not used.

```java
...
TextView phoneField = (TextView)findViewById(R.id.phoneField);
phoneField.addTextChangedListener(new PhoneNumberTextWatcher2());
phoneField.setFilters(new InputFilter[] { new PhoneNumberFilter2() });
...
```

