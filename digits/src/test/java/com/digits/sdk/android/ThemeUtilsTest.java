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

import android.graphics.Color;
import android.test.AndroidTestCase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class ThemeUtilsTest  extends AndroidTestCase {

    @Test
    public void testIsLightColor_blue() {
        assertFalse(ThemeUtils.isLightColor(Color.BLUE));
    }

    @Test
    public void testIsLightColor_black() {
        assertFalse(ThemeUtils.isLightColor(Color.BLACK));
    }

    @Test
    public void testIsLightColor_white() {
        assertTrue(ThemeUtils.isLightColor(Color.WHITE));
    }

    @Test
    public void testCalculateOpacityTransform_zeroOpacity() {
        assertEquals(Color.WHITE, ThemeUtils.calculateOpacityTransform(0, Color.BLUE, Color.WHITE));
    }

    @Test
    public void testCalculateOpacityTransform_fullOpacity() {
        assertEquals(Color.BLUE, ThemeUtils.calculateOpacityTransform(1, Color.BLUE, Color.WHITE));
    }

    @Test
    public void testCalculateOpacityTransform_returnsFullOpacity() {
        final int color = ThemeUtils.calculateOpacityTransform(0, Color.BLUE, Color.WHITE);
        assertEquals(0xFF000000, color & 0xFF000000);
    }
}
