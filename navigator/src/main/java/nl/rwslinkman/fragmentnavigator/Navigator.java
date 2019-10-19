package nl.rwslinkman.fragmentnavigator;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import androidx.annotation.IdRes;
import androidx.annotation.VisibleForTesting;

/**
 * @author Rick Slinkman
 */
public class Navigator
{
    public interface NavigationListener {
        void onNavigate();
    }
    private NavigationListener mListener;
    private int mContainerId;
    private FragmentManager mFragmentManager;

    @VisibleForTesting
    Navigator() {
        // NOP
    }

    /**
     * @param fragmentManager FragmentManager Android Fragment manager
     * @param containerId int Reference to the FrameLayout to use the navigator with
     */
    public Navigator(FragmentManager fragmentManager, @IdRes int containerId) {
        this.mContainerId = containerId;
        this.mFragmentManager = fragmentManager;
    }

    public void start(BaseFragment fragment, NavigationListener listener) {
        this.mListener = listener;
        navigateTo(fragment);
    }

    public void start(BaseFragment fragment) {
        start(fragment, null);
    }

    public void navigateTo(BaseFragment fragment) {
        String fragmentTag = fragment.getClass().getSimpleName();

        FragmentTransaction ft = mFragmentManager.beginTransaction();
        ft.replace(mContainerId, fragment, fragmentTag);
        ft.addToBackStack(null);
        ft.commit();

        notifyListener();
    }

    public boolean goBack() {
        if(mFragmentManager.getBackStackEntryCount() > 1) {
            mFragmentManager.popBackStack();
            mFragmentManager.executePendingTransactions();
            notifyListener();
            return true;
        }
        return false;
    }

    private void notifyListener() {
        if(mListener != null) {
            mListener.onNavigate();
        }
    }
}
