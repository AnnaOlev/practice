package com.example.practice;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class MyDialogFragment2 extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Параметры")
                .setMessage("Жизней - 3. БЭ - 100. Pазвитие полушарий - по 77.")
                .setPositiveButton("Ясно",new DialogInterface.OnClickListener() {
                    public void onClick (DialogInterface dialog,int id){
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}
