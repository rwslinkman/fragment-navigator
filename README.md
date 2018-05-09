# Fragment Navigator
A simple, yet effective Android navigation library to navigate between Fragments in your app.   
It assumes your Fragments are all hosted within a single Activity.   
Using the `Navigator` class, it is really easy to go from Fragment to Fragment.

This component also supports Fragments from the `support v4` package.   

## Getting started
Add the component to your app's `build.gradle` file.

```gradle
dependencies {
	implementation "nl.rwslinkman.fragmentnavigator:fragment-navigator:1.4"
}
```

In some projects, there were difficulties locating the dependency.   
You can add this to your `repositories` section in your Gradle files.

```gradle
maven {
    url  "https://dl.bintray.com/rwslinkman/maven"
}
```

## Setting up your Activity
First, make sure your Activity class extends the `NavigatorActivity`.   
This will be a central control point for your Fragments.   

Instantiate the `Navigator` in the `onCreate` method.   
Also, you must specify the container where your `Navigator` can work.   
This is were all the Fragments will be put in.   
Usually, this is a `FrameLayout` with `match_parent` dimensions for both width and height.

Provide the first Fragment you want to display, and it will be loaded when opening the app.

```java
public class MyActivity extends NavigatorActivity {

    private Navigator navigator;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        // Other setup code for your app
        
        // Setting up the navigator with its first Fragment
        MainFragment fragment = MainFragment.newInstance();
        navigator = new Navigator(getFragmentManager(), R.id.fragment_container);
        navigator(fragment);
    }
    
    @Override
    public Navigator getNavigator() {
        return mNavigator;
    }
}
```

## Creating Fragments for the Navigator
The library provides a `BaseFragment` that you can extend.   
It takes care of creating your Fragmen, as well as providing a handle to your `NavigatorActivity`.   

```java
public class MainFragment extends BaseFragment<MyActivity> {
	// Your Fragment code goes here
}
```

The `BaseFragment` class takes a generic argument. You must set your `NavigatorActivity` there.   
This will give access to the following methods:
- `getFragmentActivity` which returns the Fragment's host.   
- `getNavigator` which gets the Navigator from the Activity
- Any public methods you have in your `NavigatorActivity` implementation.

## Navigating
With the `Navigator` you can navigate to another Fragment.  
The destination Fragment must also extend `BaseFragment`.

Anywhere within your Fragment, you can make the `Navigator` perform actions.
```java
getNavigator().navigateTo(game);
```

The `Navigator` allows to navigate backwards using the following method:
```java
boolean didGoBack = getNavigator().goBack();
``` 
It will return true when it went back to the previous Fragment.    
If there was no previous Fragment, it returns false.   
The root Fragment, provided at `start()`, will never be popped from the stack.

## Support library
In case your app uses Fragments from the `support v4` package, you can use the `support` package from the Navigator too.

In every example, replace the following:    

```
import nl.rwslinkman.fragmentnavigator.*;
```

```
import nl.rwslinkman.fragmentnavigator.support.*;
```

This is available since version `1.4`.