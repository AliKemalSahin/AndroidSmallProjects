package ders.yasin.fragmentapplication;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
    EditText etLoginUN,etLoginPass;
    Button btnLogin;
    TextView tvNewUser;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_login, container, false);
        etLoginPass=v.findViewById(R.id.et_loginPass);
        etLoginUN=v.findViewById(R.id.et_LoginUN);
        tvNewUser=v.findViewById(R.id.tv_NewUser);
        btnLogin=v.findViewById(R.id.btn_Login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userName=etLoginUN.getText().toString();
                String password=etLoginPass.getText().toString();
                if(!TextUtils.isEmpty(userName) && !TextUtils.isEmpty(password)){
                    if(userName.equals("yasin")&& password.equals("1234"))
                        Toast.makeText(getActivity(),"You have logined successfully",Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getActivity(),"Your password or username is wrong",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*FragmentManager manager=getFragmentManager();
                FragmentTransaction transaction=manager.beginTransaction();
                RegisterFragment registerFragment=new RegisterFragment();
                transaction.replace(R.id.container,registerFragment);
                transaction.commit();
                */

                RegisterFragment registerFragment=new RegisterFragment();
                getFragmentManager().beginTransaction().replace(R.id.container,registerFragment).commit();

            }
        });


        return v;
    }

}
