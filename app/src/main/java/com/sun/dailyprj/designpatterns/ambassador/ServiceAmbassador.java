/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sun.dailyprj.designpatterns.ambassador;

import android.util.Log;

import static java.lang.Thread.sleep;

/**
 *
 * ServiceAmbassador provides an interface for a ({@link Client}) to access ({@link RemoteService}).
 * The interface adds logging, latency testing and usage of the service in a safe way that will not
 * add stress to the remote service when connectivity issues occur.
 *
 */
public class ServiceAmbassador implements RemoteServiceInterface {

  private static final int RETRIES = 3;
  private static final int DELAY_MS = 3000;

  ServiceAmbassador() {}

  @Override
  public long doRemoteFunction(int value) {
    return safeCall(value);
  }

  private long checkLatency(int value) {
    long startTime = System.currentTimeMillis();
    long result = RemoteService.getRemoteService().doRemoteFunction(value);
    long timeTaken = System.currentTimeMillis() - startTime;

    Log.i("syp","Time taken (ms): " + timeTaken);
    return result;
  }

  private long safeCall(int value) {

    int retries = 0;
    long result = FAILURE;

    for (int i = 0; i < RETRIES; i++) {

      if (retries >= RETRIES) {
        return FAILURE;
      }

      if ((result = checkLatency(value)) == FAILURE) {
        Log.i("syp","Failed to reach remote: (" + (i + 1) + ")");
        retries++;
        try {
          sleep(DELAY_MS);
        } catch (InterruptedException e) {
          Log.e("syp","Thread sleep state interrupted", e);
        }
      } else {
        break;
      }
    }
    return result;
  }
}
