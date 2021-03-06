package nl.rwslinkman.fragmentnavigator;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;

/**
 * @author Rick Slinkman
 */
@Deprecated
abstract public class BaseFragment<A extends NavigatorActivity> extends Fragment {

    private A mActivity;
    private Navigator mNavigator;

    abstract protected void setupFragmentView(View fragmentView);
    @LayoutRes
    abstract protected int getLayoutId();

    public A getFragmentActivity() {
        if (mActivity != null) {
            return mActivity;
        }
        //noinspection unchecked
        return (A) this.getActivity();
    }

    public Navigator getNavigator() {
        if (this.mNavigator != null) {
            return mNavigator;
        }
        return getFragmentActivity().getNavigator();
    }

    @Nullable
    @Override
    final public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(getLayoutId(), container, false);
        this.setupFragmentView(fragmentView);
        return fragmentView;
    }

    @VisibleForTesting
    public void setNavigator(Navigator navigator) {
        this.mNavigator = navigator;
    }

    @VisibleForTesting
    public void setFragmentActivity(A activity) {
        this.mActivity = activity;
    }
}
