package com.haierac.biz.airkeeper.module.user.register;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.blankj.utilcode.util.ToastUtils;
import com.haierac.biz.airkeeper.R;
import com.haierac.biz.airkeeper.base.BaseActivity;
import com.haierac.biz.airkeeper.module.protocol.UserUsageProtocolActivity_;
import com.haierac.biz.airkeeper.utils.CommonUtils;
import com.haierac.biz.airkeeper.utils.Loading;
import com.haierac.biz.airkeeper.utils.Md5Utils;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_register)
public class RegisterActivity extends BaseActivity implements RegisterContract.IView {

    @ViewById(R.id.btn_sms_code)
    Button btnSmsCode;

    @ViewById(R.id.edt_username)
    EditText edtUsername;
    @ViewById(R.id.edt_password)
    EditText edtPassword;
    @ViewById(R.id.edt_verify_code)
    EditText edtVerifyCode;
    @ViewById(R.id.chk_register)
    CheckBox chkRegister;
    @ViewById(R.id.btn_register)
    Button btnReg;

    String mobile, password, smsCode;
    RegisterContract.IPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new RegisterPresenter(this);
    }

    @Override
    public void initUI() {
        tvRight.setVisibility(View.GONE);
        timer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                btnSmsCode.setText(String.format(countDownStr, Math.round(millisUntilFinished / 1000)));
            }

            @Override
            public void onFinish() {
                btnSmsCode.setText(DFT_VERIFY_TXT);
                btnSmsCode.setEnabled(true);
            }
        };
        chkRegister.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                btnReg.setEnabled(isChecked);
            }
        });
        mobile = edtUsername.getText().toString().trim();
        btnSmsCode.setEnabled(CommonUtils.isValidMobile(mobile));
        edtUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                btnSmsCode.setEnabled(CommonUtils.isValidMobile(s.toString()));
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                btnSmsCode.setEnabled(CommonUtils.isValidMobile(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {
                btnSmsCode.setEnabled(CommonUtils.isValidMobile(s.toString()));
            }
        });
    }

    @Override
    public String title() {
        return "注册";
    }

    String countDownStr = "重新获取%ss";
    final String DFT_VERIFY_TXT = "获取验证码";
    CountDownTimer timer;

    @Click(R.id.btn_sms_code)
    void onClickVerify() {
        if (!btnSmsCode.getText().equals(DFT_VERIFY_TXT)) {
            return;
        }
        mPresenter.sendVerifyCode();
    }

    @Override
    public String getPhoneNum() {
        return edtUsername.getText().toString();
    }

    @Override
    public String getVerifyCode() {
        return edtVerifyCode.getText().toString();
    }

    @Override
    public String getPassword() {
        return edtPassword.getText().toString().trim();
    }

    @Override
    public String getVerifyPass() {
        return null;
    }

    @Override
    public void sendSuccess() {
        btnSmsCode.setEnabled(false);
        timer.start();
    }

    @Override
    public void sendFail(String failString) {
        ToastUtils.showShort(failString);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @Click(R.id.btn_register)
    void onClickTvRegister() {
        mPresenter.register();
    }

    @Click(R.id.tv_agree_protocol)
    void onClickChk() {
        chkRegister.toggle();
    }


    @Override
    public void registerSuccess() {
//        HomeActivity_.intent(this).flags(Intent.FLAG_ACTIVITY_CLEAR_TASK).start();
        finish();
    }

    @Override
    public void registerFail(String failString) {
        ToastUtils.showShort(failString);
    }

    @Click(R.id.tv_register_protocol)
    void onClickProtocol() {
        UserUsageProtocolActivity_.intent(this).isProtocol(true).start();
    }

    @Click(R.id.tv_privacy_policy)
    void onClickPolicy() {
        UserUsageProtocolActivity_.intent(this).isProtocol(false).start();
    }
}
