package com.example.birthday_card;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.birthday_card.fragment.BirthdayCardFragment;
import com.example.birthday_card.fragment.InputDialogFragment;

public class MainActivity extends AppCompatActivity  implements InputDialogFragment.InputDialogListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add = findViewById(R.id.button);
        Button remove = findViewById(R.id.button2);
        FrameLayout frame = findViewById(R.id.frameLayout);

        InputDialogFragment inputDialogFragment = InputDialogFragment.newInstance("Enter celebrant's details");
        inputDialogFragment.setInputDialogListener(this);
        add.setOnClickListener(view -> inputDialogFragment.show(getSupportFragmentManager(), "inputDialog"));
        remove.setOnClickListener(view -> {
            Fragment currentFragment = getSupportFragmentManager().findFragmentByTag("birthdayCardFragment");
            if (currentFragment != null) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .remove(currentFragment)
                        .commit();
            }
        });

    }

    @Override
    public void onDataEntered(Bundle data) {
        String name = data.getString("name","");
        int age = data.getInt("age", 0);
        String wishes = data.getString("wishes", "");
        int imageSelected = data.getInt("selectedRadioButtonId", -1);
        Log.d("ImageSelected", "Value: " + imageSelected);
        String imageResource;
        String[] urls = getResources().getStringArray(R.array.urls);
        if (imageSelected == R.id.cat){
            imageResource = urls[2];
        } else if (imageSelected == R.id.dog){
            imageResource = urls[1];
        } else {
            imageResource = urls[0];
        }

        BirthdayCardFragment birthdayCardFragment = BirthdayCardFragment.newInstance(name, age, wishes, imageResource);



        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, birthdayCardFragment, "birthdayCardFragment")
                .commit();

        birthdayCardFragment.updateData(name, age, wishes, imageResource);



    }
}