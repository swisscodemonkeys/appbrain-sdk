AppBrain SDK
=============

[![AppBrain SDK](https://www.appbrain.com/stats/libraries/shield/appbrain.svg)](https://www.appbrain.com/stats/libraries/details/appbrain/appbrain-sdk)

This repository contains the AppBrain SDK and an example project how to use it. (The AppBrain SDK formerly was called "AppLift").

To learn more about our SDK, [visit our Android monetization SDK information page](https://www.appbrain.com/info/monetize). 

Other documentation for the SDK is available here:
  
  * [Getting started guide](https://www.appbrain.com/info/help/sdk/gettingstarted.html)
  * [SDK integration policy](https://www.appbrain.com/info/help/sdk/policy.html)
  * [SDK Terms Of Service](https://www.appbrain.com/info/help/publisher-tos.html)

Please contact us directly at contact@appbrain.com if you need any assistence, and we will be happy to help you.


Recent changes
==============

Every release contains bugfixes and monetizations improvements.

V16.02 (May 1st, 2020):
  * Fix issue with manifest entry verification of `AppBrainJobService` on older Android SDK versions.
  * Performance & size improvement

V16.00 (April 21st, 2020):
  * Improve Google Play compliance, remove too broad javascript interface functions.
  * Depend on newer version of the play referrer library that doesn't require extra permissions. [See e.g. this stack overflow post](https://stackoverflow.com/questions/59369092/play-install-referrer-library-adding-write-external-storage-and-read-external-st)

V15.11 (December 12th, 2019):
  * Remove ReferrerReceiver from the manifest as Google will stop broadcasting install referrers soon. [See our blogpost for more information](https://medium.com/appbrain/the-google-play-referrer-api-and-the-appbrain-sdk-38cfbaa350dc)
  * Stability improvements

V15.00 (July 1st, 2019):
  * Startup optimizations
  * Improved Google Play referrer reporting (using Referrer API)
  * Default ListView ads show "Ad" in corner in accordance with Google Play policy guidelines

V14.60 (January 29th, 2019):
  * Reduce ANRs caused by SharedPreferences

V14.50 (November 28th, 2018):
  * Detect non-working clickthroughs better
  * Fix for Unity

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

