package nl.rwslinkman.fragmentnavigator.example;

import android.os.Bundle;

import nl.rwslinkman.fragmentnavigator.Navigator;
import nl.rwslinkman.fragmentnavigator.NavigatorActivity;

public class ExampleActivity extends NavigatorActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);

        Navigator navigator = new Navigator(null, 0);
    }

    @Override
    public Navigator getNavigator() {
        return null;
    }
}
