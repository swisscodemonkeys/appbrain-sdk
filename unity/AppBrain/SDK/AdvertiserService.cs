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

	public class AdvertiserService
	{
		private readonly AndroidJavaObject javaObject;

		internal AdvertiserService(AndroidJavaObject javaObject)
		{
			this.javaObject = javaObject;
		}

		public void SendConversionEvent(string name, int value)
		{
			javaObject.Call("sendConversionEvent", name, value);
		}
	}

#else

	public class AdvertiserService
	{
		public void SendConversionEvent(string name, int value)
		{
		}
	}

#endif

}
