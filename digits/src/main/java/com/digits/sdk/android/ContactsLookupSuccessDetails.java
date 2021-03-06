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


/**
 * ContactsLookupSuccessDetails contains information passed into the
 * DigitsEventLogger implementations.
 */
@Beta(Beta.Feature.Analytics)
public class ContactsLookupSuccessDetails {

    public final int matchCount;

    public ContactsLookupSuccessDetails(int matchCount) {
        this.matchCount = matchCount;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getName() + "{");
        stringBuilder.append("matchCount='" + matchCount + '\'');
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
