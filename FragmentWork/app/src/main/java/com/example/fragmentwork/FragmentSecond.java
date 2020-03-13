package com.example.fragmentwork;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentSecond extends Fragment {


    TextView nameText;
    TextView versionText;
    TextView apinoText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_second,container, false);

        nameText = viewGroup.findViewById(R.id.nameText);
        versionText = viewGroup.findViewById(R.id.versionText);
        apinoText = viewGroup.findViewById(R.id.apinoText);

        Bundle bundle = this.getArguments();

        if (bundle != null) {
            String name = bundle.getString("Name");
            String version = bundle.getString("Version");
            String apino = bundle.getString("APINo");
            nameText.setText(name);
            versionText.setText(version);
            apinoText.setText(apino);

        }


        return viewGroup;
    }
}
