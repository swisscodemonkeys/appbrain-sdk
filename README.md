AppBrain SDK
=============

This repository contains the AppBrain SDK and an example project how to use it. (The AppBrain SDK formerly was called "AppLift").

Click here to [download all files of the AppBrain SDK](https://github.com/swisscodemonkeys/appbrain-sdk/zipball/master)

Please make sure you read and understood these documents before  using the SDK:
  
  * [AppBrain SDK documentation](www.appbrain.com/info/help/sdk/index.html)
  * [SDK integration policy](http://www.appbrain.com/info/help/sdk/policy.html)
  * [SDK Terms Of Service](http://www.appbrain.com/info/help/publisher-tos.html)

Please contact us directly at contact@appbrain.com if you need any assistence, and we will be happy to help you.

AppBrain Team


Recent changes
============

Every release contains bugfixes and monetizations improvements.

V11.10 (October 1st, 2015):

  * Reduction of promotions for apps that are not available to the current user
  * Fixes to be able to compile with targetSdkVersion=23
  * Transparent offerwall for better integration within the publisher app

V11.02 (July 21st, 2015):

  * Pop-over interstitials that keep the user engaged with your app. You can set your own border color. [Documentation](http://www.appbrain.com/info/help/sdk/interstitial.html#custom-interstitial-border)
  * Add native ads in Recycler Views. [Documentation](http://www.appbrain.com/info/help/sdk/listviews.html)
  * Fixed a potential issue with Unity integration.
  * Fix an issue with the webview in-app alert.
  * V11.02 fixes a proguard issue regarding the RecyclerView ads.

V10.51 (March 23th, 2015):

  * Fixed measuring bug when AppBrainBanner is a child of a RelativeLayout

V10.5 (March 11th, 2015):

  * COPPA compliance mode. [Documentation](http://www.appbrain.com/info/help/sdk/gettingstarted.html#coppa-compliance)
  * New WebView based in-app alert type.
  * Fixed proguarded AppBrainBanner.setSize()
  * Better support for interstitial on tablets.

V10.41 (December 23rd, 2014):

  * Easy Gradle/Android studio integration with maven repository. [Documentation](http://www.appbrain.com/info/help/sdk/gettingstarted.html)
  * Admob mediation adapter is now integrated in the main SDK jar. [AdMob medation documentation](http://www.appbrain.com/info/help/sdk/admob.html)

V10.4 (December 17th, 2014):

  * Added AppBrain.getAds().setUserData(AppBrainUserData) to communicate demographic information and location for increased monetization. [Documentation](http://www.appbrain.com/info/help/sdk/javadoc/AppBrainUserData.html)
  * Fixes for Unity, and "More Apps" button click listener. [Unity documentation](http://www.appbrain.com/info/help/sdk/unity.html)

V10.31 & V10.32 (October 14th & 20th, 2014):

  * Small fixes for Admob mediation

V10.3 (October 14th, 2014):

  * Improvements to banner monetization
  * Automatically scale up banner size on tablets ("SMART / RESPONSIVE" banner size).
  * Give more control over banner size using AppBrainBanner.setSize(DEFAULT | LARGE | RESPONSIVE).

V10.2 (July 29th, 2014):

  * Added instream ads
  * Better reporting of events to mediation adapters


