package ders.yasin.fragmentapplication;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentReceiver#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentReceiver extends Fragment {

    TextView tvName;


    // TODO: Rename and change types of parameters
    private String mName;


    public FragmentReceiver() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentReceiver newInstance(String name) {
        FragmentReceiver fragment = new FragmentReceiver();
        Bundle args = new Bundle();
        args.putString("NAME", name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mName = getArguments().getString("NAME");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_receiver, container, false);
        tvName=view.findViewById(R.id.tv_Name);
        tvName.setText(mName);
        return view;
    }

    public void setName(String name) {
        tvName.setText(name);

    }
}
