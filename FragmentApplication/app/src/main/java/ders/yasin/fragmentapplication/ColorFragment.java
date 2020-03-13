package ders.yasin.fragmentapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;


public class ColorFragment extends Fragment {
    RadioGroup rgColors;

            private OnColorChangeListener colorListener;

    public ColorFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_color, container, false);
        rgColors=view.findViewById(R.id.rg_Colors);
        rgColors.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedID) {
                switch (checkedID){
                    case R.id.rb_Blue: colorListener.onColorChange("blue"); break;
                    case R.id.rb_Red: colorListener.onColorChange("red"); break;
                    case R.id.rb_Green: colorListener.onColorChange("green"); break;
                }

            }
        });
        return view;
    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnColorChangeListener) {
            colorListener = (OnColorChangeListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        colorListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnColorChangeListener {
        // TODO: Update argument type and name
        void onColorChange(String color);
    }
}
