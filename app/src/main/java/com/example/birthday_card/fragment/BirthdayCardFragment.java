package com.example.birthday_card.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.birthday_card.R;
import com.squareup.picasso.Picasso;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BirthdayCardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BirthdayCardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BirthdayCardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BirthdayCardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BirthdayCardFragment newInstance(String param1, String param2) {
        BirthdayCardFragment fragment = new BirthdayCardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_birthday_card2, container, false);
    }

    public void updateData(String name, int age, String wishes, String imageResource) {
        TextView nameTextView = requireView().findViewById(R.id.celebrant);
        TextView ageTextView = requireView().findViewById(R.id.ageCard);
        TextView wishesTextView = requireView().findViewById(R.id.wishesCard);

        nameTextView.setText(name);
        ageTextView.setText(String.valueOf(age));
        wishesTextView.setText(wishes);

        ImageView imageView = requireView().findViewById(R.id.picture);
        Picasso.get().load(imageResource).into(imageView);
    }

}