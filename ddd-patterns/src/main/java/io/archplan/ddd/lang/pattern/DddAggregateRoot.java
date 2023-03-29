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
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Indicates that an annotated class represents the root Entity of an Aggregate
 * as defined by Domain-Driven Design (Eric Evans, 2003)
 * <p>
 * An Aggregate is an abstraction for modeling a group of closely related domain
 * objects with complex relationships. The purpose of an Aggregate is to treat
 * related objects as a single unit so that consistency of relationships can be
 * established according domain rules when data changes.
 * <p>
 * <b>Root Entity and Boundary:</b> Each Aggregate has exactly one root Entity.
 * The root Entity defines the boundary of the Aggregate and thus which Entities
 * and Value Objects are in the Aggregate. These objects are referred to as
 * Aggregate members.
 * <p>
 * <b>References:</b> Objects that are outside the Aggregate and that hold
 * references to the Aggregate must reference only the root Entity. Members of
 * the aggregate may reference each other freely.
 * <p>
 * <b>Identity:</b> The root Entity represents a domain object with a global
 * identity. Whereas, the Aggregate members need only to be distinguishable
 * within the boundary and therefore have local identities.
 * <p>
 * <b>Invariants:</b> The relationships of the domain objects are subject to
 * business rules. These business rules are also called invariants. Within an
 * Aggregate the root entity is responsible for applying the business rules when
 * data changes.
 * 
 * @author Udo Cirkel
 * @since 1.0.0
 * 
 * @see also {@link DddEntity}
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@DddPattern("Aggregate Root")
public @interface DddAggregateRoot {

    /**
     * Unique identifier of the root Entity
     * 
     * @return an identifier or an empty string
     */
    String id() default "";

    /**
     * Name of the root Entity as defined in the domain model and ubiquitous
     * language
     * <p>
     * The name of the root Entity corresponds to the name of the Aggregate.
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
     * {@code @DddAggregateRoot("A meaningful name")} instead of
     * {@code @DddAggregateRoot(name="A meaningful name")}. Only one of these
     * attributes may be specified.
     * 
     * @return a name or an empty string
     */
    String value() default "";

    /**
     * Names of all Entities and Value Objects that are Aggregate members, excluding
     * the root Entity
     * <p>
     * This information is optional. The membership of an Aggregate should be
     * specified in the annotations to Entities and Value Objects.
     * 
     * @return an array with names or an empty array
     */
    String[] members() default {};

    /**
     * Additional information that is related to the Aggregate
     * <p>
     * The provided information is specified in key-value form, where keys may occur
     * multiple times.
     * 
     * @return an array with attribute elements or an empty array
     */
    Attribute[] attributes() default {};

}
