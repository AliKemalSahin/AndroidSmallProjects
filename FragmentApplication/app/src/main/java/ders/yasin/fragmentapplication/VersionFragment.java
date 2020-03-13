package ders.yasin.fragmentapplication;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class VersionFragment extends Fragment {
    ListView lvVersion;


    public VersionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_version, container, false);
        lvVersion=view.findViewById(R.id.lv_Version);

        String[] listVersion = getResources().getStringArray(R.array.AndroidVersions);
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,listVersion);
        lvVersion.setAdapter(adapter);


        return view;
    }

}
