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
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that an annotated class represents a "Domain Event" as defined by
 * Domain-Driven Design (Eric Evans, 2003)
 * <p>
 * A Domain Event is an abstraction for modeling a significant occurrence or
 * change within the domain that is relevant for domain experts. The purpose of
 * a Domain Event is to allow interested parties to respond to the event and
 * take appropriate action.
 * <p>
 * <b>Characteristics</b>
 * <p>
 * Significant occurrence - A Domain Event represents a significant occurrence
 * within the domain. This could be a change to the state of an Entity or an
 * Aggregate, the completion of a business process, or the occurrence of a
 * significant business event.
 * <p>
 * Immutable - A Domain Event is immutable. This ensures that the event is a
 * true historical record of what happened in the domain.
 * <p>
 * Contextual - A Domain Event is specific to a particular Bounded Context. This
 * allows to define Events that represent specific requirements of the context.
 * <p>
 * Published - A Domain Event is published, meaning that it is broadcasted to
 * all interested parties within the domain. This allows other parts of the
 * system and other systems to respond to the event and take appropriate action.
 * <p>
 * Asynchronous - A Domain Event is processed asynchronously. This allows the
 * generating system to continue processing without waiting for the event to be
 * handled.
 * 
 * @author Udo Cirkel
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@DddPattern("Domain Event")
public @interface DddDomainEvent {

    /**
     * Unique identifier of the Domain Event
     * 
     * @return an identifier or an empty string
     */
    String id() default "";

    /**
     * Name of the Domain Event as defined in the domain model and equally in the
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
     * {@code @DddDomainEvent("A meaningful name")} instead of
     * {@code @DddDomainEvent(name="A meaningful name")}. Only one of these
     * attributes may be specified.
     * 
     * @return a name or an empty string
     */
    String value() default "";

    /**
     * Concise description of the Domain Event
     * 
     * @return a description or an empty string
     */
    String description() default "";

    // TODO document operation
    /**
     * The DDD aggregate, entity or service that emits the domain event
     * 
     * @return
     */
    String emitter() default "";

    /**
     * Additional information that is related to the Domain Event
     * <p>
     * The provided information is specified in key-value form, where keys may occur
     * multiple times
     * 
     * @return an array with attribute elements or an empty array
     */
    Attribute[] attributes() default {};

}
