package ders.yasin.fragmentapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class FragmentCommunicationActivity extends AppCompatActivity implements FragmentSender.OnNameSetListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);

        FragmentSender fragmentSender=new FragmentSender();
        getSupportFragmentManager().beginTransaction().add(R.id.name_Container,fragmentSender).commit();
    }

    @Override
    public void onNameSet(String name) {
        //Option 1 Communication between Static Fragments
        FragmentReceiver fragmentReceiver=(FragmentReceiver) getSupportFragmentManager().findFragmentById(R.id.fragment_Receiver);
        fragmentReceiver.setName(name);

        //Option Communication between Dynamic Fragments
        //FragmentReceiver fragmentReceiver=FragmentReceiver.newInstance(name);
        //getSupportFragmentManager().beginTransaction().replace(R.id.name_Container,fragmentReceiver).commit();



    }
}
