/*
 * Copyright (C) 2013 AppBrain
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
	public class RemoteSettings
	{
		private AndroidJavaObject settings;
		
		public RemoteSettings(AndroidJavaObject settings) {
			this.settings = settings;
		}
		
		public String Get(String key) {
			try {
				return settings.Call<String>("get", key);
			} catch (Exception e) {
				Debug.LogError(e);
			}
		}

		public String Get(String key, String defaultValue) {
			try {
				return settings.Call<String>("get", key, defaultValue);
			} catch (Exception e) {
				Debug.LogError(e);
			}
		}

	}
#else
	public class RemoteSettings {
		
		public String Get(String key) {
			return "";
		}
		
		public String Get(String key, String defaultValue) {
			return "";
		}
	}
#endif
}

