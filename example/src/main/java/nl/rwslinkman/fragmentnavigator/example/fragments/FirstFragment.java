package nl.rwslinkman.fragmentnavigator.example.fragments;

import android.view.View;

import nl.rwslinkman.fragmentnavigator.BaseFragment;
import nl.rwslinkman.fragmentnavigator.example.ExampleActivity;

public class FirstFragment extends BaseFragment<ExampleActivity>{
    @Override
    protected void setupFragmentView(View fragmentView) {

    }

    @Override
    protected int getLayoutId() {
        return 0;
    }
}
