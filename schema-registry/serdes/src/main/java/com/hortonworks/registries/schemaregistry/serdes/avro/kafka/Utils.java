/**
 * Copyright 2016 Hortonworks.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 **/
package com.hortonworks.registries.schemaregistry.serdes.avro.kafka;

import com.hortonworks.registries.schemaregistry.SchemaMetadata;
import com.hortonworks.registries.schemaregistry.avro.AvroSchemaProvider;

/**
 *
 */
public final class Utils {
    public static final String GROUP_ID = "kafka";

    private Utils() {
    }

    public static SchemaMetadata getSchemaKey(String topicName, boolean isKey) {
        String name = topicName;
        if(isKey) {
            name += ":k";
        }
        // there wont be any naming collisions as kafka does not allow character `:` in a topic name.
        return new SchemaMetadata.Builder(name).type(AvroSchemaProvider.TYPE).schemaGroup(GROUP_ID).build();
    }

}
