package com.example.birthday_card.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.birthday_card.BirthdayCard;
import com.example.birthday_card.R;
import com.squareup.picasso.Picasso;

public class BirthdayCardFragment extends Fragment {
    private TextView nameTextView;
    private TextView ageTextView;
    private TextView wishesTextView;
    private ImageView imageView;

    public BirthdayCardFragment() {
    }

    public static BirthdayCardFragment newInstance(BirthdayCard birthdayCard) {
        BirthdayCardFragment fragment = new BirthdayCardFragment();
        Bundle args = new Bundle();
        args.putParcelable("birthday", birthdayCard);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("FF", "ONCREATE REACHED");
        return inflater.inflate(R.layout.fragment_birthday_card2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d("FF","ONVIEW REACHED");
        nameTextView = view.findViewById(R.id.celebrant);
        ageTextView = view.findViewById(R.id.ageCard);
        wishesTextView = view.findViewById(R.id.wishesCard);
        imageView = view.findViewById(R.id.picture);
        Bundle args = getArguments();
        if (args != null) {
            BirthdayCard birthdayCard = getArguments().getParcelable("birthday");
            if (birthdayCard != null) {
                updateData(birthdayCard.getName(), birthdayCard.getAge(), birthdayCard.getWishes(),
                        birthdayCard.getPicture());
            }
        }

    }

    public void updateData(String name, int age, String wishes, String imageResource) {
        Log.d("FF", " UPDATE REACHED");


        if (nameTextView != null && ageTextView != null && wishesTextView != null) {
            nameTextView.setText(name);
            ageTextView.setText(String.valueOf(age));
            wishesTextView.setText(wishes);
        }

        if (imageView != null) {
            Picasso.get().load(imageResource).into(imageView);
        } else {
            Log.e("BirthdayCardFragment", "ImageView is null.");
        }
    }
}
