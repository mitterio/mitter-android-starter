# Getting started

Use this basic starter template to whip up an Android chat app powered by Mitter in seconds.

## The Setup

* Open this template project in Android Studio and wait for the sync to finish.

* Navigate to `MyApp.kt` and replace the placeholder texts with your app and user credentials.

* Navigate to `MainActivity.kt` inside the `activity` package and paste your channel ID in the `channelId` variable.

## Using UI layouts

This starter template consist the following UI XML files:

* **2** shape files inside the `drawable` package
* **2** reusable layouts files inside the `layout` package

You can either use these files to quickly have some UI rendered on the screen for your app or you can totally define your own layout if you would like to go pro.

## Configuring FCM

Most of the configuration for FCM has been already done in this template. You do, however, need to setup your FCM profile in the Firebase console, download the `google-services.json` file and place it in the root folder of your project (_MitterAndroidStarter_).

Also, you need to use an event bus or anything else similar to that to send the received push messages from the `MyApp` class to your `MainActivity` or any other activity or fragment that you need.


