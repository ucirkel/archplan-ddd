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
 * Indicates that an annotated class represents the root Entity of an Aggregate
 * as defined by Domain-Driven Design (Eric Evans, 2003)
 * <p>
 * An Aggregate is an abstraction for modeling a group of closely related domain
 * objects with complex relationships. The purpose of an Aggregate is to treat
 * related objects as a single unit so that consistency of relationships can be
 * established according domain rules when data changes.
 * <p>
 * <b>Characteristics</b>
 * <p>
 * Root Entity - An Aggregate consists of a root Entity and related objects. The
 * root Entity defines the boundary of the Aggregate. The objects within the
 * Aggregate are referred to as Aggregate members. All members must be accessed
 * through the root Entity so that consistency of the Aggregate can be
 * maintained.
 * <p>
 * Boundary - An Aggregate has a clearly defined boundary that separates it from
 * other Aggregates. The boundary defines which objects are Aggregate members
 * and thus which operations and data are in the Aggregate and which are not.
 * <p>
 * Identity - An Aggregate has a unique identity that is represented by the root
 * Entity. Aggregate members need only to be distinguishable within the boundary
 * and therefore may have local identities.
 * <p>
 * Consistency - Objects in the domain model are subject to domain rules. A more
 * concise term for domain rule is invariant. Invariants must be met to maintain
 * consistency of data and relationships. Within an Aggregate the root Entity is
 * responsible for applying invariants. The root Entity acts as gateway for all
 * operations on the Aggregate and establishes that the Aggregate remains in a
 * consistent state when data changes.
 * <p>
 * Relationships - Objects that are outside an Aggregate and hold references to
 * the Aggregate may only refer to the root Entity. Members of the aggregate may
 * refer to each other freely. If clients need to access Aggregate members, then
 * they must do so through the root Entity. Aggregate members may also refer to
 * other Aggregates but must do so by value.
 * <p>
 * <b>Modeling hints</b>
 * <p>
 * Aggregates are useful to create domain models that are easier to reason
 * about, maintain, and evolve over time. An important task is to determine
 * reasonable Aggregate boundaries. The following criteria may guide with
 * modeling.
 * <p>
 * Consistency - An Aggregate must remain in a consistent state when data
 * changes. If changes to an object could impact the consistency of other
 * objects, then they should be modeled as part of the same Aggregate.
 * <p>
 * Transactions - Operations to an Aggregate should be atomic, as part of a
 * single transaction. If changes to an Aggregate member require changes to
 * other objects outside the Aggregate, then these objects should be modeled as
 * part of the same Aggregate.
 * <p>
 * Performance - Aggregate members should be accessed and modified together
 * frequently. If objects are accessed and modified independently, then they
 * should be part of separate Aggregates.
 * <p>
 * Domain relevance - Aggregate members should represent a cohesive set of logic
 * and data that are related to a specific aspect of the domain. If objects
 * belong to multiple aspects of the domain, then they should be part of
 * separate Aggregates.
 * <p>
 * Granularity - An Aggregate boundary should provide an appropriate
 * granularity. If an Aggregate is too broad, it could impact maintainability
 * negatively. An Aggregate that is too limited may not offer sufficient context
 * for certain use cases.
 * <p>
 * Dependencies - An Aggregate boundary should be chosen to minimize
 * interdependencies among Aggregates. Tight coupling between Aggregates can
 * affect scalability and maintainability.
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
     * Concise description of the root Entity
     * 
     * @return a description or an empty string
     */
    String description() default "";

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
