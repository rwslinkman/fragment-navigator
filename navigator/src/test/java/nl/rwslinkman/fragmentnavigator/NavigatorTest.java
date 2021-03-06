package nl.rwslinkman.fragmentnavigator;

import android.app.FragmentManager;
import android.app.FragmentTransaction;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class NavigatorTest {

    @InjectMocks
    private Navigator navigator;

    @Mock
    private FragmentManager fragmentManager;
    @Mock
    private BaseFragment baseFragment;
    @Mock
    private FragmentTransaction transaction;

    @Mock
    private Navigator.NavigationListener navigationListener;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        navigator = new Navigator(fragmentManager, 0);
    }

    @Test
    public void start_shouldCallNotifyListener_WithNullListener() {
//        FragmentTransaction transaction = Mockito.mock(FragmentTransaction.class);
        Mockito.when(fragmentManager.beginTransaction()).thenReturn(transaction);
        navigator.start(baseFragment, null);
    }

    @Test
    public void goBack_shouldReturnFalse() {
        assertFalse(navigator.goBack());
    }

    @Test
    public void goBack_shouldReturnTrue() {
        Mockito.when(fragmentManager.getBackStackEntryCount()).thenReturn(2);
        assertTrue(navigator.goBack());
    }

}
