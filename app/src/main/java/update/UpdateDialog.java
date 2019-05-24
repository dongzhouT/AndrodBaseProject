package update;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Toast;

public class UpdateDialog extends DialogFragment {
    private int posClickNum = 0;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("发现新版本");
        if (UpdateChecker.isForceUpdate(getActivity())) {
            //强制升级
            builder.setMessage(getArguments().getString(Constants.APK_UPDATE_CONTENT))
                    .setPositiveButton("立即下载", null)
                    .setNegativeButton("我要退出", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                            dismiss();
                            //强制退出应用
                            getActivity().finish();
                        }
                    });
            setCancelable(false);
        } else {
            builder.setMessage(getArguments().getString(Constants.APK_UPDATE_CONTENT))
                    .setPositiveButton("立即下载", null)
                    .setNegativeButton("以后再说", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // User cancelled the dialog
                            dismiss();
                        }
                    });
        }

        // Create the AlertDialog object and return it
        return builder.create();
    }


    private void goToDownload() {
        posClickNum++;
        if (posClickNum > 1)
            return;
        Intent intent = new Intent(getActivity().getApplicationContext(), DownloadService.class);
        intent.putExtra(Constants.APK_DOWNLOAD_URL, getArguments().getString(Constants.APK_DOWNLOAD_URL));
        getActivity().startService(intent);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            final AlertDialog dialog = (AlertDialog) getDialog();
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getActivity(), "程序已在后台下载，请耐心等待", Toast.LENGTH_LONG).show();
                    goToDownload();
//                    dismiss();
                }
            });
        }
    }
}
