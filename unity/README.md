AppBrain AppLift Unity integration
=====

This tutorial describes how to integrate the AppBrain AppLift SDK into your unity app.

Integration steps:

  * Open Unity with your project, eg "MyProject"
  * Copy the included files (Ads.cs, AppBrain.cs,AndroidManifest.xml and appbrain-sdk-android.jar) to "MyProject"/Assets/Plugins/Android
  * Enter your app's packagename into the AndroidManifest.xml file located at Assets/Plugins/Android/AndroidManifest.xml
  * Call AppLift functions where appropriate (see below)

The following example javascript-File that calls AppLift functions. 


	using AppLift;
	
	// Use this for initialization
	void Start () {
		AppBrain.Init();
	}

	function Update () {
		if (Input.GetKeyUp(KeyCode.Escape)) {
			AppBrain.getAds().showInterstitial(true);
		}
	}

-------------------------------------------------------------------

Please contact us directly at contact@appbrain.com if you need any assistence, and we will be happy to help you.
