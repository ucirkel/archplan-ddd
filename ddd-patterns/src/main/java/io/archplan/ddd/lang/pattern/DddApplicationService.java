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
 * Indicates that an annotated class represents an "Application Service" as
 * defined by Domain-Driven Design (Eric Evans, 2003)
 * <p>
 * A Service in general is an abstraction for modeling operations that cannot be
 * clearly assigned to the responsibility of a domain object. A service is the
 * appropriate place for such operations that, in an object, would compromise
 * its conceptual clarity and ease of understanding.
 * <p>
 * Specifically, an Application Services focus on the interaction with users and
 * other systems, performs a task that is not relevant to the Domain Layer,
 * orchestrates more fine-grained operations on Services and Objects in the
 * Domain Layer and therefore is stateless.
 * 
 * @author Udo Cirkel
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DddPattern("Application Service")
public @interface DddApplicationService {

    /**
     * Unique identifier of the Application Service
     * 
     * @return an identifier or an empty string
     */
    String id() default "";

    /**
     * Name of the Application Service as defined in the domain model and equally in
     * the ubiquitous language
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
     * {@code @DddApplicationService("A meaningful name")} instead of
     * {@code @DddApplicationService(name="A meaningful name")}. Only one of these
     * attributes may be specified.
     * 
     * @return a name or an empty string
     */
    String value() default "";

    /**
     * Names of the Aggregates and Entities that are involved in the Application
     * Service logic
     * 
     * @return an array with names or an empty array
     */
    String involvedObjects() default "";

    /**
     * Additional information that is related to the Application Service
     * <p>
     * The provided information is specified in key-value form, where keys may occur
     * multiple times
     * 
     * @return an array with attribute elements or an empty array
     */
    Attribute[] attributes() default {};

}
