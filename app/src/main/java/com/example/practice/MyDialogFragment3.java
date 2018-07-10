package com.example.practice;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;

public class MyDialogFragment3 extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Предупреждение!")
                .setMessage("Вы правда хотите обменять энергию на жизни?")
                .setPositiveButton("Я согласен!",new DialogInterface.OnClickListener() {
                    public void onClick (DialogInterface dialog,int id){
                        ((game) getActivity()).okClicked();
                    }
                })
                .setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                    });
        return builder.create();
    }
}