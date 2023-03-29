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
 * Indicates that an annotated class represents a "Factory" as defined by
 * Domain-Driven Design (Eric Evans, 2003)
 * 
 * @author Udo Cirkel
 * @since 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DddPattern("Factory")
public @interface DddFactory {

    /**
     * Unique identifier of the Factory
     * 
     * @return an identifier or an empty string
     */
    String id() default "";

    /**
     * Name of the Factory as defined in the domain model and equally in the
     * ubiquitous language.
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
     * {@code @DddFactory("A meaningful name")} instead of
     * {@code @DddFactory(name="A meaningful name")}. Only one of these attributes
     * may be specified.
     * 
     * @return a name or an empty string
     */
    String value() default "";

    /**
     * Name of the Aggregate or Entity that is managed by the Factory
     * 
     * @return a name or an empty string
     */
    String managedObject() default "";

    /**
     * Additional information that is related to the Factory
     * <p>
     * The provided information is specified in key-value form, where keys may occur
     * multiple times
     * 
     * @return an array with attribute elements or an empty array
     */
    Attribute[] attributes() default {};

}
