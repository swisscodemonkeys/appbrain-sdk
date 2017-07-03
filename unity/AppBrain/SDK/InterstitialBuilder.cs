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

	public class InterstitialBuilder
	{
		private readonly AndroidJavaObject javaObject = new AndroidJavaObject("com.appbrain.InterstitialBuilder");

		private InterstitialBuilder()
		{
		}

		public static InterstitialBuilder Create()
		{
			return new InterstitialBuilder();
		}

		public InterstitialBuilder SetAdId(AdId adId)
		{
			javaObject.Call<AndroidJavaObject>("setAdId", adId.javaObject);
			return this;
		}

		public AdId GetAdId()
		{
			return new AdId(javaObject.Call<AndroidJavaObject>("getAdId"));
		}

		public InterstitialBuilder SetListener(InterstitialListener listener)
		{
			javaObject.Call<AndroidJavaObject>("setListener", new InterstitialListenerProxy(listener));
			return this;
		}

		public InterstitialBuilder SetFinishOnExit(bool finishOnExit)
		{
			javaObject.Call<AndroidJavaObject>("setFinishOnExit", finishOnExit ? AppBrain.GetCurrentActivity() : null);
			return this;
		}

		public InterstitialBuilder SetAllowedToUseMediation(bool allowedToUseMediation)
		{
			javaObject.Call<AndroidJavaObject>("setAllowedToUseMediation", allowedToUseMediation);
			return this;
		}

		public InterstitialBuilder Preload()
		{
			javaObject.Call<AndroidJavaObject>("preload", AppBrain.GetCurrentActivity());
			return this;
		}

		public bool Show()
		{
			return javaObject.Call<bool>("show", AppBrain.GetCurrentActivity());
		}

		public bool MaybeShow()
		{
			return javaObject.Call<bool>("maybeShow", AppBrain.GetCurrentActivity());
		}
	}

#else

	public class InterstitialBuilder
	{
		private InterstitialBuilder()
		{
		}

		public static InterstitialBuilder Create()
		{
			return new InterstitialBuilder();
		}

		public InterstitialBuilder SetAdId(AdId adId)
		{
			return this;
		}

		public AdId GetAdId()
		{
			return null;
		}

		public InterstitialBuilder SetListener(InterstitialListener listener)
		{
			return this;
		}

		public InterstitialBuilder SetFinishOnExit(bool finishOnExit)
		{
			return this;
		}

		public InterstitialBuilder SetAllowedToUseMediation(bool allowedToUseMediation)
		{
			return this;
		}

		public InterstitialBuilder Preload()
		{
			return this;
		}

		public bool Show()
		{
			return false;
		}

		public bool MaybeShow()
		{
			return false;
		}
	}

#endif

}
