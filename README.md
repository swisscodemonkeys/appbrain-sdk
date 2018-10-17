AppBrain SDK
=============

This repository contains the AppBrain SDK and an example project how to use it. (The AppBrain SDK formerly was called "AppLift").

Click here to [download all files of the AppBrain SDK](https://github.com/swisscodemonkeys/appbrain-sdk/zipball/master)

Please make sure you read and understood these documents before  using the SDK:
  
  * [AppBrain SDK documentation](https://www.appbrain.com/info/help/sdk/index.html)
  * [SDK integration policy](https://www.appbrain.com/info/help/sdk/policy.html)
  * [SDK Terms Of Service](https://www.appbrain.com/info/help/publisher-tos.html)

Please contact us directly at contact@appbrain.com if you need any assistence, and we will be happy to help you.

AppBrain Team


Recent changes
============

Every release contains bugfixes and monetizations improvements.

V14.40 (October 17th, 2018):
  * Android O and P compatibility fixes
  * Large performance update, significant reduction in appwall loading time on some devices

V14.30 (July 30th, 2018):
  * Allow programmatic setting of user-returns-to-app interstitial. [Documentation](https://www.appbrain.com/info/help/sdk/javadoc/AdService.html#com.appbrain.AdService.setReturnToAppInterstitial%28ReturnToAppConfig%29)
  * Set adids in Admob and Mopub mediation through extra data. [Admob documentation](https://www.appbrain.com/info/help/sdk/admob.html#mediating-the-appbrain-interstitial) [Mopub documentation](https://www.appbrain.com/info/help/sdk/mopub.html#mediating-the-appbrain-banners)

V14.20 (June 20th, 2018):
  * Detect better which devices can advertise demanding advertiser apps
  * Fixed issue around proguard setup
  * Speed and stability optimizations

V14.10 (February 9th, 2018):
  * Improve loading speeds with DNS prefetching
  * Various other speed and stability optimizations

V14.00 (January 9th, 2018):
  * Added remotely-controllable interstitials [Blogpost](https://medium.com/appbrain/appbrain-automatic-interstitials-easily-control-ad-placement-in-your-android-app-f6717dd08183)
  * Better protection against scammy ads
  * Speed and stability optimizations

V13.30 (November 7th, 2017):
  * Added convenient onDoneCallback for InterstitialBuilder. [Documentation](https://www.appbrain.com/info/help/sdk/javadoc/InterstitialBuilder.html#com.appbrain.InterstitialBuilder.setOnDoneCallback(Runnable))
  * Speed optimizations, removed potential StrictMode warnings

V13.22 (July 21th, 2017):
  * Fixed proguard issue
  * Fixed rare WebView instantiation issue
  * Workaround for rare OkHttp IllegalStateException "cache is closed"

V13.20 (July 3rd, 2017):
  * Improved support for Unity. [Documentation](https://www.appbrain.com/info/help/sdk/unity.html)
  * Automatic SDK initialization. (Calling AppBrain.init() is optional now).
  * Android O compatibility fixes
  * Removed RecyclerView-based ads

V13.10 (April 5th, 2017):
  * Added support for 11 more languages, bringing the total to 34.

V13.00 (January 31st, 2017):
  * Added preload() function to InterstitialBuilder. [Documentation](https://www.appbrain.com/info/help/sdk/javadoc/InterstitialBuilder.html)
  * InterstitialLoader now has onAdLoaded and onAdFailedToLoad callbacks. [Documentation](https://www.appbrain.com/info/help/sdk/javadoc/InterstitialListener.html#com.appbrain.InterstitialListener)
  * Supports mediation (contact us for details).
  * Better timeouts for ad conversion rates.

V12.00 (March 24th, 2016):

  * Tag ad units with Ad IDs. [Documentation](https://www.appbrain.com/info/help/sdk/javadoc/AdId.html)
  * Made interstitial better to show in other place than at app exit.
  * Easier API to show interstitials: InterstitialBuilder. [Documentation](https://www.appbrain.com/info/help/sdk/javadoc/InterstitialBuilder.html)
  * Startup performance optimizations.

V11.20 (December 11th, 2015):

  * Better performing interstitials
  * More accurate identification of users who are likely to install promoted apps
  * Better handling of problems caused by devices with buggy Android OS versions

V11.10 (October 1st, 2015):

  * Reduction of promotions for apps that are not available to the current user
  * Fixes to be able to compile with targetSdkVersion=23
  * Transparent offerwall for better integration within the publisher app

V11.02 (July 21st, 2015):

  * Pop-over interstitials that keep the user engaged with your app. You can set your own border color. [Documentation](https://www.appbrain.com/info/help/sdk/interstitial.html#custom-interstitial-border)
  * Add native ads in Recycler Views. [Documentation](https://www.appbrain.com/info/help/sdk/listviews.html)
  * Fixed a potential issue with Unity integration.
  * Fix an issue with the webview in-app alert.
  * V11.02 fixes a proguard issue regarding the RecyclerView ads.

V10.51 (March 23th, 2015):

  * Fixed measuring bug when AppBrainBanner is a child of a RelativeLayout

