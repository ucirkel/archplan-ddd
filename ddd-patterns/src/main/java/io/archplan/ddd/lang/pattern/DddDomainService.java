/*
 * Copyright 2023 Udo Cirkel (www.udocirkel.de)
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
 * Indicates that an annotated class represents a "Domain Service" as defined by
 * Domain-Driven Design (Eric Evans, 2003)
 * <p>
 * A Service in general is an abstraction for modeling operations that cannot be
 * clearly assigned to the responsibility of a domain object. A Service is the
 * appropriate place for operations that, in an object, would compromise its
 * conceptual clarity and ease of understanding. A Service does not hold state
 * and therefore can easily scale to handle increasing traffic. A Service can
 * offer a group of related operations that together realize a specific
 * requirement or goal.
 * <p>
 * Specifically, a Domain Service focus on business logic and coordinating tasks
 * that are closely tied to the domain model. It offers significant domain
 * functionality and can be reused more easily. A Domain Service can reduce the
 * complexity of the domain model, which may arise through many Aggregates and
 * Entities with fine-grained operations, by providing easy-to-use operations.
 * Clients of the domain model are decoupled from Aggregates and Entities and
 * only need to pass them as parameters of operations and receive them as
 * results.
 * 
 * @author Udo Cirkel
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DddPattern("Domain Service")
public @interface DddDomainService {

    /**
     * Unique identifier of the Domain Service
     * 
     * @return an identifier or an empty string
     */
    String id() default "";

    /**
     * Name of the Domain Service as defined in the domain model and equally in the
     * ubiquitous language
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
     * {@code @DddDomainService("A meaningful name")} instead of
     * {@code @DddDomainService(name="A meaningful name")}. Only one of these
     * attributes may be specified.
     * 
     * @return a name or an empty string
     */
    String value() default "";

    /**
     * Concise description of the Domain Service
     * 
     * @return a description or an empty string
     */
    String description() default "";

    /**
     * Names of the Aggregates and Entities that are involved in the Domain Service
     * logic
     * 
     * @return an array with names or an empty array
     */
    String involvedObjects() default "";

    /**
     * Additional information that is related to the Domain Service
     * <p>
     * The provided information is specified in key-value form, where keys may occur
     * multiple times
     * 
     * @return an array with attribute elements or an empty array
     */
    Attribute[] attributes() default {};

}
