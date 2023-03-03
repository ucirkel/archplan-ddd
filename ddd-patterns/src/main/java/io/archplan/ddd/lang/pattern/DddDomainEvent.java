/*
 * Copyright 2023 Udo Cirkel (mail@udocirkel.de)
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
 * Indicates that an annotated class represents a "Domain Event" as defined by
 * Domain-Driven Design (Eric Evans, 2003)
 * <p>
 * Event in the domain that is relevant for domain experts.
 * 
 * @author Udo Cirkel
 * @since 1.0.0
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@DddPattern(name = "Domain Event")
@Documented
public @interface DddDomainEvent {

    /**
     * Name of the Domain Event as defined in the domain model and equally in the
     * ubiquitous language.
     * 
     * @return a name or an empty string
     */
    String name() default "";

    // TODO document operation
    /**
     * The DDD aggregate, entity or service that emits the domain event.
     * 
     * @return
     */
    Class<?> emitter();

}
