package com.example.oliver.vezba161217_recyclerviewfragmenti.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.oliver.vezba161217_recyclerviewfragmenti.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Oliver on 12/16/2017.
 */

public class FragmentSignIn extends Fragment{
    private Unbinder mUnbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.signin_fragment,null);
        mUnbinder = ButterKnife.bind(this, view);

        return view;
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        mUnbinder.unbind();
    }
}
