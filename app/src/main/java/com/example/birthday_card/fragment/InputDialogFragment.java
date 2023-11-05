package com.example.birthday_card.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.birthday_card.R;

import java.util.Objects;

public class InputDialogFragment extends DialogFragment {


    public interface InputDialogListener {
        void onDataEntered(Bundle data);
    }
    private InputDialogListener mListener;

    private EditText name;
    private EditText age;
    private EditText wishes;
    private RadioGroup pictures;


    public InputDialogFragment(){}

    public void setInputDialogListener(InputDialogListener listener) {
        mListener = listener;
    }

    public static InputDialogFragment newInstance(String title) {
        InputDialogFragment fragment = new InputDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input_info, container);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name = view.findViewById(R.id.editText);
        age = view.findViewById(R.id.age);
        wishes = view.findViewById(R.id.editText2);
        pictures = view.findViewById(R.id.pictures);
        assert getArguments() != null;
        String title = getArguments().getString("title", "Enter celebrant's details");
        Objects.requireNonNull(getDialog()).setTitle(title);
        name.requestFocus();
        Objects.requireNonNull(getDialog().getWindow())
                .setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        view.findViewById(R.id.submit).setOnClickListener(submit -> {
            Bundle data = new Bundle();
            data.putString("name", name.getText().toString());
            data.putInt("age", Integer.parseInt(age.getText().toString()));
            data.putString("wishes", wishes.getText().toString());
            data.putInt("selectedRadioButtonId", pictures.getCheckedRadioButtonId());

            if (mListener != null) {
                mListener.onDataEntered(data);
            }

            dismiss();
        });

    }
}
