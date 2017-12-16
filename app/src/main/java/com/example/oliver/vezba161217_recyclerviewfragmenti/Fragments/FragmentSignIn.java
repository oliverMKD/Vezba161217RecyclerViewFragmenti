package com.example.oliver.vezba161217_recyclerviewfragmenti.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.oliver.vezba161217_recyclerviewfragmenti.Main2Activity;
import com.example.oliver.vezba161217_recyclerviewfragmenti.R;
import com.example.oliver.vezba161217_recyclerviewfragmenti.SharedPreferences.User;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Oliver on 12/16/2017.
 */

public class FragmentSignIn extends Fragment{

    @BindView(R.id.txtUser)
    EditText user;
    @BindView(R.id.txtPass)
    EditText pass;
    private Unbinder mUnbinder;
    User user1;
    @BindView(R.id.kopceProveri)
    Button kopceProveri;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signin_fragment,null);
        mUnbinder = ButterKnife.bind(this, view);



        return view;
    }
    @OnClick(R.id.kopceProveri)
    public void Klik(){
        String username = user.getText().toString();
        String password = pass.getText().toString();

        user1=((Main2Activity)getActivity()).GetUser(user1);
        if (username.equals(user1.username)&&password.equals(user1.password)){
            ((Main2Activity)getActivity()).pager.setCurrentItem(1);
        } else {
            user.setError("Wrong user");
            pass.setError("Wrong Password");
        }
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        mUnbinder.unbind();
    }
}
