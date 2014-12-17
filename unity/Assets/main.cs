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
