package com.haierac.biz.airkeeper.module.user.findpass;

import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.ToastUtils;
import com.haierac.biz.airkeeper.R;
import com.haierac.biz.airkeeper.base.BaseActivity;
import com.haierac.biz.airkeeper.utils.CommonUtils;
import com.haierac.biz.airkeeper.utils.Loading;
import com.haierac.biz.airkeeper.utils.Md5Utils;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_forget_pass)
public class ForgetPassActivity extends BaseActivity {

    @ViewById(R.id.btn_sms_code)
    Button btnSmsCode;
    @ViewById(R.id.edt_username)
    EditText edtUsername;
    @ViewById(R.id.edt_password)
    EditText edtPassword;
    @ViewById(R.id.edt_verify_code)
    EditText edtVerifyCode;
    String mobile, smsCode, passwordNew;
//    @Bean
//    CommonRestClient commonRestClient;

    @Override
    public String title() {
        return "忘记密码";
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

    String countDownStr = "重新获取%ss";
    final String DFT_VERIFY_TXT = "获取验证码";
    CountDownTimer timer;

    @Click(R.id.btn_sms_code)
    void onClickVerify() {
        if (!btnSmsCode.getText().equals(DFT_VERIFY_TXT)) {
            return;
        }
        mobile = edtUsername.getText().toString().trim();
        if (TextUtils.isEmpty(mobile)) {
            ToastUtils.showShort("手机号不能为空");
            edtUsername.setFocusable(true);
            return;
        }
        if (!CommonUtils.isValidMobile(mobile)) {
            ToastUtils.showShort("请输入正确的手机号");
            edtUsername.setFocusable(true);
            return;
        }
        sendSmsCode();
    }

    @Background
    void sendSmsCode() {
//        commonRestClient.sendForUpdate(mobile, new DefaultRestClientCallBack(this) {
//            @Override
//            public void success(HaierBaseResultBean entity) {
//                sendSuccess();
//            }
//
//            @Override
//            public void fail(HaierRestClientException e) {
//                sendFail(e.getMessage());
//            }
//        });
    }

    @UiThread
    void sendSuccess() {
        btnSmsCode.setEnabled(false);
        timer.start();
    }

    @UiThread
    void sendFail(String failString) {
        ToastUtils.showShort(failString);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @Click(R.id.btn_forget_pass)
    void onClickForgetPass() {
        mobile = edtUsername.getText().toString().trim();
        smsCode = edtVerifyCode.getText().toString().trim();
        passwordNew = edtPassword.getText().toString().trim();
        if (TextUtils.isEmpty(mobile)) {
            ToastUtils.showShort("手机号不能为空");
            edtUsername.setFocusable(true);
            return;
        }
        if (!CommonUtils.isValidMobile(mobile)) {
            ToastUtils.showShort("请输入正确的手机号");
            edtUsername.setFocusable(true);
            return;
        }
        if (TextUtils.isEmpty(smsCode)) {
            ToastUtils.showShort("手机验证码不能为空！");
            edtVerifyCode.setFocusable(true);
            return;
        }
        if (TextUtils.isEmpty(passwordNew)) {
            ToastUtils.showShort("新密码不能为空！");
            return;
        }
        if (!CommonUtils.isValidPassword(passwordNew)) {
            ToastUtils.showShort(getString(R.string.string_pass_invalid));
            return;
        }
        Loading.show(this);
        resetPassword();
    }

    @Background
    void resetPassword() {
        passwordNew = Md5Utils.encode(passwordNew);
//        commonRestClient.changePass(mobile, smsCode, passwordNew, new DefaultRestClientCallBack(this) {
//            @Override
//            public void success(HaierBaseResultBean entity) {
//                Loading.close();
//                resetPassSuccess();
//            }
//
//            @Override
//            public void fail(HaierRestClientException e) {
//                Loading.close();
//                resetPassFail(e.getMessage());
//            }
//        });

    }

    @UiThread
    void resetPassSuccess() {
        ToastUtils.showShort("密码重置成功，请重新登录");
        finish();
    }

    @UiThread
    void resetPassFail(String failString) {
        ToastUtils.showShort(failString);
    }

}
