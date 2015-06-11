/*
 * Copyright (C) 2015 Twitter, Inc.
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
 */

package com.digits.sdk.android;

import com.twitter.sdk.android.core.TwitterAuthConfig;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

import java.util.concurrent.ExecutorService;

import javax.net.ssl.SSLSocketFactory;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, emulateSdk = 21)
public class DigitsApiProviderTests {
    private TwitterAuthConfig authConfig;
    private DigitsSession guestSession;
    private DigitsApiProvider provider;

    @Before
    public void setUp() throws Exception {

        authConfig = new TwitterAuthConfig(TestConstants.CONSUMER_SECRET,
                TestConstants.CONSUMER_KEY);
        guestSession = DigitsSession.create(DigitsSessionTests.getNewLoggedOutUser());


        provider = new DigitsApiProvider(guestSession, authConfig,
                mock(SSLSocketFactory.class), mock(ExecutorService.class),
                mock(MockDigitsUserAgent.class));

    }

    @Test
    public void testGetSdkService() throws Exception {
        final DigitsApiProvider.SdkService sdkService = provider.getSdkService();
        final DigitsApiProvider.SdkService newSdkService = provider.getSdkService();
        assertTrue(sdkService == newSdkService);
    }

    @Test
    public void testGetDeviceService() throws Exception {
        final DigitsApiProvider.DeviceService deviceService = provider.getDeviceService();
        final DigitsApiProvider.DeviceService newDeviceService = provider.getDeviceService();
        assertTrue(deviceService == newDeviceService);
    }

}
