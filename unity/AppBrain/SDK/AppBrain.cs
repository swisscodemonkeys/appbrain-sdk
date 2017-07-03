/*
 * Copyright (C) 2012-2017 AppBrain
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
 *
 *
 * This file is part of the AppBrain SDK for Unity:
 * https://www.appbrain.com/info/help/sdk/unity.html
 */
using UnityEngine;
using System;
using System.Collections;
using System.Runtime.InteropServices;

namespace AppBrainSdk
{

#if UNITY_ANDROID

	public class AppBrain
	{
		private static readonly AndroidJavaClass javaClass = new AndroidJavaClass("com.appbrain.AppBrain");
		private static readonly AndroidJavaClass unityPlayer = new AndroidJavaClass("com.unity3d.player.UnityPlayer");

		public static void Init()
		{
			javaClass.CallStatic("init", GetCurrentActivity());
		}

		public static void AddTestDevice(string deviceId)
		{
			javaClass.CallStatic("addTestDevice", deviceId);
		}

		public static AdService GetAds()
		{
			return new AdService(javaClass.CallStatic<AndroidJavaObject>("getAds"));
		}

		public static RemoteSettings GetSettings()
		{
			return new RemoteSettings(javaClass.CallStatic<AndroidJavaObject>("getSettings"));
		}

		public static AdvertiserService getAdvertiserService()
		{
			return new AdvertiserService(javaClass.CallStatic<AndroidJavaObject>("getAdvertiserService"));
		}

		internal static AndroidJavaObject GetCurrentActivity()
		{
			return unityPlayer.GetStatic<AndroidJavaObject>("currentActivity");
		}
	}

#else

	public class AppBrain
	{
		public static void Init()
		{
		}

		public static void AddTestDevice(string deviceId)
		{
		}

		public static AdService GetAds()
		{
			return new AdService();
		}

		public static RemoteSettings GetSettings()
		{
			return new RemoteSettings();
		}

		public static AdvertiserService getAdvertiserService()
		{
			return new AdvertiserService();
		}
	}

#endif

}
