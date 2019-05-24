package com.haierac.biz.airkeeper.module.user.login;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

import com.haierac.biz.airkeeper.R;
import com.haierac.biz.airkeeper.base.BaseActivity;
import com.haierac.biz.airkeeper.module.user.findpass.ForgetPassActivity_;
import com.haierac.biz.airkeeper.module.user.register.RegisterActivity_;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements LoginContract.View {
    LoginContract.Presenter mPresenter;
    @ViewById(R.id.edt_login_mobile)
    EditText edtName;
    @ViewById(R.id.edt_login_password)
    EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new LoginPresenter(this);
    }

    @Override
    public String title() {
        return "登录";
    }

    @Override
    public void initUI() {
//        ivBack.setVisibility(View.GONE);
        tvRight.setText("注册");
    }

    @Override
    public String getUserName() {
        return edtName.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return edtPass.getText().toString().trim();
    }

    @Override
    public void success(String token) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("消息")
                .setPositiveButton("登录成功", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create();
        dialog.show();

    }

    @Override
    public void fail(String code, String msg) {
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("消息")
                .setPositiveButton("登录失败", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                }).create();
        dialog.show();
    }

    @Click(R.id.btn_login)
    void onClickLogin() {
        mPresenter.login();
    }

    @Click(R.id.tv_head_right)
    void onClickRegister() {
        RegisterActivity_.intent(this).start();
    }

    @Click(R.id.tv_forget_pass)
    void onClickForgetPass() {
        ForgetPassActivity_.intent(this).start();
    }

}
