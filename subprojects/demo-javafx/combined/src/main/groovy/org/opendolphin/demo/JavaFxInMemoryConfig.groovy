/*
 * Copyright 2012-2015 Canoo Engineering AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opendolphin.demo

import org.opendolphin.core.client.comm.BlindCommandBatcher
import org.opendolphin.core.client.comm.InMemoryClientConnector
import org.opendolphin.core.client.comm.JavaFXUiThreadHandler
import org.opendolphin.core.comm.DefaultInMemoryConfig

import java.lang.reflect.Field

class JavaFxInMemoryConfig extends DefaultInMemoryConfig {

    JavaFxInMemoryConfig() {
        def batcher = new BlindCommandBatcher(deferMillis: 400, mergeValueChanges: true)

        clientDolphin.clientConnector = new InMemoryClientConnector(clientDolphin, serverDolphin.serverConnector, batcher)
        clientDolphin.clientConnector.sleepMillis = 100

        clientDolphin.clientConnector.uiThreadHandler = new JavaFXUiThreadHandler()
        serverDolphin.registerDefaultActions()

        // Mac-specific hack for java 7 on el capitan
        try {
            Class<?> macFontFinderClass = Class.forName("com.sun.t2k.MacFontFinder");
            Field psNameToPathMap = macFontFinderClass.getDeclaredField("psNameToPathMap");
            psNameToPathMap.setAccessible(true);
            psNameToPathMap.set(null, new HashMap<String, String>());
        } catch (Exception e) {
            // ignore
        }
    }
}
