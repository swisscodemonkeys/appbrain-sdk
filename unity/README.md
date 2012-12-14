AppBrain AppLift Unity integration
=====

This tutorial describes how to integrate the AppBrain AppLift SDK into your unity app.

Integration steps:

  * Open Unity with your project, eg "MyProject"
  * Copy the included files (Ads.cs, AppBrain.cs,AndroidManifest.xml and appbrain-sdk-android.jar) to "MyProject"/Assets/Plugins/Android
  * Call AppLift functions where appropriate (see below)

The following example file calls the AppLift functions. 


	using UnityEngine;
	using System.Collections;
	using AppLift;

	public class main : MonoBehaviour {
		void Start () {
	    		AppBrain.Init();
		}

		void Update () {
		    if (Input.GetKeyUp(KeyCode.Escape)) {
			AppBrain.GetAds().ShowInterstitial(true);
		    }
		}
	}

-------------------------------------------------------------------

Please contact us directly at contact@appbrain.com if you need any assistence, and we will be happy to help you.
