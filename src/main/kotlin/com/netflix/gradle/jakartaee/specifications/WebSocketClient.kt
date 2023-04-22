/*
 * Copyright 2022 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.netflix.gradle.jakartaee.specifications

import com.netflix.gradle.jakartaee.artifacts.ArtifactCoordinate
import com.netflix.gradle.jakartaee.artifacts.ArtifactVersion

internal class WebSocketClient : ContainerProvidedSpecification(
    "websocket-client-api",
    JAVAX,
    JAVAX_COORDINATES,
    JAKARTA,
    JAKARTA_COORDINATES,
    SPECIFICATION_TO_WS_CLIENT_VERSION
) {
    companion object {
        private val JAVAX = ArtifactCoordinate("javax.websocket", "javax.websocket-client-api") // 1.0 through 1.1
        private val JAKARTA = ArtifactCoordinate("jakarta.websocket", "jakarta.websocket-client-api") // 1.1.1 and later

        private val TOMCAT = ArtifactCoordinate("org.apache.tomcat", "tomcat-websocket-client-api") // 10.1.0 and later
        private val TOMCAT_EMBED_WS = ArtifactCoordinate("org.apache.tomcat.embed", "tomcat-embed-websocket") // 7.0.0 and later

        private val SPECIFICATION_TO_WS_CLIENT_VERSION = mapOf(
            SpecificationVersion.EE7 to ArtifactVersion("1.0.0"),
            SpecificationVersion.EE8 to ArtifactVersion("2.0.0"),
            SpecificationVersion.EE9 to ArtifactVersion("3.0.0"),
            SpecificationVersion.EE9_1 to ArtifactVersion("4.0.0"),
            SpecificationVersion.EE10 to ArtifactVersion("4.0.0"),
        )

        private val JAVAX_COORDINATES = listOf(
            TOMCAT,
            JAVAX,
        )

        private val JAKARTA_COORDINATES = listOf(
            JAKARTA,
            TOMCAT_EMBED_WS,
        )
    }
}
