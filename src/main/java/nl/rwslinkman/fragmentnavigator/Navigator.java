package nl.rwslinkman.fragmentnavigator;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * @author Rick Slinkman
 */
public class Navigator
{
    public interface NavigationListener {
        void onNavigate();
    }
    private NavigationListener mListener;
    private final int mContainerId;
    private final FragmentManager mFragmentManager;

    public Navigator(FragmentManager fragmentManager, int containerId) {
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
