AppBrain AppLift SDK
===========

This repository contains the AppBrain AppLift SDK files and an example project how to use it.

Click here to [download all files of the AppBrain AppLift SDK](https://github.com/swisscodemonkeys/appbrain-sdk/zipball/master)

Please make sure you read and understood these documents before  using the SDK:
  
  * [AppBrain AppLift SDK](http://www.appbrain.com/info/sdk)
  * [SDK Policy](http://www.appbrain.com/info/sdk-policy)
  * [SDK Terms Of Service](http://www.appbrain.com/info/sdk-tos)

Please contact us directly at contact@appbrain.com if you need any assistence, and we will be happy to help you.

AppBrain Team


Recent changes
============

Every release contains bugfixes and monetizations improvements.

V11.0 (July 17th, 2015):

  * Pop-over interstitials that keep the user engaged with your app. You can set your own border color. [Documentation](http://www.appbrain.com/info/sdk-docs/interstitial.html#custom-interstitial-border)
  * Fixed a potential issue with Unity integration.

V10.51 (March 23th, 2015):

  * Fixed measuring bug when AppBrainBanner is a child of a RelativeLayout

V10.5 (March 11th, 2015):

  * COPPA compliance mode. [Documentation](http://www.appbrain.com/info/sdk-docs/gettingstarted.html#coppa-compliance)
  * New WebView based in-app alert type.
  * Fixed proguarded AppBrainBanner.setSize()
  * Better support for interstitial on tablets.

V10.41 (December 23rd, 2014):

  * Easy Gradle/Android studio integration with maven repository. [Documentation](http://www.appbrain.com/info/sdk-docs/gettingstarted.html)
  * Admob mediation adapter is now integrated in the main SDK jar. [AdMob medation documentation](http://www.appbrain.com/info/sdk-docs/admob.html)

V10.4 (December 17th, 2014):

  * Added AppBrain.getAds().setUserData(AppBrainUserData) to communicate demographic information and location for increased monetization. [Documentation](http://www.appbrain.com/info/sdk-docs/javadoc/com/appbrain/AppBrainUserData.html)
  * Fixes for Unity, and "More Apps" button click listener. [Unity documentation](http://www.appbrain.com/info/sdk-docs/unity.html)

V10.31 & V10.32 (October 14th & 20th, 2014):

  * Small fixes for Admob mediation

V10.3 (October 14th, 2014):

  * Improvements to banner monetization
  * Automatically scale up banner size on tablets ("SMART / RESPONSIVE" banner size).
  * Give more control over banner size using AppBrainBanner.setSize(DEFAULT | LARGE | RESPONSIVE).

V10.2 (July 29th, 2014):

  * Added instream ads
  * Better reporting of events to mediation adapters

V10.1 (June 6th, 2014):

  * Added [AppBrain Cloud Alerts](http://blog.appbrain.com/2014/07/keep-in-touch-with-your-users-through.html)
  * Added setOfferWallClickListener function for custom "more apps" buttons
  * Only use Advertising ID for Google Play compliance

