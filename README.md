# MultiNavHost
Separate back stack history for each tab in Bottom Navigation View using Android Navigation Architecture Component 

Bottom Navigation View gives the user quick access to 3-5 top-level destinations in an Android app. The common architectural approach for such a top level navigation which is provided by the Android navigation component is that activity only knows one backstack.
But in some cases you need to have different back stack history for each tab in bottom navigation view like Instagram app. 

This sample app shows the usage of the new Navigation Architecture Component in collaboration with the Bottom Navigation view with separate back stack history for each tab.

As you know when you are using Android Navigation Component you have to use a NavHostFragment as a container for your fragments:

```xml
<fragment
    android:id="@+id/mainNavFragment"
    android:name="androidx.navigation.fragment.NavHostFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:defaultNavHost="true"
    app:navGraph="@navigation/nav_graph_main" />
```

Because `Navigation` class in navigation components use just one back stack for each graph you have to use multiple `NavHostFragment` with multiple navigation graphs. So your main xml layout should look like this:

```xml
<fragment
    android:id="@+id/homeTab"
    android:name="androidx.navigation.fragment.NavHostFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:defaultNavHost="false"
    app:navGraph="@navigation/navigation_graph_home" />
<fragment
    android:id="@+id/dashboardTab"
    android:name="androidx.navigation.fragment.NavHostFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:defaultNavHost="false"
    app:navGraph="@navigation/navigation_graph_dashboard" />
<fragment
    android:id="@+id/notificationsTab"
    android:name="androidx.navigation.fragment.NavHostFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:defaultNavHost="false"
    app:navGraph="@navigation/navigation_notifications" />
```

The number of `NavHostFragment` in your layout must match the number of menu items (tabs) used for your bottom navigation view. As you see in above code snippet you should define a separate navigation graph for each `NavHostFragment` in order to handle the navigation correctly.

For further information please review the sample app code.

<img src="https://github.com/moallemi/MultiNavHost/blob/master/.github/demo.gif?raw=true" width="540">


