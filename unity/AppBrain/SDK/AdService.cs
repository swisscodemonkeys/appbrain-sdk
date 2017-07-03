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

	public class AdService
	{
		private readonly AndroidJavaObject javaObject;

		internal AdService(AndroidJavaObject javaObject)
		{
			this.javaObject = javaObject;
		}

		public bool ShouldShowInterstitial()
		{
			return javaObject.Call<bool>("shouldShowInterstitial", AppBrain.GetCurrentActivity());
		}

		public bool MaybeShowInterstitial()
		{
			return javaObject.Call<bool>("maybeShowInterstitial", AppBrain.GetCurrentActivity());
		}

		public bool ShowInterstitial()
		{
			return javaObject.Call<bool>("showInterstitial", AppBrain.GetCurrentActivity());
		}

		public void ShowOfferWall()
		{
			javaObject.Call("showOfferWall", AppBrain.GetCurrentActivity());
		}

		public void OfferWallButtonClick()
		{
			javaObject.Call("unityOfferWallButtonClick", AppBrain.GetCurrentActivity());
		}

		public string GetOfferWallButtonLabel()
		{
			return javaObject.Call<string>("getOfferWallButtonLabel", AppBrain.GetCurrentActivity());
		}
	}

#else

	public class AdService
	{
		public bool ShouldShowInterstitial()
		{
			return false;
		}

		public bool MaybeShowInterstitial()
		{
			return false;
		}

		public bool ShowInterstitial()
		{
			return false;
		}

		public void ShowOfferWall()
		{
		}

		public void OfferWallButtonClick()
		{
		}

		public string GetOfferWallButtonLabel()
		{
			return null;
		}
	}

#endif

}
