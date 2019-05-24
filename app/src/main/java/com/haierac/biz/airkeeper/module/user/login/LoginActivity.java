package com.haierac.biz.airkeeper.module.user.login;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.EditText;

import com.haierac.biz.airkeeper.R;
import com.haierac.biz.airkeeper.base.BaseActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements LoginContract.View {
    LoginContract.Presenter mPresenter;
    @ViewById(R.id.edt_name)
    EditText edtName;
    @ViewById(R.id.edt_pass)
    EditText edtPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = new LoginPresenter(this);
    }

    @Override
    public String title() {
        return null;
    }

    @Override
    public void initUI() {
        setHeaderVisiable(View.GONE);
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
}
