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

// TODO klären: Conceptual Module / Module in the model / Module as namespace
/**
 * Indicates that an annotated package represents a "Module" as defined by
 * Domain-Driven Design (Eric Evans, 2003)
 * 
 * @author Udo Cirkel
 * @since 1.0.0
 */
@Target(ElementType.PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@DddPattern("Module")
public @interface DddModule {

    /**
     * Name of the Module as defined in the domain model and equally in the
     * ubiquitous language.
     * 
     * @return a non-empty name
     */
    String value();

    /**
     * Additional information that is related to the Module
     * <p>
     * The provided information is specified in key-value form, where keys may occur
     * multiple times
     * 
     * @return an array with attribute elements or an empty array
     */
    Attribute[] attributes() default {};

}
