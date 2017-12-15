package nl.rwslinkman.fragmentnavigator;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Rick Slinkman
 */

abstract public class BaseFragment<A extends NavigatorActivity> extends Fragment {

    private A mActivity;
    private Navigator mNavigator;

    abstract protected int getLayoutId();
    abstract protected void setupFragmentView(View fragmentView);

    public A getFragmentActivity() {
        if (mActivity != null) {
            return mActivity;
        }
        //noinspection unchecked
        return (A) this.getActivity();
    }

    @Deprecated
    public void setFragmentActivity(A activity) {
        this.mActivity = activity;
    }

    public Navigator getNavigator() {
        if (this.mNavigator != null) {
            return mNavigator;
        }
        return getFragmentActivity().getNavigator();
    }

    @Deprecated
    public void setNavigator(Navigator navigator) {
        this.mNavigator = navigator;
    }

    @Nullable
    @Override
    final public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(getLayoutId(), container, false);
        this.setupFragmentView(fragmentView);
        return fragmentView;
    }
}
