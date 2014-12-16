/*
 *
 *  * Licensed to the Apache Software Foundation (ASF) under one or more
 *  *  contributor license agreements.  The ASF licenses this file to You
 *  * under the Apache License, Version 2.0 (the "License"); you may not
 *  * use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *     http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.  For additional information regarding
 *  * copyright in this work, please see the NOTICE file in the top level
 *  * directory of this distribution.
 *
 */

package org.apache.usergrid.rest.test.resource2point0.endpoints;

import com.sun.jersey.api.client.WebResource;
import org.apache.usergrid.rest.test.resource2point0.model.ApiResponse;
import org.apache.usergrid.rest.test.resource2point0.state.ClientContext;

import javax.ws.rs.core.MediaType;

/**
 * Classy class class.
 */
public abstract class AbstractEntityResource<T> extends NamedResource {

    public AbstractEntityResource(String identifier, ClientContext context, UrlResource parent) {
        super(identifier, context, parent);
    }

    public T get() {
        WebResource resource = getResource(true);
        ApiResponse response = resource.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON)
                .get(ApiResponse.class);
        return instantiateT(response);
    }

    public ApiResponse post(final T entity) {
        WebResource resource = getResource(true);
        return resource.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON)
                .post(ApiResponse.class, entity);
    }

    public ApiResponse put(final T entity) {
        WebResource resource = getResource(true);
        return resource.type(MediaType.APPLICATION_JSON_TYPE).accept(MediaType.APPLICATION_JSON)
                .put(ApiResponse.class, entity);
    }

    protected abstract T instantiateT(ApiResponse response);
}