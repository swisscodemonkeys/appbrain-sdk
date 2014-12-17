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
	public class AppBrain
	{
		private static bool initialized = false;
		private static AndroidJavaClass appbrainUnity = new AndroidJavaClass("com.appbrain.AppBrainUnity");
		private static AndroidJavaClass unityPlayer = new AndroidJavaClass("com.unity3d.player.UnityPlayer");
		
		public static void Init() {
			if (initialized) {
				return;
			}
			try {
				appbrainUnity.CallStatic("init", GetCurrentActivity());
				initialized = true;
			} catch (Exception e) {
				Debug.LogError(e);
			}
		}
		
		public static Ads GetAds() {
		       return new Ads();
		}

		public static RemoteSettings GetSettings() {
			try {
				return new RemoteSettings(appbrainUnity.CallStatic<AndroidJavaObject>("getSettings"));
			} catch (Exception e) {
				Debug.LogError(e);
				return new RemoteSettings(null);
			}
		}
		
		public static AndroidJavaObject GetCurrentActivity() {
			try {
				return unityPlayer.GetStatic<AndroidJavaObject>("currentActivity");
			} catch (Exception e) {
				Debug.LogError (e);
				return null;
			}
		}

	}
#else
	public class AppBrain {
		public static void Init() {
		}
		
		public static Ads GetAds() {
			return new Ads();
		}
		public static RemoteSettings GetSettings() {
		       return new RemoteSettings();
		}
	}
#endif
}
