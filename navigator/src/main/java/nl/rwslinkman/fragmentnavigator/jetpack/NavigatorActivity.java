package nl.rwslinkman.fragmentnavigator.jetpack;

import androidx.fragment.app.FragmentActivity;

abstract public class NavigatorActivity extends FragmentActivity {
    abstract public Navigator getNavigator();
}
