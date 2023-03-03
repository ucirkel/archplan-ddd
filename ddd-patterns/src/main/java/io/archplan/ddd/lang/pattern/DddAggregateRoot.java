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
 * Indicates that an annotated class represents an root "Entity" of an
 * "Aggregate" as defined by Domain-Driven Design (Eric Evans, 2003)
 * 
 * @author Udo Cirkel
 * @since 1.0.0
 * 
 * @see also {@link DddEntity}
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
@DddPattern(name = "Aggregate Root")
@Documented
public @interface DddAggregateRoot {

    /**
     * Name of the Aggregate and its root Entity as defined in the domain model and
     * ubiquitous language.
     * <p>
     * The name of the Aggregate and its root Entity are identically, since the root
     * Entity contains the invariants and business logic that keep the Aggregate
     * members in a consistent state.
     * 
     * @return a name or an empty string
     */
    String name() default "";

    /**
     * Names of all Entities and Value Objects that are Aggregate members, excluding
     * the root Entity.
     * <p>
     * This information is optional. The membership of an Aggregate should be
     * specified in the annotations to Entities and Value Objects.
     * 
     * @return a array with names or an empty array
     */
    String[] memberNames() default {};

}
