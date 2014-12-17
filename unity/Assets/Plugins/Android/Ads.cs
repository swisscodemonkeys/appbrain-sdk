/*
 * Copyright (C) 2012-2014 AppBrain
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
using UnityEngine;
using System;
using System.Collections;
using System.Runtime.InteropServices;

namespace AppLift {
#if UNITY_ANDROID
	public class Ads
	{
		private static AndroidJavaClass appbrainUnity = new AndroidJavaClass("com.appbrain.AppBrainUnity");
		
		public Ads() {}
		
		public void ShowOfferWall() {
			try {
				SetKillWhenDone(false);
				appbrainUnity.CallStatic("showOfferWall", AppBrain.GetCurrentActivity());
			} catch (Exception e) {
				Debug.LogError(e);
			}
		}
		
		public bool ShowInterstitial(bool quitWhenDone) {
			try {
				SetKillWhenDone(quitWhenDone);
				return appbrainUnity.CallStatic<bool>("showInterstitial", AppBrain.GetCurrentActivity());
			} catch (Exception e) {
				Debug.LogError(e);
				return false;
			}
		}
		
		public bool MaybeShowInterstitial(bool quitWhenDone) {
			try {
				SetKillWhenDone(quitWhenDone);
				return appbrainUnity.CallStatic<bool>("maybeShowInterstitial", AppBrain.GetCurrentActivity());
			} catch (Exception e) {
				Debug.LogError(e);
				return false;
			}
		}

		public void OfferwallButtonClick() {
		       try {
				SetKillWhenDone(false);
				appbrainUnity.CallStatic("offerwallButtonClick", AppBrain.GetCurrentActivity());
			} catch (Exception e) {
				Debug.LogError(e);
			}								
		}
		
		private static void SetKillWhenDone(bool killWhenDone) {
			if (killWhenDone) {
				appbrainUnity.CallStatic("killWhenDone", AppBrain.GetCurrentActivity());
			} else {
				appbrainUnity.CallStatic("dontKillWhenDone");
			}
		}
	}
#else
	public class Ads {
		public void ShowOfferWall() {
		}
		
		public bool ShowInterstitial(bool quitWhenDone) {
			return false;
		}
		
		public bool MaybeShowInterstitial(bool quitWhenDone) {
			return false;
		}
	}
#endif
}

