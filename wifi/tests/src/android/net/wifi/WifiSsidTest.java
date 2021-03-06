/*
 * Copyright (C) 2017 The Android Open Source Project
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

package android.net.wifi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import androidx.test.filters.SmallTest;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

/**
 * Unit tests for {@link android.net.wifi.WifiSsid}.
 */
@SmallTest
public class WifiSsidTest {

    private static final String TEST_SSID = "Test SSID";
    private static final byte[] TEST_SSID_BYTES = TEST_SSID.getBytes(StandardCharsets.US_ASCII);

    /**
     * Check that createFromByteArray() works.
     */
    @Test
    public void testCreateFromByteArray() {
        WifiSsid wifiSsid = WifiSsid.createFromByteArray(TEST_SSID_BYTES);
        assertTrue(wifiSsid != null);
        assertEquals(TEST_SSID, wifiSsid.toString());
    }

    /**
     * Check that createFromByteArray() works.
     */
    @Test
    public void testCreateFromGbkByteArray() throws Exception {
        String TEST_GBK_SSID = "Test GBK SSID";
        byte[] TEST_GBK_SSID_BYTES = TEST_GBK_SSID.getBytes("GBK");
        WifiSsid wifiSsid = WifiSsid.createFromByteArray(TEST_GBK_SSID_BYTES);
        wifiSsid.mIsGbkEncoding = true;
        assertTrue(wifiSsid != null);
        assertEquals(TEST_GBK_SSID, wifiSsid.toString());
    }

    /**
     * Verify that SSID created from byte array and string with the same content are equal.
     *
     * @throws Exception
     */
    @Test
    public void testEquals() throws Exception {
        WifiSsid fromBytes = WifiSsid.createFromByteArray(TEST_SSID_BYTES);
        WifiSsid fromString = WifiSsid.createFromAsciiEncoded(TEST_SSID);
        assertTrue(fromBytes != null);
        assertTrue(fromString != null);
        assertEquals(fromBytes, fromString);
    }
}
