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
	public enum InterstitialError { NoFill, Error }

	public class InterstitialListener
	{
		public Action OnPresented { get; set; }
		public Action OnClick { get; set; }
		public Action<bool> OnDismissed { get; set; }
		public Action OnAdLoaded { get; set; }
		public Action<InterstitialError> OnAdFailedToLoad { get; set; }
	}

#if UNITY_ANDROID

	internal class InterstitialListenerProxy : AndroidJavaProxy
	{
		internal readonly InterstitialListener listener;

		internal InterstitialListenerProxy(InterstitialListener listener) : base("com.appbrain.InterstitialListener")
		{
			this.listener = listener;
		}

		public void onPresented()
		{
			Action action = listener.OnPresented;
			if (action != null) {
				action();
			}
		}

		public void onClick()
		{
			Action action = listener.OnClick;
			if (action != null) {
				action();
			}
		}

		public void onDismissed(bool wasClicked)
		{
			Action<bool> action = listener.OnDismissed;
			if (action != null) {
				action(wasClicked);
			}
		}

		public void onAdLoaded()
		{
			Action action = listener.OnAdLoaded;
			if (action != null) {
				action();
			}
		}

		public void onAdFailedToLoad(AndroidJavaObject error)
		{
			Action<InterstitialError> action = listener.OnAdFailedToLoad;
			if (action != null) {
				action(error.Call<string>("name") == "NO_FILL" ? InterstitialError.NoFill : InterstitialError.Error);
			}
		}
	}

#endif

}
