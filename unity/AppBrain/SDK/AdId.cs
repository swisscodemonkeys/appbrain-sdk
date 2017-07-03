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

	public class AdId
	{
		private static readonly AndroidJavaClass javaClass = new AndroidJavaClass("com.appbrain.AdId");

		public static readonly AdId Default = new AdId(javaClass.GetStatic<AndroidJavaObject>("DEFAULT"));
		public static readonly AdId HomeScreen = new AdId(javaClass.GetStatic<AndroidJavaObject>("HOME_SCREEN"));
		public static readonly AdId Startup = new AdId(javaClass.GetStatic<AndroidJavaObject>("STARTUP"));
		public static readonly AdId Pause = new AdId(javaClass.GetStatic<AndroidJavaObject>("PAUSE"));
		public static readonly AdId Exit = new AdId(javaClass.GetStatic<AndroidJavaObject>("EXIT"));
		public static readonly AdId LevelStart = new AdId(javaClass.GetStatic<AndroidJavaObject>("LEVEL_START"));
		public static readonly AdId LevelComplete = new AdId(javaClass.GetStatic<AndroidJavaObject>("LEVEL_COMPLETE"));
		public static readonly AdId Achievements = new AdId(javaClass.GetStatic<AndroidJavaObject>("ACHIEVEMENTS"));
		public static readonly AdId Leaderboards = new AdId(javaClass.GetStatic<AndroidJavaObject>("LEADERBOARDS"));
		public static readonly AdId Store = new AdId(javaClass.GetStatic<AndroidJavaObject>("STORE"));

		internal readonly AndroidJavaObject javaObject;

		internal AdId(AndroidJavaObject javaObject)
		{
			this.javaObject = javaObject;
		}

		public static AdId Custom(string idString)
		{
			return new AdId(javaClass.CallStatic<AndroidJavaClass>("custom", idString));
		}

		public bool IsInterstitialId()
		{
			return javaObject.Call<bool>("isInterstitialId");
		}

		public bool IsBannerId()
		{
			return javaObject.Call<bool>("isBannerId");
		}

		public override string ToString()
		{
			return javaObject.Call<string>("toString");
		}

		public override bool Equals(object obj)
		{
			return obj != null && obj.GetType() == GetType() && javaObject.Call<bool>("equals", ((AdId) obj).javaObject);
		}

		public override int GetHashCode()
		{
			return javaObject.Call<int>("hashCode");
		}
	}

#else

	public class AdId
	{
		public static readonly AdId Default = null;
		public static readonly AdId HomeScreen = null;
		public static readonly AdId StartUp = null;
		public static readonly AdId Pause = null;
		public static readonly AdId Exit = null;
		public static readonly AdId LevelStart = null;
		public static readonly AdId LevelComplete = null;
		public static readonly AdId Achievements = null;
		public static readonly AdId Leaderboards = null;
		public static readonly AdId Store = null;

		public static AdId Custom(string idString)
		{
			return null;
		}

		public bool IsInterstitialId()
		{
			return false;
		}

		public bool IsBannerId()
		{
			return false;
		}
	}

#endif

}
