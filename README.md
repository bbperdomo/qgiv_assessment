Qgiv Android Assessment
=============================

Repo containing the android technical assessment.

## Building the App

First, clone the repo:

`https://github.com/bbperdomo/qgiv_assessment.git`

Building the app with Android Studio:

### Android Studio (Recommended)

* Open Android Studio and select `File->Open...` or from the Android Launcher select `Open` and navigate to the root directory of the project.
* Select the directory.
* Click 'OK' to open the the project in Android Studio.
* A Gradle sync should start, but you can force a sync and build the 'app' module as needed.

## Running the App

* Connect an Android device to your development machine. Alternatively, you can use a virtual device with Android Studio's Emulator.
* Select `Run -> Run 'app'` (or `Debug 'app'`) from the menu bar
* Select the device you wish to run the app on and click 'OK'


## About the App

It's a simple implementation of the Figma prototype and screen shots provided. Clicking the "Give Now" button will add a pre-determined amount to the current amount raised,
and will stop after a hard-coded max value is reached. The progress bar increases relative to what the current amount raised is compared to the max goal.
A recycler view allows for scrolling through all donations made. A user can upload a new company icon by long-pressing the current image.

I used some material design components like the cardview to get that nice elevated shadow effect. I used Picasso for the image loading. I used constraintlayouts for organizing most of the views.


## Improvements + Notes
* I would have liked to add a "pull to refresh" on the donation history to display the elapsed time.
* Some kind of unit testing.
* Maybe MVC or some other pattern.
* I didnt get a chance to add that top screen pop to confirm a donation, but i was thinking of using a PopUpWindow or SnackBar maybe?
* I hard-coded some attribute values for some views, which isnt always ideal.
* Use RxJava and maybe have the progressBar and amountRaised be Observers that Subcribe to the "Give Now" Button that would be an Observable that emits data. 
