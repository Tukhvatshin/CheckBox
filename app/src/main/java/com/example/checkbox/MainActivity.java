package com.example.checkbox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText mInputMoney;
    private EditText mInputInfo;
    private Button mBtnOk;
    private CheckBox mBankCardChkBx;
    private CheckBox mMobilePhoneChkBx;
    private CheckBox mCashAddressChkBx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mInputMoney = findViewById(R.id.inputMoney);
        mInputInfo = findViewById(R.id.inputInfo);
        mBtnOk = findViewById(R.id.btnOK);
        mBankCardChkBx = findViewById(R.id.bankCardChkBx);
        mMobilePhoneChkBx = findViewById(R.id.mobilePhoneChkBx);
        mCashAddressChkBx = findViewById(R.id.cashAddressChkBx);
        mBankCardChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mMobilePhoneChkBx.setOnCheckedChangeListener(checkedChangeListener);
        mCashAddressChkBx.setOnCheckedChangeListener(checkedChangeListener);

        mBtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mBankCardChkBx.isChecked() && !mMobilePhoneChkBx.isChecked() && !mCashAddressChkBx.isChecked())
                    ;
                if (mInputMoney.getText().length() == 0) ;
                if (mInputInfo.getText().length() == 0) {
                    Toast.makeText(MainActivity.this, R.string.errorMsngr, Toast.LENGTH_SHORT).show();
                } else if (mBankCardChkBx.isChecked()) {
                    Toast.makeText(MainActivity.this, getString(R.string.payComplt) + ("\n") +
                            mInputMoney.getText().toString() + ("\n") +
                            mInputInfo.getText().toString() + ("\n") +
                            mBankCardChkBx.getText().toString(), Toast.LENGTH_LONG).show();
                } else if (mMobilePhoneChkBx.isChecked()) {
                    Toast.makeText(MainActivity.this, getString(R.string.payComplt) + ("\n") +
                            mInputMoney.getText().toString() + ("\n") +
                            mInputInfo.getText().toString() + ("\n") +
                            mMobilePhoneChkBx.getText().toString(), Toast.LENGTH_LONG).show();
                } else if (mCashAddressChkBx.isChecked()) {
                    Toast.makeText(MainActivity.this, getString(R.string.payComplt) + ("\n") +
                            mInputMoney.getText().toString() + ("\n") +
                            mInputInfo.getText().toString() + ("\n") +
                            mCashAddressChkBx.getText().toString(), Toast.LENGTH_LONG).show();
                }

                mInputMoney.getText().clear();
                mInputInfo.getText().clear();
                resetCheckBoxes();
            }
        });

    }

    private void resetCheckBoxes() {
        mBankCardChkBx.setChecked(false);
        mMobilePhoneChkBx.setChecked(false);
        mCashAddressChkBx.setChecked(false);
    }

    CompoundButton.OnCheckedChangeListener checkedChangeListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if (b) {
                switch (compoundButton.getId()) {
                    case R.id.bankCardChkBx:
                        resetCheckBoxes();
                        mBankCardChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_NUMBER);
                        break;
                    case R.id.mobilePhoneChkBx:
                        resetCheckBoxes();
                        mMobilePhoneChkBx.setChecked(true);
                        mInputInfo.setInputType(InputType.TYPE_CLASS_PHONE);
                        break;
                    case R.id.cashAddressChkBx:
                        resetCheckBoxes();
                        mInputInfo.setInputType(InputType.TYPE_CLASS_TEXT);
                        mCashAddressChkBx.setChecked(true);
                        break;
                    default:
                }
            }
        }
    };

}
