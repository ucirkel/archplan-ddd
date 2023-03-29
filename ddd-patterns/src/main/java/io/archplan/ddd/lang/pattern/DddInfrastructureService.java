/*
 * Copyright 2023 Udo Cirkel <mail@udocirkel.de>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.archplan.ddd.lang.pattern;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that an annotated class represents an "Infrastructure Service" as
 * defined by Domain-Driven Design (Eric Evans, 2003)
 * <p>
 * Infrastructure Services have no significant meaning in the domain and cover
 * purely technical aspects. Domain and Application Services work together with
 * Infrastructure Services.
 * 
 * @author Udo Cirkel
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DddPattern("Infrastructure Service")
public @interface DddInfrastructureService {

    /**
     * Unique identifier of the Infrastructure Service
     * 
     * @return an identifier or an empty string
     */
    String id() default "";

    /**
     * Name of the Infrastructure Service as defined in the domain model and equally
     * in the ubiquitous language.
     * <p>
     * {@link #value()} is an alias for this attribute.
     * 
     * @return a name or an empty string
     */
    String name() default "";

    /**
     * Alias for the {@link #name()} attribute
     * <p>
     * Allows a more concise declaration of annotations such as
     * {@code @DddInfrastructureService("A meaningful name")} instead of
     * {@code @DddInfrastructureService(name="A meaningful name")}. Only one of
     * these attributes may be specified.
     * 
     * @return a name or an empty string
     */
    String value() default "";

    /**
     * Names of the Aggregates and Entities that are involved in the Infrastructure
     * Service logic
     * 
     * @return an array with names or an empty array
     */
    String involvedObjects() default "";

    /**
     * Additional information that is related to the Infrastructure Service
     * <p>
     * The provided information is specified in key-value form, where keys may occur
     * multiple times
     * 
     * @return an array with attribute elements or an empty array
     */
    Attribute[] attributes() default {};

}
