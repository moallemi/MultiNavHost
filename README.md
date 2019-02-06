# MultiNavHost
This sample provides an approach to separate back stack history for each tab in Bottom Navigation View using Android Navigation Architecture Component

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

Because `Navigation` class in navigation components use just one back stack for each graph, you have to use multiple `NavHostFragment` with a **single** navigation graph. So your main xml layout should look like this:

```xml
<fragment
    android:id="@+id/homeTab"
    android:name="androidx.navigation.fragment.NavHostFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:defaultNavHost="false" />
<fragment
    android:id="@+id/dashboardTab"
    android:name="androidx.navigation.fragment.NavHostFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:defaultNavHost="false" />
<fragment
    android:id="@+id/notificationsTab"
    android:name="androidx.navigation.fragment.NavHostFragment"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:defaultNavHost="false" />
```

To avoid creating multiple navigation_graph.xml files, we use only `navigation_graph_main` file and every destination and action must be defined here.

```xml
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/navigation_graph_main">
</navigation>
```
There is no need to define the `app:startDestination` in the navigation graph. We need
different start destination for each tab. So we handle start destination in `TabManager` class.

```kotlin
private val startDestinations = mapOf(
    R.id.navigation_home to R.id.homeFragment,
    R.id.navigation_dashboard to R.id.dashboardFragment,
    R.id.navigation_notifications to R.id.notificationsFragment
)
```

For further information please review the sample app code.

<img src="https://github.com/moallemi/MultiNavHost/blob/master/.github/demo.gif?raw=true" width="540">


