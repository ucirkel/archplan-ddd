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
 * Indicates that an annotated class represents an "Entity" as defined by
 * Domain-Driven Design (Eric Evans, 2003)
 * <p>
 * If the Entity is root of an Aggregate then use the {@link DddAggregateRoot}
 * annotation instead.
 * 
 * @author Udo Cirkel
 * @since 1.0.0
 * 
 * @see also {@link DddAggregateRoot}
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@DddPattern("Entity")
public @interface DddEntity {

    /**
     * Unique identifier of the Entity
     * 
     * @return an identifier or an empty string
     */
    String id() default "";

    /**
     * Name of the Entity as defined in the domain model and equally in the
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
     * {@code @DddEntity("A meaningful name")} instead of
     * {@code @DddEntity(name="A meaningful name")}. Only one of these attributes
     * may be specified.
     * 
     * @return a name or an empty string
     */
    String value() default "";

    /**
     * Name of the Aggregate of which the Entity is a member, or an empty string if
     * the entity does not belong to any Aggregate
     * 
     * @return a name or an empty string
     */
    String aggregate() default "";

    /**
     * Additional information that is related to the Entity
     * <p>
     * The provided information is specified in key-value form, where keys may occur
     * multiple times
     * 
     * @return an array with attribute elements or an empty array
     */
    Attribute[] attributes() default {};

}
